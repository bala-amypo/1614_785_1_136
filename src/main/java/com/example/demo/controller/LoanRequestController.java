// package com.example.demo.controller;

// import java.util.*;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
// import com.example.demo.entity.LoanRequest;
// // import com.example.demo.service.UserService;
// import com.example.demo.service.LoanRequestService;
// import jakarta.validation.Valid;

// @RestController
// @RequestMapping("/LoanRequest")
// public class LoanRequestController{
//     @Autowired  LoanRequestService ser;
//     @PostMapping("/register")
//     public LoanRequest sendData(@RequestBody LoanRequest stu){
//         return ser.postData4(stu);
//     }
//     @GetMapping("/get")
//     public List<LoanRequest> getval(){
//         return ser.getAllData4();
//     }
//     @DeleteMapping("/delete/{id}")
//     public String del(@PathVariable Long id){
//         return ser.DeleteData4(id);
//     }
//     @GetMapping("/find/{id}")
//     public LoanRequest find(@PathVariable Long id){
//         return ser.getData4(id);
//     }
//     @PutMapping("/put/{id}")
//     public LoanRequest putval(@PathVariable Long id,@RequestBody LoanRequest entity){
//         return ser.updateData4(id,entity);
//     }
// }








// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/loan-requests")
// public class LoanRequestController {

//     @Autowired
//     private LoanRequestService service;

//     @PostMapping
//     public LoanRequest create(@RequestBody LoanRequest request) {
//         return service.createLoanRequest(request);
//     }

//     @GetMapping("/{id}")
//     public LoanRequest getById(@PathVariable Long id) {
//         return service.getLoanRequestById(id);
//     }

//     @GetMapping("/user/{userId}")
//     public List<LoanRequest> getByUser(@PathVariable Long userId) {
//         return service.getLoanRequestsByUser(userId);
//     }
// }










// src/main/java/com/example/demo/controller/LoanRequestController.java
package com.example.demo.controller;

import com.example.demo.entity.LoanRequest;
import com.example.demo.service.LoanRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan-requests")
public class LoanRequestController {

    private final LoanRequestService loanRequestService;

    public LoanRequestController(LoanRequestService loanRequestService) {
        this.loanRequestService = loanRequestService;
    }

    @PostMapping
    public ResponseEntity<LoanRequest> submit(@RequestBody LoanRequest request) {
        LoanRequest saved = loanRequestService.submitRequest(request);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanRequest> getById(@PathVariable Long id) {
        LoanRequest lr = loanRequestService.getById(id);
        return ResponseEntity.ok(lr);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LoanRequest>> getByUser(@PathVariable Long userId) {
        List<LoanRequest> list = loanRequestService.getRequestsByUser(userId);
        return ResponseEntity.ok(list);
    }
}
