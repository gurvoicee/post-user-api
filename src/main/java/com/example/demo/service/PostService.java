package com.example.demo.service;

import com.example.demo.entities.Post;
import com.example.demo.entities.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.requests.PostCreateRequest;
import com.example.demo.requests.PostUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserService userService;
    public List<Post> getAllPosts() {
        List<Post> list = postRepository.findAll();
        return list;
    }

    public List<Post> getPostsOfOneUser(Long userId) {
        User user = userService.getOne(userId);
        if (user!=null){
            List<Post> list = postRepository.findAllPostsByUserId(userId);
            return list;
        }
        return null;
    }

    public Post createPost(PostCreateRequest postCreateRequest) {
        User user = userService.getOne(postCreateRequest.getUserId());
        if(user!=null){
            Post post = new Post();
            post.setText(postCreateRequest.getText());
            post.setTitle(postCreateRequest.getTitle());
            post.setUser(user);
            return postRepository.save(post);
        }
        return null;
    }

    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId).orElse(null);
        if (post!=null){
            postRepository.delete(post);
        }
    }

    public Post updatePost(PostUpdateRequest postUpdateRequest,Long postId) {
        User user = userService.getOne(postUpdateRequest.getUserId());
        Post post = postRepository.findById(postId).orElse(null);
        if (user!=null && post!=null&&post.getUser()==user){
            post.setTitle(postUpdateRequest.getTitle());
            post.setText(postUpdateRequest.getText());
            return postRepository.save(post);
        }
        return null;
    }
}
