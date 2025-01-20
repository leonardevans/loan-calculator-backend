package com.loancalculator.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class HttpUtil {
    protected Map<String, String> getErrors(BindingResult bindingResult){
        Map<String, String> errors = new HashMap<>();

        bindingResult.getAllErrors().forEach((error) ->{
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });

        return errors;
    }
}
