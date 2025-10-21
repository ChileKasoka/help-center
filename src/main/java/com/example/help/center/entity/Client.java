package com.example.help.center.entity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String f_name;
    private String l_name;
    private String phone;
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
