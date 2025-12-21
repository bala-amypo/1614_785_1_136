package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;   
import com.example.demo.entity.RiskAssessmentLog;
import com.example.demo.repository.RiskAssessmentLogRepository;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.service.RiskAssessmentService;                

@Service
public class RiskAssessmentServiceImpl implements RiskAssessmentService{

    @Autowired RiskAssessmentLogRepository used;
    @Override
    public RiskAssessmentLog postData4(RiskAssessmentLog use){
        return used.save(use);  
    }
    @Override
    public List<RiskAssessmentLog>getAllData4(){
        return used.findAll();
    }
    @Override
    public String DeleteData4(Long id){
        used.deleteById(id);
        return "Deleted successfully";
    }
    @Override
    public RiskAssessmentLog getData4(Long id){
    return used.findById(id).orElse(null);
    }
    @Override
    public RiskAssessmentLog updateData4(Long id,RiskAssessmentLog entity){
        if(used.existsById(id)){
            entity.setId(id);
            return used.save(entity);
        } 
        return null;
    }
}