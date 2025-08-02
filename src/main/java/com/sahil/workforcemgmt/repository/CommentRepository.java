package com.sahil.workforcemgmt.repository;

import com.sahil.workforcemgmt.model.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {
    Comment save(Comment comment);
    Optional<Comment> findById(Long id);
    List<Comment> findByTaskId(Long taskId);
}
