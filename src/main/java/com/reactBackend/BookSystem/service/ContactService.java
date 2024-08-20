package com.reactBackend.BookSystem.service;

import com.reactBackend.BookSystem.model.ContactDetails;

import java.util.List;

public interface ContactService {
    public ContactDetails saveDetails(ContactDetails contactDetails);

    public List<ContactDetails> getAllDetails();
}
