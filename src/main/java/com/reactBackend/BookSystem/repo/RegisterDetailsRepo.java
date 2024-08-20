package com.reactBackend.BookSystem.repo;

import com.reactBackend.BookSystem.model.RegisterDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterDetailsRepo extends JpaRepository<RegisterDetails, Integer> {

    RegisterDetails findByEmail(String email);
}
