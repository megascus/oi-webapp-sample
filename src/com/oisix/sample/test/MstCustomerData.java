package com.oisix.sample.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.oisix.sample.dao.MstCustomerDao;
import com.oisix.sample.model.MstCustomer;

public class MstCustomerData {
	
	public void create() {
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		MstCustomer customer = new MstCustomer();
		customer.setCustomerId("1");
		customer.setMailAddress("test1@oisix.co.jp");
		customer.setFullname("おい六 一郎");
		customer.setFullnameKana("オイロク イチロウ");
		customer.setZipCode("141-0012");
		customer.setTodofuken("東京都");
		customer.setAddress1("東京都品川区東五反田1丁目13番12号");
		customer.setAddress2("いちご五反田ビル");
		customer.setTel("03-1234-5678");
		MstCustomerDao.merge(session, customer);
		
		transaction.commit();
		session.close();
	}
}
