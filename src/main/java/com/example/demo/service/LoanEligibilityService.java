package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.EligibilityResult;

public interface LoanEligibilityService{
    EligibilityResult postData2(EligibilityResult use);
    List<EligibilityResult>getAllData1();
    String  DeleteData1(Long id);
    EligibilityResult getData1(Long id);         
    EligibilityResult updateData1(Long id,EligibilityResult entity);                                                        
}