package com.github.ilyamurzinov.ecareapp.desktopclient;

import com.github.ilyamurzinov.ecareapp.desktopclient.controller.MainController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ilya-murzinov
 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        MainController controller = (MainController) context.getBean("mainController");

        controller.run();
    }
}
