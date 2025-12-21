package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;   
import com.example.demo.entity.LoanRequest;
import com.example.demo.repository.LoanRequestRepository;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.service.Service;                

@Service
public class LoanRequestServiceImpl implements LoanRequestService{

    @Autowired LoanRequestRepository used;
    @Override
    public LoanRequest postData4(LoanRequest use){
        return used.save(use);  
    }
    @Override
    public List<LoanRequest>getAllData4(){
        return used.findAll();
    }
    @Override
    public String DeleteData4(Long id){
        used.deleteById(id);
        return "Deleted successfully";
    }
    @Override
    public LoanRequest getData4(Long id){
    return used.findById(id).orElse(null);
    }
    @Override
    public LoanRequest updateData4(Long id,LoanRequest entity){
        if(used.existsById(id)){
            entity.setId(id);
            return used.save(entity);
        } 
        return null;
    }
}