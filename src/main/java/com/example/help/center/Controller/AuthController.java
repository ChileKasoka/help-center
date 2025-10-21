package com.example.help.center.Controller;

import com.example.help.center.Service.UserService;
import com.example.help.center.entity.User;
import com.example.help.center.entity.UserType;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    // 🧱 Register any type of user: system user, cleaner, or client
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        switch (request.getUserCategory().toUpperCase()) {
            case "USER":
                userService.registerSystemUser(
                        request.getUsername(),
                        request.getPassword(),
                        request.getUserType()
                );
                return ResponseEntity.ok("System user registered successfully!");

            case "CLIENT":
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

            case "CLEANER":
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

            default:
                return ResponseEntity.badRequest().body("Invalid user category.");
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return userService.loginUser(request.getUsername(), request.getPassword());
    }

    @GetMapping("/users")
    public List<User> listUsers() {
        return userService.findAll();
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class RegisterRequest {
    // Common for all
    private String userCategory; // USER, CLIENT, CLEANER
    private String username;
    private String password;
    private UserType userType;
    private boolean systemUser; // whether this person uses the system

    // Personal details
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    // Cleaner-specific
    private String nationalId;
    private String gender;
    private String address;

    // Shared
    private Long companyId;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class LoginRequest {
    private String username;
    private String password;
}
