// package com.example.demo.service.impl;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;   
// import com.example.demo.entity.EligibilityResult;
// import com.example.demo.repository.EligibilityResultRepository;
// import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.service.LoanEligibilityService;                

// @Service
// public class LoanEligibilityServiceImpl implements LoanEligibilityService{

//     @Autowired EligibilityResultRepository used;
//     @Override
//     public EligibilityResult postData2(EligibilityResult use){
//         return used.save(use);  
//     }
//     @Override
//     public List<EligibilityResult>getAllData2(){
//         return used.findAll();
//     }
//     @Override
//     public String DeleteData2(Long id){
//         used.deleteById(id);
//         return "Deleted successfully";
//     }
//     @Override
//     public EligibilityResult getData2(Long id){
//     return used.findById(id).orElse(null);
//     }
//     @Override
//     public EligibilityResult updateData2(Long id,EligibilityResult entity){
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
//  import com.example.demo.entity.EligibilityResult;
//  import com.example.demo.repository.EligibilityResultRepository;
//  import org.springframework.web.bind.annotation.PathVariable;
//  import com.example.demo.service.LoanEligibilityService;                

//  @Service
// public class LoanEligibilityServiceImpl {

//     private final LoanRequestRepository loanRepo;
//     private final FinancialProfileRepository fpRepo;
//     private final EligibilityResultRepository erRepo;

//     public LoanEligibilityServiceImpl(LoanRequestRepository l,
//                                   FinancialProfileRepository f,
//                                   EligibilityResultRepository e) {
//         loanRepo = l; fpRepo = f; erRepo = e;
//     }

//     public EligibilityResult evaluateEligibility(Long loanId) {

//         if (erRepo.findByLoanRequestId(loanId).isPresent())
//             throw new BadRequestException("Eligibility already evaluated");

//         LoanRequest lr = loanRepo.findById(loanId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Loan request not found"));

//         FinancialProfile fp = fpRepo.findByUserId(lr.getUser().getId())
//                 .orElseThrow(() -> new ResourceNotFoundException("Financial profile not found"));

//         EligibilityResult er = new EligibilityResult();
//         er.setLoanRequest(lr);
//         er.setIsEligible(true);
//         er.setMaxEligibleAmount(Math.max(0, fp.getMonthlyIncome() * 10));
//         er.setEstimatedEmi(er.getMaxEligibleAmount() / lr.getTenureMonths());
//         er.setRiskLevel("LOW");

//         return erRepo.save(er);
//     }

//     public EligibilityResult getByLoanRequestId(Long id) {
//         return erRepo.findByLoanRequestId(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Eligibility result not found"));
//     }
// }




// package com.example.demo.service.impl;

// import com.example.demo.entity.EligibilityResult;
// import com.example.demo.entity.FinancialProfile;
// import com.example.demo.entity.LoanRequest;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.EligibilityResultRepository;
// import com.example.demo.repository.FinancialProfileRepository;
// import com.example.demo.repository.LoanRequestRepository;

// public class LoanEligibilityServiceImpl {

//     private final LoanRequestRepository loanRepo;
//     private final FinancialProfileRepository profileRepo;
//     private final EligibilityResultRepository resultRepo;

//     public LoanEligibilityServiceImpl(LoanRequestRepository loanRepo,
//                                       FinancialProfileRepository profileRepo,
//                                       EligibilityResultRepository resultRepo) {
//         this.loanRepo = loanRepo;
//         this.profileRepo = profileRepo;
//         this.resultRepo = resultRepo;
//     }

//     public EligibilityResult evaluateEligibility(Long loanRequestId) {

//         if (resultRepo.findByLoanRequestId(loanRequestId).isPresent()) {
//             throw new BadRequestException("Eligibility already evaluated");
//         }

//         LoanRequest loan = loanRepo.findById(loanRequestId)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Loan request not found"));

//         FinancialProfile profile = profileRepo
//                 .findByUserId(loan.getUser().getId())
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Financial profile not found"));

//         EligibilityResult result = new EligibilityResult();
//         result.setLoanRequest(loan);
//         result.setIsEligible(true);
//         result.setRiskLevel("LOW");
//         result.setMaxEligibleAmount(Math.max(0, profile.getMonthlyIncome() * 10));
//         result.setEstimatedEmi(
//                 result.getMaxEligibleAmount() / loan.getTenureMonths()
//         );

