package com.example.springbootmailserver.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "users") //User table and columns
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String password;
}


