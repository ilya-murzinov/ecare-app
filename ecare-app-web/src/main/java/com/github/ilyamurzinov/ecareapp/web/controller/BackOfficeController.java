package com.github.ilyamurzinov.ecareapp.web.controller;

import com.github.ilyamurzinov.ecareapp.common.domain.Client;
import com.github.ilyamurzinov.ecareapp.common.domain.User;
import com.github.ilyamurzinov.ecareapp.web.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author ilya-murzinov
 */
@Controller
@RequestMapping("backoffice")
public class BackOfficeController {
    @Autowired
    private ClientService clientService;

    @ModelAttribute("currentUser")
    public User getCurrentUser() {
        return SecurityHelper.getCurrentUser();
    }

    @ModelAttribute
    public List<Client> getClients() {
        return clientService.getAllClients();
    }

    @RequestMapping
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("backoffice/index");
        return modelAndView;
    }
}
