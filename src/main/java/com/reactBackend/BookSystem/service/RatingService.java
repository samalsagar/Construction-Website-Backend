package com.reactBackend.BookSystem.service;

import com.reactBackend.BookSystem.model.RatingDetails;

import java.util.List;

public interface RatingService {
    public RatingDetails saveRating(RatingDetails ratingDetails);

    public RatingDetails findRatingDetails(String email);

    public List<RatingDetails> getAllRatings();
}
