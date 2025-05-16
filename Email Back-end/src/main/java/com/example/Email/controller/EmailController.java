package com.example.Email.controller;
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
    public String sendEmail(@RequestBody EmailRequest request)
    {
        try {
            emailService.sendSimpleMail(request.getTo(), request.getSubject(), request.getBody());
            return "Email sent successfully.";
        } catch (Exception e) {
            return "Failed to send email: " + e.getMessage();
        }
    }
}
