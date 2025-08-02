package com.sahil.workforcemgmt.model;

import lombok.Data;

@Data
public class Comment {
    private Long id;
    private Long taskId;
    private Long userId;
    private String body;
    private Long createdAt;
    private Long updatedAt;
}
