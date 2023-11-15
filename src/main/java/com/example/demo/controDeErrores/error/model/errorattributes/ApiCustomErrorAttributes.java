package com.example.demo.controDeErrores.error.model.errorattributes;

import com.example.demo.controDeErrores.error.ApiError;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Order
@Component
@RequiredArgsConstructor
public class ApiCustomErrorAttributes extends DefaultErrorAttributes {

    private final ObjectMapper objectMapper;

    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options){
        Map<String, Object> defaultErrorAttributes = super.getErrorAttributes(webRequest, options);
        ApiError apiError = ApiError.formErrorAttributes(defaultErrorAttributes);
        return objectMapper.convertValue(apiError, Map.class);
    }
}
