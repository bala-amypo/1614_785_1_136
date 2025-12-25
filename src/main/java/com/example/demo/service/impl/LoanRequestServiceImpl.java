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



public class LoanRequestServiceImpl {

    private final LoanRequestRepository repo;
    private final UserRepository userRepo;

    public LoanRequestServiceImpl(LoanRequestRepository r, UserRepository u) {
        repo = r; userRepo = u;
    }

    public LoanRequest submitRequest(LoanRequest lr) {
        if (lr.getRequestedAmount() <= 0)
            throw new BadRequestException("Requested amount");

        userRepo.findById(lr.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        lr.setStatus(LoanRequest.Status.PENDING.name());
        return repo.save(lr);
    }

    public LoanRequest getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan request not found"));
    }

    public List<LoanRequest> getRequestsByUser(Long uid) {
        return repo.findByUserId(uid);
    }
}
