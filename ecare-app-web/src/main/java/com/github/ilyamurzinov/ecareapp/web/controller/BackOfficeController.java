package com.github.ilyamurzinov.ecareapp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ilya-murzinov
 */
@Controller
@RequestMapping("backoffice")
public class BackOfficeController {
    @RequestMapping
    public String index() {
        return "backoffice/index";
    }
}
