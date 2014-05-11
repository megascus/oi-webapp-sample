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
import static com.oisix.sample.base.MstCustomerUtils.*;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author s.kubo
 */
@WebServlet(name = "CustomerEdit", urlPatterns = {"/Customer/Edit"})
public class CustomerEditServlet extends BaseServlet {

    @Inject
    CustomerService service;

    @Override
    protected String get(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        MstCustomer mstCustomer = convertParameter(request);
        CustomerEditBean bean = new CustomerEditBean();
        if (StringUtils.isNotEmpty(mstCustomer.getCustomerId())) {
            Optional<MstCustomer> find = service.find(mstCustomer.getCustomerId());
            if (find.isPresent()) {
                bean.setMstCustomer(find.get());
            }
        }
        request.setAttribute("bean", bean);
        return null;
    }

    @Override
    protected String post(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        MstCustomer mstCustomer = convertParameter(request);
        List<String> errors = validate(mstCustomer);
        if (!errors.isEmpty()) {
            service.edit(mstCustomer);
        }
        CustomerEditBean bean = new CustomerEditBean();
        bean.setMstCustomer(mstCustomer);
        bean.setErrors(errors);
        request.setAttribute("bean", bean);
        return null;
    }
}
