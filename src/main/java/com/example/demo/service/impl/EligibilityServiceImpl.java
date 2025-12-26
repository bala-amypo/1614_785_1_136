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

















import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EligibilityServiceImpl implements EligibilityService {

    @Autowired
    private LoanRequestRepository loanRequestRepository;

    @Autowired
    private FinancialProfileRepository financialProfileRepository;

    @Autowired
    private EligibilityResultRepository eligibilityResultRepository;

    @Autowired
    private RiskAssessmentService riskAssessmentService;

    @Override
    public EligibilityResult evaluateEligibility(Long requestId) {

        LoanRequest loanRequest = loanRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        FinancialProfile profile =
                financialProfileRepository.findByUserId(
                        loanRequest.getUser().getId())
                .orElseThrow(() -> new RuntimeException("Financial profile not found"));

        // DTI = Expenses / Income
        double dti = profile.getExpenses() / profile.getIncome();

        boolean eligible = dti < 0.4 && profile.getCreditScore() >= 650;
        String riskLevel;

        if (profile.getCreditScore() >= 750) {
            riskLevel = "LOW";
        } else if (profile.getCreditScore() >= 650) {
            riskLevel = "MEDIUM";
        } else {
            riskLevel = "HIGH";
        }

        EligibilityResult result = new EligibilityResult();
        result.setLoanRequest(loanRequest);
        result.setDti(dti);
        result.setEligible(eligible);
        result.setRiskLevel(riskLevel);

        EligibilityResult savedResult =
                eligibilityResultRepository.save(result);

        // Save Risk Assessment
        RiskAssessment assessment = new RiskAssessment();
        assessment.setLoanRequest(loanRequest);
        assessment.setRiskLevel(riskLevel);
        assessment.setMessage("Eligibility evaluated with DTI = " + dti);

        riskAssessmentService.createAssessment(assessment);

        return savedResult;
    }

    @Override
    public EligibilityResult getEligibilityByRequest(Long requestId) {
        return eligibilityResultRepository.findByLoanRequestId(requestId)
                .orElseThrow(() -> new RuntimeException("Eligibility result not found"));
    }
}
