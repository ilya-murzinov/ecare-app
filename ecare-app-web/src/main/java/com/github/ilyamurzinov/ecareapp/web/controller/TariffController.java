package com.github.ilyamurzinov.ecareapp.web.controller;

import com.github.ilyamurzinov.ecareapp.common.domain.Tariff;
import com.github.ilyamurzinov.ecareapp.web.service.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ilya-murzinov
 */
@Controller
@RequestMapping("tariff")
public class TariffController {
    @Autowired
    private TariffService tariffService;

    @ModelAttribute
    public Tariff getContract() {
        return new Tariff();
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    ModelAndView getContract(int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tariff", tariffService.getTariff(id));
        modelAndView.setViewName("tariff");
        return modelAndView;
    }
}