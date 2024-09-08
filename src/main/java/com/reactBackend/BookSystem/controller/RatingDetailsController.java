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
//        List<RatingDetails> ratingDetails = ratingService.getAllRatings();
////        System.out.println(ratingDetails);
//        List<RatingDetails> test = new ArrayList<>();
////
//        for (RatingDetails ratingDetail : ratingDetails) {
//            RegisterDetails register = registerService.getDetailsByEmail(ratingDetail.getEmailId());
//            System.out.println(register);
//            ratingDetail.setEmailId(register.getName());
//            test.add(ratingDetail);
//            System.out.println("HEY");
//        }

        // Fetch all rating details from the service
        List<RatingDetails> ratingDetails = ratingService.getAllRatings();

        // Create a new list to hold the updated rating details
        List<RatingDetails> updatedRatingDetails = new ArrayList<>();

        // Iterate over each rating detail
        for (RatingDetails ratingDetail : ratingDetails) {
            // Fetch RegisterDetails using the email ID from the rating detail
            RegisterDetails register = registerService.getDetailsByEmail(ratingDetail.getEmailId());

            // Print the register object for debugging purposes
            System.out.println("Register Details: " + register);

            // Check if the register object is not null
            if (register != null) {
                // Update the email ID with the register's name
                ratingDetail.setEmailId(register.getName());
            } else {
                // Handle the case where register is null
                System.out.println("No RegisterDetails found for email: " + ratingDetail.getEmailId());
                // Optionally, set a default value or leave it as is
                ratingDetail.setEmailId("Unknown"); // Or handle as needed
            }

            // Add the updated rating detail to the new list
            updatedRatingDetails.add(ratingDetail);

            // Print a debug message
            System.out.println("Processed rating detail for email: " + ratingDetail.getEmailId());
        }

        // Return the list of updated rating details
        return updatedRatingDetails;

//       return test;
    }
}
