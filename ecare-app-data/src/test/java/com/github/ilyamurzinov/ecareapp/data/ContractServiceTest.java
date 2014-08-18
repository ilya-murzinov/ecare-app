package com.github.ilyamurzinov.ecareapp.data;

import com.github.ilyamurzinov.ecareapp.data.domain.Contract;
import com.github.ilyamurzinov.ecareapp.data.service.ContractService;
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
public class ContractServiceTest {
    @Autowired
    private ContractService contractService;

    @Test
    public void addContractTest() {
        Contract contract = new Contract();
        contract.setNumber(42);
        //contractService.
    }
}
