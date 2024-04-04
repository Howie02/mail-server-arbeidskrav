package com.example.springbootmailserver.repository;

import com.example.springbootmailserver.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository // Repository component for Emails managed by Spring
public interface EmailRepository extends JpaRepository<Email, Long>{

    // Method to find emails sent from a specific email address
    List<Email> findByFromEmail(String fromEmail);

    // Method to find emails received by a specific email address
    List<Email> findByToEmail(String toEmail);

}

