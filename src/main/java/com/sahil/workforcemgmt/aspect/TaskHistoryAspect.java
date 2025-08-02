package com.sahil.workforcemgmt.aspect;

import com.sahil.workforcemgmt.model.TaskHistory;
import com.sahil.workforcemgmt.model.TaskManagement;
import com.sahil.workforcemgmt.model.enums.Action;
import com.sahil.workforcemgmt.model.enums.Fields;
import com.sahil.workforcemgmt.repository.InMemoryTaskHistoryRepository;
import com.sahil.workforcemgmt.repository.TaskHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Aspect
@Component
@RequiredArgsConstructor
public class TaskHistoryAspect {
    private final TaskHistoryRepository historyRepository;

    @AfterReturning(
            pointcut = "execution(* com.sahil.workforcemgmt.repository..*.save(com.sahil.workforcemgmt.model.TaskManagement)) && args(task)",
            returning = "savedTask"
    )
    public void trackTaskChanges(TaskManagement task, TaskManagement savedTask) {
        if (task.getId() == null) {
            TaskHistory history = new TaskHistory();
            history.setTaskId(savedTask.getId());
            history.setAction(Action.CREATE);
            history.setTimestamp(System.currentTimeMillis());
            history.setNewValue("Task created: " + savedTask.getTask());
            historyRepository.save(history);
        } else {
            logFieldChange(task, savedTask, Fields.PRIORITY);
            logFieldChange(task, savedTask, Fields.STATUS);
            logFieldChange(task, savedTask, Fields.ASSIGNEE);
            logFieldChange(task, savedTask, Fields.DESCRIPTION);
        }
    }

    private void logFieldChange(TaskManagement updated, TaskManagement original, Fields field) {
        try {
            Object oldValue;
            Object newValue;

            switch (field) {
                case PRIORITY:
                    oldValue = original.getPriority();
                    newValue = updated.getPriority();
                    break;
                case STATUS:
                    oldValue = original.getStatus();
                    newValue = updated.getStatus();
                    break;
                case ASSIGNEE:
                    oldValue = original.getAssigneeId();
                    newValue = updated.getAssigneeId();
                    break;
                case DESCRIPTION:
                    oldValue = original.getDescription();
                    newValue = updated.getDescription();
                    break;
                default:
                    return; // Unknown field, skip logging
            }

            // Only log if there's an actual change
            if (!Objects.equals(oldValue, newValue)) {
                TaskHistory history = new TaskHistory();
                history.setTaskId(updated.getId());
                history.setAction(Action.UPDATE);
                history.setChangedField(Fields.valueOf(field.toString()));
                history.setOldValue(String.valueOf(oldValue));
                history.setNewValue(String.valueOf(newValue));
                history.setTimestamp(System.currentTimeMillis());
                historyRepository.save(history);
            }
        } catch (Exception e) {
            System.out.println("Exception occured while saving history: " + e.getMessage());
        }
    }
}
