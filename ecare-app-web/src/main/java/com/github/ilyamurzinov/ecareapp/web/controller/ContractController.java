package com.github.ilyamurzinov.ecareapp.web.controller;

import com.github.ilyamurzinov.ecareapp.common.domain.Contract;
import com.github.ilyamurzinov.ecareapp.web.service.ContractService;
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
@RequestMapping("contract")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @ModelAttribute
    public Contract getContract() {
        return new Contract();
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    ModelAndView getContract(int id) {
        ModelAndView modelAndView = new ModelAndView("contract");
        modelAndView.addObject("contract", contractService.getContract(id));
        return modelAndView;
    }
}
