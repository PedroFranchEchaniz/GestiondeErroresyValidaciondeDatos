package com.example.demo.controDeErrores.error;

import com.example.demo.controDeErrores.error.impl.ApiErrorImpl;
import com.example.demo.controDeErrores.error.impl.ApiValidationSubError;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface ApiError {

    HttpStatus getStatus();

    int getStatusCode();

    String getMessage();

    LocalDateTime getDate();

    List <ApiSubError>getSubErrors();

    static ApiError formErrorAttributes(Map<String, Object> defaultErroAttributesMap){
        int statusCode = ((Integer)defaultErroAttributesMap.get("status")).intValue();
        ApiErrorImpl result =
                ApiErrorImpl.builder()
                        .status(HttpStatus.valueOf(statusCode))
                        .statusCode(statusCode)
                        .message((String) defaultErroAttributesMap.getOrDefault("message", "no message"))
                        .path((String) defaultErroAttributesMap.getOrDefault("path", "no path"))
                        .build();
        if(defaultErroAttributesMap.containsKey("errors")){
            List<ObjectError> errors = (List<ObjectError>) defaultErroAttributesMap.get("errors");

            List<ApiSubError> subErrors = errors.stream()
                    .map(ApiValidationSubError::fromObjectError)
                    .collect(Collectors.toList());
            result.setSubErrors(subErrors);
        }

        return result;

    }
}
