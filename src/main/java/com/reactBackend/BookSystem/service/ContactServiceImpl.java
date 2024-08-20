package com.reactBackend.BookSystem.service;

import com.reactBackend.BookSystem.model.ContactDetails;
import com.reactBackend.BookSystem.repo.ContactDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDetailsRepo contactDetailsRepo;

    @Override
    public ContactDetails saveDetails(ContactDetails contactDetails) {
       return contactDetailsRepo.save(contactDetails);
    }

    @Override
    public List<ContactDetails> getAllDetails() {
        return contactDetailsRepo.findAll();
    }
}
