package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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


    @NotNull(message = "Requested amount is required")
    @Min(value = 1, message = "Requested amount must be greater than 0")
    @Column(nullable = false)
    private Double requestedAmount;

    @NotNull(message = "Tenure is required")
    @Min(value = 1, message = "Tenure months must be greater than 0")
    @Column(nullable = false)
    private Integer tenureMonths;

    private String purpose;

    @NotBlank(message = "Loan status is required")
    @Pattern(
        regexp = "PENDING|APPROVED|REJECTED",
        message = "Status must be PENDING, APPROVED, or REJECTED"
    )
    @Column(nullable = false)
    private String status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime appliedAt;


    @PrePersist
    protected void onCreate() {
        this.appliedAt = LocalDateTime.now();

        if (this.status == null || this.status.isBlank()) {
            this.status = "PENDING";
        }
    }
}
