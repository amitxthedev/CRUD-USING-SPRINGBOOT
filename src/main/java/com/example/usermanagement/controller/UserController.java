package com.example.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.usermanagement.models.User;
import com.example.usermanagement.services.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController 
{
    @Autowired
    private UserService userService;

    // To fetch all the users data 

    @GetMapping
    public String getAllUsers(Model model)
    {
        model.addAttribute("users", userService.getAllUsers());
        return "user-list";
    }

    //  to create users
    @GetMapping("/new")
    public String showUserForm(Model model)
    {
        model.addAttribute("user", new User());
        return "user-form";
    }
    @PostMapping
    public String saveUser(@Valid @ModelAttribute("user")User user,BindingResult result, Model model)
    {
        if (result.hasErrors()) 
        {
            return "user-form";
        }
        userService.savUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String updateUser(@PathVariable Long id,Model model)
    {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id)
    {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
