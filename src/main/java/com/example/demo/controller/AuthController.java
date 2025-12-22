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






package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class AuthController {

    private final UserService userService;

    // Constructor injection is preferred over @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    /** ===================== REGISTER ===================== **/
    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody User user) {
        User savedUser = userService.postData1(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    /** ===================== LOGIN ===================== **/
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User loggedInUser = userService.postData11(user);
        return ResponseEntity.ok(loggedInUser);
    }

    /** ===================== GET ALL USERS ===================== **/
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllData1();
        return ResponseEntity.ok(users);
    }

    /** ===================== GET USER BY ID ===================== **/
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.getData1(id);
        return ResponseEntity.ok(user);
    }

    /** ===================== UPDATE USER ===================== **/
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody User user) {
        User updatedUser = userService.updateData1(id, user);
        if (updatedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUser);
    }

    /** ===================== DELETE USER ===================== **/
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        String message = userService.DeleteData1(id);
        return ResponseEntity.ok(message);
    }
}
