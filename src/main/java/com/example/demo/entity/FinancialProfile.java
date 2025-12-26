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


//  package com.example.demo.entity;
//  import jakarta.persistence.*;
//  import jakarta.validation.constraints.*;
//  import lombok.*;

//  import java.time.LocalDateTime;

// @Entity
// public class FinancialProfile {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @OneToOne
//     private User user;

//     private Double monthlyIncome;
//     private Double monthlyExpenses;
//     private Double existingLoanEmi = 0.0;
//     private Integer creditScore;
//     private Double savingsBalance;

//     private LocalDateTime lastUpdatedAt;

//     @PrePersist @PreUpdate
//     void touch() {
//         lastUpdatedAt = LocalDateTime.now();
//     }

//     // getters & setters
// }







// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// public class FinancialProfile {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @OneToOne
//     private User user;

//     private double monthlyIncome;
//     private double monthlyExpenses;
//     private double existingLoanEmi;
//     private int creditScore;

//     // Getters and Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public User getUser() { return user; }
//     public void setUser(User user) { this.user = user; }

//     public double getMonthlyIncome() { return monthlyIncome; }
//     public void setMonthlyIncome(double monthlyIncome) { this.monthlyIncome = monthlyIncome; }

//     public double getMonthlyExpenses() { return monthlyExpenses; }
//     public void setMonthlyExpenses(double monthlyExpenses) { this.monthlyExpenses = monthlyExpenses; }

//     public double getExistingLoanEmi() { return existingLoanEmi; }
//     public void setExistingLoanEmi(double existingLoanEmi) { this.existingLoanEmi = existingLoanEmi; }

//     public int getCreditScore() { return creditScore; }
//     public void setCreditScore(int creditScore) { this.creditScore = creditScore; }
// }




// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// public class FinancialProfile {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @OneToOne
//     private User user;

//     private Integer creditScore;  // Changed from int to Integer

//     private Double monthlyIncome;
//     private Double monthlyExpenses;
//     private Double existingLoanEmi;

//     // Getters and Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public User getUser() { return user; }
//     public void setUser(User user) { this.user = user; }

//     public Integer getCreditScore() { return creditScore; }
//     public void setCreditScore(Integer creditScore) { this.creditScore = creditScore; }

//     public Double getMonthlyIncome() { return monthlyIncome; }
//     public void setMonthlyIncome(Double monthlyIncome) { this.monthlyIncome = monthlyIncome; }

//     public Double getMonthlyExpenses() { return monthlyExpenses; }
//     public void setMonthlyExpenses(Double monthlyExpenses) { this.monthlyExpenses = monthlyExpenses; }

//     public Double getExistingLoanEmi() { return existingLoanEmi; }
//     public void setExistingLoanEmi(Double existingLoanEmi) { this.existingLoanEmi = existingLoanEmi; }
// }












// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// public class FinancialProfile {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private double savingsBalance;

//     // Add other fields as needed

//     // Getters and setters

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public double getSavingsBalance() {
//         return savingsBalance;
//     }

//     public void setSavingsBalance(double savingsBalance) {
//         this.savingsBalance = savingsBalance;
//     }
// }











// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.OneToOne;

// @Entity
// public class FinancialProfile {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Double income;
//     private Double expenses;
//     private Integer creditScore;

//     @OneToOne
//     @JoinColumn(name = "user_id")
//     private User user;

//     // getters and setters
// }
















// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// public class FinancialProfile {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private double income;
//     private double expenses;
//     private int creditScore;

//     @OneToOne
//     private User user;

//     public double getIncome() {
//         return income;
//     }

//     public double getExpenses() {
//         return expenses;
//     }

//     public int getCreditScore() {
//         return creditScore;
//     }

//     public User getUser() {
//         return user;
//     }

//     public void setIncome(double income) {
//         this.income = income;
//     }

//     public void setExpenses(double expenses) {
//         this.expenses = expenses;
//     }

//     public void setCreditScore(int creditScore) {
//         this.creditScore = creditScore;
//     }

//     public void setUser(User user) {
//         this.user = user;
//     }
// }
















// src/main/java/com/example/demo/entity/FinancialProfile.java
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "financial_profiles",
       uniqueConstraints = @UniqueConstraint(columnNames = "user_id"))
public class FinancialProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Double monthlyIncome;
    private Double monthlyExpenses;
    private Double existingLoanEmi;
    private Integer creditScore;
    private Double savingsBalance;

    private Instant lastUpdatedAt;

    @PrePersist
    @PreUpdate
    public void prePersist() {
        lastUpdatedAt = Instant.now();
    }

    // getters and setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Double getMonthlyIncome() { return monthlyIncome; }

    public void setMonthlyIncome(Double monthlyIncome) { this.monthlyIncome = monthlyIncome; }

    public Double getMonthlyExpenses() { return monthlyExpenses; }

    public void setMonthlyExpenses(Double monthlyExpenses) { this.monthlyExpenses = monthlyExpenses; }

    public Double getExistingLoanEmi() { return existingLoanEmi; }

    public void setExistingLoanEmi(Double existingLoanEmi) { this.existingLoanEmi = existingLoanEmi; }

    public Integer getCreditScore() { return creditScore; }

    public void setCreditScore(Integer creditScore) { this.creditScore = creditScore; }

    public Double getSavingsBalance() { return savingsBalance; }

    public void setSavingsBalance(Double savingsBalance) { this.savingsBalance = savingsBalance; }

    public Instant getLastUpdatedAt() { return lastUpdatedAt; }

    public void setLastUpdatedAt(Instant lastUpdatedAt) { this.lastUpdatedAt = lastUpdatedAt; }
}
