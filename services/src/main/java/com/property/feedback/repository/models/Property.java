package com.property.feedback.repository.models;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nehaojha on 07/11/16.
 */
@Entity
@Table(name = "properties")
@Cacheable(true)
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "property")
public class Property extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer propertyId;

    private String address;

    private double latitude;

    private double longitude;

    private Double distance;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "property")
    private List<Review> reviews = new ArrayList<>();

    public Property() {
    }

    public Property(String address, double latitude, double longitude) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Property property = (Property) o;

        if (Double.compare(property.latitude, latitude) != 0) return false;
        if (Double.compare(property.longitude, longitude) != 0) return false;
        return address != null ? address.equals(property.address) : property.address == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(latitude);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Property{" +
                "propertyId=" + propertyId +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", distance=" + distance +
                ", reviews=" + reviews +
                '}';
    }
}
