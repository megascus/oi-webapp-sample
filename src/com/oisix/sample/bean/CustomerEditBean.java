package com.oisix.sample.bean;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.oisix.sample.dao.MstCustomerDao;
import com.oisix.sample.model.MstCustomer;
import com.oisix.sample.validator.Address1Validator;
import com.oisix.sample.validator.Address2Validator;
import com.oisix.sample.validator.FullnameKanaValidator;
import com.oisix.sample.validator.FullnameValidator;
import com.oisix.sample.validator.MailAddressValidator;
import com.oisix.sample.validator.TelValidator;
import com.oisix.sample.validator.TodofukenValidator;
import com.oisix.sample.validator.ZipCodeValidator;

public class CustomerEditBean extends ModelBeanBase {

	private MstCustomer mstCustomer = new MstCustomer();

	@Override
	public void process() {
		this.mstCustomer.setCustomerId(getParameterNvl("customerId"));

		if (isClick("edit")) {
			this.edit();
		}
		else if (!StringUtils.isEmpty(this.mstCustomer.getCustomerId())) {
			search();
			request.setAttribute("mstCustomer", this.mstCustomer);
		}


	}

	public void search() {
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		this.mstCustomer = MstCustomerDao.findByPk(session, mstCustomer.getCustomerId());
		this.mstCustomer.divideZipCode();
		this.mstCustomer.divideTel();

		transaction.commit();

		session.close();

	}

	public void edit() {
		if (super.isError()) {
			return;
		}

		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		MstCustomerDao.merge(session, mstCustomer);

		transaction.commit();

		session.close();

		super.setActionMessage(getViewTitle() + "完了しました。");
	}

	@Override
	public void validate() {

		if (isClick("edit")) {
			this.getParameter();
			List<String> errors = super.getErrors();

			new FullnameValidator(errors).validate(this.mstCustomer.getFullname());
			new FullnameKanaValidator(errors).validate(this.mstCustomer.getFullnameKana());
			new MailAddressValidator(errors).validate(this.mstCustomer.getMailAddress());
			new ZipCodeValidator(errors).validate(this.mstCustomer.getZipCode1() + "-" + this.mstCustomer.getZipCode2());
			new TodofukenValidator(errors).validate(this.mstCustomer.getTodofuken());
			new Address1Validator(errors).validate(this.mstCustomer.getAddress1());
			new Address2Validator(errors).validate(this.mstCustomer.getAddress2());
			new TelValidator(errors).validate(this.mstCustomer.getTel1(), this.mstCustomer.getTel2(), this.mstCustomer.getTel3());
		}
		if (errors.size() == 0) {
			this.mstCustomer.joinZipCode();
			this.mstCustomer.joinTel();
		}

		super.setErrors(errors);
	}

	public MstCustomer getMstCustomer() {
		return mstCustomer;
	}

	public void setMstCustomer(MstCustomer mstCustomer) {
		this.mstCustomer = mstCustomer;
	}

	public String getViewTitle() {
		if (StringUtils.isEmpty(this.mstCustomer.getCustomerId())) {
			return "登録";
		} else {
			return "更新";
		}
	}

	private void getParameter() {
		this.mstCustomer.setCustomerId(getParameterNvl("customerId"));
		this.mstCustomer.setFullname(getParameterNvl("fullname"));
		this.mstCustomer.setFullnameKana(getParameterNvl("fullnameKana"));
		this.mstCustomer.setMailAddress(getParameterNvl("mailAddress"));
		this.mstCustomer.setZipCode1(getParameterNvl("zipCode1"));
		this.mstCustomer.setZipCode2(getParameterNvl("zipCode2"));
		this.mstCustomer.setTodofuken(getParameterNvl("todofuken"));
		this.mstCustomer.setAddress1(getParameterNvl("address1"));
		this.mstCustomer.setAddress2(getParameterNvl("address2"));
		this.mstCustomer.setTel1(getParameterNvl("tel1"));
		this.mstCustomer.setTel2(getParameterNvl("tel2"));
		this.mstCustomer.setTel3(getParameterNvl("tel3"));
	}
}