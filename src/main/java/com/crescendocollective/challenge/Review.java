package com.crescendocollective.challenge;

/**
 * Review Model Class that contains properties
 * retrieved from Yelp Fusion API for a business's reviews
 */
public class Review {

    private String id;
    private String url;
    private Integer rating;
    private User user;

    //getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
