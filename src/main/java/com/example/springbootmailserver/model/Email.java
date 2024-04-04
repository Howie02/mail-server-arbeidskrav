package com.example.springbootmailserver.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;


//Table entity emails, columns for table emails:
@Data
@Entity
@Table(name = "emails")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fromEmail;

    @Column(nullable = false)
    private String toEmail;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false, length = 10000)
    private String body;

    @Column(nullable = false)
    private LocalDateTime timestamp;
}
