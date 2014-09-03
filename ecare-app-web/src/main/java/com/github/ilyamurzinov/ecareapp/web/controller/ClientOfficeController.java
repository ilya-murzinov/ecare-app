package com.github.ilyamurzinov.ecareapp.web.controller;

import com.github.ilyamurzinov.ecareapp.web.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ilya-murzinov
 */
@Controller
@RequestMapping("clientoffice")
public class ClientOfficeController {
    @Autowired
    private ClientService clientService;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        int id = clientService.getCurrentClient().getId();
        return "redirect:/client?id=" + id;
    }
}
