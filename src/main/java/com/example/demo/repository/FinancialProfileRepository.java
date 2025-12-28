// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import com.example.demo.entity.FinancialProfile;

// @Repository
// public interface FinancialProfileRepository extends JpaRepository<FinancialProfile,Long>{

// }



//  package com.example.demo.repository;

//  import org.springframework.data.jpa.repository.JpaRepository;
//  import org.springframework.stereotype.Repository;
//  import com.example.demo.entity.FinancialProfile;

//  @Repository
// public interface FinancialProfileRepository extends JpaRepository<FinancialProfile, Long> {
//     Optional<FinancialProfile> findByUserId(Long userId);
// }






// package com.example.demo.repository;

// import com.example.demo.entity.FinancialProfile;
// import org.springframework.data.jpa.repository.JpaRepository;

// import java.util.Optional;   

// public interface FinancialProfileRepository
//         extends JpaRepository<FinancialProfile, Long> {

//     Optional<FinancialProfile> findByUserId(Long userId);
// }











// import java.util.Optional;
// import org.springframework.data.jpa.repository.JpaRepository;

// public interface FinancialProfileRepository extends JpaRepository<FinancialProfile, Long> {
//     Optional<FinancialProfile> findByUserId(Long userId);
// }











// // src/main/java/com/example/demo/repository/FinancialProfileRepository.java
// package com.example.demo.repository;

// import com.example.demo.entity.FinancialProfile;
// import org.springframework.data.jpa.repository.JpaRepository;

// import java.util.Optional;

// public interface FinancialProfileRepository extends JpaRepository<FinancialProfile, Long> {
//     Optional<FinancialProfile> findByUserId(Long userId);
// }














// // src/main/java/com/example/demo/repository/FinancialProfileRepository.java
// package com.example.demo.repository;

// import com.example.demo.entity.FinancialProfile;
// import org.springframework.data.jpa.repository.JpaRepository;

// import java.util.Optional;

// public interface FinancialProfileRepository extends JpaRepository<FinancialProfile, Long> {
//     Optional<FinancialProfile> findByUserId(Long userId);
// }









// src/main/java/com/example/demo/repository/FinancialProfileRepository.java
package com.example.demo.repository;

import com.example.demo.entity.FinancialProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FinancialProfileRepository extends JpaRepository<FinancialProfile, Long> {
    Optional<FinancialProfile> findByUserId(Long userId);
}