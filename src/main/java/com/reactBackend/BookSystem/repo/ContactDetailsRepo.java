package com.reactBackend.BookSystem.repo;

import com.reactBackend.BookSystem.model.ContactDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactDetailsRepo extends JpaRepository<ContactDetails ,Integer> {
}
