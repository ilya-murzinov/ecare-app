package com.github.ilyamurzinov.ecareapp.controller;

import com.github.ilyamurzinov.ecareapp.domain.Client;
import com.github.ilyamurzinov.ecareapp.beans.UserBean;
import com.github.ilyamurzinov.ecareapp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.NoResultException;
import javax.validation.Valid;

/**
 * @author ilya-murzinov
 */
@Controller
@RequestMapping("client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private SecurityHelper securityHelper;

    @ModelAttribute("currentUser")
    public UserBean getCurrentUser() {
        return securityHelper.getCurrentUser();
    }

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN') || #id == this.currentUser.client.id")
    public ModelAndView getClientView(@RequestParam int id) {
        Client client = clientService.getClient(id);
        ModelAndView modelAndView = new ModelAndView("client");
        modelAndView.addObject("client", client);
        return modelAndView;
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView getAllClients() {
        ModelAndView modelAndView = new ModelAndView("list-clients");
        modelAndView.addObject("clientsList", clientService.getAllClients());
        return modelAndView;
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN') || #id == this.currentUser.client.id")
    public ModelAndView getEditClientForm(
            @RequestParam int id
    ) {
        ModelAndView modelAndView = new ModelAndView("edit-client");
        modelAndView.addObject("client", clientService.getClient(id));
        return modelAndView;
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN') || #client.id == this.currentUser.client.id")
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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView getAddClientForm() {
        ModelAndView modelAndView = new ModelAndView("add-client");
        modelAndView.addObject("client", new Client());
        return modelAndView;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
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

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public
    @ResponseBody
    String delete(
            @RequestParam("id") int id
    ) {
        clientService.removeClient(id);
        return "{}";
    }

    @ExceptionHandler(NoResultException.class)
    public ModelAndView handle(NoResultException ex) {
        return new ModelAndView("error");
    }
}
