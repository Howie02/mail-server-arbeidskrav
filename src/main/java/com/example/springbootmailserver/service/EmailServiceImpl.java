package com.example.springbootmailserver.service;

import com.example.springbootmailserver.model.Email;
import com.example.springbootmailserver.repository.EmailRepository;
import com.example.springbootmailserver.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

// Email service component managed by Spring
@Service
public class EmailServiceImpl implements EmailService {

    // Dependency injection of EmailRepo
    private final EmailRepository emailRepository;

    // Constructor injection of EmailRepo
    @Autowired
    public EmailServiceImpl(EmailRepository emailRepository){
        this.emailRepository = emailRepository;
    }

    // Implementation of the sendEmail method to save the email in the db
    @Override
    public Email sendEmail(Email email){
        return emailRepository.save(email);
    }

    // Implementation of the getAllSentEmails method to retrieve emails sent from a user
    @Override
    public List<Email> getAllSentEmails(String fromEmail){
        return emailRepository.findByFromEmail(fromEmail);
    }

    // Implementation of the getAllReceived method to retrieve all received emails
    @Override
    public List<Email> getAllReceivedEmails(String toEmail){
        return emailRepository.findByToEmail(toEmail);
    }
}
