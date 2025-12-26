// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.entity.User;

// public interface UserService{
//     User postData1(User use);
//     User postData11(User user);
//     List<User>getAllData1();
//     String  DeleteData1(Long id);
//     User getData1(Long id);         
//     User updateData1(Long id,User entity);                                                        
// }





// package com.example.demo.service;

// import com.example.demo.entity.User;

// public interface UserService {
//     User register(User user);
//     User getById(Long id);
//     User findByEmail(String email);
// }












package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    User register(User user);

    User getById(Long id);

    User findByEmail(String email);
}
