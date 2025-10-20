package com.example.help.center.Service;


import com.example.help.center.entity.User;
import com.example.help.center.entity.UserType;
import com.example.help.center.Repository.UserRepository;
import com.example.help.center.security.JwtService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    // Register new user
    public void registerUser(String username, String password, UserType userType) {
        User user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .userType(userType)
                .build();
        userRepository.insert(user);
    }

    // Login method
    public String loginUser(String username, String password) {
        // Authenticate user
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        // If successful, generate JWT
        return jwtService.generateToken(username);
    }

    public Optional<User> findByUsername(String username) {
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return user;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}