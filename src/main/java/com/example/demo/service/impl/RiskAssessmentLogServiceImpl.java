// package com.example.demo.service.impl;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;   
// import com.example.demo.entity.RiskAssessmentLog;
// import com.example.demo.repository.RiskAssessmentLogRepository;
// import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.service.RiskAssessmentLogService;                

// @Service
// public class RiskAssessmentLogServiceImpl implements RiskAssessmentLogService{

//     @Autowired RiskAssessmentLogRepository used;
//     @Override
//     public RiskAssessmentLog postData5(RiskAssessmentLog use){
//         return used.save(use);  
//     }
//     @Override
//     public List<RiskAssessmentLog>getAllData5(){
//         return used.findAll();
//     }
//     @Override
//     public String DeleteData5(Long id){
//         used.deleteById(id);
//         return "Deleted successfully";
//     }
//     @Override
//     public RiskAssessmentLog getData5(Long id){
//     return used.findById(id).orElse(null);
//     }
//     @Override
//     public RiskAssessmentLog updateData5(Long id,RiskAssessmentLog entity){
//         if(used.existsById(id)){
//             entity.setId(id);
//             return used.save(entity);
//         } 
//         return null;
//     }
// }




//  package com.example.demo.service.impl;

//  import java.util.List;
//  import org.springframework.beans.factory.annotation.Autowired;
//  import org.springframework.stereotype.Service;   
//  import com.example.demo.entity.RiskAssessmentLog;
//  import com.example.demo.repository.RiskAssessmentLogRepository;
//  import org.springframework.web.bind.annotation.PathVariable;
//  import com.example.demo.service.RiskAssessmentLogService;                

//  @Service

// public class RiskAssessmentLogServiceImpl {

//     private final LoanRequestRepository loanRepo;
//     private final FinancialProfileRepository fpRepo;
//     private final RiskAssessmentLogRepository raRepo;

//     public RiskAssessmentLogServiceImpl(LoanRequestRepository l,
//                                      FinancialProfileRepository f,
//                                      RiskAssessmentLogRepository r) {
//         loanRepo = l; fpRepo = f; raRepo = r;
//     }

//     public RiskAssessmentLog assessRisk(Long loanId) {

//         if (raRepo.findByLoanRequestId(loanId).isPresent())
//             throw new BadRequestException("Risk already assessed");

//         LoanRequest lr = loanRepo.findById(loanId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Loan request not found"));

//         FinancialProfile fp = fpRepo.findByUserId(lr.getUser().getId())
//                 .orElseThrow(() -> new ResourceNotFoundException("Financial profile not found"));

//         RiskAssessmentLog ra = new RiskAssessmentLog();
//         ra.setLoanRequestId(loanId);

//         double income = fp.getMonthlyIncome();
//         double obligations = fp.getMonthlyExpenses() + fp.getExistingLoanEmi();
//         ra.setDtiRatio(income == 0 ? 0.0 : obligations / income);
//         ra.setRiskScore(Math.min(100.0, ra.getDtiRatio() * 100));

//         return raRepo.save(ra);
//     }

//     public RiskAssessmentLog getByLoanRequestId(Long id) {
//         return raRepo.findByLoanRequestId(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Risk not found"));
//     }
// }





// package com.example.demo.service.impl;

// import com.example.demo.entity.FinancialProfile;
// import com.example.demo.entity.LoanRequest;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.FinancialProfileRepository;
// import com.example.demo.repository.LoanRequestRepository;


// import com.example.demo.entity.RiskAssessmentLog;
// import com.example.demo.repository.RiskAssessmentLogRepository;


// public class RiskAssessmentLogServiceImpl {

//     private final LoanRequestRepository loanRepo;
//     private final FinancialProfileRepository profileRepo;
//     private final RiskAssessmentRepository riskRepo;

//     public RiskAssessmentLogServiceImpl(LoanRequestRepository loanRepo,
//                                         FinancialProfileRepository profileRepo,
//                                         RiskAssessmentRepository riskRepo) {
//         this.loanRepo = loanRepo;
//         this.profileRepo = profileRepo;
//         this.riskRepo = riskRepo;
//     }

//     public RiskAssessment assessRisk(Long loanRequestId) {

//         if (riskRepo.findByLoanRequestId(loanRequestId).isPresent()) {
//             throw new BadRequestException("Risk already assessed");
//         }

//         LoanRequest loan = loanRepo.findById(loanRequestId)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Loan request not found"));

//         FinancialProfile profile = profileRepo
//                 .findByUserId(loan.getUser().getId())
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Financial profile not found"));

