package com.example.ems_backend.config;

import com.example.ems_backend.entity.User;
import com.example.ems_backend.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner load(
            UserRepository repo,
            PasswordEncoder encoder){

        return args->{

            if(repo.findByUsername(
                    "admin").isEmpty()){

                User user=
                        User.builder()
                                .username(
                                        "admin")
                                .password(
                                        encoder.encode(
                                                "admin123"))
                                .role("ADMIN")
                                .build();

                repo.save(user);
            }
        };
    }
}

