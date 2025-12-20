package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;   
import com.example.demo.entity.EligibityResult;
import com.example.demo.repository.EligibityResultRepository;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.service.EligibityResultService;                

@Service
public class EligibityResultServiceImpl implements EligibityResultService{

    @Autowired EligibityResultRepository used;
    @Override
    public EligibityResult postData1(EligibityResult use){
        return used.save(use);  
    }
    @Override
    public List<EligibityResult>getAllData1(){
        return used.findAll();
    }
    @Override
    public String DeleteData1(Long id){
        used.deleteById(id);
        return "Deleted successfully";
    }
    @Override
    public EligibityResult getData1(Long id){
    return used.findById(id).orElse(null);
    }
    @Override
    public EligibityResult updateData1(Long id,EligibityResult entity){
        if(used.existsById(id)){
            entity.setId(id);
            return used.save(entity);
        } 
        return null;
    }
}