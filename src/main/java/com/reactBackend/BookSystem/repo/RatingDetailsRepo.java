package com.reactBackend.BookSystem.repo;

import com.reactBackend.BookSystem.model.RatingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingDetailsRepo extends JpaRepository<RatingDetails, Integer> {

    RatingDetails findByEmailId(String emailId);
}
