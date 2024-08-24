package com.reactBackend.BookSystem.service;
import com.reactBackend.BookSystem.model.MailStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromMail;

    public void sendEmail(MailStructure mailStructure) {

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromMail);
            message.setTo(mailStructure.getEmail());
            message.setSubject(mailStructure.getSubject());
            message.setText(mailStructure.getMessage());
            javaMailSender.send(message);
    }
}
