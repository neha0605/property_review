package com.property.feedback.repository;

import com.property.feedback.repository.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nehaojha on 02/11/16.
 */
@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {

    List<Review> findByPropertyPropertyId(Integer propertyId);

    List<Review> findByPhoneNumber(String phoneNumber);
}
