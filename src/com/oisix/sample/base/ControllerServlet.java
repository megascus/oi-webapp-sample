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
		
		} catch (InstantiationException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		if (modelBean == null) {
			// Todoエラー処理
		} else {
			modelBean.init(request, response);
			modelBean.validate();
			modelBean.process();
			RequestDispatcher rd = request.getRequestDispatcher(jspDir + name + ".jsp");
			request.setAttribute("bean", modelBean);
			rd.forward(request, response);
		}
	}
}


