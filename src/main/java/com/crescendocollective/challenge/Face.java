package com.crescendocollective.challenge;

import com.google.cloud.vision.v1.FaceAnnotation;

/**
 * Face model class, returns likelihood of User
 * emotions from Yelp Review User Image
 */
public class Face {
    private final FaceAnnotation faceAnnotation;
    private String joyLikelihood;
    private String sorrowLikelihood;
    private String angerLikelihood;
    private String surpriseLikelihood;

    //constructor takes in FaceAnnotation from API call
    public Face(FaceAnnotation faceAnnotation){
        this.faceAnnotation = faceAnnotation;
    }

    //getters and setters
    public String getJoyLikelihood() {
        return faceAnnotation.getJoyLikelihood().toString();
    }

    public String getSorrowLikelihood() {
        return faceAnnotation.getSorrowLikelihood().toString();
    }

    public String getAngerLikelihood() {
        return faceAnnotation.getAngerLikelihood().toString();
    }

    public String getSurpriseLikelihood() {
        return faceAnnotation.getSurpriseLikelihood().toString();
    }
}
