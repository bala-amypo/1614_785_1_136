package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.LoanRequest;

public interface LoanRequestService{
    LoanRequest postData2(LoanRequest use);
    List<EligibilityResult>getAllData2();
    String  DeleteData2(Long id);
    EligibilityResult getData2(Long id);         
    EligibilityResult updateData2(Long id,EligibilityResult entity);                                                        
}