//         RiskAssessment ra = new RiskAssessment();
//         ra.setLoanRequestId(loanRequestId);

//         double income = profile.getMonthlyIncome();
//         double obligations =
//                 profile.getMonthlyExpenses() + profile.getExistingLoanEmi();

//         ra.setDtiRatio(income == 0 ? 0.0 : obligations / income);
//         ra.setRiskScore(Math.min(100.0, ra.getDtiRatio() * 100));

//         return riskRepo.save(ra);
//     }

//     public RiskAssessment getByLoanRequestId(Long loanRequestId) {
//         return riskRepo.findByLoanRequestId(loanRequestId)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Risk not found"));
//     }
// }







// package com.example.demo.service.impl;

// import com.example.demo.entity.FinancialProfile;
// import com.example.demo.entity.LoanRequest;
// import com.example.demo.entity.RiskAssessmentLog;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.FinancialProfileRepository;
// import com.example.demo.repository.LoanRequestRepository;
// import com.example.demo.repository.RiskAssessmentLogRepository;

// public class RiskAssessmentLogServiceImpl {

//     private final LoanRequestRepository loanRepo;
//     private final FinancialProfileRepository profileRepo;
//     private final RiskAssessmentLogRepository riskRepo;

//     public RiskAssessmentLogServiceImpl(
//             LoanRequestRepository loanRepo,
//             FinancialProfileRepository profileRepo,
//             RiskAssessmentLogRepository riskRepo) {

//         this.loanRepo = loanRepo;
//         this.profileRepo = profileRepo;
//         this.riskRepo = riskRepo;
//     }

//     public RiskAssessmentLog assessRisk(Long loanRequestId) {

//         if (riskRepo.findByLoanRequestId(loanRequestId).isPresent()) {
//             throw new BadRequestException("Risk already assessed");
//         }

//         LoanRequest loan = loanRepo.findById(loanRequestId)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Loan request not found"));

//         FinancialProfile profile = profileRepo
//                 .findByUserId(loan.getUser().getId())
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Financial profile not found"));

//         RiskAssessmentLog ra = new RiskAssessmentLog();
//         ra.setLoanRequestId(loanRequestId);

//         double income = profile.getMonthlyIncome();
//         double obligations =
//                 profile.getMonthlyExpenses() + profile.getExistingLoanEmi();

//         ra.setDtiRatio(income == 0 ? 0.0 : obligations / income);
//         ra.setRiskScore(Math.min(100.0, ra.getDtiRatio() * 100));

//         return riskRepo.save(ra);
//     }

//     public RiskAssessmentLog getByLoanRequestId(Long loanRequestId) {
//         return riskRepo.findByLoanRequestId(loanRequestId)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Risk not found"));
//     }
// }









package com.example.demo.service.impl;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.entity.LoanRequest;
import com.example.demo.entity.RiskAssessmentLog;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.repository.RiskAssessmentLogRepository;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class RiskAssessmentLogServiceImpl {

    private final LoanRequestRepository loanRepo;
    private final FinancialProfileRepository profileRepo;
    private final RiskAssessmentLogRepository riskRepo;

    public RiskAssessmentLogServiceImpl(
            LoanRequestRepository loanRepo,
            FinancialProfileRepository profileRepo,
            RiskAssessmentLogRepository riskRepo) {

        this.loanRepo = loanRepo;
        this.profileRepo = profileRepo;
        this.riskRepo = riskRepo;
    }

    public RiskAssessmentLog assessRisk(Long loanRequestId) {

        Optional<RiskAssessmentLog> existingRisk = riskRepo.findByLoanRequestId(loanRequestId);
        if (existingRisk.isPresent()) {
            throw new BadRequestException("Risk already assessed");
        }

        LoanRequest loan = loanRepo.findById(loanRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan request not found"));

        FinancialProfile profile = profileRepo
                .findByUserId(loan.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Financial profile not found"));

        RiskAssessmentLog ra = new RiskAssessmentLog();
        ra.setLoanRequestId(loanRequestId);

        double income = profile.getMonthlyIncome();
        double obligations = profile.getMonthlyExpenses() + profile.getExistingLoanEmi();

        ra.setDtiRatio(income == 0 ? 0.0 : obligations / income);
        ra.setRiskScore(Math.min(100.0, ra.getDtiRatio() * 100));

        return riskRepo.save(ra);
    }

    public RiskAssessmentLog getByLoanRequestId(Long loanRequestId) {
        return riskRepo.findByLoanRequestId(loanRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("Risk not found"));
    }
}
