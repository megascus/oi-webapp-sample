/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oisix.sample.base;

import com.oisix.sample.bean.CustomerService;
import com.oisix.sample.model.MstCustomer;
import com.oisix.sample.validator.Address1Validator;
import com.oisix.sample.validator.Address2Validator;
import com.oisix.sample.validator.FullnameKanaValidator;
import com.oisix.sample.validator.FullnameValidator;
import com.oisix.sample.validator.MailAddressValidator;
import com.oisix.sample.validator.TelValidator;
import com.oisix.sample.validator.TodofukenValidator;
import com.oisix.sample.validator.ZipCodeValidator;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author s.kubo
 */
@WebServlet(name = "CustomerView", urlPatterns = {"/CustomerView"})
public class CustomerViewServlet extends BaseServlet {

    @Inject
    CustomerService service;

    @Override
    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        MstCustomer mstCustomer = convertParameter(request);
        Optional<MstCustomer> find = service.find(mstCustomer.getCustomerId());
        if (find.isPresent()) {
            request.setAttribute("bean",find.get());
        }
        forward("CustomerEdit.jsp", request, response);
    }
}