//         return resultRepo.save(result);
//     }

//     public EligibilityResult getByLoanRequestId(Long loanRequestId) {
//         return resultRepo.findByLoanRequestId(loanRequestId)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Eligibility result not found"));
//     }
// }








// package com.example.demo.service.impl;

// import com.example.demo.entity.EligibilityResult;
// import com.example.demo.entity.FinancialProfile;
// import com.example.demo.entity.LoanRequest;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.EligibilityResultRepository;
// import com.example.demo.repository.FinancialProfileRepository;
// import com.example.demo.repository.LoanRequestRepository;

// import java.util.Optional; // Required for Optional usage

// public class LoanEligibilityServiceImpl {

//     private final LoanRequestRepository loanRepo;
//     private final FinancialProfileRepository profileRepo;
//     private final EligibilityResultRepository resultRepo;

//     public LoanEligibilityServiceImpl(LoanRequestRepository loanRepo,
//                                       FinancialProfileRepository profileRepo,
//                                       EligibilityResultRepository resultRepo) {
//         this.loanRepo = loanRepo;
//         this.profileRepo = profileRepo;
//         this.resultRepo = resultRepo;
//     }

//     public EligibilityResult evaluateEligibility(Long loanRequestId) {

//         // Check if eligibility already exists
//         Optional<EligibilityResult> existingResult = resultRepo.findByLoanRequestId(loanRequestId);
//         if (existingResult.isPresent()) {
//             throw new BadRequestException("Eligibility already evaluated");
//         }

//         // Get LoanRequest
//         LoanRequest loan = loanRepo.findById(loanRequestId)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Loan request not found"));

//         // Get FinancialProfile
//         FinancialProfile profile = profileRepo.findByUserId(loan.getUser().getId())
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Financial profile not found"));

//         // Create EligibilityResult
//         EligibilityResult result = new EligibilityResult();
//         result.setLoanRequest(loan);
//         result.setIsEligible(true);
//         result.setRiskLevel("LOW");
//         result.setMaxEligibleAmount(Math.max(0, profile.getMonthlyIncome() * 10));
//         result.setEstimatedEmi(
//                 result.getMaxEligibleAmount() / loan.getTenureMonths()
//         );

//         return resultRepo.save(result);
//     }

//     public EligibilityResult getByLoanRequestId(Long loanRequestId) {
//         return resultRepo.findByLoanRequestId(loanRequestId)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Eligibility result not found"));
//     }
// }









// package com.example.demo.service.impl;

// import com.example.demo.entity.EligibilityResult;
// import com.example.demo.entity.FinancialProfile;
// import com.example.demo.entity.LoanRequest;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.EligibilityResultRepository;
// import com.example.demo.repository.FinancialProfileRepository;
// import com.example.demo.repository.LoanRequestRepository;
// import com.example.demo.service.LoanEligibilityService;

// import org.springframework.stereotype.Service;

// @Service // <-- make this a Spring bean
// public class LoanEligibilityServiceImpl implements LoanEligibilityService {

//     private final LoanRequestRepository loanRepo;
//     private final FinancialProfileRepository profileRepo;
//     private final EligibilityResultRepository resultRepo;

//     public LoanEligibilityServiceImpl(LoanRequestRepository loanRepo,
//                                       FinancialProfileRepository profileRepo,
//                                       EligibilityResultRepository resultRepo) {
//         this.loanRepo = loanRepo;
//         this.profileRepo = profileRepo;
//         this.resultRepo = resultRepo;
//     }

//     @Override
//     public EligibilityResult evaluateEligibility(Long loanRequestId) {
//         // Check if eligibility already exists
//         resultRepo.findByLoanRequestId(loanRequestId).ifPresent(r -> {
//             throw new BadRequestException("Eligibility already evaluated");
//         });

//         // Fetch loan request
//         LoanRequest loan = loanRepo.findById(loanRequestId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Loan request not found"));

//         // Fetch financial profile
//         FinancialProfile profile = profileRepo.findByUserId(loan.getUser().getId())
//                 .orElseThrow(() -> new ResourceNotFoundException("Financial profile not found"));

