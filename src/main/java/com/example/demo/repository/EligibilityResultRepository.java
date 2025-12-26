// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import com.example.demo.entity.EligibilityResult;

// @Repository
// public interface EligibilityResultRepository extends JpaRepository<EligibilityResult,Long>{

// }




// package com.example.demo.repository;

//  import org.springframework.data.jpa.repository.JpaRepository;
//  import org.springframework.stereotype.Repository;
//  import com.example.demo.entity.EligibilityResult;

//  @Repository

// public interface EligibilityResultRepository extends JpaRepository<EligibilityResult, Long> {
//     Optional<EligibilityResult> findByLoanRequestId(Long id);
// }





// package com.example.demo.repository;

// import com.example.demo.entity.EligibilityResult;
// import org.springframework.data.jpa.repository.JpaRepository;

// import java.util.Optional;   

// public interface EligibilityResultRepository
//         extends JpaRepository<EligibilityResult, Long> {

//     Optional<EligibilityResult> findByLoanRequestId(Long loanRequestId);
// }











import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EligibilityResultRepository extends JpaRepository<EligibilityResult, Long> {
    Optional<EligibilityResult> findByLoanRequestId(Long requestId);
}
