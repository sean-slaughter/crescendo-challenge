package com.crescendocollective.challenge;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Service class to make calls to the Yelp Fusion API,
 * Will return reviews for Tenuta's Italian Restaurant in Milwaukee
 */
@Service
@PropertySource("classpath:yelp.properties")
public class YelpService {
    @Value("${YELP_API_KEY}")
    private String key;
    private final RestTemplate restTemplate = new RestTemplate();

    //create HttpEntity containing Yelp API authorization
    private HttpEntity<String> getHttpEntity(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + key);
        return new HttpEntity<String>(headers);
    }
    //send GET request to Yelp Fusion API and return response
    public ResponseEntity<Business> getReviewsResponse(){
        String REVIEWS_QUERY = "https://api.yelp.com/v3/businesses/k0jk7sVdHDPqr-jnVJWlmA/reviews";
        return restTemplate.exchange(
                REVIEWS_QUERY, HttpMethod.GET, getHttpEntity(), Business.class);
    }
    public Business getBusiness(ResponseEntity<Business> response){
        return response.getBody();
    }
}
