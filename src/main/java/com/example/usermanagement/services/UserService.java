package com.example.usermanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usermanagement.models.User;
import com.example.usermanagement.repo.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUsers()
    {
        return userRepo.findAll();
    }
    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    public User savUser(User user)
    {
        return userRepo.save(user);
    }
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
