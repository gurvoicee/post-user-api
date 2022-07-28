package com.example.demo.controller;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/{userId}")
    public User getOne(@PathVariable Long userId){
        return userService.getOne(userId);
    }
    @PostMapping
    public User createOneUser(@RequestBody User newUser){
        return userService.createOne(newUser);
    }


}
