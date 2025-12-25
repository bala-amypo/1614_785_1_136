









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

//         return resultRepo.save(existing);
//     }

//     // <-- Missing method from interface implemented here
//     @Override
//     public EligibilityResult getData2(Long loanRequestId) {
//         return resultRepo.findByLoanRequestId(loanRequestId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Eligibility result not found"));
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

import java.util.Optional; // Required for Optional usage

public class LoanEligibilityServiceImpl {

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

    public EligibilityResult evaluateEligibility(Long loanRequestId) {

        // Check if eligibility already exists
        Optional<EligibilityResult> existingResult = resultRepo.findByLoanRequestId(loanRequestId);
        if (existingResult.isPresent()) {
            throw new BadRequestException("Eligibility already evaluated");
        }

        // Get LoanRequest
        LoanRequest loan = loanRepo.findById(loanRequestId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Loan request not found"));

        // Get FinancialProfile
        FinancialProfile profile = profileRepo.findByUserId(loan.getUser().getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Financial profile not found"));

        // Create EligibilityResult
        EligibilityResult result = new EligibilityResult();
        result.setLoanRequest(loan);
        result.setIsEligible(true);
        result.setRiskLevel("LOW");
        result.setMaxEligibleAmount(Math.max(0, profile.getMonthlyIncome() * 10));
        result.setEstimatedEmi(
                result.getMaxEligibleAmount() / loan.getTenureMonths()
        );

        return resultRepo.save(result);
    }

    public EligibilityResult getByLoanRequestId(Long loanRequestId) {
        return resultRepo.findByLoanRequestId(loanRequestId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Eligibility result not found"));
    }
}
