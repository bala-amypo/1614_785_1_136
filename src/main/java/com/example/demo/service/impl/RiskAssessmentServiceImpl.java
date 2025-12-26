// package com.example.demo.service.impl;

// import com.example.demo.entity.RiskAssessmentLog;
// import com.example.demo.service.RiskAssessmentLogService;
// import org.springframework.stereotype.Service;

// import java.util.ArrayList;
// import java.util.List;

// @Service
// public class RiskAssessmentLogServiceImpl implements RiskAssessmentLogService {

//     // Temporary in-memory storage (replace with repository if you have one)
//     private final List<RiskAssessmentLog> store = new ArrayList<>();

//     @Override
//     public RiskAssessmentLog postData5(RiskAssessmentLog use) {
//         store.add(use);
//         return use;
//     }

//     @Override
//     public List<RiskAssessmentLog> getAllData5() {
//         return new ArrayList<>(store);
//     }

//     @Override
//     public String DeleteData5(Long id) {
//         store.removeIf(r -> r.getId().equals(id));
//         return "Deleted";
//     }

//     @Override
//     public RiskAssessmentLog getData5(Long id) {
//         return store.stream()
//                 .filter(r -> r.getId().equals(id))
//                 .findFirst()
//                 .orElse(null);
//     }

//     @Override
//     public RiskAssessmentLog updateData5(Long id, RiskAssessmentLog entity) {
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

import com.example.demo.entity.RiskAssessment;
import com.example.demo.repository.RiskAssessmentRepository;
import com.example.demo.service.RiskAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskAssessmentServiceImpl implements RiskAssessmentService {

    @Autowired
    private RiskAssessmentRepository riskAssessmentRepository;

    @Override
    public RiskAssessment postData5(RiskAssessment use) {
        return riskAssessmentRepository.save(use);
    }

    @Override
    public List<RiskAssessment> getAllData5() {
        return riskAssessmentRepository.findAll();
    }

    @Override
    public String deleteData5(Long id) {
        if (riskAssessmentRepository.existsById(id)) {
            riskAssessmentRepository.deleteById(id);
            return "RiskAssessment deleted successfully";
        }
        return "RiskAssessment not found with id: " + id;
    }

    @Override
    public RiskAssessment getData5(Long id) {
        return riskAssessmentRepository.findById(id).orElse(null);
    }

    @Override
    public RiskAssessment updateData5(Long id, RiskAssessment entity) {
        return riskAssessmentRepository.findById(id).map(existing -> {
            existing.setRiskLevel(entity.getRiskLevel());
            existing.setDescription(entity.getDescription());
            existing.setUpdatedAt(entity.getUpdatedAt());
            return riskAssessmentRepository.save(existing);
        }).orElse(null);
    }
}
