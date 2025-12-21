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
import com.example.demo.entity.RiskAssessmentLog;
// import com.example.demo.service.UserService;
import com.example.demo.service.RiskAssessmentService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/User4")
public class RiskLogController{
    @Autowired  RiskAssessmentService ser;
    @PostMapping("/register")
    public RiskAssessmentLog sendData(@RequestBody RiskAssessmentLog stu){
        return ser.postData5(stu);
    }
    @GetMapping("/get")
    public List<RiskAssessmentLog> getval(){
        return ser.getAllData5();
    }
    @DeleteMapping("/delete/{id}")
    public String del(@PathVariable Long id){
        return ser.DeleteData5(id);
    }
    @GetMapping("/find/{id}")
    public RiskAssessmentLog find(@PathVariable Long id){
        return ser.getData5(id);
    }
    @PutMapping("/put/{id}")
    public RiskAssessmentLog putval(@PathVariable Long id,@RequestBody RiskAssessmentLog entity){
        return ser.updateData5(id,entity);
    }
}