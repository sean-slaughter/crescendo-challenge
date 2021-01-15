package com.crescendocollective.challenge;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ChallengeApplicationTests {

    @Autowired
    private YelpController yelpController;

    @Autowired
    private YelpService yelpService;

    @Test
    void contextLoads() {
        assertThat(yelpController).isNotNull();
        assertThat(yelpService).isNotNull();
    }

    //tests for Yelp Service class
    @Test
    void testYelpServiceGetHttpEntity(){
        ResponseEntity<Business> testResponse = yelpService.getReviewsResponse();
        assertEquals(HttpStatus.OK, testResponse.getStatusCode());
    }

}
