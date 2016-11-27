package com.property.feedback.service;

import com.property.feedback.repository.models.PropertyFeedback;
import com.property.feedback.repository.models.Review;

import java.util.List;

/**
 * Created by nehaojha on 02/11/16.
 */
public interface ReviewService {

    void addReview(PropertyFeedback feedback);

    List<Review> findReviewByPhoneNumber(String number);

}
