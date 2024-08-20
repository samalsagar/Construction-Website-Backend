package com.reactBackend.BookSystem.controller;

import com.reactBackend.BookSystem.model.ContactDetails;
import com.reactBackend.BookSystem.service.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contact")
@CrossOrigin
public class ContactDetailsController {
    @Autowired
    private ContactServiceImpl contactService;
    @PostMapping("/save")
    public void saveContactDetails(@RequestBody ContactDetails contactDetails) {
//        System.out.println("HEYYYYYYYY");
        ContactDetails res = contactService.saveDetails(contactDetails);
       if(res.getContactId() > 0) {
           System.out.println("Data Inserted Successfully with id : " + res.getContactId());
       }
    }

    @GetMapping("/allDetails")
    public List<ContactDetails> getAllDetails() {
        return contactService.getAllDetails();
    }
}
