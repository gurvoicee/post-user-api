package com.example.demo.controller;

import com.example.demo.entities.Post;
import com.example.demo.entities.User;
import com.example.demo.requests.PostCreateRequest;
import com.example.demo.requests.PostUpdateRequest;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/posts")
public class PostController {
    @Autowired
    PostService postService;
    @GetMapping
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }
    @GetMapping("/{userId}")
    public List<Post> getPostsOfOneUser(@PathVariable Long userId){
        return postService.getPostsOfOneUser(userId);
    }
    @PostMapping
    public Post createPost(@RequestBody PostCreateRequest postCreateRequest){
        return postService.createPost(postCreateRequest);
    }
    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId){
        postService.deletePost(postId);
    }
    @PutMapping("/{postId}")
    public Post updatePost(@RequestBody PostUpdateRequest postUpdateRequest,@PathVariable Long postId){
        return postService.updatePost(postUpdateRequest,postId);
    }
}
