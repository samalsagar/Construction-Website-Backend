package com.reactBackend.BookSystem.service;

import com.reactBackend.BookSystem.model.RatingDetails;
import com.reactBackend.BookSystem.repo.RatingDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingDetailsRepo ratingDetailsRepo;
    @Override
    public RatingDetails saveRating(RatingDetails ratingDetails) {
        return ratingDetailsRepo.save(ratingDetails);
    }

    @Override
    public RatingDetails findRatingDetails(String email) {
        return ratingDetailsRepo.findByEmailId(email);
    }

    @Override
    public List<RatingDetails> getAllRatings() {
        return ratingDetailsRepo.findAll();
    }
}
