package com.github.ilyamurzinov.ecareapp.web.controller;

import com.github.ilyamurzinov.ecareapp.common.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ilya-murzinov
 */
@Controller
public class MainController {
    @ModelAttribute
    public User getUser() {
        return SecurityHelper.getCurrentUser();
    }

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @ExceptionHandler
    public ModelAndView handle(IllegalStateException ex) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("user", SecurityHelper.getNullUser());
        return modelAndView;
    }
}
