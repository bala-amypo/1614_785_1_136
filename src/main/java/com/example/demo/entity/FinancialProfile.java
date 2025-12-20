package com.example.demo.entity;

import jakarta.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinanciaProfile{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private Long id;
    @OneToOne
    @JoinColumn(name="user_id",nullable=false)
    private String user;
    @Positive(message="Monthly income ")

    private Double monthlyIncome;
    private Double monthlyExpenses;
    private Double existingLoanEmi;
    private Integer creditScore;
    private Double savingBalance;
    private Timestamp lastUpdatedAt;

}