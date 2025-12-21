package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;   
import com.example.demo.entity.EligibilityResult;
import com.example.demo.repository.EligibilityResultRepository;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.service.LoanEligibilityService;                

@Service
public class LoanEligibilityServiceImpl implements LoanEligibilityService{

    @Autowired EligibilityResultRepository used;
    @Override
    public EligibilityResult postData2(EligibilityResult use1){
        return used.save(use1);  
    }
    @Override
    public List<EligibilityResult>getAllData2(){
        return used.findAll();
    }
    @Override
    public String DeleteData2(Long id){
        used.deleteById(id);
        return "Deleted successfully";
    }
    @Override
    public EligibilityResult getData2(Long id){
    return used.findById(id).orElse(null);
    }
    @Override
    public EligibilityResult updateData2(Long id,EligibilityResult entity){
        if(used.existsById(id)){
            entity.setId(id);
            return used.save(entity);
        } 
        return null;
    }
}