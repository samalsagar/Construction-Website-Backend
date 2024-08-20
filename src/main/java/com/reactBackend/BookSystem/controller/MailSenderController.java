package com.reactBackend.BookSystem.controller;

import com.reactBackend.BookSystem.ApiResponse.ApiResponse;
import com.reactBackend.BookSystem.model.MailStructure;
import com.reactBackend.BookSystem.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
@CrossOrigin
public class MailSenderController {

    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("/send")
    public ApiResponse sendEmail(@RequestBody MailStructure mailStructure){
        try {
            emailSenderService.sendEmail(mailStructure);
            return new ApiResponse("Mail Sent successfully to " + mailStructure.getEmail(), true);
        } catch (Exception e) {
            return new ApiResponse("Unable to send the mail", false);
        }
    }
}
