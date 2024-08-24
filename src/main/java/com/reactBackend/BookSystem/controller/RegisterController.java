package com.reactBackend.BookSystem.controller;

import com.reactBackend.BookSystem.model.RegisterDetails;
import com.reactBackend.BookSystem.service.RegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.reactBackend.BookSystem.ApiResponse.ApiResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/register")
@CrossOrigin
public class RegisterController {

    @Autowired
    private RegisterServiceImpl registerService;

    @PostMapping("/add")
    public ApiResponse saveDetails(@RequestBody RegisterDetails registerDetails) {
        RegisterDetails res = registerService.getDetailsByEmail(registerDetails.getEmail());
        if (res == null) {
            registerService.saveRegisterDetails(registerDetails);
            return new ApiResponse("Account Created Successfully", true);
        } else {
            return new ApiResponse("User already registered with this email!!!", false);
        }
    }

    @GetMapping("/allDetails")
    public List<RegisterDetails> getAllRegister() {
        List<RegisterDetails> registerDetails = new ArrayList<>();
        for (RegisterDetails re : registerService.getAllRegister()) {
            if (re.getEmail().equals("architectyatharth@gmail.com")) {
                continue;
            } else {
                registerDetails.add(re);
            }
        }
        System.out.println(registerDetails);
        return registerDetails;
    }
}
