package com.example.demo.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.entity.LoanRequest;
// import com.example.demo.service.UserService;
import com.example.demo.service.LoanRequestService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/User3")
public class LoanRequestController{
    @Autowired  LoanRequestService ser;
    @PostMapping("/register")
    public LoanRequest sendData(@RequestBody LoanRequest stu){
        return ser.postData4(stu);
    }
    @GetMapping("/get")
    public List<LoanRequest> getval(){
        return ser.getAllData4();
    }
    @DeleteMapping("/delete/{id}")
    public String del(@PathVariable Long id){
        return ser.DeleteData4(id);
    }
    @GetMapping("/find/{id}")
    public LoanRequest find(@PathVariable Long id){
        return ser.getData4(id);
    }
    @PutMapping("/put/{id}")
    public LoanRequest putval(@PathVariable Long id,@RequestBody LoanRequest entity){
        return ser.updateData4(id,entity);
    }
}