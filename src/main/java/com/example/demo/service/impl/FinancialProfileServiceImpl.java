package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;   
import com.example.demo.entity.EligibilityResult;
import com.example.demo.repository.EligibilityResultRepository;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.service.FinancialProfileService;                

@Service
public class FinancialProfileServiceImpl implements FinancialProfileService{

    @Autowired FinancialProfileRepository used;
    @Override
    public FinancialProfile postData3(FinancialProfile use){
        return used.save(use);  
    }
    @Override
    public List<FinancialProfile>getAllData3(){
        return used.findAll();
    }
    @Override
    public String DeleteData3(Long id){
        used.deleteById(id);
        return "Deleted successfully";
    }
    @Override
    public FinancialProfile getData3(Long id){
    return used.findById(id).orElse(null);
    }
    @Override
    public FinancialProfile updateData3(Long id,FinancialProfile entity){
        if(used.existsById(id)){
            entity.setId(id);
            return used.save(entity);
        } 
        return null;
    }
}