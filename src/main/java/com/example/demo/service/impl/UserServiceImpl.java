// package com.example.demo.service.impl;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;   
// import com.example.demo.entity.User;
// import com.example.demo.repository.UserRepository;
// import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.service.UserService;                
// import com.example.demo.exception.ResourceNotFoundException;
// @Service
// public class UserServiceImpl implements UserService{

//     @Autowired UserRepository used;
//     @Override
//     public User postData1(User use){
//         return used.save(use);  
//     }
//       @Override
//     public User postData11(User user){
//         return used.save(user);  
//     }
//     @Override
//     public List<User>getAllData1(){
//         return used.findAll();
//     }
//     @Override
//     public String DeleteData1(Long id){
//         used.deleteById(id);
//         return "Deleted successfully";
//     }
//     @Override
//     public User getData1(Long id){
//     return used.findById(id).orElseThrow(()->new ResourceNotFoundException("Not Found"));
//     }
//     @Override
//     public User updateData1(Long id,User entity){
//         if(used.existsById(id)){
//             entity.setId(id);
//             return used.save(entity);
//         } 
//         return null;
//     }
// }



//  package com.example.demo.service.impl;

//  import java.util.List;
//  import org.springframework.beans.factory.annotation.Autowired;
//  import org.springframework.stereotype.Service;   
//  import com.example.demo.entity.User;
//  import com.example.demo.repository.UserRepository;
//  import org.springframework.web.bind.annotation.PathVariable;
//  import com.example.demo.service.UserService;                
//  import com.example.demo.exception.ResourceNotFoundException;
// @Service

// public class UserServiceImpl {

//     private final UserRepository repo;
//     private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

//     public UserServiceImpl(UserRepository repo) {
//         this.repo = repo;
//     }

//     public User register(User user) {
//         if (repo.findByEmail(user.getEmail()).isPresent())
//             throw new BadRequestException("Email already in use");

//         user.setPassword(encoder.encode(user.getPassword()));
//         user.setRole(User.Role.CUSTOMER.name());
//         return repo.save(user);
//     }

//     public User getById(Long id) {
//         return repo.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("User not found"));
//     }

//     public User findByEmail(String email) {
//         return repo.findByEmail(email).orElse(null);
//     }
// }





// package com.example.demo.service.impl;

// import com.example.demo.entity.User;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.UserRepository;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// import java.util.Optional;

// public class UserServiceImpl {

//     private final UserRepository userRepository;
//     private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

//     public UserServiceImpl(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }

//     public User register(User user) {

//         Optional<User> existing = userRepository.findByEmail(user.getEmail());
//         if (existing.isPresent()) {
//             throw new BadRequestException("Email already in use");
//         }

//         user.setPassword(encoder.encode(user.getPassword()));
//         user.setRole(User.Role.CUSTOMER.name());
//         return userRepository.save(user);
//     }

//     public User getById(Long id) {
//         return userRepository.findById(id)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("User not found"));
//     }

//     public User findByEmail(String email) {
//         return userRepository.findByEmail(email).orElse(null);
//     }
// }






// package com.example.demo.service.impl;

// import com.example.demo.entity.User;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.UserRepository;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// import java.util.Optional;

// public class UserServiceImpl {

//     private final UserRepository userRepository;
//     private final BCryptPasswordEncoder encoder;

//     public UserServiceImpl(UserRepository userRepository) {
//         this.userRepository = userRepository;
//         this.encoder = new BCryptPasswordEncoder();
//     }

//     public User register(User user) {

//         Optional<User> existing = userRepository.findByEmail(user.getEmail());
//         if (existing.isPresent()) {
//             throw new BadRequestException("Email already in use");
//         }

//         user.setPassword(encoder.encode(user.getPassword()));
//         user.setRole(User.Role.CUSTOMER.name());

//         return userRepository.save(user);
//     }

//     public User getById(Long id) {
//         return userRepository.findById(id)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("User not found"));
//     }

//     public User findByEmail(String email) {
//         return userRepository.findByEmail(email).orElse(null);
//     }
// }







package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    public User register(User user) {

        Optional<User> existing = userRepository.findByEmail(user.getEmail());
        if (existing.isPresent()) {
            throw new BadRequestException("Email already in use");
        }

        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(User.Role.CUSTOMER.name());

        return userRepository.save(user);
    }

    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}
