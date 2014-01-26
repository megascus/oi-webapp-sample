package com.oisix.sample.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ModelBean {
	
	public void init(HttpServletRequest request, HttpServletResponse response);
	
	public void process() throws IOException, ServletException;

	public void validate() throws IOException, ServletException;
	
	public boolean isSystemError();
}


