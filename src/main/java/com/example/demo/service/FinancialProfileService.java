// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.entity.FinancialProfile;

// public interface FinancialProfileService{
//     FinancialProfile postData3(FinancialProfile use);
//     List<FinancialProfile>getAllData3();
//     String  DeleteData3(Long id);
//     FinancialProfile getData3(Long id);         
//     FinancialProfile updateData3(Long id,FinancialProfile entity);                                                        
// }





package com.example.demo.service;

import com.example.demo.entity.FinancialProfile;

public interface FinancialProfileService {
    FinancialProfile createOrUpdate(FinancialProfile profile);
}
