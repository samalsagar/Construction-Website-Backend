package com.reactBackend.BookSystem.controller;

import com.reactBackend.BookSystem.ApiResponse.ApiResponse;
import com.reactBackend.BookSystem.model.RatingDetails;
import com.reactBackend.BookSystem.model.RegisterDetails;
import com.reactBackend.BookSystem.service.RatingServiceImpl;
import com.reactBackend.BookSystem.service.RegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ratings")
@CrossOrigin
public class RatingDetailsController {

    @Autowired
    private RatingServiceImpl ratingService;

    @Autowired
    private RegisterServiceImpl registerService;


    @PostMapping("/add")
    public ApiResponse saveRating(@RequestBody RatingDetails ratingDetails){

       try {
           if(registerService.getDetailsByEmail(ratingDetails.getEmailId())!=null) {
               if(ratingService.findRatingDetails(ratingDetails.getEmailId()) == null){
                   RatingDetails details = ratingService.saveRating(ratingDetails);
                   if(details.getRatingId() > 0) {
                       return new ApiResponse("Thank you for your valuable feed back!!!", true);
                   } else {
                       return new ApiResponse("Error occured while saving", false);
                   }
               } else {
                   return new ApiResponse("You already commented", false);
               }

           } else {
               return new ApiResponse("Please register for rating us", false);
           }
       } catch (Exception e) {
           return new ApiResponse("Sorry we are facing some issue", false);
       }
    }

    @GetMapping("/allRatings")
    public List<RatingDetails> getAllRating() {
        List<RatingDetails> ratingDetails = ratingService.getAllRatings();

        List<RatingDetails> test = new ArrayList<>();

        for (int i = 0; i < ratingDetails.size(); i++) {
            RegisterDetails register = registerService.getDetailsByEmail(ratingDetails.get(i).getEmailId());
            ratingDetails.get(i).setEmailId(register.getName());
        }

       return ratingDetails;
    }
}
