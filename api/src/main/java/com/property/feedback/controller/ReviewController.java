package com.property.feedback.controller;

import com.property.feedback.repository.models.PropertyFeedback;
import com.property.feedback.repository.models.view.ReviewViewModel;
import com.property.feedback.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nehaojha on 02/11/16.
 */
@RestController
@RequestMapping(value = "/reviews")
public class ReviewController extends BaseController {

    @Autowired
    private ReviewService reviewService;

    @RequestMapping(method = RequestMethod.POST, headers = ACCEPT_JSON)
    public ResponseEntity<String> addNewReview(@RequestBody @Valid PropertyFeedback feedback, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(FieldError.parse(bindingResult), HttpStatus.BAD_REQUEST);
        }
        reviewService.addReview(feedback);
        return new ResponseEntity("review added successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{phoneNumber}", method = RequestMethod.GET, headers = ACCEPT_JSON)
    public ResponseEntity<List<ReviewViewModel>> getReviewByPhonenumber(@PathVariable String phoneNumber) {
        List<ReviewViewModel> reviewViewModels = reviewService.findReviewByPhoneNumber(phoneNumber).stream().map(ReviewViewModel::new).collect(Collectors.toList());
        return new ResponseEntity<>(reviewViewModels, HttpStatus.OK);
    }
}

