package com.github.ilyamurzinov.ecareapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
}
