package com.example.demo.controller;

import com.example.demo.entities.User;
import com.example.demo.requests.UserRequest;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @PostMapping("/login")
    public String login(@RequestBody UserRequest loginRequest){
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),loginRequest.getPassword());
        Authentication auth = authenticationManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwtToken = jwtTokenProvider.generateJwt(auth);
        return "Bearer" + jwtToken;
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRequest userRequest){
        if (userService.getOneByUserName(userRequest.getUserName()) != null){
            return new ResponseEntity<>("userName already is used.",HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setName(userRequest.getUserName());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        userService.createOne(user);
        return  new ResponseEntity<>("user succesfully is registred",HttpStatus.CREATED);
    }
}
