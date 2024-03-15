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

    @Autowired
    public EmailController(EmailService emailService){
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public ResponseEntity<Email> sendEmail(@RequestBody Email email){
        Email sentEmail = emailService.sendEmail(email);
        return new ResponseEntity<>(sentEmail, HttpStatus.CREATED);
    }

    @GetMapping("/sent")
    public ResponseEntity<List<Email>> getAllSentEmails(@RequestParam String fromEmail){
        List<Email> emails = emailService.getAllSentEmails(fromEmail);
        return new ResponseEntity<>(emails, HttpStatus.OK);
    }

    @GetMapping("/received")
    public ResponseEntity<List<Email>> getAllReceivedEmails(@RequestParam String toEmail){
        List<Email> emails = emailService.getAllReceivedEmails(toEmail);
        return new ResponseEntity<>(emails, HttpStatus.OK);
    }
}
