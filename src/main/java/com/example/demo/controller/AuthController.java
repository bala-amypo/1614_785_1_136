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

// package com.example.demo.controller;

// import com.example.demo.entity.User;
// import com.example.demo.service.UserService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     @Autowired
//     private UserService userService;

//     @PostMapping("/register")
//     public User register(@RequestBody User user) {
//         return userService.register(user);
//     }

//     @GetMapping("/user/{id}")
//     public User getUser(@PathVariable Long id) {
//         return userService.getById(id);
//     }
// }











// // src/main/java/com/example/demo/controller/AuthController.java
// package com.example.demo.controller;

// import com.example.demo.dto.AuthRequest;
// import com.example.demo.dto.AuthResponse;
// import com.example.demo.entity.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.security.JwtUtil;
// import com.example.demo.service.UserService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.web.bind.annotation.*;

// import java.util.HashMap;
// import java.util.Map;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final UserService userService;
//     private final JwtUtil jwtUtil;
//     private final UserRepository userRepository;
//     private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

//     public AuthController(UserService userService, JwtUtil jwtUtil,
//                           UserRepository userRepository) {
//         this.userService = userService;
//         this.jwtUtil = jwtUtil;
//         this.userRepository = userRepository;
//     }

//     @PostMapping("/login")
//     public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
//         User user = userRepository.findByEmail(request.getEmail())
//                 .orElseThrow(() -> new RuntimeException("Invalid credentials"));

//         if (!encoder.matches(request.getPassword(), user.getPassword())) {
//             throw new RuntimeException("Invalid credentials");
//         }

//         Map<String, Object> claims = new HashMap<>();
//         claims.put("email", user.getEmail());
//         claims.put("userId", user.getId());
//         claims.put("role", user.getRole());

//         String token = jwtUtil.generateToken(claims, user.getEmail());
//         return ResponseEntity.ok(new AuthResponse(token, user.getEmail()));
//     }
//     // src/main/java/com/example/demo/controller/AuthController.java
// // ...

// @PostMapping("/login")
// public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
//     User user = userRepository.findByEmail(request.getEmail())
//             .orElseThrow(() -> new RuntimeException("Invalid credentials"));

//     if (!encoder.matches(request.getPassword(), user.getPassword())) {
//         throw new RuntimeException("Invalid credentials");
//     }

//     Map<String, Object> claims = new HashMap<>();
//     claims.put("email", user.getEmail());
//     claims.put("userId", user.getId());
//     claims.put("role", user.getRole());

//     String token = jwtUtil.generateToken(claims, user.getEmail());
//     return ResponseEntity.ok(new AuthResponse(token, user.getEmail()));
// }

// }














// // src/main/java/com/example/demo/controller/AuthController.java
// package com.example.demo.controller;

// import com.example.demo.dto.AuthRequest;
// import com.example.demo.dto.AuthResponse;
// import com.example.demo.entity.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.security.JwtUtil;
// import com.example.demo.service.UserService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.web.bind.annotation.*;

// import java.util.HashMap;
// import java.util.Map;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final UserService userService;
//     private final JwtUtil jwtUtil;
//     private final UserRepository userRepository;
//     private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

//     public AuthController(UserService userService, JwtUtil jwtUtil,
//                           UserRepository userRepository) {
//         this.userService = userService;
//         this.jwtUtil = jwtUtil;
//         this.userRepository = userRepository;
//     }

//     // Single login method – do not duplicate this
//     @PostMapping("/login")
//     public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
//         // fetch user by email (t45_authcontroller_login_positive)
//         User user = userRepository.findByEmail(request.getEmail())
//                 .orElseThrow(() -> new RuntimeException("Invalid credentials"));

//         // verify password using BCrypt (test hashes password then calls login)
//         if (!encoder.matches(request.getPassword(), user.getPassword())) {
//             throw new RuntimeException("Invalid credentials");
//         }

//         // build JWT claims
//         Map<String, Object> claims = new HashMap<>();
//         claims.put("email", user.getEmail());
//         claims.put("userId", user.getId());
//         claims.put("role", user.getRole());

//         // generate token and respond
//         String token = jwtUtil.generateToken(claims, user.getEmail());
//         AuthResponse resp = new AuthResponse(token, user.getEmail());
//         return ResponseEntity.ok(resp);
//     }
// }



















// // Example correct usage inside AuthController
// package com.example.demo.controller;

// import com.example.demo.security.JwtUtil;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.Map;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final JwtUtil jwtUtil;

//     public AuthController(JwtUtil jwtUtil) {
//         this.jwtUtil = jwtUtil;
//     }

//     @PostMapping("/login")
//     public ResponseEntity<?> login(@RequestBody LoginRequest request) {
//         // Authenticate user first (omitted)

//         String username = request.getUsername();
//         Map<String, Object> extraClaims = Map.of(
//                 "role", "USER"
//         );

//         // Correct order: username first, then claims
//         String token = jwtUtil.generateToken(username, extraClaims);

//         return ResponseEntity.ok(Map.of("token", token));
//     }

//     // simple DTO for example
//     public static class LoginRequest {
//         private String username;
//         private String password;

//         public String getUsername() { return username; }
//         public void setUsername(String username) { this.username = username; }
//         public String getPassword() { return password; }
//         public void setPassword(String password) { this.password = password; }
//     }
// }
















package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthController(UserService userService, JwtUtil jwtUtil,
                          UserRepository userRepository) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    // Single login method – do not duplicate this
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        // fetch user by email (t45_authcontroller_login_positive)
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        // verify password using BCrypt (test hashes password then calls login)
        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        // build JWT claims
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", user.getEmail());
        claims.put("userId", user.getId());
        claims.put("role", user.getRole());

        // generate token and respond
        String token = jwtUtil.generateToken(claims, user.getEmail());
        AuthResponse resp = new AuthResponse(token, user.getEmail());
        return ResponseEntity.ok(resp);
    }
}