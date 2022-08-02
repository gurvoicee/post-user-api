package com.example.demo.controller;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @GetMapping("/{userId}")
    public User getOne(@PathVariable Long userId){
        return userService.getOne(userId);
    }
    @GetMapping
    public List<User> getAll(){
        List<User> list = userRepository.findAll();
        return list;
    }
    @PostMapping
    public User createOneUser(@RequestBody User newUser){
        return userService.createOne(newUser);
    }


}
