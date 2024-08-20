package com.reactBackend.BookSystem.service;

import com.reactBackend.BookSystem.model.RegisterDetails;

import java.util.List;

public interface RegisterService {

    public RegisterDetails saveRegisterDetails(RegisterDetails registerDetails);

    public RegisterDetails getDetailsByEmail(String email);

    public List<RegisterDetails> getAllRegister();
}
