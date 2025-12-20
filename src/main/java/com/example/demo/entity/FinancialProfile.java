package com.example.demo.entity;




@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinanciaProfile{
    @Id
    @GeneratedValue(strategy)
    private Long id;
    private String user;
    private Double monthlyIncome;
    private Double monthlyExpenses;
    private Double existingLoanEmi;
    private Integer creditScore;
    private Double savingBalance;
    private Timestamp lastUpdatedAt;

}