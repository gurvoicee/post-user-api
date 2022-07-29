package com.example.demo.controller;

import com.example.demo.entities.Like;
import com.example.demo.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikeController {
    @Autowired
    LikeService likeService;
    @PostMapping
    public Like createLike(@RequestBody Like like){
        return likeService.createLike(like);
    }
    @PutMapping
    public Like updateLike(@RequestBody Like like){
        return likeService.updateLike(like);
    }

}
