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
import java.util.ArrayList;
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
@WebServlet(name = "CustomerEdit", urlPatterns = {"/CustomerEdit"})
public class CustomerEditServlet extends BaseServlet {

    @Inject
    CustomerService service;

    @Override
    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        MstCustomer mstCustomer = convertParameter(request);
        List<String> errors = validate(mstCustomer);
        if (!errors.isEmpty()) {
            service.edit(mstCustomer);
        }
        request.setAttribute("bean", mstCustomer);
        forward("CustomerEdit.jsp", request, response);
    }

    private List<String> validate(MstCustomer mstCustomer) {
        List<String> errors = new ArrayList<String>();

        new FullnameValidator(errors).validate(mstCustomer.getFullname());
        new FullnameKanaValidator(errors).validate(mstCustomer.getFullnameKana());
        new MailAddressValidator(errors).validate(mstCustomer.getMailAddress());
        new ZipCodeValidator(errors).validate(mstCustomer.getZipCode1() + "-" + mstCustomer.getZipCode2());
        new TodofukenValidator(errors).validate(mstCustomer.getTodofuken());
        new Address1Validator(errors).validate(mstCustomer.getAddress1());
        new Address2Validator(errors).validate(mstCustomer.getAddress2());
        new TelValidator(errors).validate(mstCustomer.getTel1(), mstCustomer.getTel2(), mstCustomer.getTel3());
        return errors;
    }
}
