package com.github.ilyamurzinov.ecareapp.web.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

/**
 * @author ilya-murzinov
 */
public class BindingResultHelper {
    private BindingResultHelper() {
    }

    public static String getMessage(BindingResult result) {
        StringBuilder stringBuilder = new StringBuilder();
        for (ObjectError objectError : result.getAllErrors()) {
            stringBuilder.append("Error: \"");
            stringBuilder.append(objectError.getDefaultMessage());
            stringBuilder.append("\"\n");
        }
        return stringBuilder.toString();
    }
}
