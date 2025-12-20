package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "risk_assessment_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RiskAssessmentLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * References LoanRequest by ID only (audit entity)
     */
    @Column(nullable = false)
    private Long loanRequestId;

    @Column(nullable = false)
    private Double dtiRatio;

    @Column(nullable = false)
    private String creditCheckStatus;

    @Column(nullable = false, updatable = false)
    private LocalDateTime timestamp;

    /* ===================== Constructors ===================== */

    /**
     * Core fields constructor
     */
    public RiskAssessmentLog(
            Long loanRequestId,
            Double dtiRatio,
            String creditCheckStatus
    ) {
        this.loanRequestId = loanRequestId;
        this.dtiRatio = dtiRatio;
        this.creditCheckStatus = creditCheckStatus;
    }

    /* ===================== Lifecycle Hooks ===================== */

    @PrePersist
    protected void onCreate() {
        // Auto-populate timestamp
        this.timestamp = LocalDateTime.now();

        // Validate creditCheckStatus
        if (!"APPROVED".equals(creditCheckStatus)
                && !"REJECTED".equals(creditCheckStatus)
                && !"PENDING_REVIEW".equals(creditCheckStatus)) {
            throw new IllegalArgumentException("Invalid creditCheckStatus");
        }

        // Basic validation for dtiRatio
        if (dtiRatio == null || dtiRatio < 0) {
            throw new IllegalArgumentException("Invalid dtiRatio");
        }
    }
}
