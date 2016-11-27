package com.property.feedback.service.impl;

import com.property.feedback.repository.ReviewRepo;
import com.property.feedback.repository.models.Property;
import com.property.feedback.repository.models.PropertyFeedback;
import com.property.feedback.repository.models.Review;
import com.property.feedback.service.PropertyService;
import com.property.feedback.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nehaojha on 02/11/16.
 */
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private PropertyService propertyService;


    @Transactional
    @Override
    public void addReview(PropertyFeedback feedback) {
        Property property = propertyService.findByLatitudeAndLongitude(feedback.getLatitude(), feedback.getLongitude());

        if (property == null) {
            property = new Property();
            property.setAddress(feedback.getAddress());
            property.setLatitude(feedback.getLatitude());
            property.setLongitude(feedback.getLongitude());
        }

        Review review = new Review(feedback.getFeedback(), feedback.getPhoneNumber(), feedback.getRating());
        review.setProperty(property);
        reviewRepo.save(review);
    }

    @Override
    public List<Review> findReviewByPhoneNumber(String number) {
        return reviewRepo.findByPhoneNumber(number);
    }
}
