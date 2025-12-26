package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // Disable CSRF for REST APIs
            .csrf(csrf -> csrf.disable())

            // Authorize requests
            .authorizeHttpRequests(auth -> auth
                // Allow Swagger
                .requestMatchers(
                    "/swagger-ui/**",
                    "/v3/api-docs/**",
                    "/swagger-ui.html"
                ).permitAll()

                // Allow root
                .requestMatchers("/").permitAll()

                // Allow all APIs for now (you can secure later)
                .requestMatchers("/**").permitAll()

                // Any other request
                .anyRequest().authenticated()
            )

            // Disable login form & basic auth
            .httpBasic(Customizer.withDefaults())
            .formLogin(form -> form.disable());

        return http.build();
    }
}
