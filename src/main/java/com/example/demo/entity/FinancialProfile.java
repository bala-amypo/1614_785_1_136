// package com.example.demo.entity;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.*;
// import lombok.*;

// import java.time.LocalDateTime;

// @Entity
// @Table(name = "financial_profiles")
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// public class FinancialProfile {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @NotNull(message = "Monthly income is required")
//     @Min(value = 1, message = "Monthly income must be greater than 0")
//     @Column(nullable = false)
//     private Double monthlyIncome;

//     @NotNull(message = "Monthly expenses is required")
//     @Min(value = 0, message = "Monthly expenses cannot be negative")
//     @Column(nullable = false)
//     private Double monthlyExpenses;

//     @Min(value = 0, message = "Existing loan EMI cannot be negative")
//     private Double existingLoanEmi;

//     @NotNull(message = "Credit score is required")
//     @Min(value = 300, message = "Credit score must be at least 300")
//     @Max(value = 900, message = "Credit score must not exceed 900")
//     @Column(nullable = false)
//     private Integer creditScore;

//     @NotNull(message = "Savings balance is required")
//     @Min(value = 0, message = "Savings balance cannot be negative")
//     @Column(nullable = false)
//     private Double savingsBalance;

//     @Column(nullable = false)
//     private LocalDateTime lastUpdatedAt;


//     @PrePersist
//     @PreUpdate
//     protected void updateTimestamp() {
//         this.lastUpdatedAt = LocalDateTime.now();
//     }
// }


 package com.example.demo.entity;
 import jakarta.persistence.*;
 import jakarta.validation.constraints.*;
 import lombok.*;

 import java.time.LocalDateTime;

@Entity
public class FinancialProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    private Double monthlyIncome;
    private Double monthlyExpenses;
    private Double existingLoanEmi = 0.0;
    private Integer creditScore;
    private Double savingsBalance;

    private LocalDateTime lastUpdatedAt;

    @PrePersist @PreUpdate
    void touch() {
        lastUpdatedAt = LocalDateTime.now();
    }

    // getters & setters
}
