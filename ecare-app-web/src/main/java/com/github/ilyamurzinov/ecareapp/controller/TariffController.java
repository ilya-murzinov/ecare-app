package com.github.ilyamurzinov.ecareapp.controller;

import com.github.ilyamurzinov.ecareapp.domain.Tariff;
import com.github.ilyamurzinov.ecareapp.beans.UserBean;
import com.github.ilyamurzinov.ecareapp.service.OptionService;
import com.github.ilyamurzinov.ecareapp.service.TariffService;
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
@RequestMapping("tariff")
public class TariffController {
    @Autowired
    private TariffService tariffService;

    @Autowired
    private OptionService optionService;

    @Autowired
    private SecurityHelper securityHelper;

    @ModelAttribute("currentUser")
    public UserBean getCurrentUser() {
        return securityHelper.getCurrentUser();
    }

    @RequestMapping(value = "all")
    public ModelAndView getAllTariffs() {
        ModelAndView modelAndView = new ModelAndView("list-tariffs");
        modelAndView.addObject("tariffsList", tariffService.getAllTariffs());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getTariff(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("tariff");
        modelAndView.addObject("tariff", tariffService.getTariff(id));
        return modelAndView;
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView getEditTariffForm(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("edit-tariff");
        modelAndView.addObject("tariff", tariffService.getTariff(id));
        modelAndView.addObject("options", optionService.getAllOptions());
        return modelAndView;
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public
    @ResponseBody
    String editTariff(
            @Valid @RequestBody Tariff tariff,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return BindingResultHelper.getMessage(result);
        }

        String message = tariffService.updateTariff(tariff);
        if (message != null) {
            return message;
        }
        return "{}";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView getAddTariffForm() {
        ModelAndView modelAndView = new ModelAndView("add-tariff");
        modelAndView.addObject("tariff", new Tariff());
        modelAndView.addObject("options", optionService.getAllOptions());
        return modelAndView;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public
    @ResponseBody
    String addTariff(
            @Valid @RequestBody Tariff tariff,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return BindingResultHelper.getMessage(result);
        }
        String message = tariffService.addTariff(tariff);
        if (message != null) {
            return message;
        }
        return "{}";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public
    @ResponseBody
    String delete(
            @RequestBody Tariff tariff
    ) {
        String message = tariffService.removeTariff(tariff.getId());
        if (message != null) {
            return message;
        }
        return "{}";
    }

    @RequestMapping("options")
    public ModelAndView getOptionsByTariff(@RequestParam("id") int tariffId) {
        ModelAndView modelAndView = new ModelAndView("fragments/options");
        modelAndView.addObject("tariff", tariffService.getTariff(tariffId));
        return modelAndView;
    }

    @ExceptionHandler(NoResultException.class)
    public ModelAndView handle(NoResultException ex) {
        return new ModelAndView("error");
    }
}
