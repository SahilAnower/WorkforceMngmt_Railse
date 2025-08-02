package com.sahil.workforcemgmt.service.impl;

import com.sahil.workforcemgmt.common.exception.ResourceNotFoundException;
import com.sahil.workforcemgmt.dto.CommentCreateRequest;
import com.sahil.workforcemgmt.dto.CommentDto;
import com.sahil.workforcemgmt.dto.UpdateCommentRequest;
import com.sahil.workforcemgmt.mapper.ICommentMapper;
import com.sahil.workforcemgmt.model.Comment;
import com.sahil.workforcemgmt.repository.CommentRepository;
import com.sahil.workforcemgmt.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final ICommentMapper commentMapper;

    public CommentServiceImpl(CommentRepository commentRepository, ICommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    @Override
    public List<CommentDto> createComments(CommentCreateRequest request) {
        List<Comment> createdComments = new ArrayList<>();
        for (CommentCreateRequest.RequestItem item : request.getRequests()) {
            Comment comment = new Comment();
            comment.setTaskId(item.getTaskId());
            comment.setUserId(item.getUserId());
            comment.setBody(item.getBody());
            createdComments.add(commentRepository.save(comment));
        }
        return commentMapper.modelListToDtoList(createdComments);
    }

    @Override
    public List<CommentDto> updateComments(UpdateCommentRequest request) {
        List<Comment> updatedComments = new ArrayList<>();
        for (UpdateCommentRequest.RequestItem item : request.getRequests()) {
            Comment comment = commentRepository.findById(item.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Comment not found with id: " + item.getId()));

            if (item.getBody() != null) {
                comment.setBody(item.getBody());
            }
            updatedComments.add(commentRepository.save(comment));
        }
        return commentMapper.modelListToDtoList(updatedComments);
    }

    @Override
    public List<CommentDto> findTasksByTaskId(Long taskId) {
        List<Comment> comments = commentRepository.findByTaskId(taskId);
        return commentMapper.modelListToDtoList(comments);
    }
}
