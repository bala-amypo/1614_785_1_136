// package com.example.demo.entity;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.*;
// import lombok.*;

// import java.time.LocalDateTime;

// @Entity
// @Table(name = "eligibility_results")
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// public class EligibilityResult {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;


//     @NotNull(message = "Eligibility flag is required")
//     @Column(nullable = false)
//     private Boolean isEligible;

//     @NotNull(message = "Max eligible amount is required")
//     @Min(value = 0, message = "Max eligible amount must be >= 0")
//     @Column(nullable = false)
//     private Double maxEligibleAmount;

//     @NotNull(message = "Estimated EMI is required")
//     @Min(value = 0, message = "Estimated EMI must be >= 0")
//     @Column(nullable = false)
//     private Double estimatedEmi;

//     @NotBlank(message = "Risk level is required")
//     @Pattern(
//         regexp = "LOW|MEDIUM|HIGH",
//         message = "Risk level must be LOW, MEDIUM, or HIGH"
//     )
//     @Column(nullable = false)
//     private String riskLevel;

//     private String rejectionReason;

//     @Column(nullable = false, updatable = false)
//     private LocalDateTime calculatedAt;


//     @PrePersist
//     protected void onCreate() {
//         this.calculatedAt = LocalDateTime.now();
//     }
// }



// package com.example.demo.entity;
//  import jakarta.persistence.*;
//  import jakarta.validation.constraints.*;
//  import lombok.*;

//  import java.time.LocalDateTime;

// @Entity
// public class EligibilityResult {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @OneToOne
//     private LoanRequest loanRequest;

//     private Boolean isEligible;
//     private Double maxEligibleAmount;
//     private Double estimatedEmi;
//     private String riskLevel;
//     private String rejectionReason;

//     private LocalDateTime calculatedAt;

//     @PrePersist
//     void calcTime() {
//         calculatedAt = LocalDateTime.now();
//     }

//     // getters & setters
// }









// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// public class EligibilityResult {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @OneToOne
//     private LoanRequest loanRequest;

//     private boolean isEligible;
//     private String riskLevel;
//     private double maxEligibleAmount;
//     private double estimatedEmi;

//     // Getters and Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public LoanRequest getLoanRequest() { return loanRequest; }
//     public void setLoanRequest(LoanRequest loanRequest) { this.loanRequest = loanRequest; }

//     public boolean getIsEligible() { return isEligible; }
//     public void setIsEligible(boolean isEligible) { this.isEligible = isEligible; }

//     public String getRiskLevel() { return riskLevel; }
//     public void setRiskLevel(String riskLevel) { this.riskLevel = riskLevel; }

//     public double getMaxEligibleAmount() { return maxEligibleAmount; }
//     public void setMaxEligibleAmount(double maxEligibleAmount) { this.maxEligibleAmount = maxEligibleAmount; }

//     public double getEstimatedEmi() { return estimatedEmi; }
//     public void setEstimatedEmi(double estimatedEmi) { this.estimatedEmi = estimatedEmi; }
// }












import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class EligibilityResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String riskLevel;
    private Double dti;
    private Boolean eligible;

    @OneToOne
    private LoanRequest loanRequest;

    // getters and setters
}
