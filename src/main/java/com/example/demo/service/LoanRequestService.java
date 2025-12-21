package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.LoanRequest;

public interface LoanRequestService{
    LoanRequest postData4(LoanRequest use);
    List<LoanRequest>getAllData4();
    String  DeleteData4(Long id);
    LoanRequest getData4(Long id);         
    LoanRequest updateData4(Long id,LoanRequest entity);                                                        
}