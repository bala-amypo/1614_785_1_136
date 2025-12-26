// package com.example.demo.service.impl;

// import com.example.demo.entity.EligibilityResult;
// import com.example.demo.service.LoanEligibilityService;
// import org.springframework.stereotype.Service;

// import java.util.ArrayList;
// import java.util.List;

// @Service
// public class LoanEligibilityServiceImpl implements LoanEligibilityService {

//     // Temporary in‑memory storage (replace with repository if you have one)
//     private final List<EligibilityResult> store = new ArrayList<>();

//     @Override
//     public EligibilityResult postData2(EligibilityResult use) {
//         store.add(use);
//         return use;
//     }

//     @Override
//     public List<EligibilityResult> getAllData2() {
//         return new ArrayList<>(store);
//     }

//     @Override
//     public String DeleteData2(Long id) {
//         store.removeIf(e -> e.getId().equals(id));
//         return "Deleted";
//     }

//     @Override
//     public EligibilityResult getData2(Long id) {
//         return store.stream()
//                 .filter(e -> e.getId().equals(id))
//                 .findFirst()
//                 .orElse(null);
//     }

//     @Override
//     public EligibilityResult updateData2(Long id, EligibilityResult entity) {
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

// import com.example.demo.entity.EligibilityResult;
// import com.example.demo.service.EligibilityService;
// import org.springframework.stereotype.Service;

// import java.util.ArrayList;
// import java.util.List;

// @Service
// public class EligibilityServiceImpl implements EligibilityService {

//     // Temporary in‑memory storage (replace with repository if you have one)
//     private final List<EligibilityResult> store = new ArrayList<>();

//     @Override
//     public EligibilityResult postData2(EligibilityResult use) {
//         store.add(use);
//         return use;
//     }

//     @Override
//     public List<EligibilityResult> getAllData2() {
//         return new ArrayList<>(store);
//     }

//     @Override
//     public String deleteData2(Long id) {
//         store.removeIf(e -> e.getId().equals(id));
//         return "Deleted";
//     }

//     @Override
//     public EligibilityResult getData2(Long id) {
//         return store.stream()
//                 .filter(e -> e.getId().equals(id))
//                 .findFirst()
//                 .orElse(null);
//     }

//     @Override
//     public EligibilityResult updateData2(Long id, EligibilityResult entity) {
//         for (int i = 0; i < store.size(); i++) {
//             if (store.get(i).getId().equals(id)) {
//                 store.set(i, entity);
//                 return entity;
//             }
//         }
//         return null;
//     }
// }

















// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// @Service
// public class EligibilityServiceImpl implements EligibilityService {

//     @Autowired
//     private LoanRequestRepository loanRequestRepository;

//     @Autowired
//     private FinancialProfileRepository financialProfileRepository;

//     @Autowired
//     private EligibilityResultRepository eligibilityResultRepository;

//     @Autowired
//     private RiskAssessmentService riskAssessmentService;

//     @Override
//     public EligibilityResult evaluateEligibility(Long requestId) {

//         LoanRequest loanRequest = loanRequestRepository.findById(requestId)
//                 .orElseThrow(() -> new RuntimeException("Request not found"));

//         FinancialProfile profile =
//                 financialProfileRepository.findByUserId(
//                         loanRequest.getUser().getId())
//                 .orElseThrow(() -> new RuntimeException("Financial profile not found"));

//         // DTI = Expenses / Income
//         double dti = profile.getExpenses() / profile.getIncome();

//         boolean eligible = dti < 0.4 && profile.getCreditScore() >= 650;
//         String riskLevel;

//         if (profile.getCreditScore() >= 750) {
//             riskLevel = "LOW";
//         } else if (profile.getCreditScore() >= 650) {
//             riskLevel = "MEDIUM";
//         } else {
//             riskLevel = "HIGH";
//         }

//         EligibilityResult result = new EligibilityResult();
//         result.setLoanRequest(loanRequest);
//         result.setDti(dti);
//         result.setEligible(eligible);
//         result.setRiskLevel(riskLevel);

//         EligibilityResult savedResult =
//                 eligibilityResultRepository.save(result);

//         // Save Risk Assessment
//         RiskAssessment assessment = new RiskAssessment();
//         assessment.setLoanRequest(loanRequest);
//         assessment.setRiskLevel(riskLevel);
//         assessment.setMessage("Eligibility evaluated with DTI = " + dti);

//         riskAssessmentService.createAssessment(assessment);

