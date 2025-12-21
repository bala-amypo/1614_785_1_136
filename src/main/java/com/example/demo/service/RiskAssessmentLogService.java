package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.RiskAssessmentLog;

public interface RiskAssessmentLogService{
    RiskAssessmentLog postData5(RiskAssessmentLog use);
    List<RiskAssessmentLog>getAllData5();
    String  DeleteData5(Long id);
    RiskAssessmentLog getData5(Long id);         
    RiskAssessmentLog updateData5(Long id,RiskAssessmentLog entity);                                                        
}