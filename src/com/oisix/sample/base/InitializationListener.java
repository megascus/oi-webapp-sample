package com.oisix.sample.base;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.oisix.sample.test.MstCustomerData;

public class InitializationListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent event){
		
		new MstCustomerData().create();
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}
}


