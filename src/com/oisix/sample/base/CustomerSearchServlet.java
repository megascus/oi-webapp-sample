/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oisix.sample.base;

import com.oisix.sample.bean.CustomerService;
import com.oisix.sample.model.MstCustomer;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author s.kubo
 */
@WebServlet(name = "CustomerSearch", urlPatterns = {"/CustomerSearch"})
public class CustomerSearchServlet extends BaseServlet {

    @Inject
    CustomerService service;

    @Override
    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        MstCustomer mstCustomer = convertParameter(request);
        List<MstCustomer> searchResults = service.search(mstCustomer);
        request.setAttribute("results", searchResults);
        forward("CustomerSearch.jsp", request, response);
    }

}
