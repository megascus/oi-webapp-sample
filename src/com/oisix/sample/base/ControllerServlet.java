package com.oisix.sample.base;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oisix.sample.bean.ModelBean;

public class ControllerServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request,
	           HttpServletResponse response)
	    throws IOException, ServletException {
		try {
			process(request, response);
		} catch (ServletException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
	}

	public void doPost(HttpServletRequest request,
	        HttpServletResponse response)
	       throws IOException, ServletException {
		try {
			process(request, response);
		} catch (ServletException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
	}
	
	private final String modelPackage = "com.oisix.sample.bean.";
	private final String jspDir = "WEB-INF/jsp/";
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("model");
		
		ModelBean modelBean = null;
		try {
			modelBean = (ModelBean)Class.forName(modelPackage + name + "Bean").newInstance();
		
		} catch (Exception e) {} // log逵∫払
		
		if (modelBean == null) {
			forward("error.jsp", request, response);
		} else {
			modelBean.init(request, response);
			modelBean.validate();
			modelBean.process();
			request.setAttribute("bean", modelBean);
			if (modelBean.isSystemError()) {
				forward("error.jsp", request, response);
			} else {
				forward(name + ".jsp", request, response);
			}
		}
	}
	
	private void forward(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(jspDir + jsp);
		rd.forward(request, response);
	}
}


