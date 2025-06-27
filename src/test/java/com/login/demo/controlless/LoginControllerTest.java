package com.login.demo.controlless;

import com.login.demo.controlless.LoginController;
import com.login.demo.request.LoginRequest;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {

    private final LoginController loginController = new LoginController();

    @Test
    void testLoginSuccess() {
        LoginRequest request = new LoginRequest();
        request.setUsername("admin");
        request.setPassword("password123");

        ResponseEntity<?> response = loginController.loginUser(request);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Login successful!", response.getBody());
    }

    @Test
    void testLoginWithWrongUsername() {
        LoginRequest request = new LoginRequest();
        request.setUsername("wrongUser");
        request.setPassword("password123");

        ResponseEntity<?> response = loginController.loginUser(request);

        assertEquals(401, response.getStatusCodeValue());
        assertEquals("Invalid username or password", response.getBody());
    }

    @Test
    void testLoginWithWrongPassword() {
        LoginRequest request = new LoginRequest();
        request.setUsername("admin");
        request.setPassword("wrongPassword");

        ResponseEntity<?> response = loginController.loginUser(request);

        assertEquals(401, response.getStatusCodeValue());
        assertEquals("Invalid username or password", response.getBody());
    }

    @Test
    void testLoginWithEmptyCredentials() {
        LoginRequest request = new LoginRequest();
        request.setUsername("");
        request.setPassword("");

        ResponseEntity<?> response = loginController.loginUser(request);

        assertEquals(401, response.getStatusCodeValue());
        assertEquals("Invalid username or password", response.getBody());
    }

    @Test
    void testLoginWithNullValues() {
        LoginRequest request = new LoginRequest();
        request.setUsername(null);
        request.setPassword(null);

        ResponseEntity<?> response = loginController.loginUser(request);

        assertEquals(401, response.getStatusCodeValue());
        assertEquals("Invalid username or password", response.getBody());
    }
}