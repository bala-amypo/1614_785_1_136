package com.example.demo.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.StudentEntity;
import com.example.demo.service.StudentService;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class LoanRequestServiceImpl implements UserService{
    @Autowired LoanRequestRepository student;
    @Override 
    public StudentEntity postData(StudentEntity stu){
        return student.save(stu);
    }
}
