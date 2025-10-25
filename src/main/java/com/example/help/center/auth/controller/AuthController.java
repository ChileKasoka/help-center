package com.example.help.center.auth.controller;

import com.example.help.center.auth.entity.User;
import com.example.help.center.auth.entity.UserType;
import com.example.help.center.auth.service.UserService;
import com.example.help.center.cleaner.entity.Gender;

import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {

        if (request.getUserType() == null) {
            return ResponseEntity.badRequest().body("User type must be provided.");
        }

        UserType userType;
        try {
            userType = UserType.valueOf(request.getUserType().name());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid user category: " + request.getUserType());
        }

        switch (userType) {
            case USER:
                userService.registerSystemUser(
                        request.getUsername(),
                        request.getPassword(),
                        request.getUserType()
                );
                return ResponseEntity.ok("System user registered successfully!");

            case CLIENT:
                userService.registerClient(
                        request.getUsername(),
                        request.getPassword(),
                        request.getUserType(),
                        request.getFirstName(),
                        request.getLastName(),
                        request.getPhone(),
                        request.getEmail(),
                        request.getAddress(),
                        request.getCompanyId(),
                        request.isSystemUser()
                );
                return ResponseEntity.ok("Client registered successfully!");

            case CLEANER:
                userService.registerCleaner(
                        request.getUsername(),
                        request.getPassword(),
                        request.getUserType(),
                        request.getFirstName(),
                        request.getLastName(),
                        request.getPhone(),
                        request.getNationalId(),
                        request.getGender(),
                        request.getAddress(),
                        request.getCompanyId(),
                        request.isSystemUser()
                );
                return ResponseEntity.ok("Cleaner registered successfully!");

            case PLATFORM_ADMIN:


            default:
                return ResponseEntity.badRequest().body("Unsupported user category.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(
                userService.loginUser(request.getUsername(), request.getPassword())
        );
    }

    @GetMapping("/users")
    public List<User> listUsers() {
        return userService.findAll();
    }
}

// ✅ DTOs

@Data
@NoArgsConstructor
@AllArgsConstructor
class RegisterRequest {
    private String username;
    private String password;
    private UserType userType;
    private boolean systemUser;

    // Common profile information
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    // Cleaner-specific details
    private String nationalId;
    private Gender gender;
    private String address;

    // Both cleaner/client need company
    private Long companyId;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class LoginRequest {
    private String username;
    private String password;
}
