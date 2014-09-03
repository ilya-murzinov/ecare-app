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
@RequestMapping("/")
public class MainController {
    @ModelAttribute("currentUser")
    public User getCurrentUser() {
        return SecurityHelper.getCurrentUser();
    }

    @RequestMapping
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @ExceptionHandler
    public ModelAndView handle(IllegalStateException ex) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("currentUser", SecurityHelper.getNullUser());
        return modelAndView;
    }
}
