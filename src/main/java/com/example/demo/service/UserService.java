package com.example.demo.service;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User getOne(Long id){
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    public User createOne(User newUser) {
        userRepository.save(newUser);
        return newUser;
    }

}

