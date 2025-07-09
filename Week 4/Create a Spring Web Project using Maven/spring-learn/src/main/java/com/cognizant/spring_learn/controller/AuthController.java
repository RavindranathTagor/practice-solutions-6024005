package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(HttpServletRequest request) {
        LOGGER.info("START - authenticate() method");

        try {
            // Step 1: Read Authorization header
            String authorizationHeader = request.getHeader("Authorization");
            LOGGER.debug("Authorization header: {}", authorizationHeader);

            if (authorizationHeader == null || !authorizationHeader.startsWith("Basic ")) {
                LOGGER.warn("Invalid or missing Authorization header");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("error", "Missing or invalid Authorization header"));
            }

            // Step 2: Decode the username and password
            String base64Credentials = authorizationHeader.substring(6); // Remove "Basic "
            String credentials = new String(Base64.getDecoder().decode(base64Credentials), StandardCharsets.UTF_8);
            String[] parts = credentials.split(":", 2);

            if (parts.length != 2) {
                LOGGER.warn("Invalid credentials format");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("error", "Invalid credentials format"));
            }

            String username = parts[0];
            String password = parts[1];
            
            LOGGER.debug("Extracted username: {}", username);

            // Step 3: Validate credentials (simple validation for demo)
            if (!isValidUser(username, password)) {
                LOGGER.warn("Invalid credentials for user: {}", username);
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("error", "Invalid credentials"));
            }

            // Step 4: Generate JWT token
            String token = jwtUtil.generateToken(username);
            LOGGER.info("JWT token generated for user: {}", username);

            // Step 5: Return token response
            Map<String, String> response = new HashMap<>();
            response.put("token", token);

            LOGGER.info("END - authenticate() method - Success");
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            LOGGER.error("Error during authentication: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Authentication failed"));
        }
    }

    /**
     * Simple user validation method
     * In production, this should check against a database or external service
     */
    private boolean isValidUser(String username, String password) {
        LOGGER.debug("Validating user credentials for: {}", username);
        
        // Simple hardcoded validation for demo purposes
        // In real application, check against database or LDAP
        return "user".equals(username) && "pwd".equals(password);
    }
}
