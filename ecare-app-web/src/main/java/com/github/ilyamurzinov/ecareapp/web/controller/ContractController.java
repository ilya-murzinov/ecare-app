package com.github.ilyamurzinov.ecareapp.web.controller;

import com.github.ilyamurzinov.ecareapp.common.domain.Contract;
import com.github.ilyamurzinov.ecareapp.web.beans.UserBean;
import com.github.ilyamurzinov.ecareapp.web.service.ContractService;
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
    private SecurityHelper securityHelper;

    @ModelAttribute("currentUser")
    public UserBean getCurrentUser() {
        return securityHelper.getCurrentUser();
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    ModelAndView getContract(int id) {
        ModelAndView modelAndView = new ModelAndView("fragments/contract");
        modelAndView.addObject("contract", contractService.getContract(id));
        return modelAndView;
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView getAddContractForm(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("add-contract");
        modelAndView.addObject("contract", new Contract());
        modelAndView.addObject("tariffs", tariffService.getAllTariffs());
        return modelAndView;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public
    @ResponseBody
    String addContract(
            @RequestBody Contract contract
    ) {
        contractService.addContract(contract);
        return "{}";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN') " +
            "|| this.currentUser.client.contracts.contains(" +
            "new com.github.ilyamurzinov.ecareapp.common.domain.Contract(#id)" +
            ")")
    public ModelAndView getEditContractForm(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("edit-contract");
        modelAndView.addObject("contract", contractService.getContract(id));
        modelAndView.addObject("tariffs", tariffService.getAllTariffs());
        return modelAndView;
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN') " +
            "|| this.currentUser.client.contracts.contains(" +
            "new com.github.ilyamurzinov.ecareapp.common.domain.Contract(#id)" +
            ")")
    public
    @ResponseBody
    String updateContract(
            @RequestBody Contract newContract
    ) {
        if (getCurrentUser().isAdmin()) {
            newContract.setBlockedByEmployee(true);
        }
        contractService.updateContract(newContract);
        return "{}";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public
    @ResponseBody
    String deleteContract(
            @RequestBody int id
    ) {
        contractService.deleteContract(id);
        return "{}";
    }
}
