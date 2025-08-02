package com.sahil.workforcemgmt.repository;

import com.sahil.workforcemgmt.common.model.enums.ReferenceType;
import com.sahil.workforcemgmt.model.TaskManagement;
import com.sahil.workforcemgmt.model.enums.Priority;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    Optional<TaskManagement> findById(Long id);
    TaskManagement save(TaskManagement task);
    List<TaskManagement> findAll();
    List<TaskManagement> findByReferenceIdAndReferenceType(Long referenceId, ReferenceType referenceType);
    List<TaskManagement> findByPriority(Priority priority);
    List<TaskManagement> findByAssigneeIdIn(List<Long> assigneeIds);
}
