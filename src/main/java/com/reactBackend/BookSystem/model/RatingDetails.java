package com.reactBackend.BookSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class RatingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ratingId;
    private String emailId;
    private String message;
}
