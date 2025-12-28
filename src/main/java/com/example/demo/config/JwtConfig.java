// // src/main/java/com/example/demo/config/JwtConfig.java
// package com.example.demo.config;

// import com.example.demo.security.JwtUtil;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class JwtConfig {

//     @Bean
//     public JwtUtil jwtUtil() {
//         // secret and expiration must match what tests use (t41–t45)
//         String secret = "ChangeThisSecretForProductionButKeepItLongEnough";
//         long validityInMs = 3600000L; // 1 hour
//         return new JwtUtil(secret, validityInMs);
//     }
// }











// package com.example.demo.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import com.example.demo.security.JwtUtil;

// @Configuration
// public class JwtConfig {

//     @Bean
//     public JwtUtil jwtUtil() {
//         // JwtUtil has a no-arg constructor and uses @Value fields.
//         return new JwtUtil();
//     }
// }














// // src/main/java/com/example/demo/config/JwtConfig.java
// package com.example.demo.config;

// import com.example.demo.security.JwtUtil;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class JwtConfig {

//     @Bean
//     public JwtUtil jwtUtil() {
//         // secret and expiration must match what tests use (t41–t45)
//         String secret = "ChangeThisSecretForProductionButKeepItLongEnough";
//         long validityInMs = 3600000L; // 1 hour
//         return new JwtUtil(secret, validityInMs);
//     }
// }













package com.example.demo.config;

import com.example.demo.security.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Bean
    public JwtUtil jwtUtil() {
        // secret and expiration must match what tests use (t41–t45)
        String secret = "ChangeThisSecretForProductionButKeepItLongEnough";
        long validityInMs = 3600000L; // 1 hour
        return new JwtUtil(secret, validityInMs);
    }
}