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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @author ilya-murzinov
 */
@Controller
@RequestMapping("client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @ModelAttribute("currentUser")
    public User getCurrentUser() {
        return SecurityHelper.getCurrentUser();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getClientView(@RequestParam int id) {
        Client client = clientService.getClient(id);
        ModelAndView modelAndView = new ModelAndView("client");
        modelAndView.addObject("client", client);
        return modelAndView;
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public ModelAndView getAllClients() {
        return new ModelAndView("edit-client");
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public ModelAndView getEditClientForm(
            @RequestParam int id
    ) {
        ModelAndView modelAndView = new ModelAndView("edit-client");
        modelAndView.addObject("client", clientService.getClient(id));
        return modelAndView;
    }

    @RequestMapping(value = "edit",method = RequestMethod.POST)
    public String edit(
            @Valid @ModelAttribute("client") Client client,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "edit-client";
        }
        clientService.updateClient(client);
        return "redirect:?id=" + client.getId();
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView getAddClientForm() {
        ModelAndView modelAndView = new ModelAndView("add-client");
        modelAndView.addObject("client", new Client());
        return modelAndView;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(
            @Valid @ModelAttribute("client") Client client,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "add-client";
        }
        clientService.addClient(client);
        return "redirect:?id=" + client.getId();
    }
}
