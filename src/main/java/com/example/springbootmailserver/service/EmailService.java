package com.example.springbootmailserver.service;

import com.example.springbootmailserver.model.Email;
import java.util.List;


// Interface defining methods for email-related services
public interface EmailService {

    // Method to send an email
    Email sendEmail(Email email);

    // Method to retrieve all emails sent by a specific email address
    List<Email> getAllSentEmails(String fromEmail);

    // Method to retrieve all emails received by a specific email address
    List<Email> getAllReceivedEmails(String toEmail);
}
