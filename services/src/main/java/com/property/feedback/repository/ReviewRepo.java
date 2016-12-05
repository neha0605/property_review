package com.property.feedback.repository;

import com.property.feedback.repository.models.Review;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by nehaojha on 02/11/16.
 */
public interface ReviewRepo extends JpaRepository<Review, Integer> {

    List<Review> findByPhoneNumber(String phoneNumber);
}
