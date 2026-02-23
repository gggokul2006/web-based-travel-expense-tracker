package com.example.Web.Based.Travel.Expense.Tracker.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Web.Based.Travel.Expense.Tracker.Service.EmailService;



@RestController
@RequestMapping("/email") // Ensure this matches your API path
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send") // Make sure the mapping is correct
    public ResponseEntity<String> sendEmail(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String body) {
        try {
            emailService.sendEmail(to, subject, body);
            return ResponseEntity.ok("Email sent successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error sending email: " + e.getMessage());
        }
    }
}