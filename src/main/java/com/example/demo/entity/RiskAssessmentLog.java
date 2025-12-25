// package com.example.demo.entity;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.*;
// import lombok.*;

// import java.time.LocalDateTime;

// @Entity
// @Table(name = "risk_assessment_logs")
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// public class RiskAssessmentLog {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

  
//     @NotNull(message = "Loan request ID is required")
//     @Column(nullable = false)
//     private Long loanRequestId;

//     @NotNull(message = "DTI ratio is required")
//     @DecimalMin(value = "0.0", inclusive = true, message = "DTI ratio must be >= 0")
//     @Column(nullable = false)
//     private Double dtiRatio;

//     @NotBlank(message = "Credit check status is required")
//     @Pattern(
//         regexp = "APPROVED|REJECTED|PENDING_REVIEW",
//         message = "creditCheckStatus must be APPROVED, REJECTED, or PENDING_REVIEW"
//     )
//     @Column(nullable = false)
//     private String creditCheckStatus;

//     @Column(nullable = false, updatable = false)
//     private LocalDateTime timestamp;


//     @PrePersist
//     protected void onCreate() {
//         this.timestamp = LocalDateTime.now();
//     }
// }




// package com.example.demo.entity;
//  import jakarta.persistence.*;
//  import jakarta.validation.constraints.*;
//  import lombok.*;

//  import java.time.LocalDateTime;

// @Entity
// public class RiskAssessmentLog {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Long loanRequestId;
//     private Double dtiRatio;
//     private Double riskScore;

//     private LocalDateTime timestamp;

//     @PrePersist
//     void ts() {
//         timestamp = LocalDateTime.now();
//     }

//     // getters & setters
// }






// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.PrePersist;

// import java.time.LocalDateTime;

// @Entity
// public class RiskAssessmentLog {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Long loanRequestId;

//     private Double dtiRatio;

//     private Double riskScore;

//     private LocalDateTime timestamp;

//     @PrePersist
//     void onCreate() {
//         timestamp = LocalDateTime.now();
//     }

//     // getters and setters
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public Long getLoanRequestId() {
//         return loanRequestId;
//     }

//     public void setLoanRequestId(Long loanRequestId) {
//         this.loanRequestId = loanRequestId;
//     }

//     public Double getDtiRatio() {
//         return dtiRatio;
//     }

//     public void setDtiRatio(Double dtiRatio) {
//         this.dtiRatio = dtiRatio;
//     }

//     public Double getRiskScore() {
//         return riskScore;
//     }

//     public void setRiskScore(Double riskScore) {
//         this.riskScore = riskScore;
//     }

//     public LocalDateTime getTimestamp() {
//         return timestamp;
//     }
// }









package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RiskAssessmentLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long loanRequestId;
    private double dtiRatio;
    private double riskScore;
    private LocalDateTime timestamp;

    @PrePersist
    void onCreate() {
        timestamp = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getLoanRequestId() { return loanRequestId; }
    public void setLoanRequestId(Long loanRequestId) { this.loanRequestId = loanRequestId; }

    public double getDtiRatio() { return dtiRatio; }
    public void setDtiRatio(double dtiRatio) { this.dtiRatio = dtiRatio; }

    public double getRiskScore() { return riskScore; }
    public void setRiskScore(double riskScore) { this.riskScore = riskScore; }

    public LocalDateTime getTimestamp() { return timestamp; }
}
