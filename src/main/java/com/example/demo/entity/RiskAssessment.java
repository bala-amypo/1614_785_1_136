package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(
    name = "risk_assessments",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "loan_request_id")
    }
)
public class RiskAssessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(
        name = "loan_request_id",
        nullable = false,
        unique = true
    )
    @JsonBackReference
    private LoanRequest loanRequest;

    private Double riskScore;

    private Double dtiRatio;

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LoanRequest getLoanRequest() {
        return loanRequest;
    }

    public void setLoanRequest(LoanRequest loanRequest) {
        this.loanRequest = loanRequest;
    }

    public Double getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(Double riskScore) {
        this.riskScore = riskScore;
    }

    public Double getDtiRatio() {
        return dtiRatio;
    }

    public void setDtiRatio(Double dtiRatio) {
        this.dtiRatio = dtiRatio;
    }
}
