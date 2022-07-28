package com.example.demo.controller;

import com.example.demo.entities.Comment;
import com.example.demo.requests.CommentCreateRequest;
import com.example.demo.requests.CommentUpdateRequest;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping
    public List<Comment> getAllComments(){
        return commentService.getAll();
    }
    @GetMapping("/{userId}")
    public List<Comment> getAllCommentsById(@PathVariable Long userId){
        return commentService.getAllCommentsById(userId);
    }
    @PostMapping
    public Comment createComment(@RequestBody CommentCreateRequest commentCreateRequest){
        return commentService.createComment(commentCreateRequest);
    }
    @PutMapping("/{commentId}")
    public Comment updateComment(@RequestBody CommentUpdateRequest commentUpdateRequest,@PathVariable Long commentId){
        return commentService.updateCommnent(commentUpdateRequest,commentId);
    }
    @DeleteMapping("/{commentId}")
    public void deletePost(@PathVariable Long commentId){
        commentService.delete(commentId);
    }
}
