package com.example.help.center.auth.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

@Builder
@Data
@Entity
@Table(name = "users")  // optional: specify table name
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType userType;

    // Implement UserDetails methods
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null; // implement properly
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public UserType getUserType() { return userType; }
    public void setUserType(UserType userType) { this.userType = userType; }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
