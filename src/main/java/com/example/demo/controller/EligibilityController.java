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
import org.springframework.web.bind.annotation.RestMapping;
import com.example.demo.entity.EligibilityResult;
import com.example.demo.service.UserService;
import com.example.demo.service.LoanEligibilityService;
import jakarta.validation.Valid;

@RestController
@RestMapping("/User1")
public class EligibilityController{
    @Autowired  LoanEligibilityService ser;
    @PostMapping("/register")
    public EligibilityResult sendData(@RequestBody EligibilityResult stu){
        return ser.postData2(stu);
    }
    @GetMapping("/get")
    public List<EligibilityResult> getval(){
        return ser.getAllData2();
    }
    @DeleteMapping("/delete/{id}")
    public String del(@PathVariable Long id){
        return ser.DeleteData2(id);
    }
    @GetMapping("/find/{id}")
    public EligibilityResult find(@PathVariable Long id){
        return ser.getData2(id);
    }
    @PutMapping("/put/{id}")
    public EligibilityResult putval(@PathVariable Long id,@RequestBody EligibilityResult entity){
        return ser.updateData2(id,entity);
    }
}