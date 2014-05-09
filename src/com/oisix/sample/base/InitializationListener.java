package com.oisix.sample.base;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.oisix.sample.test.MstCustomerTestService;
import javax.inject.Inject;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitializationListener implements ServletContextListener {

    @Inject
    MstCustomerTestService data;
    @Override
    public void contextInitialized(ServletContextEvent event) {
        data.create();
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
    }
}
