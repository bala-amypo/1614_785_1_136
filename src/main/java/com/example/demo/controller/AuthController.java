// package com.example.demo.controller;

// import java.util.*;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// // import org.springframework.web.bind.annotation.RestMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.entity.User;
// import com.example.demo.service.UserService;
// import jakarta.validation.Valid;

// @RestController
// @RequestMapping("/User")
// public class AuthController{
//     @Autowired  UserService ser;
//     @PostMapping("/register")
//     public User sendData(@RequestBody User stu){
//         return ser.postData1(stu);
//     }
//      @PostMapping("/login")
//     public User sendData1(@RequestBody User stu1){
//         return ser.postData11(stu1);
//     }
//     @GetMapping("/get")
//     public List<User> getval(){
//         return ser.getAllData1();
//     }
//     @DeleteMapping("/delete/{id}")
//     public String del(@PathVariable Long id){
//         return ser.DeleteData1(id);
//     }
//     @GetMapping("/find/{id}")
//     public User find(@PathVariable Long id){
//         return ser.getData1(id);
//     }
//     @PutMapping("/put/{id}")
//     public User putval(@PathVariable Long id,@RequestBody User entity){
//         return ser.updateData1(id,entity);
//     }
// }


package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class AuthController {

    @Autowired
    private UserService userService;

    /* ===================== REGISTER ===================== */

    @PostMapping("/register")
    public User register(@Valid @RequestBody User user) {
        return userService.register(user);
    }

    /* ===================== LOGIN ===================== */

    @PostMapping("/login")
    public User login(@RequestBody User loginRequest) {
        return userService.login(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        );
    }

    /* ===================== CRUD ===================== */

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable Long id,
            @Valid @RequestBody User user
    ) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return user.delete(id);
    }
}



