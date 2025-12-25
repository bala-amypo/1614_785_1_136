// package com.example.demo.service.impl;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;   
// import com.example.demo.entity.LoanRequest;
// import com.example.demo.repository.LoanRequestRepository;
// import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.service.LoanRequestService;                

// @Service
// public class LoanRequestServiceImpl implements LoanRequestService{

//     @Autowired LoanRequestRepository used;
//     @Override
//     public LoanRequest postData4(LoanRequest use){
//         return used.save(use);  
//     }
//     @Override
//     public List<LoanRequest>getAllData4(){
//         return used.findAll();
//     }
//     @Override
//     public String DeleteData4(Long id){
//         used.deleteById(id);
//         return "Deleted successfully";
//     }
//     @Override
//     public LoanRequest getData4(Long id){
//     return used.findById(id).orElse(null);
//     }
//     @Override
//     public LoanRequest updateData4(Long id,LoanRequest entity){
//         if(used.existsById(id)){
//             entity.setId(id);
//             return used.save(entity);
//         } 
//         return null;
//     }
// }




// package com.example.demo.service.impl;

//  import java.util.List;
//  import org.springframework.beans.factory.annotation.Autowired;
//  import org.springframework.stereotype.Service;   
//  import com.example.demo.entity.LoanRequest;
//  import com.example.demo.repository.LoanRequestRepository;
//  import org.springframework.web.bind.annotation.PathVariable;
//  import com.example.demo.service.LoanRequestService;                

//  @Service
// public class LoanRequestServiceImpl {

//     private final LoanRequestRepository repo;
//     private final UserRepository userRepo;

//     public LoanRequestServiceImpl(LoanRequestRepository r, UserRepository u) {
//         repo = r; userRepo = u;
//     }

//     public LoanRequest submitRequest(LoanRequest lr) {
//         if (lr.getRequestedAmount() <= 0)
//             throw new BadRequestException("Requested amount");

//         userRepo.findById(lr.getUser().getId())
//                 .orElseThrow(() -> new ResourceNotFoundException("User not found"));

//         lr.setStatus(LoanRequest.Status.PENDING.name());
//         return repo.save(lr);
//     }

//     public LoanRequest getById(Long id) {
//         return repo.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Loan request not found"));
//     }

//     public List<LoanRequest> getRequestsByUser(Long uid) {
//         return repo.findByUserId(uid);
//     }
// }





// package com.example.demo.service.impl;

// import com.example.demo.entity.LoanRequest;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.LoanRequestRepository;
// import com.example.demo.repository.UserRepository;

// import java.util.List;

// public class LoanRequestServiceImpl {

//     private final LoanRequestRepository repository;
//     private final UserRepository userRepository;

//     public LoanRequestServiceImpl(LoanRequestRepository repository,
//                                   UserRepository userRepository) {
//         this.repository = repository;
//         this.userRepository = userRepository;
//     }

//     public LoanRequest submitRequest(LoanRequest request) {

//         if (request.getRequestedAmount() <= 0) {
//             throw new BadRequestException("Requested amount");
//         }

//         userRepository.findById(request.getUser().getId())
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("User not found"));

//         request.setStatus(LoanRequest.Status.PENDING.name());
//         return repository.save(request);
//     }

//     public LoanRequest getById(Long id) {
//         return repository.findById(id)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Loan request not found"));
//     }

//     public List<LoanRequest> getRequestsByUser(Long userId) {
//         return repository.findByUserId(userId);
//     }
// }








// package com.example.demo.service.impl;

// import com.example.demo.entity.LoanRequest;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.LoanRequestRepository;
// import com.example.demo.repository.UserRepository;

// import java.util.List;
// import java.util.Optional;

// public class LoanRequestServiceImpl {

//     private final LoanRequestRepository repository;
//     private final UserRepository userRepository;

//     public LoanRequestServiceImpl(LoanRequestRepository repository,
//                                   UserRepository userRepository) {
//         this.repository = repository;
//         this.userRepository = userRepository;
//     }

//     public LoanRequest submitRequest(LoanRequest request) {

//         if (request.getRequestedAmount() <= 0) {
//             throw new BadRequestException("Requested amount must be greater than zero");
//         }

//         // Check if user exists
//         Optional.ofNullable(request.getUser())
//                 .flatMap(u -> userRepository.findById(u.getId()))
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("User not found"));

//         // Set initial status
//         request.setStatus(LoanRequest.Status.PENDING.name());

//         return repository.save(request);
//     }

//     public LoanRequest getById(Long id) {
//         return repository.findById(id)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Loan request not found"));
//     }

//     public List<LoanRequest> getRequestsByUser(Long userId) {
//         return repository.findByUserId(userId);
//     }
// }







// package com.example.demo.service.impl;

// import com.example.demo.entity.LoanRequest;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.LoanRequestRepository;
// import com.example.demo.repository.UserRepository;

// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class LoanRequestServiceImpl {

//     private final LoanRequestRepository repository;
//     private final UserRepository userRepository;

//     public LoanRequestServiceImpl(LoanRequestRepository repository,
//                                   UserRepository userRepository) {
//         this.repository = repository;
//         this.userRepository = userRepository;
//     }

//     public LoanRequest submitRequest(LoanRequest request) {

//         if (request.getRequestedAmount() <= 0) {
//             throw new BadRequestException("Requested amount must be greater than zero");
//         }

//         // Check if user exists
//         Optional.ofNullable(request.getUser())
//                 .flatMap(u -> userRepository.findById(u.getId()))
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("User not found"));

//         // Set initial status
//         request.setStatus(LoanRequest.Status.PENDING.name());

//         return repository.save(request);
//     }

//     public LoanRequest getById(Long id) {
//         return repository.findById(id)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Loan request not found"));
//     }

//     public List<LoanRequest> getRequestsByUser(Long userId) {
//         return repository.findByUserId(userId);
//     }
// }








package com.example.demo.service.impl;

import com.example.demo.entity.LoanRequest;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class LoanRequestServiceImpl {

    private final LoanRequestRepository repository;
    private final UserRepository userRepository;

    public LoanRequestServiceImpl(LoanRequestRepository repository,
                                  UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public LoanRequest submitRequest(LoanRequest request) {

        if (request.getRequestedAmount() <= 0) {
            throw new BadRequestException("Requested amount must be greater than zero");
        }

        // Check if user exists
        Optional.ofNullable(request.getUser())
                .flatMap(u -> userRepository.findById(u.getId()))
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        // Set initial status using enum
        request.setStatus(LoanRequest.Status.PENDING);

        return repository.save(request);
    }

    public LoanRequest getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Loan request not found"));
    }

    public List<LoanRequest> getRequestsByUser(Long userId) {
        return repository.findByUserId(userId);
    }
}
