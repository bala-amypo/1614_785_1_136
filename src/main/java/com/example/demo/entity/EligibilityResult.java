package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "eligibility_results")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EligibilityResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* ===================== Relationships ===================== */

   

    /* ===================== Fields ===================== */

    @Column(nullable = false)
    private Boolean isEligible;

    @Column(nullable = false)
    private Double maxEligibleAmount;

    @Column(nullable = false)
    private Double estimatedEmi;

    @Column(nullable = false)
    private String riskLevel;

    @Column
    private String rejectionReason;

    @Column(nullable = false, updatable = false)
    private LocalDateTime calculatedAt;

    /* ===================== Constructors ===================== */

    /**
     * Core fields constructor
     */
    public EligibilityResult(
            LoanRequest loanRequest,
            Boolean isEligible,
            Double maxEligibleAmount,
            Double estimatedEmi,
            String riskLevel,
            String rejectionReason
    ) {
        
        this.isEligible = isEligible;
        this.maxEligibleAmount = maxEligibleAmount;
        this.estimatedEmi = estimatedEmi;
        this.riskLevel = riskLevel;
        this.rejectionReason = rejectionReason;
    }

    /* ===================== Lifecycle Hooks ===================== */

    @PrePersist
    protected void onCreate() {
        // Auto-populate timestamp
        this.calculatedAt = LocalDateTime.now();

        // Validate risk level
        if (!riskLevel.equals("LOW")
                && !riskLevel.equals("MEDIUM")
                && !riskLevel.equals("HIGH")) {
            throw new IllegalArgumentException("Invalid riskLevel");
        }

        // rejectionReason only if not eligible
        if (Boolean.TRUE.equals(isEligible) && rejectionReason != null) {
            throw new IllegalStateException("rejectionReason must be null when eligible");
        }

        if (Boolean.FALSE.equals(isEligible) && (rejectionReason == null || rejectionReason.isBlank())) {
            throw new IllegalStateException("rejectionReason must be provided when not eligible");
        }
    }
}
