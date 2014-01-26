package com.oisix.sample.bean;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;


public abstract class ModelBeanBase implements ModelBean {
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected List<String> errors = new ArrayList<String>();
	protected String actionMessage = new String();
	protected String systemErrorMessage;
	
	public void init(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	
	public abstract void process();

	private static final String EMPTY = "";
	
	public String getParameterNvl(String key) {
		String s = this.request.getParameter(key);
		if (s == null) {
			s = EMPTY;
		}
		return s;
	}
	
	public boolean isClick(String key) {
		String s = this.request.getParameter(key);
		return !(StringUtils.isEmpty(s));
	}

	public boolean isError() {
		return this.errors.size() > 0;
	}
	
	public List<String> getErrors() {
		return this.errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public String getActionMessage() {
		return this.actionMessage;
	}

	public void setActionMessage(String actionMessage) {
		this.actionMessage = actionMessage;
	}
	
	public void gotoSystemErrorPage(String systemErrorMessage) {
		this.systemErrorMessage = systemErrorMessage;
	}
	
	public boolean isSystemError() {
		return (this.systemErrorMessage != null);
	}
}