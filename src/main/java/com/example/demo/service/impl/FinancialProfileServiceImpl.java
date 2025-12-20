package com.example.demo.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.repository.FinancialProfileServiceRepository;
import org.springframework.stereotype.Service;

@Service
public class FinancialProfileServiceImpl implements UserService{
    @Autowired FinancialProfileServiceRepository student;
    @Override 
    public User postData(User stu){
        return student.save(stu);
    }
}
