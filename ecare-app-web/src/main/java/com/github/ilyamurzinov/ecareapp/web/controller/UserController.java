package com.github.ilyamurzinov.ecareapp.web.controller;

import com.github.ilyamurzinov.ecareapp.common.domain.User;
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
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView getUserForm(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("add-user");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public
    @ResponseBody
    String addUser(
            @RequestParam int id,
            @Valid @RequestBody User user,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return BindingResultHelper.getMessage(result);
        }
        userService.addClient(user.getEmail(), user.getPassword(), id);
        return "{}";
    }
}
