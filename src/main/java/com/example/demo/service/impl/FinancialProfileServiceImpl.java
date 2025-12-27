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













// package com.example.demo.service.impl;

// import com.example.demo.entity.FinancialProfile;
// import com.example.demo.repository.FinancialProfileRepository;
// import com.example.demo.service.FinancialProfileService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// @Service
// public class FinancialProfileServiceImpl implements FinancialProfileService {

//     @Autowired
//     private FinancialProfileRepository repository;

//     @Override
//     public FinancialProfile createOrUpdate(FinancialProfile profile) {
//         return repository.save(profile);
//     }
// }










// package com.example.demo.service.impl;

// import com.example.demo.entity.FinancialProfile;
// import com.example.demo.repository.FinancialProfileRepository;
// import com.example.demo.service.FinancialProfileService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class FinancialProfileServiceImpl implements FinancialProfileService {

//     @Autowired
//     private FinancialProfileRepository repository;

//     @Override
//     public FinancialProfile postData3(FinancialProfile profile) {
//         return repository.save(profile);
//     }

//     @Override
//     public List<FinancialProfile> getAllData3() {
//         return repository.findAll();
//     }

//     @Override
//     public String DeleteData3(Long id) {
//         if (repository.existsById(id)) {
//             repository.deleteById(id);
//             return "Deleted successfully";
//         }
//         return "Not found with id: " + id;
//     }

//     @Override
//     public FinancialProfile getData3(Long id) {
//         return repository.findById(id).orElse(null);
//     }

//     @Override
//     public FinancialProfile updateData3(Long id, FinancialProfile entity) {
//         return repository.findById(id).map(existing -> {
//             // Update fields accordingly, example:
//             existing.setSavingsBalance(entity.getSavingsBalance());
//             // update other fields if any
//             return repository.save(existing);
//         }).orElse(null);
//     }
// }
















// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// @Service
// public class FinancialProfileServiceImpl implements FinancialProfileService {

//     @Autowired
//     private FinancialProfileRepository repository;

//     @Override
//     public FinancialProfile createOrUpdateProfile(FinancialProfile profile) {
//         return repository.save(profile);
//     }

//     @Override
//     public FinancialProfile getProfileByUserId(Long userId) {
//         return repository.findByUserId(userId)
//                 .orElseThrow(() -> new RuntimeException("Financial profile not found"));
//     }
// }











// // src/main/java/com/example/demo/service/impl/FinancialProfileServiceImpl.java
// package com.example.demo.service.impl;

// import com.example.demo.entity.FinancialProfile;
// import com.example.demo.entity.User;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.FinancialProfileRepository;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.FinancialProfileService;
// import org.springframework.stereotype.Service;

// import java.util.Optional;

// @Service
// public class FinancialProfileServiceImpl implements FinancialProfileService {

//     private final FinancialProfileRepository financialProfileRepository;
//     private final UserRepository userRepository;

//     public FinancialProfileServiceImpl(FinancialProfileRepository financialProfileRepository,
//                                        UserRepository userRepository) {
//         this.financialProfileRepository = financialProfileRepository;
//         this.userRepository = userRepository;
//     }

//     @Override
//     public FinancialProfile createOrUpdate(FinancialProfile profile) {
//         if (profile.getCreditScore() != null &&
//                 (profile.getCreditScore() < 300 || profile.getCreditScore() > 900)) {
//             throw new BadRequestException("Invalid credit score");
//         }
//         Long userId = profile.getUser() != null ? profile.getUser().getId() : null;
//         if (userId == null) {
//             throw new BadRequestException("User required");
//         }
//         User user = userRepository.findById(userId)
//                 .orElseThrow(() -> new ResourceNotFoundException("User not found"));

//         Optional<FinancialProfile> existingOpt = financialProfileRepository.findByUserId(userId);
//         FinancialProfile toSave;
//         if (existingOpt.isPresent()) {
//             FinancialProfile existing = existingOpt.get();
//             existing.setMonthlyIncome(profile.getMonthlyIncome());
//             existing.setMonthlyExpenses(profile.getMonthlyExpenses());
//             existing.setExistingLoanEmi(profile.getExistingLoanEmi());
//             existing.setCreditScore(profile.getCreditScore());
//             existing.setSavingsBalance(profile.getSavingsBalance());
//             toSave = existing;
//         } else {
//             profile.setUser(user);
//             toSave = profile;
//         }
//         return financialProfileRepository.save(toSave);
//     }

