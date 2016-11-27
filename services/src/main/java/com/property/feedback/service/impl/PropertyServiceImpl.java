package com.property.feedback.service.impl;

import com.property.feedback.repository.PropertyRepo;
import com.property.feedback.repository.models.Property;
import com.property.feedback.repository.models.Review;
import com.property.feedback.service.PropertyService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by nehaojha on 11/11/16.
 */
@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepo propertyRepo;

    public final static Logger LOGGER = Logger.getLogger(PropertyServiceImpl.class.getName());

    @Override
    public List<Property> findReviewsNearLocation(Double latitude, Double longitude) {
        return propertyRepo.findNearByProperties(latitude, longitude);
    }

    @Override
    public Property findByLatitudeAndLongitude(double latitude, double longitude) {
        return propertyRepo.findByLatitudeAndLongitude(latitude, longitude);
    }

    @Override
    public List<Review> findPublishedReviewsForProperty(Integer propertyId) {
        Optional<Property> propertyOptional = propertyRepo.findByPropertyIdAndReviewsPublishedTrue(propertyId);
        return propertyOptional.map(property -> property.getReviews()).orElse(null);
    }

    @Override
    public List<Property> findAllProperties() {
        List<Property> properties = propertyRepo.findAll();
        if (properties == null) {
            LOGGER.log(Level.INFO, "property is null");
        }
        return properties;
    }
}
