package com.jetbrains.bisesh.bookmarket.controller;

import com.jetbrains.bisesh.bookmarket.model.AuthRequest;
import com.jetbrains.bisesh.bookmarket.model.UserInfo;
import com.jetbrains.bisesh.bookmarket.service.JwtService;
import com.jetbrains.bisesh.bookmarket.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserInfoService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/signup")
    public ResponseEntity<?> addNewUser(@RequestBody UserInfo userInfo) {
        try {
            UserInfo savedUser = service.addUser(userInfo);
            return ResponseEntity.ok(savedUser); // User successfully added
        } catch (DataIntegrityViolationException e) {
            // Catching exception if user already exists or any other data integrity issues
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists or data integrity violation.");
        } catch (Exception e) {
            // General exception handling
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing your request.");
        }
    }

    @PostMapping("/getToken")
    public ResponseEntity<?> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );

            if (authentication.isAuthenticated()) {
                String token = jwtService.generateToken(authRequest.getUsername());
                Map<String, String> tokenResponse = new HashMap<>();
                tokenResponse.put("token", token);
                tokenResponse.put("tokenType", "Bearer");
                tokenResponse.put("username", authRequest.getUsername());
                return ResponseEntity.ok(tokenResponse);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
            }
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing your request");
        }
    }

    @GetMapping("/user/userProfile")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userProfile() {
        return "Welcome to User Profile";
    }
}
