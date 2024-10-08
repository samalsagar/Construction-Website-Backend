package com.reactBackend.BookSystem.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reactBackend.BookSystem.ApiResponse.ApiResponse;
import com.reactBackend.BookSystem.model.LoginDetails;
import com.reactBackend.BookSystem.model.RegisterDetails;
//import com.reactBackend.BookSystem.service.LoginServiceImpl;
import com.reactBackend.BookSystem.service.RegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/")
@CrossOrigin
public class LoginController {

    @Autowired
    private RegisterServiceImpl registerService;

//    @Autowired
//    private LoginServiceImpl loginService;
    ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/login")
    public ApiResponse checkLogin(@RequestBody String loginDetails) {
        try {
            // Convert string to JsonNode (generic JSON tree)
            JsonNode jsonNode = objectMapper.readTree(loginDetails);
            String resEmail = jsonNode.get("email").asText();
            String resPassword = jsonNode.get("password").asText();
            if (resEmail.isEmpty() || resPassword.isEmpty()) {
                return new ApiResponse("Invalid Details", false);
            } else {
                if (registerService.getDetailsByEmail(resEmail) != null) {
                    if (resEmail.equals("architectyatharth@gmail.com") && resPassword.equals("yathartharc@7575")) {
                        return new ApiResponse("Login Success", true);
                    } else {
                        return new ApiResponse("Invalid Credentials...", false);
                    }
                } else {
                    return new ApiResponse("Account doesn't exist... Please register", false);
                }
            }
        } catch (Exception e) {
            return new ApiResponse("Getting error", false);
        }
    }
}
