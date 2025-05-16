package com.example.Email.controller;
/*Why We Use App Passwords to Send Email in Java (Gmail + SMTP)
         The Problem:
        In Java (like Spring Boot), we send email using SMTP, which needs:
         Your Gmail address
         Your Gmail password
        But... Google blocks this for security reasons, especially if:
        2FA (Two-Factor Authentication) is enabled
        The app is not using a browser to log in
        Google’s Solution:
        To safely allow apps to connect, Google provides something called an App Password.
         So the Steps Are:
        Enable 2FA (Two-Factor Authentication) on your Gmail account
         This protects your account
        Generate an App Password
         A special 16-character password like:
         jnup viyt ataz kcjc
        Use this App Password in your Java code, instead of your real Gmail password
         This bypasses 2FA for that app only*/
import com.example.Email.model.EmailRequest;
import com.example.Email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@CrossOrigin
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailRequest request)//so spring create the object assign the values using lombok
    {
        try {
            emailService.sendSimpleMail(request.getTo(), request.getSubject(), request.getBody());
            return "Email sent successfully.";
        } catch (Exception e) {
            return "Failed to send email: " + e.getMessage();
        }
    }
}
