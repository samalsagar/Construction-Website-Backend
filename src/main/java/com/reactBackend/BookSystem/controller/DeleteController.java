package com.reactBackend.BookSystem.controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reactBackend.BookSystem.ApiResponse.ApiResponse;
import com.reactBackend.BookSystem.service.ContactServiceImpl;
import com.reactBackend.BookSystem.service.RegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin
public class DeleteController {
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private ContactServiceImpl contactService;

    @Autowired
    private RegisterServiceImpl registerService;

    @DeleteMapping("/delete")
    public ApiResponse deleteRegister(@RequestBody String  details) {
            boolean flag = false;
        try {
            JsonNode jsonNode = objectMapper.readTree(details);

            if (jsonNode.has("contactId")) {
                int contactId = jsonNode.get("contactId").asInt();
                System.out.println("Contact id is present: " + contactId);
                contactService.deleteContact(contactId);
                flag = true;
            }

            if (jsonNode.has("registerId")) {
                int registerId = jsonNode.get("registerId").asInt();
                System.out.println("Register id is present: " + registerId);
                registerService.deleteRegister(registerId);
                flag = true;
            }

            if(flag) {
                return new ApiResponse("Record Deleted Successfully", true);
            } else {
                return new ApiResponse("Record not found", false);
            }
        } catch (Exception e) {
            return new ApiResponse("Getting an exception", false);
        }
    }
}
