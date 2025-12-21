package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    /* ===================== Fields ===================== */

    @NotNull(message = "Loan request ID is required")
    @Column(nullable = false)
    private Long loanRequestId;

    @NotNull(message = "DTI ratio is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "DTI ratio must be >= 0")
    @Column(nullable = false)
    private Double dtiRatio;

    @NotBlank(message = "Credit check status is required")
    @Pattern(
        regexp = "APPROVED|REJECTED|PENDING_REVIEW",
        message = "creditCheckStatus must be APPROVED, REJECTED, or PENDING_REVIEW"
    )
    @Column(nullable = false)
    private String creditCheckStatus;

    @Column(nullable = false, updatable = false)
    private LocalDateTime timestamp;

    /* ===================== Lifecycle Hook ===================== */

    @PrePersist
    protected void onCreate() {
        this.timestamp = LocalDateTime.now();
    }
}
