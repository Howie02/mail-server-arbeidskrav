package com.example.springbootmailserver.service;

import com.example.springbootmailserver.model.Email;
import java.util.List;

public interface EmailService {
    Email sendEmail(Email email);
    List<Email> getAllSentEmails(String fromEmail);
    List<Email> getAllReceivedEmails(String toEmail);
}
