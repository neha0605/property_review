package com.property.feedback.repository.models.view;

import com.property.feedback.repository.models.Review;

/**
 * Created by nehaojha on 02/11/16.
 */
public class ReviewViewModel {

    private String userReview;
    private Integer rating;

    public ReviewViewModel(Review review) {
        this.userReview = review.getFeedback();
        this.rating = review.getRating();
    }

    public String getUserReview() {
        return userReview;
    }

    public void setUserReview(String userReview) {
        this.userReview = userReview;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
