package com.github.ilyamurzinov.ecareapp.web.controller;

import com.github.ilyamurzinov.ecareapp.common.domain.Client;
import com.github.ilyamurzinov.ecareapp.common.domain.User;
import com.github.ilyamurzinov.ecareapp.web.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ilya-murzinov
 */
@Controller
@RequestMapping("clientoffice")
public class ClientOfficeController {
    @Autowired
    private ClientService clientService;

    @ModelAttribute
    public Client getClientBean() {
        return clientService.getCurrentClient();
    }

    @ModelAttribute
    public User getUserBean() {
        return SecurityHelper.getCurrentUser();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("clientoffice/index");
    }
}
