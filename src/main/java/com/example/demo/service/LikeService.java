package com.example.demo.service;

import com.example.demo.entities.Like;
import com.example.demo.entities.Post;
import com.example.demo.entities.User;
import com.example.demo.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {
    @Autowired
    LikeRepository likeRepository;
    @Autowired
    UserService userService;
    @Autowired
    PostService postService;

    public Like createLike(Like like) {
        User user = userService.getOne(like.getUser().getId());
        Post post = postService.getOnePost(like.getPost().getId());
        if (user != null && post != null && like.isLiked() == false) {
            Like toSaveLike = new Like();

            toSaveLike.setLiked(true);
            toSaveLike.setUser(like.getUser());
            toSaveLike.setPost(like.getPost());
            return likeRepository.save(toSaveLike);
        }
        return null;
    }

    public Like updateLike(Like like) {
        User user = userService.getOne(like.getUser().getId());
        Post post = postService.getOnePost(like.getPost().getId());

        if (user != null && post != null && like.isLiked() == true) {
            like.setLiked(false);
            return likeRepository.save(like);
        }
        return null;
    }
}