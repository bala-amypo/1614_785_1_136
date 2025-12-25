package com.example.demo.service.impl;

import com.example.demo.entity.EligibilityResult;
import com.example.demo.service.LoanEligibilityService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanEligibilityServiceImpl implements LoanEligibilityService {

    // Temporary in‑memory storage (replace with repository if you have one)
    private final List<EligibilityResult> store = new ArrayList<>();

    @Override
    public EligibilityResult postData2(EligibilityResult use) {
        store.add(use);
        return use;
    }

    @Override
    public List<EligibilityResult> getAllData2() {
        return new ArrayList<>(store);
    }

    @Override
    public String DeleteData2(Long id) {
        store.removeIf(e -> e.getId().equals(id));
        return "Deleted";
    }

    @Override
    public EligibilityResult getData2(Long id) {
        return store.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public EligibilityResult updateData2(Long id, EligibilityResult entity) {
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getId().equals(id)) {
                store.set(i, entity);
                return entity;
            }
        }
        return null;
    }
}
