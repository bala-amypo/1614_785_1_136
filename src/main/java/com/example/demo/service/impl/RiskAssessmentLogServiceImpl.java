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



public class RiskAssessmentLogServiceImpl {

    private final LoanRequestRepository loanRepo;
    private final FinancialProfileRepository fpRepo;
    private final RiskAssessmentRepository raRepo;

    public RiskAssessmentLogServiceImpl(LoanRequestRepository l,
                                     FinancialProfileRepository f,
                                     RiskAssessmentLogRepository r) {
        loanRepo = l; fpRepo = f; raRepo = r;
    }

    public RiskAssessment assessRisk(Long loanId) {

        if (raRepo.findByLoanRequestId(loanId).isPresent())
            throw new BadRequestException("Risk already assessed");

        LoanRequest lr = loanRepo.findById(loanId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan request not found"));

        FinancialProfile fp = fpRepo.findByUserId(lr.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Financial profile not found"));

        RiskAssessment ra = new RiskAssessment();
        ra.setLoanRequestId(loanId);

        double income = fp.getMonthlyIncome();
        double obligations = fp.getMonthlyExpenses() + fp.getExistingLoanEmi();
        ra.setDtiRatio(income == 0 ? 0.0 : obligations / income);
        ra.setRiskScore(Math.min(100.0, ra.getDtiRatio() * 100));

        return raRepo.save(ra);
    }

    public RiskAssessment getByLoanRequestId(Long id) {
        return raRepo.findByLoanRequestId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Risk not found"));
    }
}
