// package com.example.demo.config;

// import io.swagger.v3.oas.models.OpenAPI;
// import io.swagger.v3.oas.models.servers.Server;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import java.util.List;

// @Configuration
// public class SwaggerConfig {

//     @Bean
//     public OpenAPI customOpenAPI() {
//         return new OpenAPI()
//                 .servers(List.of(
//                         new Server()
//                                 .url("h")
//                                 .description("Production Server")
//                 ));
//     }
// }












// package com.example.demo.config;

// import io.swagger.v3.oas.models.OpenAPI;
// import io.swagger.v3.oas.models.servers.Server;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import io.swagger.v3.oas.models.security.SecurityScheme;
// import java.util.List;

// @Configuration
// public class  SwaggerConfig {
        
//     @Bean
//     public OpenAPI customOpenAPI() {
//          SecurityScheme bearerAuth = new SecurityScheme()
//                 .type(SecurityScheme.Type.HTTP)
//                 .scheme("bearer")
//                 .bearerFormat("JWT");
//         return new OpenAPI()
//                 // You need to change the port as per your server
//                 .servers(List.of(
//                         new Server().url("https://9138.pro604cr.amypo.ai/")
//                 ));
//         }
// }















package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        // 🔐 Define JWT Security Scheme
        SecurityScheme securityScheme = new SecurityScheme()
                .name("bearerAuth")
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");

        // 🔒 Apply security globally
        SecurityRequirement securityRequirement =
                new SecurityRequirement().addList("bearerAuth");

        return new OpenAPI()
                .servers(List.of(
                        new Server().url("https://9138.pro604cr.amypo.ai/")
                ))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", securityScheme)
                )
                .addSecurityItem(securityRequirement);
    }
}
