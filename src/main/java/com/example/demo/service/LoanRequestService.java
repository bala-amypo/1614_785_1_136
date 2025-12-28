// package com.example.demo.service;

// import com.example.demo.entity.LoanRequest;
// import java.util.List;

// public interface LoanRequestService {
//     LoanRequest postData4(LoanRequest use);
//     List<LoanRequest> getAllData4();
//     String DeleteData4(Long id);
//     LoanRequest getData4(Long id);
//     LoanRequest updateData4(Long id, LoanRequest entity);
// }






// package com.example.demo.service;

// import com.example.demo.entity.LoanRequest;

// import java.util.List;

// public interface LoanRequestService {
//     LoanRequest submitRequest(LoanRequest request);
//     List<LoanRequest> getRequestsByUser(Long userId);
//     LoanRequest getById(Long id);
// }










// package com.example.demo.service;

// import com.example.demo.entity.LoanRequest;
// import java.util.List;

// public interface LoanRequestService {
//     LoanRequest postData4(LoanRequest request);
//     List<LoanRequest> getAllData4();
//     String DeleteData4(Long id);
//     LoanRequest getData4(Long id);
//     LoanRequest updateData4(Long id, LoanRequest entity);
// }







// import java.util.List;

// public interface LoanRequestService {

//     LoanRequest createLoanRequest(LoanRequest request);

//     LoanRequest getLoanRequestById(Long id);

//     List<LoanRequest> getLoanRequestsByUser(Long userId);
// }












// // src/main/java/com/example/demo/service/LoanRequestService.java
// package com.example.demo.service;

// import com.example.demo.entity.LoanRequest;

// import java.util.List;

// public interface LoanRequestService {
//     LoanRequest submitRequest(LoanRequest request);
//     LoanRequest getById(Long id);
//     List<LoanRequest> getRequestsByUser(Long userId);
// }












// // src/main/java/com/example/demo/service/LoanRequestService.java
// package com.example.demo.service;

// import com.example.demo.entity.LoanRequest;

// import java.util.List;

// public interface LoanRequestService {
//     LoanRequest submitRequest(LoanRequest request);
//     LoanRequest getById(Long id);
//     List<LoanRequest> getRequestsByUser(Long userId);
// }













// src/main/java/com/example/demo/service/LoanRequestService.java
package com.example.demo.service;

import com.example.demo.entity.LoanRequest;

import java.util.List;

public interface LoanRequestService {
    LoanRequest submitRequest(LoanRequest request);
    LoanRequest getById(Long id);
    List<LoanRequest> getRequestsByUser(Long userId);
}