//         // Calculate eligibility
//         EligibilityResult result = new EligibilityResult();
//         result.setLoanRequest(loan);
//         result.setIsEligible(true); // example logic, you can change
//         result.setRiskLevel("LOW");
//         result.setMaxEligibleAmount(Math.max(0, profile.getMonthlyIncome() * 10));
//         result.setEstimatedEmi(result.getMaxEligibleAmount() / loan.getTenureMonths());

//         return resultRepo.save(result);
//     }

//     @Override
//     public EligibilityResult getByLoanRequestId(Long loanRequestId) {
//         return resultRepo.findByLoanRequestId(loanRequestId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Eligibility result not found"));
//     }
// }










// package com.example.demo.service.impl;

// import com.example.demo.entity.EligibilityResult;
// import com.example.demo.entity.FinancialProfile;
// import com.example.demo.entity.LoanRequest;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.EligibilityResultRepository;
// import com.example.demo.repository.FinancialProfileRepository;
// import com.example.demo.repository.LoanRequestRepository;
// import com.example.demo.service.LoanEligibilityService;

// import org.springframework.stereotype.Service;

// @Service
// public class LoanEligibilityServiceImpl implements LoanEligibilityService {

//     private final LoanRequestRepository loanRepo;
//     private final FinancialProfileRepository profileRepo;
//     private final EligibilityResultRepository resultRepo;

//     public LoanEligibilityServiceImpl(LoanRequestRepository loanRepo,
//                                       FinancialProfileRepository profileRepo,
//                                       EligibilityResultRepository resultRepo) {
//         this.loanRepo = loanRepo;
//         this.profileRepo = profileRepo;
//         this.resultRepo = resultRepo;
//     }

//     // Method 1: Evaluate Eligibility
//     @Override
//     public EligibilityResult evaluateEligibility(Long loanRequestId) {
//         resultRepo.findByLoanRequestId(loanRequestId).ifPresent(r -> {
//             throw new BadRequestException("Eligibility already evaluated");
//         });

//         LoanRequest loan = loanRepo.findById(loanRequestId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Loan request not found"));

//         FinancialProfile profile = profileRepo.findByUserId(loan.getUser().getId())
//                 .orElseThrow(() -> new ResourceNotFoundException("Financial profile not found"));

//         EligibilityResult result = new EligibilityResult();
//         result.setLoanRequest(loan);
//         result.setIsEligible(true); // example logic
//         result.setRiskLevel("LOW");
//         result.setMaxEligibleAmount(Math.max(0, profile.getMonthlyIncome() * 10));
//         result.setEstimatedEmi(result.getMaxEligibleAmount() / loan.getTenureMonths());

//         return resultRepo.save(result);
//     }

//     // Method 2: Get Eligibility by LoanRequestId
//     @Override
//     public EligibilityResult getByLoanRequestId(Long loanRequestId) {
//         return resultRepo.findByLoanRequestId(loanRequestId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Eligibility result not found"));
//     }

//     // Method 3: Implement updateData2 (was missing)
//     @Override
//     public void updateData2(Long loanRequestId, EligibilityResult result) {
//         EligibilityResult existing = resultRepo.findByLoanRequestId(loanRequestId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Eligibility result not found"));

//         existing.setIsEligible(result.getIsEligible());
//         existing.setRiskLevel(result.getRiskLevel());
//         existing.setMaxEligibleAmount(result.getMaxEligibleAmount());
//         existing.setEstimatedEmi(result.getEstimatedEmi());

//         resultRepo.save(existing);
//     }
// }










// package com.example.demo.service.impl;

// import com.example.demo.entity.EligibilityResult;
// import com.example.demo.entity.FinancialProfile;
// import com.example.demo.entity.LoanRequest;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.EligibilityResultRepository;
// import com.example.demo.repository.FinancialProfileRepository;
// import com.example.demo.repository.LoanRequestRepository;
// import com.example.demo.service.LoanEligibilityService;

// import org.springframework.stereotype.Service;

// @Service
// public class LoanEligibilityServiceImpl implements LoanEligibilityService {

//     private final LoanRequestRepository loanRepo;
//     private final FinancialProfileRepository profileRepo;
//     private final EligibilityResultRepository resultRepo;

//     public LoanEligibilityServiceImpl(LoanRequestRepository loanRepo,
//                                       FinancialProfileRepository profileRepo,
//                                       EligibilityResultRepository resultRepo) {
//         this.loanRepo = loanRepo;
//         this.profileRepo = profileRepo;
//         this.resultRepo = resultRepo;
//     }

