package com.sahil.workforcemgmt.service;

import com.sahil.workforcemgmt.dto.CommentCreateRequest;
import com.sahil.workforcemgmt.dto.CommentDto;
import com.sahil.workforcemgmt.dto.UpdateCommentRequest;

import java.util.List;

public interface CommentService {
    List<CommentDto> createComments(CommentCreateRequest request);
    List<CommentDto> updateComments(UpdateCommentRequest request);
    List<CommentDto> findTasksByTaskId(Long taskId);
}
