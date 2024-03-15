package com.example.springbootmailserver.repository;

import com.example.springbootmailserver.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long>{
    List<Email> findByFromEmail(String fromEmail);
    List<Email> findByToEmail(String toEmail);

}

