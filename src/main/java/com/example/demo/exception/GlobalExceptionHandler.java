// // package com.example.demo.exception;

// // import org.springframework.http.HttpStatus;
// // import org.springframework.http.ResponseEntity;
// // import org.springframework.web.bind.annotation.ExceptionHandler;
// // import org.springframework.web.bind.annotation.RestControllerAdvice;

// // @RestControllerAdvice
// // public class GlobalExceptionHandler {


// //     @ExceptionHandler(ResourceNotFoundException.class)
// //     public ResponseEntity<String> handleUserIDfound(ResourceNotFoundException r){
// //         return new ResponseEntity<String>(r.getMessage(),HttpStatus.NOT_FOUND);
// //     }
// // }













// import java.time.LocalDateTime;
// import java.util.HashMap;
// import java.util.Map;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.RestControllerAdvice;

// @RestControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler(ResourceNotFoundException.class)
//     public ResponseEntity<Map<String, Object>> handleNotFound(
//             ResourceNotFoundException ex) {

//         Map<String, Object> response = new HashMap<>();
//         response.put("timestamp", LocalDateTime.now());
//         response.put("status", HttpStatus.NOT_FOUND.value());
//         response.put("error", "Not Found");
//         response.put("message", ex.getMessage());

//         return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//     }

//     @ExceptionHandler(RuntimeException.class)
//     public ResponseEntity<Map<String, Object>> handleRuntime(
//             RuntimeException ex) {

//         Map<String, Object> response = new HashMap<>();
//         response.put("timestamp", LocalDateTime.now());
//         response.put("status", HttpStatus.BAD_REQUEST.value());
//         response.put("error", "Bad Request");
//         response.put("message", ex.getMessage());

//         return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//     }

//     @ExceptionHandler(Exception.class)
//     public ResponseEntity<Map<String, Object>> handleGeneric(
//             Exception ex) {

//         Map<String, Object> response = new HashMap<>();
//         response.put("timestamp", LocalDateTime.now());
//         response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
//         response.put("error", "Internal Server Error");
//         response.put("message", ex.getMessage());

//         return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//     }
// }












// // src/main/java/com/example/demo/exception/GlobalExceptionHandler.java
// package com.example.demo.exception;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.RestControllerAdvice;

// @RestControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler(BadRequestException.class)
//     public ResponseEntity<String> handleBadRequest(BadRequestException ex) {
//         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
//     }

//     @ExceptionHandler(ResourceNotFoundException.class)
//     public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex) {
//         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//     }

//     @ExceptionHandler(Exception.class)
//     public ResponseEntity<String> handleOther(Exception ex) {
//         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                 .body("Unexpected error");
//     }
// }










// // src/main/java/com/example/demo/exception/GlobalExceptionHandler.java
// package com.example.demo.exception;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.RestControllerAdvice;

// @RestControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler(BadRequestException.class)
//     public ResponseEntity<String> handleBadRequest(BadRequestException ex) {
//         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
//     }

//     @ExceptionHandler(ResourceNotFoundException.class)
//     public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex) {
//         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//     }

//     @ExceptionHandler(Exception.class)
//     public ResponseEntity<String> handleOther(Exception ex) {
//         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                 .body("Unexpected error");
//     }
// }













// src/main/java/com/example/demo/exception/GlobalExceptionHandler.java
package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleBadRequest(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleOther(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Unexpected error");
    }
}