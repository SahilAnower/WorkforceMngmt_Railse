package com.sahil.workforcemgmt.controller;

import com.sahil.workforcemgmt.common.model.response.Response;
import com.sahil.workforcemgmt.dto.*;
import com.sahil.workforcemgmt.model.enums.Priority;
import com.sahil.workforcemgmt.service.CommentService;
import com.sahil.workforcemgmt.service.TaskManagementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-mgmt")
public class TaskManagementController {
    private final TaskManagementService taskManagementService;
    private final CommentService commentService;


    public TaskManagementController(TaskManagementService taskManagementService, CommentService commentService) {
        this.taskManagementService = taskManagementService;
        this.commentService = commentService;
    }

    @GetMapping("/tasks/priority/{priority}")
    public Response<List<TaskManagementDto>> getTasksByPriority(@PathVariable Priority priority) {
        return new Response<>(taskManagementService.findTasksByPriority(priority));
    }


    @GetMapping("/{id}")
    public Response<TaskManagementDto> getTaskById(@PathVariable Long id) {
        return new Response<>(taskManagementService.findTaskById(id));
    }


    @PostMapping("/create")
    public Response<List<TaskManagementDto>> createTasks(@RequestBody TaskCreateRequest request) {
        return new Response<>(taskManagementService.createTasks(request));
    }

    @PostMapping("/comment/{taskId}")
    public Response<List<CommentDto>> createComments(@RequestBody CommentCreateRequest request) {
        return new Response<>(commentService.createComments(request));
    }

    @PutMapping("/comment")
    public Response<List<CommentDto>> updateComments(@RequestBody UpdateCommentRequest request) {
        return new Response<>(commentService.updateComments(request));
    }


    @PostMapping("/update")
    public Response<List<TaskManagementDto>> updateTasks(@RequestBody UpdateTaskRequest request) {
        return new Response<>(taskManagementService.updateTasks(request));
    }


    @PostMapping("/assign-by-ref")
    public Response<String> assignByReference(@RequestBody AssignByReferenceRequest request) {
        return new Response<>(taskManagementService.assignByReference(request));
    }

    @PostMapping("/fetch-by-date/v1")
    public Response<List<TaskManagementDto>> fetchByDateSmart(@RequestBody TaskFetchByDateRequest request) {
        return new Response<>(taskManagementService.fetchTasksByDateSmart(request));
    }


    @PostMapping("/fetch-by-date/v2")
    public Response<List<TaskManagementDto>> fetchByDate(@RequestBody TaskFetchByDateRequest request) {
        return new Response<>(taskManagementService.fetchTasksByDate(request));
    }
}