//     @Override
//     public FinancialProfile getByUserId(Long userId) {
//         return financialProfileRepository.findByUserId(userId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));
//     }
// }



























// // src/main/java/com/example/demo/service/impl/FinancialProfileServiceImpl.java
// package com.example.demo.service.impl;

// import com.example.demo.entity.FinancialProfile;
// import com.example.demo.entity.User;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.FinancialProfileRepository;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.FinancialProfileService;
// import org.springframework.stereotype.Service;

// import java.time.Instant;
// import java.util.Optional;

// @Service
// public class FinancialProfileServiceImpl implements FinancialProfileService {

//     private final FinancialProfileRepository financialProfileRepository;
//     private final UserRepository userRepository;

//     public FinancialProfileServiceImpl(FinancialProfileRepository financialProfileRepository,
//                                        UserRepository userRepository) {
//         this.financialProfileRepository = financialProfileRepository;
//         this.userRepository = userRepository;
//     }

//     @Override
//     public FinancialProfile createOrUpdate(FinancialProfile profile) {
//         if (profile.getCreditScore() != null &&
//                 (profile.getCreditScore() < 300 || profile.getCreditScore() > 900)) {
//             throw new BadRequestException("Invalid credit score");
//         }

//         Long userId = profile.getUser() != null ? profile.getUser().getId() : null;
//         if (userId == null) {
//             throw new BadRequestException("User required");
//         }

//         User user = userRepository.findById(userId)
//                 .orElseThrow(() -> new ResourceNotFoundException("User not found"));

//         Optional<FinancialProfile> existingOpt = financialProfileRepository.findByUserId(userId);
//         FinancialProfile toSave;
//         if (existingOpt.isPresent()) {
//             FinancialProfile existing = existingOpt.get();
//             existing.setMonthlyIncome(profile.getMonthlyIncome());
//             existing.setMonthlyExpenses(profile.getMonthlyExpenses());
//             existing.setExistingLoanEmi(profile.getExistingLoanEmi());
//             existing.setCreditScore(profile.getCreditScore());
//             existing.setSavingsBalance(profile.getSavingsBalance());
//             toSave = existing;
//         } else {
//             profile.setUser(user);
//             toSave = profile;
//         }

//         // Explicitly set lastUpdatedAt so tests see it with mocked repo (t29)
//         toSave.setLastUpdatedAt(Instant.now());

//         return financialProfileRepository.save(toSave);
//     }

//     @Override
//     public FinancialProfile getByUserId(Long userId) {
//         return financialProfileRepository.findByUserId(userId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));
//     }
// }











// src/main/java/com/example/demo/service/impl/FinancialProfileServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.FinancialProfileService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class FinancialProfileServiceImpl implements FinancialProfileService {

    private final FinancialProfileRepository financialProfileRepository;
    private final UserRepository userRepository;

    public FinancialProfileServiceImpl(FinancialProfileRepository financialProfileRepository,
                                       UserRepository userRepository) {
        this.financialProfileRepository = financialProfileRepository;
        this.userRepository = userRepository;
    }

    @Override
    public FinancialProfile createOrUpdate(FinancialProfile profile) {
        if (profile.getCreditScore() != null &&
                (profile.getCreditScore() < 300 || profile.getCreditScore() > 900)) {
            throw new BadRequestException("Invalid credit score");
        }

        Long userId = profile.getUser() != null ? profile.getUser().getId() : null;
        if (userId == null) {
            throw new BadRequestException("User required");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Optional<FinancialProfile> existingOpt = financialProfileRepository.findByUserId(userId);
        FinancialProfile toSave;
        if (existingOpt.isPresent()) {
            FinancialProfile existing = existingOpt.get();
            existing.setMonthlyIncome(profile.getMonthlyIncome());
            existing.setMonthlyExpenses(profile.getMonthlyExpenses());
            existing.setExistingLoanEmi(profile.getExistingLoanEmi());
            existing.setCreditScore(profile.getCreditScore());
            existing.setSavingsBalance(profile.getSavingsBalance());
            toSave = existing;
        } else {
            profile.setUser(user);
            toSave = profile;
        }

        // Explicitly set lastUpdatedAt so tests see it with mocked repo (t29)
        toSave.setLastUpdatedAt(Instant.now());

        return financialProfileRepository.save(toSave);
    }

    @Override
    public FinancialProfile getByUserId(Long userId) {
        return financialProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));
    }
}