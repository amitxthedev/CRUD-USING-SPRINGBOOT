package com.example.usermanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.usermanagement.models.User;

public interface UserRepo extends JpaRepository<User, Long>{
    
}
