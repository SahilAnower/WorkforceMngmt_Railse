package com.sahil.workforcemgmt.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sahil.workforcemgmt.common.model.enums.ReferenceType;
import com.sahil.workforcemgmt.model.Comment;
import com.sahil.workforcemgmt.model.TaskHistory;
import com.sahil.workforcemgmt.model.enums.Priority;
import com.sahil.workforcemgmt.model.enums.Task;
import com.sahil.workforcemgmt.model.enums.TaskStatus;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TaskManagementDto {
    private Long id;
    private Long referenceId;
    private ReferenceType referenceType;
    private Task task;
    private String description;
    private TaskStatus status;
    private Long assigneeId;
    private Long taskDeadlineTime;
    private Priority priority;
    private List<CommentDto> commentDtos;
    private List<TaskHistory> taskHistories;
}
