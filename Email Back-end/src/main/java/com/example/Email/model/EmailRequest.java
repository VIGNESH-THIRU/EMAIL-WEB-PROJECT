package com.example.Email.model;
/*We create a Java app that sends email.
Google blocks normal Gmail passwords for security.
So, we enable 2FA and generate a 16-character App Password.
This App Password lets the app send email securely via Gmail SMTP.*/


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailRequest {
    private String to;
    private String subject;
    private String body;

}

