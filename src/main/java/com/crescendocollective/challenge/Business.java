package com.crescendocollective.challenge;

import java.util.List;

/**
 * Business model class, contains list of reviews
 */
public class Business {
    private List<Review> reviews;

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
