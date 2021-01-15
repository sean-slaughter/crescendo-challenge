package com.crescendocollective.challenge;

import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.FaceAnnotation;
import com.google.cloud.vision.v1.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.vision.CloudVisionTemplate;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YelpController {

    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    private CloudVisionTemplate cloudVisionTemplate;
    @Autowired
    private YelpService yelpService;

    @GetMapping("/")
    public Business getReviews(){
        //make yelp API call
        ResponseEntity<Business> b = yelpService.getReviewsResponse();
        //check response
        if(b.getStatusCode() == HttpStatus.OK){
           Business biz = b.getBody();
           if(biz != null){
               //iterate through reviews and run image url through Google Vision API
               biz.getReviews().forEach(review -> {
                   User user = review.getUser();
                   AnnotateImageResponse resp = this.cloudVisionTemplate.analyzeImage(this.resourceLoader.getResource(user.getImage_url()), Feature.Type.FACE_DETECTION);
                   FaceAnnotation faceAnnotation = resp.getFaceAnnotations(0);
                   user.setFace(new Face(faceAnnotation));
               });
           }
            return biz;
        }
        else{
            System.out.println("Something went wrong with your request");
            return null;
        }
    }


}
