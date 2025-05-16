package com.example.Email.service;


import com.example.Email.model.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
//SimpleMailMessage is a class provided by Spring:
//This class is part of Spring's email system (spring-boot-starter-mail). It already has the method:
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
/*Client (Sends JSON)
       ↓
Spring Boot Controller
       ↓
Jackson maps JSON → EmailRequest object
       ↓
Controller method uses EmailRequest fields
       ↓
Service layer logic:
   → Creates SimpleMailMessage
   → Sends email via JavaMailSender
       ↓
Returns success or failure message to client*/
@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;
//so we the dependency in th starter-mail it provides the javamailsender interfacs and sendsimplemail object
// so assign the values from the controller to the simplesendmail it has some methods providede by the spring by inject the depenedency of starter-mail
//java mail sender is an interface it send the mail after the values assign to the simplemailsender
    public void sendSimpleMail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("vigneshthirumoorthy4@example.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

}

