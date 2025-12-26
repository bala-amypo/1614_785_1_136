// package com.example.demo.service.impl;

// import com.example.demo.entity.FinancialProfile;
// import com.example.demo.service.FinancialProfileService;
// import org.springframework.stereotype.Service;

// import java.util.ArrayList;
// import java.util.List;

// @Service
// public class FinancialProfileServiceImpl implements FinancialProfileService {

//     // Simple in-memory store for now (replace with repository if you have one)
//     private final List<FinancialProfile> store = new ArrayList<>();

//     @Override
//     public FinancialProfile postData3(FinancialProfile use) {
//         store.add(use);
//         return use;
//     }

//     @Override
//     public List<FinancialProfile> getAllData3() {
//         return new ArrayList<>(store);
//     }

//     @Override
//     public String DeleteData3(Long id) {
//         store.removeIf(p -> p.getId().equals(id));
//         return "Deleted";
//     }

//     @Override
//     public FinancialProfile getData3(Long id) {
//         return store.stream()
//                 .filter(p -> p.getId().equals(id))
//                 .findFirst()
//                 .orElse(null);
//     }

//     @Override
//     public FinancialProfile updateData3(Long id, FinancialProfile entity) {
//         for (int i = 0; i < store.size(); i++) {
//             if (store.get(i).getId().equals(id)) {
//                 store.set(i, entity);
//                 return entity;
//             }
//         }
//         return null;
//     }
// }













package com.example.demo.service.impl;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.service.FinancialProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancialProfileServiceImpl implements FinancialProfileService {

    @Autowired
    private FinancialProfileRepository repository;

    @Override
    public FinancialProfile createOrUpdate(FinancialProfile profile) {
        return repository.save(profile);
    }
}
