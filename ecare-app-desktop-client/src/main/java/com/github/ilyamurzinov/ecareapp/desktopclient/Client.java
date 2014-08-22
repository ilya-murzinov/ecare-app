package com.github.ilyamurzinov.ecareapp.desktopclient;

import com.github.ilyamurzinov.ecareapp.desktopclient.view.LoginWindowView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ilya-murzinov
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        LoginWindowView view = (LoginWindowView) context.getBean("loginWindowView");

        view.show();
    }
}
