package com.sahil.workforcemgmt.repository;

import com.sahil.workforcemgmt.model.TaskHistory;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class InMemoryTaskHistoryRepository implements TaskHistoryRepository{
    private final Map<Long, TaskHistory> taskHistoryStore = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(0);

    @Override
    public TaskHistory save(TaskHistory taskHistory) {
        if (taskHistory.getId() == null) {
            taskHistory.setId(idCounter.incrementAndGet());
        }
        taskHistoryStore.put(taskHistory.getId(), taskHistory);
        return taskHistory;
    }

    @Override
    public List<TaskHistory> findByTaskId(Long taskId) {
        return taskHistoryStore.values().stream()
                .filter(taskHistory -> taskHistory.getTaskId().equals(taskId))
                .sorted(Comparator.comparing(TaskHistory::getTimestamp))
                .collect(Collectors.toList());
    }
}
