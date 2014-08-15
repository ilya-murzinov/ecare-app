package com.github.ilyamurzinov.ecareapp.desktopserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author ilya-murzinov
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:server-desktop-spring-сontext.xml"})
public class ServerTest {
    @Autowired
    private Server server;

    @Test
    public void serverTest() {

    }
}
