package com.property.feedback.controller;

import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nehaojha on 19/11/16.
 */
public class FieldError {

    private String field;
    private String errorCode;

    public FieldError(String field, String errorCode) {
        this.field = field;
        this.errorCode = errorCode;
    }

    public static List<FieldError> parse(BindingResult bindingResult) {
        return bindingResult.getFieldErrors()
                .stream().map(e -> new FieldError(e.getField(), e.getObjectName() + ". " + e.getCode()))
                .collect(Collectors.toList());
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
