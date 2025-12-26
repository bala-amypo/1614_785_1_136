// package com.example.demo.service.impl;

// import com.example.demo.entity.RiskAssessmentLog;
// import com.example.demo.service.RiskAssessmentLogService;
// import org.springframework.stereotype.Service;

// import java.util.ArrayList;
// import java.util.List;

// @Service
// public class RiskAssessmentLogServiceImpl implements RiskAssessmentLogService {

//     // Temporary in-memory storage (replace with repository if you have one)
//     private final List<RiskAssessmentLog> store = new ArrayList<>();

//     @Override
//     public RiskAssessmentLog postData5(RiskAssessmentLog use) {
//         store.add(use);
//         return use;
//     }

//     @Override
//     public List<RiskAssessmentLog> getAllData5() {
//         return new ArrayList<>(store);
//     }

//     @Override
//     public String DeleteData5(Long id) {
//         store.removeIf(r -> r.getId().equals(id));
//         return "Deleted";
//     }

//     @Override
//     public RiskAssessmentLog getData5(Long id) {
//         return store.stream()
//                 .filter(r -> r.getId().equals(id))
//                 .findFirst()
//                 .orElse(null);
//     }

//     @Override
//     public RiskAssessmentLog updateData5(Long id, RiskAssessmentLog entity) {
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

// import com.example.demo.entity.RiskAssessment;
// import com.example.demo.repository.RiskAssessmentRepository;
// import com.example.demo.service.RiskAssessmentService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class RiskAssessmentServiceImpl implements RiskAssessmentService {

//     @Autowired
//     private RiskAssessmentRepository riskAssessmentRepository;

//     @Override
//     public RiskAssessment postData5(RiskAssessment use) {
//         return riskAssessmentRepository.save(use);
//     }

//     @Override
//     public List<RiskAssessment> getAllData5() {
//         return riskAssessmentRepository.findAll();
//     }

//     @Override
//     public String deleteData5(Long id) {
//         if (riskAssessmentRepository.existsById(id)) {
//             riskAssessmentRepository.deleteById(id);
//             return "RiskAssessment deleted successfully";
//         }
//         return "RiskAssessment not found with id: " + id;
//     }

//     @Override
//     public RiskAssessment getData5(Long id) {
//         return riskAssessmentRepository.findById(id).orElse(null);
//     }

//     @Override
//     public RiskAssessment updateData5(Long id, RiskAssessment entity) {
//         return riskAssessmentRepository.findById(id).map(existing -> {
//             existing.setRiskLevel(entity.getRiskLevel());
//             existing.setDescription(entity.getDescription());
//             existing.setUpdatedAt(entity.getUpdatedAt());
//             return riskAssessmentRepository.save(existing);
//         }).orElse(null);
//     }
// }












// package com.example.demo.service.impl;

// import com.example.demo.entity.RiskAssessment;
// import com.example.demo.repository.RiskAssessmentRepository;
// import com.example.demo.service.RiskAssessmentService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class RiskAssessmentServiceImpl implements RiskAssessmentService {

//     @Autowired
//     private RiskAssessmentRepository riskAssessmentRepository;

//     @Override
//     public RiskAssessment postData5(RiskAssessment use) {
//         return riskAssessmentRepository.save(use);
//     }

//     @Override
//     public List<RiskAssessment> getAllData5() {
//         return riskAssessmentRepository.findAll();
//     }

//     @Override
//     public String deleteData5(Long id) {
//         if (riskAssessmentRepository.existsById(id)) {
//             riskAssessmentRepository.deleteById(id);
//             return "RiskAssessment deleted successfully";
//         } else {
//             return "RiskAssessment not found with id: " + id;
//         }
//     }

//     @Override
//     public RiskAssessment getData5(Long id) {
//         return riskAssessmentRepository.findById(id).orElse(null);
//     }

//     @Override
//     public RiskAssessment updateData5(Long id, RiskAssessment entity) {
//         return riskAssessmentRepository.findById(id).map(existing -> {
//             // Update only the fields that exist in RiskAssessment
//             existing.setLoanRequestId(entity.getLoanRequestId());
//             existing.setDtiRatio(entity.getDtiRatio());
//             existing.setRiskScore(entity.getRiskScore());
//             return riskAssessmentRepository.save(existing);
//         }).orElse(null);
//     }
// }










// import java.time.LocalDateTime;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// @Service
// public class RiskAssessmentServiceImpl implements RiskAssessmentService {

//     @Autowired
//     private RiskAssessmentRepository riskAssessmentRepository;

//     @Override
//     public RiskAssessment saveAssessment(RiskAssessment assessment) {
//         assessment.setTimestamp(LocalDateTime.now());
//         return riskAssessmentRepository.save(assessment);
//     }

//     @Override
//     public List<RiskAssessment> getAssessmentsByLoanRequest(Long loanRequestId) {
//         return riskAssessmentRepository.findByLoanRequestId(loanRequestId);
//     }
// }












// // src/main/java/com/example/demo/service/impl/RiskAssessmentServiceImpl.java
// package com.example.demo.service.impl;

// import com.example.demo.entity.FinancialProfile;
// import com.example.demo.entity.LoanRequest;
// import com.example.demo.entity.RiskAssessment;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.FinancialProfileRepository;
// import com.example.demo.repository.LoanRequestRepository;
// import com.example.demo.repository.RiskAssessmentRepository;
// import com.example.demo.service.RiskAssessmentService;
// import org.springframework.stereotype.Service;

// @Service
// public class RiskAssessmentServiceImpl implements RiskAssessmentService {

//     private final LoanRequestRepository loanRequestRepository;
//     private final FinancialProfileRepository financialProfileRepository;
//     private final RiskAssessmentRepository riskAssessmentRepository;

