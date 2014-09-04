package com.github.ilyamurzinov.ecareapp.web.controller;

import com.github.ilyamurzinov.ecareapp.common.domain.Contract;
import com.github.ilyamurzinov.ecareapp.common.domain.User;
import com.github.ilyamurzinov.ecareapp.web.service.ContractService;
import com.github.ilyamurzinov.ecareapp.web.service.OptionService;
import com.github.ilyamurzinov.ecareapp.web.service.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ilya-murzinov
 */
@Controller
@RequestMapping("contract")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @Autowired
    private TariffService tariffService;

    @Autowired
    private OptionService optionService;

    @ModelAttribute("currentUser")
    public User getCurrentUser() {
        return SecurityHelper.getCurrentUser();
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    ModelAndView getContract(int id) {
        ModelAndView modelAndView = new ModelAndView("contract");
        modelAndView.addObject("contract", contractService.getContract(id));
        return modelAndView;
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView getAddContractForm(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("add-contract");
        modelAndView.addObject("contract", new Contract());
        modelAndView.addObject("tariffs", tariffService.getAllTariffs());
        return modelAndView;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public
    @ResponseBody
    String addContract(
            @RequestBody Contract contract
    ) {
        contractService.addContract(contract);
        return "{}";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public ModelAndView getEditContractForm(@RequestParam String id) {
        ModelAndView modelAndView = new ModelAndView("edit-contract");
        modelAndView.addObject("contract", contractService.getContract(Integer.parseInt(id)));
        modelAndView.addObject("tariffs", tariffService.getAllTariffs());
        return modelAndView;
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public
    @ResponseBody
    String updateContract(
            @RequestBody Contract newContract
    ) {
        contractService.updateContract(newContract);
        return "{}";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public
    @ResponseBody
    String deleteContract(
            @RequestBody int id
    ) {
        contractService.deleteContract(id);
        return "{}";
    }
}
