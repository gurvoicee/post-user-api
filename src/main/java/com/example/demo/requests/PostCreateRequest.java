package com.example.demo.requests;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class PostCreateRequest {
    String title;
    String text;
    Long userId;
}
