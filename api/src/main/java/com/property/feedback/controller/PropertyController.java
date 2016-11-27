package com.property.feedback.controller;

import com.property.feedback.repository.models.Property;
import com.property.feedback.repository.models.Review;
import com.property.feedback.repository.models.view.PropertyViewModel;
import com.property.feedback.repository.models.view.ReviewViewModel;
import com.property.feedback.service.PropertyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nehaojha on 11/11/16.
 */
@RestController
@RequestMapping(value = "/properties")
@Api(description = "property management api")
public class PropertyController extends BaseController {

    @Autowired
    private PropertyService propertyService;

    @RequestMapping(value = "/nearby", method = RequestMethod.GET, headers = ACCEPT_JSON)
    public PropertyViewModel getPropertyByLatitudeAndLongitude(@RequestParam double latitude,
                                                               @RequestParam double longitude) {
        Property property = propertyService.findByLatitudeAndLongitude(latitude, longitude);
        PropertyViewModel viewModel = new PropertyViewModel(property);
        return viewModel;
    }

    @ApiOperation(value = "view the published reviews of a property by its id ")
    @RequestMapping(value = "{id}/publishedReviews", method = RequestMethod.GET, headers = ACCEPT_JSON)
    public ResponseEntity<List<ReviewViewModel>> getPublishedReviewsByPropertyId(@ApiParam(name = "propertyId", value = "id of the property to be viewed", required = true) @PathVariable(value = "id") Integer propertyId) {
        List<Review> publishedReviews = propertyService.findPublishedReviewsForProperty(propertyId);
        if (publishedReviews == null) {
            return new ResponseEntity("error", HttpStatus.NOT_FOUND);
        }
        List<ReviewViewModel> viewModels = publishedReviews.stream().map(ReviewViewModel::new).collect(Collectors.toList());
        return new ResponseEntity(viewModels, HttpStatus.OK);
    }

    @RequestMapping(value = "/property/all", method = RequestMethod.GET, headers = ACCEPT_JSON)
    public ResponseEntity<List<PropertyViewModel>> getAllProperties() {

        List<PropertyViewModel> propertyViewModels = propertyService.findAllProperties().stream().map(PropertyViewModel::new).collect(Collectors.toList());
        return new ResponseEntity<>(propertyViewModels, HttpStatus.OK);
    }
}
