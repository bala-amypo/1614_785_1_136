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
// import com.example.demo.entity.FinancialProfile;
// // import com.example.demo.service.UserService;
// import com.example.demo.service.FinancialProfileService;
// import jakarta.validation.Valid;

// @RestController
// @RequestMapping("/FinancialProfile")
// public class FinancialProfileController{
//     @Autowired  FinancialProfileService ser;
//     @PostMapping("/register")
//     public FinancialProfile sendData(@RequestBody FinancialProfile stu){
//         return ser.postData3(stu);
//     }
//     @GetMapping("/get")
//     public List<FinancialProfile> getval(){
//         return ser.getAllData3();
//     }
//     @DeleteMapping("/delete/{id}")
//     public String del(@PathVariable Long id){
//         return ser.DeleteData3(id);
//     }
//     @GetMapping("/find/{id}")
//     public FinancialProfile find(@PathVariable Long id){
//         return ser.getData3(id);
//     }
//     @PutMapping("/put/{id}")
//     public FinancialProfile putval(@PathVariable Long id,@RequestBody FinancialProfile entity){
//         return ser.updateData3(id,entity);
//     }
// }












// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @RequestMapping("/api/financial-profiles")
// public class FinancialProfileController {

//     @Autowired
//     private FinancialProfileService service;

//     @PostMapping
//     public FinancialProfile createOrUpdate(
//             @RequestBody FinancialProfile profile) {
//         return service.createOrUpdateProfile(profile);
//     }

//     @GetMapping("/user/{userId}")
//     public FinancialProfile getByUser(
//             @PathVariable Long userId) {
//         return service.getProfileByUserId(userId);
//     }
// }













// src/main/java/com/example/demo/controller/FinancialProfileController.java
package com.example.demo.controller;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.service.FinancialProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/financial-profiles")
public class FinancialProfileController {

    private final FinancialProfileService financialProfileService;

    public FinancialProfileController(FinancialProfileService financialProfileService) {
        this.financialProfileService = financialProfileService;
    }

    @PostMapping
    public ResponseEntity<FinancialProfile> createOrUpdate(@RequestBody FinancialProfile profile) {
        FinancialProfile saved = financialProfileService.createOrUpdate(profile);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<FinancialProfile> getByUserId(@PathVariable Long userId) {
        FinancialProfile fp = financialProfileService.getByUserId(userId);
        return ResponseEntity.ok(fp);
    }
}
