package com.example.demo.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class FinancialProfileServiceImpl implements StudentService{
    @Autowired StudentRepository student;
    @Override 
    public StudentEntity postData(StudentEntity stu){
        return student.save(stu);
    }
}
