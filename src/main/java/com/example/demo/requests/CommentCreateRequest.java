package com.example.demo.requests;

import lombok.Data;

@Data
public class CommentCreateRequest {
    String text;
    Long userId;
    Long PostId;
}
