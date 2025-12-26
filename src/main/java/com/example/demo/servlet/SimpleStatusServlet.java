// // package com.example.demo.servlet;

// // import jakarta.servlet.http.*;
// // import jakarta.servlet.ServletException;
// // import java.io.IOException;

// // public class SimpleStatusServlet extends HttpServlet {

// //     @Override
// //     protected void doGet(HttpServletRequest req, HttpServletResponse resp)
// //             throws IOException, ServletException {

// //         resp.setContentType("text/plain");
// //         resp.getWriter().write("SimpleStatusServlet OK");
// //     }
// // }



// package com.example.demo.servlet;

// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// import java.io.IOException;

// public class SimpleStatusServlet extends HttpServlet {

//     @Override
//     protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//             throws IOException, ServletException {

//         resp.setContentType("text/plain");
//         resp.getWriter().write("SimpleStatusServlet OK");
//     }
// }












// // src/main/java/com/example/demo/servlet/SimpleStatusServlet.java
// package com.example.demo.servlet;

// import jakarta.servlet.http.HttpServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import java.io.IOException;

// public class SimpleStatusServlet extends HttpServlet {

//     @Override
//     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//         resp.setContentType("text/plain");
//         resp.getWriter().write("SimpleStatusServlet OK");
//     }
// }



















// // src/main/java/com/example/demo/servlet/SimpleStatusServlet.java
// package com.example.demo.servlet;

// import jakarta.servlet.http.HttpServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import java.io.IOException;

// public class SimpleStatusServlet extends HttpServlet {

//     @Override
//     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//         // Set content type once per call (all servlet tests verify this)
//         resp.setContentType("text/plain");

//         // Write some simple status text that includes the servlet name
//         // t04_servlet_content_written expects "SimpleStatusServlet" to be present
//         resp.getWriter().write("SimpleStatusServlet is running");
//     }
// }














// // src/main/java/com/example/demo/servlet/SimpleStatusServlet.java
// package com.example.demo.servlet;

// import jakarta.servlet.http.HttpServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import java.io.IOException;

// /**
//  * Very simple status servlet used only by tests.
//  * It must:
//  *  - always set content type "text/plain"
//  *  - write a body containing "SimpleStatusServlet"
//  *  - work even when request is null
//  *  - NOT swallow IOException from getWriter()/write
//  */
// public class SimpleStatusServlet extends HttpServlet {

//     @Override
//     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//         // Required by multiple tests (t01, t02, t03, t05, t07, t08, t09, t10)
//         resp.setContentType("text/plain");

//         // Required by t04_servlet_content_written
//         resp.getWriter().write("SimpleStatusServlet OK");
//         // Do NOT catch IOException here; t06 expects it to propagate
//     }
// }












// src/main/java/com/example/demo/servlet/SimpleStatusServlet.java
package com.example.demo.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Simple status servlet used by LoanEligibilityEmiRiskCheckerTest.
 */
public class SimpleStatusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Must always be called once per request (t01, t02, t03, t05, t07, t08, t09, t10)
        resp.setContentType("text/plain");

        // Body must contain "SimpleStatusServlet" (t04 checks this)
        resp.getWriter().write("SimpleStatusServlet");

        // Do NOT catch IOException; t06 expects it to propagate
    }
}