//     public RiskAssessmentServiceImpl(LoanRequestRepository loanRequestRepository,
//                                      FinancialProfileRepository financialProfileRepository,
//                                      RiskAssessmentRepository riskAssessmentRepository) {
//         this.loanRequestRepository = loanRequestRepository;
//         this.financialProfileRepository = financialProfileRepository;
//         this.riskAssessmentRepository = riskAssessmentRepository;
//     }

//     @Override
//     public RiskAssessment assessRisk(Long loanRequestId) {
//         LoanRequest request = loanRequestRepository.findById(loanRequestId)
//                 .orElseThrow(() -> new ResourceNotFoundException("LoanRequest not found"));

//         if (riskAssessmentRepository.findByLoanRequestId(loanRequestId).isPresent()) {
//             throw new BadRequestException("Risk already assessed");
//         }

//         Long userId = request.getUser().getId();
//         FinancialProfile profile = financialProfileRepository.findByUserId(userId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));

//         double income = profile.getMonthlyIncome() != null ? profile.getMonthlyIncome() : 0.0;
//         double obligations = (profile.getMonthlyExpenses() != null ? profile.getMonthlyExpenses() : 0.0)
//                 + (profile.getExistingLoanEmi() != null ? profile.getExistingLoanEmi() : 0.0);

//         double dti = income == 0 ? 0.0 : (obligations / income);
//         double creditScore = profile.getCreditScore() != null ? profile.getCreditScore() : 500;
//         double normalizedCs = (creditScore - 300.0) / 600.0; // 300–900 -> 0–1
//         double riskScore = 100.0 * (0.6 * dti + 0.4 * (1 - normalizedCs));
//         if (riskScore < 0) riskScore = 0;
//         if (riskScore > 100) riskScore = 100;

//         RiskAssessment ra = new RiskAssessment();
//         ra.setLoanRequest(request);
//         ra.setDtiRatio(dti);
//         ra.setRiskScore(riskScore);
//         return riskAssessmentRepository.save(ra);
//     }

//     @Override
//     public RiskAssessment getByLoanRequestId(Long loanRequestId) {
//         return riskAssessmentRepository.findByLoanRequestId(loanRequestId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Risk not found"));
//     }
// }















// src/main/java/com/example/demo/service/impl/RiskAssessmentServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.RiskAssessment;
import com.example.demo.entity.LoanRequest;
import com.example.demo.entity.FinancialProfile;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RiskAssessmentRepository;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.service.RiskAssessmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskAssessmentServiceImpl implements RiskAssessmentService {

    private final LoanRequestRepository loanRequestRepository;
    private final FinancialProfileRepository financialProfileRepository;
    private final RiskAssessmentRepository riskAssessmentRepository;

    public RiskAssessmentServiceImpl(LoanRequestRepository loanRequestRepository,
                                     FinancialProfileRepository financialProfileRepository,
                                     RiskAssessmentRepository riskAssessmentRepository) {
        this.loanRequestRepository = loanRequestRepository;
        this.financialProfileRepository = financialProfileRepository;
        this.riskAssessmentRepository = riskAssessmentRepository;
    }

    @Override
    public RiskAssessment assessRisk(Long loanRequestId) {
        LoanRequest request = loanRequestRepository.findById(loanRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("LoanRequest not found"));

        if (riskAssessmentRepository.findByLoanRequestId(loanRequestId).isPresent()) {
            throw new BadRequestException("Risk already assessed");
        }

        Long userId = request.getUser().getId();
        FinancialProfile profile = financialProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));

        double income = profile.getMonthlyIncome() != null ? profile.getMonthlyIncome() : 0.0;
        double obligations = (profile.getMonthlyExpenses() != null ? profile.getMonthlyExpenses() : 0.0)
                + (profile.getExistingLoanEmi() != null ? profile.getExistingLoanEmi() : 0.0);

        double dti = income == 0 ? 0.0 : (obligations / income);
        double creditScore = profile.getCreditScore() != null ? profile.getCreditScore() : 500;
        double normalizedCs = (creditScore - 300.0) / 600.0;
        double riskScore = 100.0 * (0.6 * dti + 0.4 * (1 - normalizedCs));
        if (riskScore < 0) riskScore = 0;
        if (riskScore > 100) riskScore = 100;

        RiskAssessment ra = new RiskAssessment();
        ra.setLoanRequest(request);
        ra.setDtiRatio(dti);
        ra.setRiskScore(riskScore);
        return riskAssessmentRepository.save(ra);
    }

    @Override
    public RiskAssessment getByLoanRequestId(Long loanRequestId) {
        return riskAssessmentRepository.findByLoanRequestId(loanRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("Risk not found"));
    }

    // CRUD-style methods for controller

    @Override
    public RiskAssessment postData5(RiskAssessment riskAssessment) {
        return riskAssessmentRepository.save(riskAssessment);
    }

    @Override
    public List<RiskAssessment> getAllData5() {
        return riskAssessmentRepository.findAll();
    }

    @Override
    public void deleteData5(Long id) {
        riskAssessmentRepository.deleteById(id);
    }

    @Override
    public RiskAssessment getData5(Long id) {
        return riskAssessmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RiskAssessment not found"));
    }

    @Override
    public RiskAssessment updateData5(Long id, RiskAssessment newData) {
        RiskAssessment existing = getData5(id);
        existing.setRiskScore(newData.getRiskScore());
        existing.setDtiRatio(newData.getDtiRatio());
        existing.setLoanRequest(newData.getLoanRequest());
        return riskAssessmentRepository.save(existing);
    }
}