//         return savedResult;
//     }

//     @Override
//     public EligibilityResult getEligibilityByRequest(Long requestId) {
//         return eligibilityResultRepository.findByLoanRequestId(requestId)
//                 .orElseThrow(() -> new RuntimeException("Eligibility result not found"));
//     }
// }















// package com.example.demo.service.impl;

// import com.example.demo.entity.*;
// import com.example.demo.repository.*;
// import com.example.demo.service.*;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// @Service
// public class EligibilityServiceImpl implements EligibilityService {

//     @Autowired
//     private LoanRequestRepository loanRequestRepository;

//     @Autowired
//     private FinancialProfileRepository financialProfileRepository;

//     @Autowired
//     private EligibilityResultRepository eligibilityResultRepository;

//     @Autowired
//     private RiskAssessmentService riskAssessmentService;

//     @Override
//     public EligibilityResult evaluateEligibility(Long requestId) {

//         LoanRequest request = loanRequestRepository.findById(requestId)
//                 .orElseThrow(() -> new RuntimeException("Request not found"));

//         FinancialProfile profile = financialProfileRepository
//                 .findByUserId(request.getUser().getId())
//                 .orElseThrow(() -> new RuntimeException("Profile not found"));

//         double dti = profile.getExpenses() / profile.getIncome();

//         boolean eligible = dti < 0.4 && profile.getCreditScore() >= 650;

//         String riskLevel =
//                 profile.getCreditScore() >= 750 ? "LOW" :
//                 profile.getCreditScore() >= 650 ? "MEDIUM" : "HIGH";

//         EligibilityResult result = new EligibilityResult();
//         result.setLoanRequest(request);
//         result.setDti(dti);
//         result.setEligible(eligible);
//         result.setRiskLevel(riskLevel);

//         EligibilityResult saved = eligibilityResultRepository.save(result);

//         RiskAssessment assessment = new RiskAssessment();
//         assessment.setLoanRequest(request);
//         assessment.setRiskLevel(riskLevel);
//         assessment.setMessage("Eligibility evaluated");

//         riskAssessmentService.createAssessment(assessment);

//         return saved;
//     }

//     @Override
//     public EligibilityResult getEligibilityByRequest(Long requestId) {
//         return eligibilityResultRepository.findByLoanRequestId(requestId)
//                 .orElseThrow(() -> new RuntimeException("Result not found"));
//     }
// }











// src/main/java/com/example/demo/service/impl/EligibilityServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.EligibilityResult;
import com.example.demo.entity.FinancialProfile;
import com.example.demo.entity.LoanRequest;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EligibilityResultRepository;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.service.EligibilityService;
import org.springframework.stereotype.Service;

@Service
public class EligibilityServiceImpl implements EligibilityService {

    private final LoanRequestRepository loanRequestRepository;
    private final FinancialProfileRepository financialProfileRepository;
    private final EligibilityResultRepository eligibilityResultRepository;

    public EligibilityServiceImpl(LoanRequestRepository loanRequestRepository,
                                  FinancialProfileRepository financialProfileRepository,
                                  EligibilityResultRepository eligibilityResultRepository) {
        this.loanRequestRepository = loanRequestRepository;
        this.financialProfileRepository = financialProfileRepository;
        this.eligibilityResultRepository = eligibilityResultRepository;
    }

    @Override
    public EligibilityResult evaluateEligibility(Long loanRequestId) {
        LoanRequest request = loanRequestRepository.findById(loanRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("LoanRequest not found"));

        if (eligibilityResultRepository.findByLoanRequestId(loanRequestId).isPresent()) {
            throw new BadRequestException("Eligibility already evaluated");
        }

        Long userId = request.getUser().getId();
        FinancialProfile profile = financialProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));

        double disposableIncome = profile.getMonthlyIncome() - profile.getMonthlyExpenses()
                - (profile.getExistingLoanEmi() != null ? profile.getExistingLoanEmi() : 0.0);
        if (disposableIncome < 0) disposableIncome = 0;
        double maxEligible = disposableIncome * 10; // simple heuristic

        EligibilityResult result = new EligibilityResult();
        result.setLoanRequest(request);
        result.setMaxEligibleAmount(maxEligible);
        return eligibilityResultRepository.save(result);
    }

    @Override
    public EligibilityResult getByLoanRequestId(Long loanRequestId) {
        return eligibilityResultRepository.findByLoanRequestId(loanRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("Eligibility not found"));
    }
}
