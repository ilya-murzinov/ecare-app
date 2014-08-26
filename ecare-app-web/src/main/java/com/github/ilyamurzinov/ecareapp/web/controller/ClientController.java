package com.github.ilyamurzinov.ecareapp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ilya-murzinov
 */
@Controller
@RequestMapping(URL.CLIENTOFFICE)
public class ClientController {
    @RequestMapping
    public String index() {
        return URL.CLIENTOFFICE + "/index";
    }
}
