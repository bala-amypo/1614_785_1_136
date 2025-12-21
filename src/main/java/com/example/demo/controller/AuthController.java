package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users") 
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@Valid @RequestBody User user) {
        return userService.postData1(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        
        return userService.postData11(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllData1();
    }

   
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getData1(id);
    }

    
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateData1(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.DeleteData1(id);
    }
}
