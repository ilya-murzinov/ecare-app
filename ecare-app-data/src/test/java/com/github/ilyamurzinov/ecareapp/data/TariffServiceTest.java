package com.github.ilyamurzinov.ecareapp.data;

import com.github.ilyamurzinov.ecareapp.data.service.OptionService;
import com.github.ilyamurzinov.ecareapp.data.service.TariffService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author ilya-murzinov
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:data-spring-сontext.xml"})
public class TariffServiceTest {
    @Autowired
    private TariffService tariffService;

    @Autowired
    private OptionService optionService;

    @Test
    public void addOptionTest() {
        tariffService.addOption(
                tariffService.getTariff(1),
                optionService.getOption(1)
        );
    }

    @Test
    public void removeOptionTest() {
        tariffService.removeOption(
                tariffService.getTariff(1),
                optionService.getOption(1)
        );
    }
}
