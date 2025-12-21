package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    /* ===================== Fields ===================== */

    @NotNull(message = "Eligibility flag is required")
    @Column(nullable = false)
    private Boolean isEligible;

    @NotNull(message = "Max eligible amount is required")
    @Min(value = 0, message = "Max eligible amount must be >= 0")
    @Column(nullable = false)
    private Double maxEligibleAmount;

    @NotNull(message = "Estimated EMI is required")
    @Min(value = 0, message = "Estimated EMI must be >= 0")
    @Column(nullable = false)
    private Double estimatedEmi;

    @NotBlank(message = "Risk level is required")
    @Pattern(
        regexp = "LOW|MEDIUM|HIGH",
        message = "Risk level must be LOW, MEDIUM, or HIGH"
    )
    @Column(nullable = false)
    private String riskLevel;

    private String rejectionReason;

    @Column(nullable = false, updatable = false)
    private LocalDateTime calculatedAt;

    /* ===================== Lifecycle Hook ===================== */

    @PrePersist
    protected void onCreate() {
        this.calculatedAt = LocalDateTime.now();
    }
}
