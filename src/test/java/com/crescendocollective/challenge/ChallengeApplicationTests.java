package com.crescendocollective.challenge;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ChallengeApplicationTests {

    @Autowired
    private YelpService yelpService;
    @Autowired
    private YelpController yelpController;

    @Test
    void contextLoads() {
        assertThat(yelpService).isNotNull();
    }

    //tests for YelpService class
    @Test
    void testYelpServiceGetHttpEntity(){
        ResponseEntity<Business> testResponse = yelpService.getReviewsResponse();
        assertEquals(HttpStatus.OK, testResponse.getStatusCode());
    }
    @Test
    void testBusinessModel(){
        Business testBiz = yelpService.getBusiness(yelpService.getReviewsResponse());
        assertThat(testBiz).isNotNull();
        assertThat(testBiz.getReviews()).isNotNull();
        assertThat(testBiz.getReviews().get(0)).isNotNull();
    }

    //test for YelpController
    @Test
    void testController(){
        Business testBiz = yelpController.getReviews();
        assertThat(testBiz).isNotNull();
        assertThat(testBiz.getReviews()).isNotNull();
        assertThat(testBiz.getReviews().get(0)).isNotNull();
    }

    //test for Google Vision API
    @Test
    void testFaces(){
        Business testBiz = yelpController.getReviews();
        testBiz.getReviews().forEach(review -> {
            assertThat(review.getUser().getFace()).isNotNull();
        });
    }

}
