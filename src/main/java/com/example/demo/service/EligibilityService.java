// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.entity.EligibilityResult;

// public interface LoanEligibilityService{
//     EligibilityResult postData2(EligibilityResult use);
//     List<EligibilityResult>getAllData2();
//     String  DeleteData2(Long id);
//     EligibilityResult getData2(Long id);  
//     EligibilityResult updateData2(Long id,EligibilityResult entity);                                                        
// }







// package com.example.demo.service;

// import com.example.demo.entity.EligibilityResult;
// import java.util.List;

// public interface EligibilityService {

//     EligibilityResult postData2(EligibilityResult use);

//     List<EligibilityResult> getAllData2();

//     String deleteData2(Long id);

//     EligibilityResult getData2(Long id);

//     EligibilityResult updateData2(Long id, EligibilityResult entity);
// }











public interface EligibilityService {

    EligibilityResult evaluateEligibility(Long requestId);

    EligibilityResult getEligibilityByRequest(Long requestId);
}
