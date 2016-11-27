package com.property.feedback.repository.models.view;

import com.property.feedback.repository.models.Property;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nehaojha on 14/11/16.
 */
public class PropertyViewModel {

    private String address;

    private List<ReviewViewModel> reviews;

    public PropertyViewModel() {
    }

    public PropertyViewModel(Property property) {
        this.address = property.getAddress();
        this.reviews = property.getReviews().stream().map(ReviewViewModel::new).collect(Collectors.toList());
    }

    public PropertyViewModel(List<ReviewViewModel> reviews) {
        this.reviews = reviews;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ReviewViewModel> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewViewModel> reviews) {
        this.reviews = reviews;
    }
}
