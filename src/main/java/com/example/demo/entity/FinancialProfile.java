package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "financial_profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinancialProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * One financial profile per user
     */
   

    @Column(nullable = false)
    private Double monthlyIncome;

    @Column(nullable = false)
    private Double monthlyExpenses;

    @Column
    private Double existingLoanEmi;

    @Column(nullable = false)
    private Integer creditScore;

    @Column(nullable = false)
    private Double savingsBalance;

    @Column(nullable = false)
    private LocalDateTime lastUpdatedAt;

    /* ===================== Constructors ===================== */

    /**
     * Core fields constructor
     */
    public FinancialProfile(
            User user,
            Double monthlyIncome,
            Double monthlyExpenses,
            Double existingLoanEmi,
            Integer creditScore,
            Double savingsBalance
    ) {
        
        this.monthlyIncome = monthlyIncome;
        this.monthlyExpenses = monthlyExpenses;
        this.existingLoanEmi = existingLoanEmi;
        this.creditScore = creditScore;
        this.savingsBalance = savingsBalance;
    }

    /* ===================== Lifecycle Hooks ===================== */

    @PrePersist
    @PreUpdate
    protected void validateAndUpdate() {
        // Auto-update timestamp
        this.lastUpdatedAt = LocalDateTime.now();

        // monthlyIncome must be > 0
        if (monthlyIncome == null || monthlyIncome <= 0) {
            throw new IllegalArgumentException("monthlyIncome must be greater than 0");
        }

        // savingsBalance must be >= 0
        if (savingsBalance == null || savingsBalance < 0) {
            throw new IllegalArgumentException("savingsBalance must be >= 0");
        }

        // creditScore must be between 300 and 900
        if (creditScore == null || creditScore < 300 || creditScore > 900) {
            throw new IllegalArgumentException("Invalid creditScore");
        }
    }
}
