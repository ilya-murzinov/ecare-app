package com.github.ilyamurzinov.ecareapp.controller;

import com.github.ilyamurzinov.ecareapp.domain.Option;
import com.github.ilyamurzinov.ecareapp.beans.UserBean;
import com.github.ilyamurzinov.ecareapp.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.NoResultException;
import javax.validation.Valid;

/**
 * @author ilya-murzinov
 */
@Controller
@RequestMapping("option")
public class OptionController {
    @Autowired
    private OptionService optionService;

    @Autowired
    private SecurityHelper securityHelper;

    @ModelAttribute("currentUser")
    public UserBean getCurrentUser() {
        return securityHelper.getCurrentUser();
    }

    @RequestMapping(value = "all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView getOptionsList() {
        ModelAndView modelAndView = new ModelAndView("list-options");
        modelAndView.addObject("optionsList", optionService.getAllOptions());
        return modelAndView;
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView getEditOptionForm(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("edit-option");
        modelAndView.addObject("option", optionService.getOption(id));
        modelAndView.addObject("optionsList", optionService.getAllOptions());
        return modelAndView;
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public
    @ResponseBody
    String editTariff(
            @Valid @RequestBody Option option,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return BindingResultHelper.getMessage(result);
        }
        optionService.updateOption(option);
        return "{}";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView getAddOptionForm() {
        ModelAndView modelAndView = new ModelAndView("add-option");
        modelAndView.addObject("option", new Option());
        modelAndView.addObject("optionsList", optionService.getAllOptions());
        return modelAndView;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public
    @ResponseBody
    String addOption(
            @Valid @RequestBody Option option,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return BindingResultHelper.getMessage(result);
        }
        optionService.addOption(option);
        return "{}";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public
    @ResponseBody
    String deleteOption(
            @RequestBody Option option
    ) {
        String message = optionService.removeOption(option.getId());
        if (message != null) {
            return message;
        }
        return "{}";
    }

    @ExceptionHandler(NoResultException.class)
    public ModelAndView handle(NoResultException ex) {
        return new ModelAndView("error");
    }
}
