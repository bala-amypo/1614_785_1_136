// package com.example.demo.entity;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.*;
// import lombok.*;

// import java.time.LocalDateTime;

// @Entity
// @Table(name = "loan_requests")
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// public class LoanRequest {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;


//     @NotNull(message = "Requested amount is required")
//     @Min(value = 1, message = "Requested amount must be greater than 0")
//     @Column(nullable = false)
//     private Double requestedAmount;

//     @NotNull(message = "Tenure is required")
//     @Min(value = 1, message = "Tenure months must be greater than 0")
//     @Column(nullable = false)
//     private Integer tenureMonths;

//     private String purpose;

//     @NotBlank(message = "Loan status is required")
//     @Pattern(
//         regexp = "PENDING|APPROVED|REJECTED",
//         message = "Status must be PENDING, APPROVED, or REJECTED"
//     )
//     @Column(nullable = false)
//     private String status;

//     @Column(nullable = false, updatable = false)
//     private LocalDateTime appliedAt;


//     @PrePersist
//     protected void onCreate() {
//         this.appliedAt = LocalDateTime.now();

//         if (this.status == null || this.status.isBlank()) {
//             this.status = "PENDING";
//         }
//     }
// }





// package com.example.demo.entity;

//  import jakarta.persistence.*;
//  import jakarta.validation.constraints.*;
//  import lombok.*;

//  import java.time.LocalDateTime;


// @Entity
// public class LoanRequest {

//     public enum Status { PENDING, APPROVED, REJECTED }

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     private User user;

//     private Double requestedAmount;
//     private Integer tenureMonths;
//     private String status = Status.PENDING.name();
//     private LocalDateTime submittedAt;

//     @PrePersist
//     void onCreate() {
//         submittedAt = LocalDateTime.now();
//     }

//     // getters & setters
// }






// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// public class LoanRequest {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     private User user;

//     private double requestedAmount;
//     private int tenureMonths;
//     private String status;

//     // Getters and Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public User getUser() { return user; }
//     public void setUser(User user) { this.user = user; }

//     public double getRequestedAmount() { return requestedAmount; }
//     public void setRequestedAmount(double requestedAmount) { this.requestedAmount = requestedAmount; }

//     public int getTenureMonths() { return tenureMonths; }
//     public void setTenureMonths(int tenureMonths) { this.tenureMonths = tenureMonths; }

//     public String getStatus() { return status; }
//     public void setStatus(String status) { this.status = status; }
// }







package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class LoanRequest {

    public enum Status {
        PENDING, APPROVED, REJECTED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private Double requestedAmount;
    private int tenureMonths;

    @Enumerated(EnumType.STRING)
    private Status status;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Double getRequestedAmount() { return requestedAmount; }
    public void setRequestedAmount(Double requestedAmount) { this.requestedAmount = requestedAmount; }

    public int getTenureMonths() { return tenureMonths; }
    public void setTenureMonths(int tenureMonths) { this.tenureMonths = tenureMonths; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
