package com.github.ilyamurzinov.ecareapp.desktopclient.controller;

import com.github.ilyamurzinov.ecareapp.common.domain.Option;
import com.github.ilyamurzinov.ecareapp.common.domain.Tariff;
import com.github.ilyamurzinov.ecareapp.desktopclient.cache.Cache;
import com.github.ilyamurzinov.ecareapp.desktopclient.service.OptionService;
import com.github.ilyamurzinov.ecareapp.desktopclient.service.TariffService;
import com.github.ilyamurzinov.ecareapp.desktopclient.view.OptionsListView;
import com.github.ilyamurzinov.ecareapp.desktopclient.view.TariffView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Set;

/**
 * @author ilya-murzinov
 */
@Component
public class TariffController {
    @Autowired
    private TariffView tariffView;

    @Autowired
    private OptionsListView optionsListView;

    @Autowired
    private TariffService tariffService;

    @Autowired
    private OptionService optionService;

    @Autowired
    private Cache cache;

    @PostConstruct
    public void init() {
        tariffView.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                for (Option option : optionService.getAllOptions()) {
                    optionsListView.getOptionsListModel().addElement(option);
                }
            }

            @Override
            public void windowActivated(WindowEvent e) {
                updateView();
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                cache.setTariff(getTariffFromView());
            }
        });
        tariffView.getTariffPanel().getSaveEditedTariffButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Tariff tariff = getTariffFromView();
                tariff.setId(cache.getTariff().getId());
                tariffService.updateTariff(tariff);
                tariffView.close();
            }
        });
        tariffView.getTariffPanel().getSaveNewTariffButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Tariff tariff = getTariffFromView();
                tariffService.addTariff(tariff);
                tariffView.close();
            }
        });
        tariffView.getTariffPanel().getAddOptionButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                optionsListView.display();
            }
        });
        optionsListView.getAddButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Option option = (Option) optionsListView.getOptionsList().getSelectedValue();
                if (option != null) {
                    cache.getTariff().getOptions().add(option);
                    tariffView.getTariffPanel().getOptionsListModel().addElement(option);
                }
                optionsListView.close();
            }
        });
        tariffView.getTariffPanel().getRemoveOptionButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Option option = (Option) optionsListView.getOptionsList().getSelectedValue();
                if (option != null) {
                    cache.getTariff().getOptions().remove(option);
                    tariffView.getTariffPanel().getOptionsListModel().removeElement(option);
                }
            }
        });
    }

    private void updateView() {
        tariffView.getTariffPanel().getNameTextField().setText(cache.getTariff().getName());
        tariffView.getTariffPanel().getPriceTextField().setText(String.valueOf(cache.getTariff().getPrice()));
        tariffView.getTariffPanel().getOptionsListModel().removeAllElements();
        for (Option option : cache.getTariff().getOptions()) {
            tariffView.getTariffPanel().getOptionsListModel().addElement(option);
        }
    }

    @SuppressWarnings("unchecked")
    private Tariff getTariffFromView() {
        Tariff tariff = new Tariff();
        tariff.setName(tariffView.getTariffPanel().getNameTextField().getText());
        tariff.setPrice(Double.parseDouble(tariffView.getTariffPanel().getPriceTextField().getText()));
        tariff.setOptions((Set<Option>) tariffView.getTariffPanel().getOptionsListModel().getAllItems());
        return tariff;
    }
}
