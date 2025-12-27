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
// import com.example.demo.entity.RiskAssessmentLog;
// // import com.example.demo.service.UserService;
// import com.example.demo.service.RiskAssessmentLogService;
// import jakarta.validation.Valid;

// @RestController
// @RequestMapping("/RiskAssessmentLog")
// public class RiskLogController{
//     @Autowired  RiskAssessmentLogService ser;
//     @PostMapping("/register")
//     public RiskAssessmentLog sendData(@RequestBody RiskAssessmentLog stu){
//         return ser.postData5(stu);
//     }
//     @GetMapping("/get")
//     public List<RiskAssessmentLog> getval(){
//         return ser.getAllData5();
//     }
//     @DeleteMapping("/delete/{id}")
//     public String del(@PathVariable Long id){
//         return ser.DeleteData5(id);
//     }
//     @GetMapping("/find/{id}")
//     public RiskAssessmentLog find(@PathVariable Long id){
//         return ser.getData5(id);
//     }
//     @PutMapping("/put/{id}")
//     public RiskAssessmentLog putval(@PathVariable Long id,@RequestBody RiskAssessmentLog entity){
//         return ser.updateData5(id,entity);
//     }
// }










// package com.example.demo.controller;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;
// import com.example.demo.entity.RiskAssessment;
// import com.example.demo.service.RiskAssessmentService;
// import jakarta.validation.Valid;

// @RestController
// @RequestMapping("/riskAssessment")
// public class RiskAssessmentController {

//     @Autowired  
//     private RiskAssessmentService service;

//     @PostMapping("/register")
//     public RiskAssessment sendData(@RequestBody @Valid RiskAssessment riskAssessment) {
//         return service.postData5(riskAssessment);
//     }

//     @GetMapping("/get")
//     public List<RiskAssessment> getAll() {
//         return service.getAllData5();
//     }

//     @DeleteMapping("/delete/{id}")
//     public String delete(@PathVariable Long id) {
//         return service.deleteData5(id);
//     }

//     @GetMapping("/find/{id}")
//     public RiskAssessment find(@PathVariable Long id) {
//         return service.getData5(id);
//     }

//     @PutMapping("/put/{id}")
//     public RiskAssessment update(@PathVariable Long id, @RequestBody @Valid RiskAssessment entity) {
//         return service.updateData5(id, entity);
//     }
// }











// // src/main/java/com/example/demo/controller/RiskAssessmentController.java
// package com.example.demo.controller;

// import com.example.demo.entity.RiskAssessment;
// import com.example.demo.service.RiskAssessmentService;
// import jakarta.validation.Valid;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/risk-assessments")
// public class RiskAssessmentController {

//     private final RiskAssessmentService service;

//     public RiskAssessmentController(RiskAssessmentService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public ResponseEntity<RiskAssessment> postData5(@Valid @RequestBody RiskAssessment riskAssessment) {
//         return ResponseEntity.ok(service.postData5(riskAssessment));
//     }

//     @GetMapping
//     public ResponseEntity<List<RiskAssessment>> getAllData5() {
//         return ResponseEntity.ok(service.getAllData5());
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deleteData5(@PathVariable Long id) {
//         service.deleteData5(id);
//         return ResponseEntity.noContent().build();
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<RiskAssessment> getData5(@PathVariable Long id) {
//         return ResponseEntity.ok(service.getData5(id));
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<RiskAssessment> updateData5(
//             @PathVariable Long id,
//             @Valid @RequestBody RiskAssessment riskAssessment) {
//         return ResponseEntity.ok(service.updateData5(id, riskAssessment));
//     }
// }
















package com.example.demo.controller;

import com.example.demo.entity.RiskAssessment;
import com.example.demo.service.RiskAssessmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/risk-assessments")
public class RiskAssessmentController {

    private final RiskAssessmentService service;

    public RiskAssessmentController(RiskAssessmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RiskAssessment> postData5(@Valid @RequestBody RiskAssessment riskAssessment) {
        return ResponseEntity.ok(service.postData5(riskAssessment));
    }

    @GetMapping
    public ResponseEntity<List<RiskAssessment>> getAllData5() {
        return ResponseEntity.ok(service.getAllData5());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteData5(@PathVariable Long id) {
        service.deleteData5(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskAssessment> getData5(@PathVariable Long id) {
        return ResponseEntity.ok(service.getData5(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RiskAssessment> updateData5(
            @PathVariable Long id,
            @Valid @RequestBody RiskAssessment riskAssessment) {
        return ResponseEntity.ok(service.updateData5(id, riskAssessment));
    }
}