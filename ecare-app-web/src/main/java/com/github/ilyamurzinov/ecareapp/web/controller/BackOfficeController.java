package com.github.ilyamurzinov.ecareapp.web.controller;

import com.github.ilyamurzinov.ecareapp.common.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ilya-murzinov
 */
@Controller
@RequestMapping("backoffice")
public class BackOfficeController {
    @ModelAttribute("userBean")
    public User getUserBean() {
        return SecurityHelper.getCurrentUser();
    }

    @RequestMapping
    public ModelAndView index() {
        return new ModelAndView("backoffice/index");
    }
}
