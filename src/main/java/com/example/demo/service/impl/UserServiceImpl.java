package com.example.demo.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired UserRepository student;
    @Override 
    public User postData(Userstu){
        return student.save(stu);
    }
}
