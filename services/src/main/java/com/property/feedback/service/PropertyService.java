package com.property.feedback.service;

import com.property.feedback.repository.models.Property;
import com.property.feedback.repository.models.Review;

import java.util.List;

/**
 * Created by nehaojha on 11/11/16.
 */
public interface PropertyService {

    List<Property> findReviewsNearLocation(Double latitude, Double longitude);

    Property findByLatitudeAndLongitude(double latitude, double longitude);

    List<Review> findPublishedReviewsForProperty(Integer propertyId);

    List<Property> findAllProperties();
}
