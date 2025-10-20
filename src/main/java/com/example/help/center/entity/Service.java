package com.example.help.center.entity;
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
