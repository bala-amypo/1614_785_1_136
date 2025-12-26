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



// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// public class User {

//     public enum Role { ADMIN, CUSTOMER }

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String fullName;

//     @Column(unique = true)
//     private String email;

//     private String password;

//     private String role = Role.CUSTOMER.name();

//     private LocalDateTime createdAt;

//     @PrePersist
//     void onCreate() {
//         createdAt = LocalDateTime.now();
//     }

//     // getters & setters
//     // (generate all)
// }









// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "users")
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;

//     @Column(unique = true)
//     private String email;

//     private String password;

//     private String role; // e.g., "CUSTOMER", "ADMIN"

//     // Getters and Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getName() { return name; }
//     public void setName(String name) { this.name = name; }

//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }

//     public String getPassword() { return password; }
//     public void setPassword(String password) { this.password = password; }

//     public String getRole() { return role; }
//     public void setRole(String role) { this.role = role; }
// }








// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String fullName;

//     private double savingsBalance;

//     // Getters and Setters

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getFullName() {
//         return fullName;
//     }

//     public void setFullName(String fullName) {
//         this.fullName = fullName;
//     }

//     public double getSavingsBalance() {
//         return savingsBalance;
//     }

//     public void setSavingsBalance(double savingsBalance) {
//         this.savingsBalance = savingsBalance;
//     }
// }









// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String email;
//     private String password;
//     private String role;

//     // Add other fields as needed

//     // Getters and Setters
    
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getEmail() {
//         return email;
//     }
    
//     public void setEmail(String email) {
//         this.email = email;
//     }

//     public String getPassword() {
//         return password;
//     }
    
//     public void setPassword(String password) {
//         this.password = password;
//     }

//     public String getRole() {
//         return role;
//     }
    
//     public void setRole(String role) {
//         this.role = role;
//     }
// }



















// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "users")
// public class User {

//     public enum Role {
//         CUSTOMER,
//         ADMIN
//     }

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false, unique = true)
//     private String email;

//     @Column(nullable = false)
//     private String password;

//     @Column(nullable = false)
//     private String fullName;

//     @Column(nullable = false)
//     private String role;

//     // ================= GETTERS & SETTERS =================

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getEmail() {
//         return email;
//     }
    
//     public void setEmail(String email) {
//         this.email = email;
//     }
    
//     public String getPassword() {
//         return password;
//     }
    
//     public void setPassword(String password) {
//         this.password = password;
//     }
    
//     public String getFullName() {
//         return fullName;
//     }
    
//     public void setFullName(String fullName) {
//         this.fullName = fullName;
//     }
    
//     public String getRole() {
//         return role;
//     }
    
//     public void setRole(String role) {
//         this.role = role;
//     }
// }














import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;
    private String name;

    // getters and setters
}
