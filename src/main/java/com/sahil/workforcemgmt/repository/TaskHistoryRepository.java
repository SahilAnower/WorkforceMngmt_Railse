package com.sahil.workforcemgmt.repository;

import com.sahil.workforcemgmt.model.TaskHistory;

import java.util.List;

public interface TaskHistoryRepository {
    TaskHistory save(TaskHistory taskHistory);
    List<TaskHistory> findByTaskId(Long taskId);
}
