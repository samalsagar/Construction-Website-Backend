package com.reactBackend.BookSystem.service;

import com.reactBackend.BookSystem.model.RegisterDetails;
import com.reactBackend.BookSystem.repo.RegisterDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService{

    @Autowired
    private RegisterDetailsRepo registerDetailsRepo;

    @Override
    public RegisterDetails saveRegisterDetails(RegisterDetails registerDetails) {
       return registerDetailsRepo.save(registerDetails);
    }

    @Override
    public RegisterDetails getDetailsByEmail(String email) {
        return registerDetailsRepo.findByEmail(email);
    }

    @Override
    public List<RegisterDetails> getAllRegister() {
        return registerDetailsRepo.findAll();
    }


}
