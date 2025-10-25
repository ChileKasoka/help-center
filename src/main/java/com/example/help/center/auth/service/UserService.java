package com.example.help.center.auth.service;


import com.example.help.center.auth.entity.User;
import com.example.help.center.auth.entity.UserType;
import com.example.help.center.auth.repository.UserRepository;
import com.example.help.center.cleaner.entity.Cleaner;
import com.example.help.center.cleaner.entity.Gender;
import com.example.help.center.cleaner.repository.CleanerRepository;
import com.example.help.center.client.entity.Client;
import com.example.help.center.client.repository.ClientRepository;
import com.example.help.center.company.entity.Company;
import com.example.help.center.company.repository.CompanyRepository;
import com.example.help.center.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CleanerRepository cleanerRepository;
    private final ClientRepository clientRepository;
    private final CompanyRepository companyRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    // 🧱 1. Register a system-level user (creds for login)
    @Transactional
    public void registerSystemUser(String username, String password, UserType userType) {
        User user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .userType(userType)
                .build();
        userRepository.insert(user);
    }

    // 🧱 2. Register a client (can be a system user or not)
    @Transactional
    public void registerClient(String username, String password, UserType userType,
                               String firstName, String lastName, String email, String phone, String address,
                               Long companyId, boolean systemUser) {

        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        Long userId = null;
        if (systemUser && userType == UserType.CLIENT) {
            User user = User.builder()
                    .username(username)
                    .password(passwordEncoder.encode(password))
                    .userType(userType)
                    .build();
            userRepository.insert(user);
            userId = user.getId();
        }

        Client client = Client.builder()
                .f_name(firstName)
                .l_name(lastName)
                .phone(phone)
                .email(email)
                .company(company)
                .address(address)
                .userId(userId)
                .build();

        clientRepository.insert(client);
    }

    // 🧱 3. Register a cleaner (can also be a system user)
    @Transactional
    public void registerCleaner(String username, String password, UserType userType,
                                String firstName, String lastName, String phone, String nationalId,
                                Gender gender, String address, Long companyId, boolean systemUser) {

        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        Long userId = null;
        if (systemUser && userType == UserType.CLEANER) {
            User user = User.builder()
                    .username(username)
                    .password(passwordEncoder.encode(password))
                    .userType(userType)
                    .build();
            userRepository.insert(user);
            userId = user.getId();
        }

        Cleaner cleaner = Cleaner.builder()
                .f_name(firstName)
                .l_name(lastName)
                .phone(phone)
                .nationalId(nationalId)
                .gender(gender)
                .address(address)
                .company(company)
                .userId(userId)
                .build();

        cleanerRepository.insert(cleaner);
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