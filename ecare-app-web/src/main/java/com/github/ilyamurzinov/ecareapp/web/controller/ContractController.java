package com.github.ilyamurzinov.ecareapp.web.controller;

import com.github.ilyamurzinov.ecareapp.common.domain.Contract;
import com.github.ilyamurzinov.ecareapp.common.domain.Option;
import com.github.ilyamurzinov.ecareapp.common.domain.Tariff;
import com.github.ilyamurzinov.ecareapp.web.service.ContractService;
import com.github.ilyamurzinov.ecareapp.web.service.OptionService;
import com.github.ilyamurzinov.ecareapp.web.service.OptionServiceImpl;
import com.github.ilyamurzinov.ecareapp.web.service.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    ModelAndView getContract(int id) {
        ModelAndView modelAndView = new ModelAndView("contract");
        modelAndView.addObject("contract", contractService.getContract(id));
        return modelAndView;
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public ModelAndView getContractForm(@RequestParam String id) {
        ModelAndView modelAndView = new ModelAndView("edit-contract");
        modelAndView.addObject("contract", contractService.getContract(Integer.parseInt(id)));
        modelAndView.addObject("tariffs", tariffService.getAllTariffs());
        return modelAndView;
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ModelAndView updateContract(
            @RequestParam int id,
            @RequestBody Contract newContract
    ) {
        Contract contract = contractService.getContract(id);
        int tariffId = newContract.getTariff().getId();
        Set<Option> newOptions = newContract.getOptions();
        Set<Option> options = new HashSet<Option>();
        for (Option option : newOptions) {
            options.add(optionService.getOption(option.getId()));
        }

        contract.setTariff(tariffService.getTariff(tariffId));
        contract.setOptions(options);

        contractService.updateContract(contract);
        return new ModelAndView("redirect:?id=" + id);
    }
}
