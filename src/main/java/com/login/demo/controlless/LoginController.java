package com.login.demo.controlless;

import com.login.demo.request.LoginRequest;
import com.login.demo.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    // Dummy user credentials
    private final String DUMMY_USERNAME = "admin";
    private final String DUMMY_PASSWORD = "password123";

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        if (DUMMY_USERNAME.equals(loginRequest.getUsername()) &&
                DUMMY_PASSWORD.equals(loginRequest.getPassword())) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }

}
