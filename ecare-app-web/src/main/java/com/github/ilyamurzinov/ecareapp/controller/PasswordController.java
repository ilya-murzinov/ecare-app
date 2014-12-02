package com.github.ilyamurzinov.ecareapp.controller;

import com.github.ilyamurzinov.ecareapp.beans.PasswordBean;
import com.github.ilyamurzinov.ecareapp.service.UserService;
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

    @Autowired
    private SecurityHelper securityHelper;

    @ModelAttribute
    public PasswordBean getPasswordBean() {
        return new PasswordBean();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView changePasswordForm() {
        return new ModelAndView("change-password");
    }

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    String changePassword(
            @Valid @RequestBody PasswordBean passwordBean,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return BindingResultHelper.getMessage(result);
        }
        int userId = (securityHelper.getCurrentUser()).getId();
        userService.changePassword(userId, passwordBean.getCurrentPassword(), passwordBean.getNewPassword());
        return "{}";
    }

    @ExceptionHandler(value = IllegalStateException.class)
    private
    @ResponseBody
    String handle(IllegalStateException ex) {
        return ex.getMessage();
    }
}
