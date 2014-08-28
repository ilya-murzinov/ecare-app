package com.github.ilyamurzinov.ecareapp.web.controller;

import com.github.ilyamurzinov.ecareapp.common.domain.User;
import com.github.ilyamurzinov.ecareapp.web.beans.ClientBean;
import com.github.ilyamurzinov.ecareapp.web.beans.PasswordBean;
import com.github.ilyamurzinov.ecareapp.web.service.ClientService;
import com.github.ilyamurzinov.ecareapp.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @author ilya-murzinov
 */
@Controller
@RequestMapping(URL.CLIENTOFFICE)
public class ClientOfficeController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private UserService userService;

    @ModelAttribute("passwordBean")
    public PasswordBean getPasswordBean() {
        return new PasswordBean();
    }

    @RequestMapping(value = "/change-password", method = RequestMethod.GET)
    public ModelAndView changePasswordForm() {
        return new ModelAndView("clientoffice/change-password");
    }

    @RequestMapping(value = "/change-password", method = RequestMethod.POST)
    public ModelAndView changePassword(
            @Valid @ModelAttribute("passwordBean") PasswordBean passwordBean,
            BindingResult result
    ) {
        if (!result.hasErrors()) {
            int userId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
            userService.changePassword(userId, passwordBean.getCurrentPassword(), passwordBean.getNewPassword());
            return new ModelAndView(URL.CLIENTOFFICE + "/index");
        }
        return new ModelAndView("clientoffice/change-password");
    }

    @ModelAttribute("clientBean")
    public ClientBean getClientBean() {
        return new ClientBean(clientService.getCurrentClient(), getUser());
    }

    public User getUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView(URL.CLIENTOFFICE + "/index");
    }
}
