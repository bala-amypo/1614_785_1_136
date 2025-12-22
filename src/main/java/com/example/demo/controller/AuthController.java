// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.entity.User;
// import com.example.demo.service.UserService;

// import jakarta.validation.Valid;

// @RestController
// @RequestMapping("/users") 
// public class AuthController {

//     @Autowired
//     private UserService userService;

//     @PostMapping("/register")
//     public User register(@Valid @RequestBody User user) {
//         return userService.postData1(user);
//     }

//     @PostMapping("/login")
//     public User login(@RequestBody User user) {
        
//         return userService.postData11(user);
//     }

//     @GetMapping
//     public List<User> getAllUsers() {
//         return userService.getAllData1();
//     }

   
//     @GetMapping("/{id}")
//     public User getUser(@PathVariable Long id) {
//         return userService.getData1(id);
//     }

    
//     @PutMapping("/{id}")
//     public User updateUser(@PathVariable Long id, @RequestBody User user) {
//         return userService.updateData1(id, user);
//     }

//     @DeleteMapping("/{id}")
//     public String deleteUser(@PathVariable Long id) {
//         return userService.DeleteData1(id);
//     }
// }




package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Full name is required")
    @Size(min = 3, max = 50, message = "Full name must be 3-50 characters")
    private String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NotBlank(message = "Role is required")
    private String role = "CUSTOMER"; 

    private LocalDateTime createdAt = LocalDateTime.now();
}
