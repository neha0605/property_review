package com.property.feedback.repository;

import com.property.feedback.repository.models.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by nehaojha on 07/11/16.
 */
@Repository
public interface PropertyRepo extends JpaRepository<Property, Integer> {

    @Query(value = "SELECT *," +
            "    ( 6371 * acos( cos( radians(?1) ) * cos( radians( latitude ) ) * cos( radians( longitude ) - " +
            "    radians(?2) ) + sin( radians(?1) ) * sin( radians( latitude ) ) ) ) AS distance" +
            "     FROM properties" +
            "     HAVING distance < 20" +
            "     ORDER BY distance" +
            "     LIMIT 0 , 30", nativeQuery = true)
    List<Property> findNearByProperties(double latitude, double longitude);

    Property findByLatitudeAndLongitude(double latitude, double longitude);

    Optional<Property> findByPropertyIdAndReviewsPublishedTrue(Integer propertyId);
}
