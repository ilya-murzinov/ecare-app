package com.github.ilyamurzinov.ecareapp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ilya-murzinov
 */
@Controller
public class MainController {
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "clientoffice")
    public String clientOffice() {
        return "clientoffice";
    }

    @RequestMapping(value = "backoffice")
    public String backOffice() {
        return "backoffice";
    }
}
