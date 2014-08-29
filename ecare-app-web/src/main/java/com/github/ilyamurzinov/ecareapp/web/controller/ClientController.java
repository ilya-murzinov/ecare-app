package com.github.ilyamurzinov.ecareapp.web.controller;

import com.github.ilyamurzinov.ecareapp.common.domain.Client;
import com.github.ilyamurzinov.ecareapp.common.domain.User;
import com.github.ilyamurzinov.ecareapp.web.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("clientoffice/edit")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @ModelAttribute("clientBean")
    public Client getClientBean() {
        return clientService.getCurrentClient();
    }

    @ModelAttribute("userBean")
    public User getUserBean() {
        return SecurityHelper.getCurrentUser();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("clientoffice/edit-data");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView edit(
            @Valid @ModelAttribute("clientBean") Client client,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return new ModelAndView("clientoffice/edit-data");
        }
        clientService.updateClient(client);
        return new ModelAndView("clientoffice/index");
    }
}
