package com.example.ems_backend.controller;

import com.example.ems_backend.dto.LoginRequest;
import com.example.ems_backend.entity.User;
import com.example.ems_backend.repository.UserRepository;
import com.example.ems_backend.security.JwtUtil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    UserRepository repo;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtil jwt;

    @PostMapping("/login")
    public String login(
            @RequestBody LoginRequest request){

        User user=
                repo.findByUsername(
                                request.getUsername())
                        .orElseThrow();

        if(encoder.matches(
                request.getPassword(),
                user.getPassword())){

            return jwt.generateToken(
                    user.getUsername());
        }

        return "Invalid Credentials";
    }
}

