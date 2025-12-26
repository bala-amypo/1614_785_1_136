package com.example.demo.service.impl;

import com.example.demo.entity.RiskAssessment;
import com.example.demo.service.RiskAssessmentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RiskAssessmentServiceImpl implements RiskAssessmentService {

    // Temporary in-memory storage (replace with repository if you have one)
    private final List<RiskAssessmentLog> store = new ArrayList<>();

    @Override
    public RiskAssessmentLog postData5(RiskAssessmentLog use) {
        store.add(use);
        return use;
    }

    @Override
    public List<RiskAssessmentLog> getAllData5() {
        return new ArrayList<>(store);
    }

    @Override
    public String DeleteData5(Long id) {
        store.removeIf(r -> r.getId().equals(id));
        return "Deleted";
    }

    @Override
    public RiskAssessmentLog getData5(Long id) {
        return store.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public RiskAssessmentLog updateData5(Long id, RiskAssessmentLog entity) {
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getId().equals(id)) {
                store.set(i, entity);
                return entity;
            }
        }
        return null;
    }
}
