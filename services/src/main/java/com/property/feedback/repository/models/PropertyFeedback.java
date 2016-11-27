package com.property.feedback.repository.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by nehaojha on 11/11/16.
 */
public class PropertyFeedback {

    private Integer id;

    private String address;

    private double latitude;

    private double longitude;

    private String feedback;

    @NotEmpty
    @Size(min = 10, max = 10)
    @Pattern(regexp = "[0-9]*")
    private String phoneNumber;

    private int rating;

    public PropertyFeedback() {
    }

    public PropertyFeedback(String address, double latitude, double longitude, String feedback, String phoneNumber, int rating) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.feedback = feedback;
        this.phoneNumber = phoneNumber;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
