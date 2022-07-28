package com.example.demo.service;

import com.example.demo.entities.Comment;
import com.example.demo.entities.Post;
import com.example.demo.entities.User;
import com.example.demo.repository.CommentRepository;
import com.example.demo.requests.CommentCreateRequest;
import com.example.demo.requests.CommentUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserService userService;
    @Autowired
    PostService postService;
    public List<Comment> getAll() {
        List<Comment> list = commentRepository.findAll();
        return list;
    }

    public List<Comment> getAllCommentsById(Long userId) {
        User user = userService.getOne(userId);
        if (user!=null){
            List<Comment> list = commentRepository.findAllCommentsByUserId(userId);
            return list;
        }
        return null;
    }

    public Comment createComment(CommentCreateRequest commentCreateRequest) {
        User user = userService.getOne(commentCreateRequest.getUserId());
        Post post = postService.getOnePost(commentCreateRequest.getPostId());
        if (user != null && post != null){
            Comment toSaveComment = new Comment();
            toSaveComment.setText(commentCreateRequest.getText());
            toSaveComment.setPost(post);
            toSaveComment.setUser(user);
            return commentRepository.save(toSaveComment);
        }
        return null;
    }

    public Comment updateCommnent(CommentUpdateRequest commentUpdateRequest,Long commentId) {
        User user = userService.getOne(commentUpdateRequest.getUserId());
        Post post = postService.getOnePost(commentUpdateRequest.getPostId());
        Comment comment = commentRepository.findById(commentId).orElse(null);
        if (user != null && post != null && comment != null
                && comment.getUser() == user
                && comment.getPost() == post){
            comment.setText(commentUpdateRequest.getText());
            return commentRepository.save(comment);
        }
        return null;
    }

    public void delete(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElse(null);
        commentRepository.delete(comment);
    }
}
