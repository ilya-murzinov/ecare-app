package com.github.ilyamurzinov.ecareapp.controller;

import com.github.ilyamurzinov.ecareapp.domain.User;
import com.github.ilyamurzinov.ecareapp.beans.NewUserBean;
import com.github.ilyamurzinov.ecareapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @author ilya-murzinov
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView getUserForm(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("add-user");
        modelAndView.addObject("user", new NewUserBean());
        return modelAndView;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    String addUser(
            @RequestParam int id,
            @Valid @RequestBody NewUserBean user,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return BindingResultHelper.getMessage(result);
        }
        userService.addClient(user.getEmail(), user.getPassword(), id);
        return "{}";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public
    @ResponseBody
    String updateUser(
            @RequestBody User user
    ) {
        userService.updateUser(user);
        return "{}";
    }
}
