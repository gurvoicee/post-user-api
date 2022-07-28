package com.example.demo.requests;

import lombok.Data;

@Data
public class CommentUpdateRequest {
    String text;
    Long userId;
    Long postId;
}
