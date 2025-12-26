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







// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// public class LoanRequest {

//     public enum Status {
//         PENDING, APPROVED, REJECTED
//     }

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     private User user;

//     private Double requestedAmount;
//     private int tenureMonths;

//     @Enumerated(EnumType.STRING)
//     private Status status;

//     // Getters and Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public User getUser() { return user; }
//     public void setUser(User user) { this.user = user; }

//     public Double getRequestedAmount() { return requestedAmount; }
//     public void setRequestedAmount(Double requestedAmount) { this.requestedAmount = requestedAmount; }

//     public int getTenureMonths() { return tenureMonths; }
//     public void setTenureMonths(int tenureMonths) { this.tenureMonths = tenureMonths; }

//     public Status getStatus() { return status; }
//     public void setStatus(Status status) { this.status = status; }
// }











// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// public class LoanRequest {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     // Add fields as needed

//     // Getters and setters
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }
// }















// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// public class LoanRequest {

//     public enum Status {
//         PENDING, APPROVED, REJECTED
//     }

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     private User user;

//     private Double requestedAmount;
//     private Integer tenureMonths;
//     private String status;
//     private LocalDateTime submittedAt;

//     @PrePersist
//     public void onCreate() {
//         this.status = Status.PENDING.name();
//         this.submittedAt = LocalDateTime.now();
//     }

//     // getters & setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public User getUser() { return user; }
//     public void setUser(User user) { this.user = user; }

//     public Double getRequestedAmount() { return requestedAmount; }
//     public void setRequestedAmount(Double requestedAmount) { this.requestedAmount = requestedAmount; }

//     public Integer getTenureMonths() { return tenureMonths; }
//     public void setTenureMonths(Integer tenureMonths) { this.tenureMonths = tenureMonths; }

//     public String getStatus() { return status; }
//     public LocalDateTime getSubmittedAt() { return submittedAt; }
// }










// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.ManyToOne;

// @Entity
// public class LoanRequest {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Double amount;
//     private String status;

//     @ManyToOne
//     private User user;

//     // getters and setters
// }












// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// public class LoanRequest {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String status;

//     @ManyToOne
//     private User user;

//     public Long getId() {
//         return id;
//     }

//     public String getStatus() {
//         return status;
//     }

//     public User getUser() {
//         return user;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public void setStatus(String status) {
//         this.status = status;
//     }

//     public void setUser(User user) {
//         this.user = user;
//     }
// }






















// src/main/java/com/example/demo/entity/LoanRequest.java
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "loan_requests")
public class LoanRequest {

    public enum Status { PENDING, APPROVED, REJECTED }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double requestedAmount;
    private Integer tenureMonths;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String status;

    private Instant submittedAt;

    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = Status.PENDING.name();
        }
        if (submittedAt == null) {
            submittedAt = Instant.now();
        }
    }

    // getters and setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Double getRequestedAmount() { return requestedAmount; }

    public void setRequestedAmount(Double requestedAmount) { this.requestedAmount = requestedAmount; }

    public Integer getTenureMonths() { return tenureMonths; }

    public void setTenureMonths(Integer tenureMonths) { this.tenureMonths = tenureMonths; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public Instant getSubmittedAt() { return submittedAt; }

    public void setSubmittedAt(Instant submittedAt) { this.submittedAt = submittedAt; }
}
