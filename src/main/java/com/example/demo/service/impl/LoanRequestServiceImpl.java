// package com.example.demo.service.impl;

// import com.example.demo.entity.LoanRequest;
// import com.example.demo.service.LoanRequestService;
// import org.springframework.stereotype.Service;

// import java.util.ArrayList;
// import java.util.List;

// @Service
// public class LoanRequestServiceImpl implements LoanRequestService {

//     // Temporary in-memory store (replace with repository if you have one)
//     private final List<LoanRequest> store = new ArrayList<>();

//     @Override
//     public LoanRequest postData4(LoanRequest use) {
//         store.add(use);
//         return use;
//     }

//     @Override
//     public List<LoanRequest> getAllData4() {
//         return new ArrayList<>(store);
//     }

//     @Override
//     public String DeleteData4(Long id) {
//         store.removeIf(r -> r.getId().equals(id));
//         return "Deleted";
//     }

//     @Override
//     public LoanRequest getData4(Long id) {
//         return store.stream()
//                 .filter(r -> r.getId().equals(id))
//                 .findFirst()
//                 .orElse(null);
//     }

//     @Override
//     public LoanRequest updateData4(Long id, LoanRequest entity) {
//         for (int i = 0; i < store.size(); i++) {
//             if (store.get(i).getId().equals(id)) {
//                 store.set(i, entity);
//                 return entity;
//             }
//         }
//         return null;
//     }
// }














// package com.example.demo.service.impl;

// import com.example.demo.entity.LoanRequest;
// import com.example.demo.repository.LoanRequestRepository;
// import com.example.demo.service.LoanRequestService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class LoanRequestServiceImpl implements LoanRequestService {

//     @Autowired
//     private LoanRequestRepository repository;

//     @Override
//     public LoanRequest submitRequest(LoanRequest request) {
//         return repository.save(request);
//     }

//     @Override
//     public List<LoanRequest> getRequestsByUser(Long userId) {
//         // Assuming your LoanRequest entity has a userId field, replace this with your query logic
//         return repository.findByUserId(userId);
//     }

//     @Override
//     public LoanRequest getById(Long id) {
//         return repository.findById(id).orElse(null);
//     }
// }













// package com.example.demo.service.impl;

// import com.example.demo.entity.LoanRequest;
// import com.example.demo.repository.LoanRequestRepository;
// import com.example.demo.service.LoanRequestService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class LoanRequestServiceImpl implements LoanRequestService {

//     @Autowired
//     private LoanRequestRepository repository;

//     @Override
//     public LoanRequest postData4(LoanRequest request) {
//         return repository.save(request);
//     }

//     @Override
//     public List<LoanRequest> getAllData4() {
//         return repository.findAll();
//     }

//     @Override
//     public String DeleteData4(Long id) {
//         if (repository.existsById(id)) {
//             repository.deleteById(id);
//             return "Deleted successfully";
//         }
//         return "Not found with id: " + id;
//     }

//     @Override
//     public LoanRequest getData4(Long id) {
//         return repository.findById(id).orElse(null);
//     }

//     @Override
//     public LoanRequest updateData4(Long id, LoanRequest entity) {
//         return repository.findById(id).map(existing -> {
//             // update fields accordingly
//             return repository.save(existing);
//         }).orElse(null);
//     }
// }





















// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// @Service
// public class LoanRequestServiceImpl implements LoanRequestService {

//     @Autowired
//     private LoanRequestRepository repository;

//     @Override
//     public LoanRequest createLoanRequest(LoanRequest request) {
//         request.setStatus("SUBMITTED");
//         return repository.save(request);
//     }

//     @Override
//     public LoanRequest getLoanRequestById(Long id) {
//         return repository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Loan request not found"));
//     }

//     @Override
//     public List<LoanRequest> getLoanRequestsByUser(Long userId) {
//         return repository.findByUserId(userId);
//     }
// }












// // src/main/java/com/example/demo/service/impl/LoanRequestServiceImpl.java
// package com.example.demo.service.impl;

// import com.example.demo.entity.LoanRequest;
// import com.example.demo.entity.User;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.LoanRequestRepository;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.LoanRequestService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class LoanRequestServiceImpl implements LoanRequestService {

//     private final LoanRequestRepository loanRequestRepository;
//     private final UserRepository userRepository;

//     public LoanRequestServiceImpl(LoanRequestRepository loanRequestRepository,
//                                   UserRepository userRepository) {
//         this.loanRequestRepository = loanRequestRepository;
//         this.userRepository = userRepository;
//     }

//     @Override
//     public LoanRequest submitRequest(LoanRequest request) {
//         if (request.getRequestedAmount() == null || request.getRequestedAmount() <= 0) {
//             throw new BadRequestException("Amount must be > 0");
//         }
//         Long userId = request.getUser() != null ? request.getUser().getId() : null;
//         if (userId == null || userRepository.findById(userId).isEmpty()) {
//             throw new ResourceNotFoundException("User not found");
//         }
//         if (request.getStatus() == null) {
//             request.setStatus(LoanRequest.Status.PENDING.name());
//         }
//         return loanRequestRepository.save(request);
//     }

//     @Override
//     public LoanRequest getById(Long id) {
//         return loanRequestRepository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("LoanRequest not found"));
//     }

//     @Override
//     public List<LoanRequest> getRequestsByUser(Long userId) {
//         return loanRequestRepository.findByUserId(userId);
//     }
// }




























// // src/main/java/com/example/demo/service/impl/LoanRequestServiceImpl.java
// package com.example.demo.service.impl;

// import com.example.demo.entity.LoanRequest;
// import com.example.demo.entity.User;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.LoanRequestRepository;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.LoanRequestService;
// import org.springframework.stereotype.Service;

// import java.time.Instant;
// import java.util.List;

// @Service
// public class LoanRequestServiceImpl implements LoanRequestService {

//     private final LoanRequestRepository loanRequestRepository;
//     private final UserRepository userRepository;

//     public LoanRequestServiceImpl(LoanRequestRepository loanRequestRepository,
//                                   UserRepository userRepository) {
//         this.loanRequestRepository = loanRequestRepository;
//         this.userRepository = userRepository;
//     }

//     @Override
//     public LoanRequest submitRequest(LoanRequest request) {
//         if (request.getRequestedAmount() == null || request.getRequestedAmount() <= 0) {
//             throw new BadRequestException("Amount must be > 0");
//         }

//         Long userId = request.getUser() != null ? request.getUser().getId() : null;
//         if (userId == null || userRepository.findById(userId).isEmpty()) {
//             throw new ResourceNotFoundException("User not found");
//         }

//         // Explicitly set defaults so tests see them even with mocked repo (t28)
//         if (request.getStatus() == null) {
//             request.setStatus(LoanRequest.Status.PENDING.name());
//         }
//         if (request.getSubmittedAt() == null) {
//             request.setSubmittedAt(Instant.now());
//         }

//         return loanRequestRepository.save(request);
//     }

//     @Override
//     public LoanRequest getById(Long id) {
//         return loanRequestRepository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("LoanRequest not found"));
//     }

//     @Override
//     public List<LoanRequest> getRequestsByUser(Long userId) {
//         return loanRequestRepository.findByUserId(userId);
//     }
// }
