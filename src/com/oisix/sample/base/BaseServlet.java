/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oisix.sample.base;

import com.oisix.sample.model.MstCustomer;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author s.kubo
 */
@SuppressWarnings("serial")
public abstract class BaseServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        process(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        process(request, response);
    }

    private final String jspDir = "WEB-INF/jsp/";

    protected void forward(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(jspDir + jsp);
        rd.forward(request, response);
    }

    protected abstract void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;

    public String getParameterNvl(HttpServletRequest req, String key) {
        String s = req.getParameter(key);
        return StringUtils.trimToEmpty(s);
    }

    protected MstCustomer convertParameter(HttpServletRequest req) {
        MstCustomer mstCustomer = new MstCustomer();
        mstCustomer.setCustomerId(getParameterNvl(req, "customerId"));
        mstCustomer.setFullname(getParameterNvl(req, "fullname"));
        mstCustomer.setFullnameKana(getParameterNvl(req, "fullnameKana"));
        mstCustomer.setMailAddress(getParameterNvl(req, "mailAddress"));
        mstCustomer.setZipCode1(getParameterNvl(req, "zipCode1"));
        mstCustomer.setZipCode2(getParameterNvl(req, "zipCode2"));
        mstCustomer.setTodofuken(getParameterNvl(req, "todofuken"));
        mstCustomer.setAddress1(getParameterNvl(req, "address1"));
        mstCustomer.setAddress2(getParameterNvl(req, "address2"));
        mstCustomer.setTel1(getParameterNvl(req, "tel1"));
        mstCustomer.setTel2(getParameterNvl(req, "tel2"));
        mstCustomer.setTel3(getParameterNvl(req, "tel3"));
        return mstCustomer;
    }

}
