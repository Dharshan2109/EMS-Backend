package com.example.ems_backend.repository;

import java.util.Optional;

import com.example.ems_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository
        extends JpaRepository<User,Long>{

    Optional<User> findByUsername(String username);
}

