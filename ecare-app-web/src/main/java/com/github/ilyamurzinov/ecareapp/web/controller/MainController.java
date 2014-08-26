package com.github.ilyamurzinov.ecareapp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ilya-murzinov
 */
@Controller
public class MainController {
    @RequestMapping(value = "/")
    public String init() {
        return "index";
    }

    @RequestMapping(value = "/protected**", method = RequestMethod.GET)
    public ModelAndView protectedPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security 3.2.4 Hello World Tutorial");
        model.setViewName("protected");
        return model;

    }
}
