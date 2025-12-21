package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.FinancialProfile;

public interface FinancialProfileService{
    FinancialProfile postData2(FinancialProfile use1);
    List<FinancialProfile>getAllData2();
    String  DeleteData3(Long id);
    FinancialProfile getData3(Long id);         
    FinancialProfile updateData3(Long id,FinancialProfile entity);                                                        
}