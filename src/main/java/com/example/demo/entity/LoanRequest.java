package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "loan_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* ===================== Relationships ===================== */

    /* ===================== Fields ===================== */

    @Column(nullable = false)
    private Double requestedAmount;

    @Column(nullable = false)
    private Integer tenureMonths;

    @Column
    private String purpose;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime appliedAt;

    /* ===================== Constructors ===================== */

    /**
     * Core fields constructor
     */
    public LoanRequest(
            User user,
            Double requestedAmount,
            Integer tenureMonths,
            String purpose
    ) {
        
        this.requestedAmount = requestedAmount;
        this.tenureMonths = tenureMonths;
        this.purpose = purpose;
    }

    /* ===================== Lifecycle Hooks ===================== */

    @PrePersist
    protected void onCreate() {
        // Auto-populate appliedAt
        this.appliedAt = LocalDateTime.now();

        // Default status
        if (this.status == null || this.status.isBlank()) {
            this.status = "PENDING";
        }

        // requestedAmount must be > 0
        if (requestedAmount == null || requestedAmount <= 0) {
            throw new IllegalArgumentException("Requested amount must be greater than 0");
        }

        // tenureMonths must be > 0
        if (tenureMonths == null || tenureMonths <= 0) {
            throw new IllegalArgumentException("tenureMonths must be greater than 0");
        }

        // Validate status values
        if (!status.equals("PENDING")
                && !status.equals("APPROVED")
                && !status.equals("REJECTED")) {
            throw new IllegalArgumentException("Invalid loan status");
        }
    }

    @PreUpdate
    protected void onUpdate() {
        // Re-validate fields on update
        if (requestedAmount == null || requestedAmount <= 0) {
            throw new IllegalArgumentException("Requested amount must be greater than 0");
        }

        if (tenureMonths == null || tenureMonths <= 0) {
            throw new IllegalArgumentException("tenureMonths must be greater than 0");
        }

        if (!status.equals("PENDING")
                && !status.equals("APPROVED")
                && !status.equals("REJECTED")) {
            throw new IllegalArgumentException("Invalid loan status");
        }
    }
}