//     @Override
//     public EligibilityResult evaluateEligibility(Long loanRequestId) {
//         resultRepo.findByLoanRequestId(loanRequestId).ifPresent(r -> {
//             throw new BadRequestException("Eligibility already evaluated");
//         });

//         LoanRequest loan = loanRepo.findById(loanRequestId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Loan request not found"));

//         FinancialProfile profile = profileRepo.findByUserId(loan.getUser().getId())
//                 .orElseThrow(() -> new ResourceNotFoundException("Financial profile not found"));

//         EligibilityResult result = new EligibilityResult();
//         result.setLoanRequest(loan);
//         result.setIsEligible(true);
//         result.setRiskLevel("LOW");
//         result.setMaxEligibleAmount(Math.max(0, profile.getMonthlyIncome() * 10));
//         result.setEstimatedEmi(result.getMaxEligibleAmount() / loan.getTenureMonths());

//         return resultRepo.save(result);
//     }

//     @Override
//     public EligibilityResult getByLoanRequestId(Long loanRequestId) {
//         return resultRepo.findByLoanRequestId(loanRequestId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Eligibility result not found"));
//     }

//     @Override
//     public EligibilityResult updateData2(Long loanRequestId, EligibilityResult result) {
//         EligibilityResult existing = resultRepo.findByLoanRequestId(loanRequestId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Eligibility result not found"));

//         existing.setIsEligible(result.getIsEligible());
//         existing.setRiskLevel(result.getRiskLevel());
//         existing.setMaxEligibleAmount(result.getMaxEligibleAmount());
//         existing.setEstimatedEmi(result.getEstimatedEmi());

//         return resultRepo.save(existing); // must return EligibilityResult
//     }
// }














package com.example.demo.service.impl;

import com.example.demo.entity.EligibilityResult;
import com.example.demo.entity.FinancialProfile;
import com.example.demo.entity.LoanRequest;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EligibilityResultRepository;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.service.LoanEligibilityService;

import org.springframework.stereotype.Service;

@Service
public class LoanEligibilityServiceImpl implements LoanEligibilityService {

    private final LoanRequestRepository loanRepo;
    private final FinancialProfileRepository profileRepo;
    private final EligibilityResultRepository resultRepo;

    public LoanEligibilityServiceImpl(LoanRequestRepository loanRepo,
                                      FinancialProfileRepository profileRepo,
                                      EligibilityResultRepository resultRepo) {
        this.loanRepo = loanRepo;
        this.profileRepo = profileRepo;
        this.resultRepo = resultRepo;
    }

    @Override
    public EligibilityResult evaluateEligibility(Long loanRequestId) {
        resultRepo.findByLoanRequestId(loanRequestId).ifPresent(r -> {
            throw new BadRequestException("Eligibility already evaluated");
        });

        LoanRequest loan = loanRepo.findById(loanRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan request not found"));

        FinancialProfile profile = profileRepo.findByUserId(loan.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Financial profile not found"));

        EligibilityResult result = new EligibilityResult();
        result.setLoanRequest(loan);
        result.setIsEligible(true);
        result.setRiskLevel("LOW");
        result.setMaxEligibleAmount(Math.max(0, profile.getMonthlyIncome() * 10));
        result.setEstimatedEmi(result.getMaxEligibleAmount() / loan.getTenureMonths());

        return resultRepo.save(result);
    }

    @Override
    public EligibilityResult getByLoanRequestId(Long loanRequestId) {
        return resultRepo.findByLoanRequestId(loanRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("Eligibility result not found"));
    }

    @Override
    public EligibilityResult updateData2(Long loanRequestId, EligibilityResult result) {
        EligibilityResult existing = resultRepo.findByLoanRequestId(loanRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("Eligibility result not found"));

        existing.setIsEligible(result.getIsEligible());
        existing.setRiskLevel(result.getRiskLevel());
        existing.setMaxEligibleAmount(result.getMaxEligibleAmount());
        existing.setEstimatedEmi(result.getEstimatedEmi());

        return resultRepo.save(existing);
    }

    // <-- Missing method from interface implemented here
    @Override
    public EligibilityResult getData2(Long loanRequestId) {
        return resultRepo.findByLoanRequestId(loanRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("Eligibility result not found"));
    }
}
