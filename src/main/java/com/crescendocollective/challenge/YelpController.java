package com.crescendocollective.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YelpController {

    @Autowired
    private YelpService yelpService;

    @GetMapping("/")
    public Business getReviews(){
        ResponseEntity<Business> b = yelpService.getReviewsResponse();
        if(b.getStatusCode() == HttpStatus.OK){
           return b.getBody();
        }
        else{
            System.out.println("Something went wrong with your request");
            return null;
        }
    }


}
