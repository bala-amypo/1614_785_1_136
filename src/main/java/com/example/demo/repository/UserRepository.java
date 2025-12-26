// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import com.example.demo.entity.User;

// @Repository
// public interface UserRepository extends JpaRepository<User,Long>{

// }




//  package com.example.demo.repository;
//  import org.springframework.data.jpa.repository.JpaRepository;
//  import org.springframework.stereotype.Repository;
//  import com.example.demo.entity.User;

//  @Repository
// public interface UserRepository extends JpaRepository<User, Long> {
//     Optional<User> findByEmail(String email);
// }


// package com.example.demo.repository;

// import com.example.demo.entity.User;
// import org.springframework.data.jpa.repository.JpaRepository;

// import java.util.Optional;

// public interface UserRepository extends JpaRepository<User, Long> {
//     Optional<User> findByEmail(String email);
// }











// package com.example.demo.repository;

// import com.example.demo.entity.User;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// @Repository
// public interface UserRepository extends JpaRepository<User, Long> {
// }







// package com.example.demo.repository;

// import com.example.demo.entity.User;
// import org.springframework.data.jpa.repository.JpaRepository;

// import java.util.Optional;

// public interface UserRepository extends JpaRepository<User, Long> {

//     Optional<User> findByEmail(String email);

// }








// import java.util.Optional;
// import org.springframework.data.jpa.repository.JpaRepository;

// public interface UserRepository extends JpaRepository<User, Long> {
//     Optional<User> findByEmail(String email);
// }











// src/main/java/com/example/demo/repository/UserRepository.java
package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    List<User> findByRole(String role);
}
