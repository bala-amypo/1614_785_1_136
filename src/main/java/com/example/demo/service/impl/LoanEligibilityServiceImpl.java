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



package com.example.demo.service.impl;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;   
// import com.example.demo.entity.EligibilityResult;
// import com.example.demo.repository.EligibilityResultRepository;
// import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.service.LoanEligibilityService;                

// @Service










public class LoanEligibilityServiceImpl {

    private final LoanRequestRepository loanRepo;
    private final FinancialProfileRepository fpRepo;
    private final EligibilityResultRepository erRepo;

    public LoanEligibilityServiceImpl(LoanRequestRepository l,
                                  FinancialProfileRepository f,
                                  EligibilityResultRepository e) {
        loanRepo = l; fpRepo = f; erRepo = e;
    }

    public EligibilityResult evaluateEligibility(Long loanId) {

        if (erRepo.findByLoanRequestId(loanId).isPresent())
            throw new BadRequestException("Eligibility already evaluated");

        LoanRequest lr = loanRepo.findById(loanId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan request not found"));

        FinancialProfile fp = fpRepo.findByUserId(lr.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Financial profile not found"));

        EligibilityResult er = new EligibilityResult();
        er.setLoanRequest(lr);
        er.setIsEligible(true);
        er.setMaxEligibleAmount(Math.max(0, fp.getMonthlyIncome() * 10));
        er.setEstimatedEmi(er.getMaxEligibleAmount() / lr.getTenureMonths());
        er.setRiskLevel("LOW");

        return erRepo.save(er);
    }

    public EligibilityResult getByLoanRequestId(Long id) {
        return erRepo.findByLoanRequestId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Eligibility result not found"));
    }
}
