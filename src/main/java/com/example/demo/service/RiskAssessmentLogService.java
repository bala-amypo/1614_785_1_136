package com.example.demo.service;

import com.example.demo.entity.RiskAssessmentLog;
import java.util.List;

public interface RiskAssessmentLogService {
    RiskAssessmentLog postData5(RiskAssessmentLog use);
    List<RiskAssessmentLog> getAllData5();
    String DeleteData5(Long id);
    RiskAssessmentLog getData5(Long id);
    RiskAssessmentLog updateData5(Long id, RiskAssessmentLog entity);
}
