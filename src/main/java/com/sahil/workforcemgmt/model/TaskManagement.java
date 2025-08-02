package com.sahil.workforcemgmt.model;

import com.sahil.workforcemgmt.common.model.enums.ReferenceType;
import com.sahil.workforcemgmt.model.enums.Priority;
import com.sahil.workforcemgmt.model.enums.Task;
import com.sahil.workforcemgmt.model.enums.TaskStatus;
import lombok.Data;

@Data
public class TaskManagement {
    private Long id;
    private Long referenceId;
    private ReferenceType referenceType;
    private Task task;
    private String description;
    private TaskStatus status;
    private Long assigneeId; // Simplified from Entity for this assignment
    private Long taskCreationTime;
    private Long taskDeadlineTime;
    private Priority priority;

}
