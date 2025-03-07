package com.nhp.university.facilitymanagement.model;

import jakarta.persistence.*;

@Entity
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Getters và setters
}