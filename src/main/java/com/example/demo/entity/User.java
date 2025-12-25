// package com.example.demo.entity;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.*;
// import lombok.*;


// import java.time.LocalDateTime;
// import java.util.List;

// @Entity
// @Table(
//     name = "users",
//     uniqueConstraints = @UniqueConstraint(columnNames = "email")
// )
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false)
//     private String fullName;

//     @Column(nullable = false, unique = true)
//     @Email
//     private String email;

//     @Column(nullable = false)
//     private String password;

//     @Column(nullable = false)
//     private String role;

//     @Column(nullable = false, updatable = false)
//     private LocalDateTime createdAt;

//     public User(String fullName, String email, String password, String role) {
//         this.fullName = fullName;
//         this.email = email;
//         this.password = password;
//         this.role = role;
//     }


//     @PrePersist
//     protected void onCreate() {
//         this.createdAt = LocalDateTime.now();
        
//         if (this.role == null || this.role.isBlank()) {
//             this.role = "CUSTOMER";
//         }
//     }
// }



package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class User {

    public enum Role { ADMIN, CUSTOMER }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true)
    private String email;

    private String password;

    private String role = Role.CUSTOMER.name();

    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        createdAt = LocalDateTime.now();
    }

    // getters & setters
    // (generate all)
}
