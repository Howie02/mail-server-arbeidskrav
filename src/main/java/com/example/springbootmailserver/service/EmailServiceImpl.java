package com.example.springbootmailserver.service;

import com.example.springbootmailserver.model.Email;
import com.example.springbootmailserver.repository.EmailRepository;
import com.example.springbootmailserver.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {
    private final EmailRepository emailRepository;

    @Autowired
    public EmailServiceImpl(EmailRepository emailRepository){
        this.emailRepository = emailRepository;
    }

    @Override
    public Email sendEmail(Email email){
        return emailRepository.save(email);
    }

    @Override
    public List<Email> getAllSentEmails(String fromEmail){
        return emailRepository.findByFromEmail(fromEmail);
    }

    @Override
    public List<Email> getAllReceivedEmails(String toEmail){
        return emailRepository.findByToEmail(toEmail);
    }
}
