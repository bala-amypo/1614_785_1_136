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
    @Positive(message="Monthly income must be greater than 0")

    private Double monthlyIncome;
    private Double monthlyExpenses;


    @Min(value=300,message="Credit score must be >=300")
    @Max(value=900,message="Credit score must be <=900")
    private Double existingLoanEmi;
    private Integer creditScore;
    private Double savingBalance;
    private Timestamp lastUpdatedAt;

}