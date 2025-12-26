// package com.example.demo.service;

// import com.example.demo.entity.RiskAssessmentLog;
// import java.util.List;

// public interface RiskAssessmentLogService {
//     RiskAssessmentLog postData5(RiskAssessmentLog use);
//     List<RiskAssessmentLog> getAllData5();
//     String DeleteData5(Long id);
//     RiskAssessmentLog getData5(Long id);
//     RiskAssessmentLog updateData5(Long id, RiskAssessmentLog entity);
// }





// package com.example.demo.service;

// import com.example.demo.entity.RiskAssessment;
// import java.util.List;

// public interface RiskAssessmentService {

//     RiskAssessment postData5(RiskAssessment use);

//     List<RiskAssessment> getAllData5();

//     String deleteData5(Long id);

//     RiskAssessment getData5(Long id);

//     RiskAssessment updateData5(Long id, RiskAssessment entity);
// }










// package com.example.demo.service;

// import com.example.demo.entity.RiskAssessment;
// import java.util.List;

// public interface RiskAssessmentService {

//     RiskAssessment postData5(RiskAssessment use);

//     List<RiskAssessment> getAllData5();

//     String deleteData5(Long id);

//     RiskAssessment getData5(Long id);

//     RiskAssessment updateData5(Long id, RiskAssessment entity);
// }








// import java.util.List;

// public interface RiskAssessmentService {

//     RiskAssessment saveAssessment(RiskAssessment assessment);

//     List<RiskAssessment> getAssessmentsByLoanRequest(Long loanRequestId);
// }












// // src/main/java/com/example/demo/service/RiskAssessmentService.java
// package com.example.demo.service;

// import com.example.demo.entity.RiskAssessment;

// public interface RiskAssessmentService {
//     RiskAssessment assessRisk(Long loanRequestId);
//     RiskAssessment getByLoanRequestId(Long loanRequestId);
// }














// src/main/java/com/example/demo/service/RiskAssessmentService.java
package com.example.demo.service;

import com.example.demo.entity.RiskAssessment;

import java.util.List;

public interface RiskAssessmentService {
    RiskAssessment assessRisk(Long loanRequestId);
    RiskAssessment getByLoanRequestId(Long loanRequestId);

    // extra CRUD-style methods used by RiskAssessmentController
    RiskAssessment postData5(RiskAssessment riskAssessment);
    List<RiskAssessment> getAllData5();
    void deleteData5(Long id);
    RiskAssessment getData5(Long id);
    RiskAssessment updateData5(Long id, RiskAssessment riskAssessment);
}
