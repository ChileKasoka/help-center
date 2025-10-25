package com.example.help.center.cleanerServices.entity;
import com.example.help.center.company.entity.Company;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // e.g., "House Cleaning"
    private String description;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
