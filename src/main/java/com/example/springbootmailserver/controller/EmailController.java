package com.example.springbootmailserver.controller;

import com.example.springbootmailserver.model.Email;
import com.example.springbootmailserver.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/emails")
public class EmailController {
    private final EmailService emailService;

    // Constructor-based dependency injection for the EmailService
    @Autowired
    public EmailController(EmailService emailService){
        this.emailService = emailService;
    }

    // POST mapping to send an email
    @PostMapping("/send")
    public ResponseEntity<Email> sendEmail(@RequestBody Email email){
        Email sentEmail = emailService.sendEmail(email);
        return new ResponseEntity<>(sentEmail, HttpStatus.CREATED);
    }

    // GET mapping to retrieve all sent emails for a specific sender address
    @GetMapping("/sent")
    public ResponseEntity<List<Email>> getAllSentEmails(@RequestParam String fromEmail){
        List<Email> emails = emailService.getAllSentEmails(fromEmail);
        return new ResponseEntity<>(emails, HttpStatus.OK);
    }

    // GET mapping to retrieve all received emails for a specific recipient
    @GetMapping("/received")
    public ResponseEntity<List<Email>> getAllReceivedEmails(@RequestParam String toEmail){
        List<Email> emails = emailService.getAllReceivedEmails(toEmail);
        return new ResponseEntity<>(emails, HttpStatus.OK);
    }
}
