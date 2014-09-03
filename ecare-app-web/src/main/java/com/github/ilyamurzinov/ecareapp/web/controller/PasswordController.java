package com.github.ilyamurzinov.ecareapp.web.controller;

import com.github.ilyamurzinov.ecareapp.web.beans.PasswordBean;
import com.github.ilyamurzinov.ecareapp.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @author ilya-murzinov
 */
@Controller
@RequestMapping("change-password")
public class PasswordController {
    @Autowired
    private UserService userService;

    private PasswordBean passwordBean;

    @ModelAttribute
    public PasswordBean getPasswordBean() {
        return passwordBean == null ? new PasswordBean() : passwordBean;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView changePasswordForm() {
        return new ModelAndView("change-password");
    }

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    String changePassword(
            @Valid @ModelAttribute("passwordBean") PasswordBean passwordBean,
            BindingResult result
    ) {
        this.passwordBean = passwordBean;
        if (!result.hasErrors()) {
            int userId = (SecurityHelper.getCurrentUser()).getId();
            userService.changePassword(userId, passwordBean.getCurrentPassword(), passwordBean.getNewPassword());
            return "OK";
        }
        return null;
    }

    @ExceptionHandler(value = IllegalStateException.class)
    private
    @ResponseBody
    String handle(IllegalStateException ex) {
        return ex.getMessage();
    }
}
