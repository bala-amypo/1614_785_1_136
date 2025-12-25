package com.example.demo.service.impl;

import com.example.demo.entity.LoanRequest;
import com.example.demo.service.LoanRequestService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanRequestServiceImpl implements LoanRequestService {

    // Temporary in-memory store (replace with repository if you have one)
    private final List<LoanRequest> store = new ArrayList<>();

    @Override
    public LoanRequest postData4(LoanRequest use) {
        store.add(use);
        return use;
    }

    @Override
    public List<LoanRequest> getAllData4() {
        return new ArrayList<>(store);
    }

    @Override
    public String DeleteData4(Long id) {
        store.removeIf(r -> r.getId().equals(id));
        return "Deleted";
    }

    @Override
    public LoanRequest getData4(Long id) {
        return store.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public LoanRequest updateData4(Long id, LoanRequest entity) {
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getId().equals(id)) {
                store.set(i, entity);
                return entity;
            }
        }
        return null;
    }
}
