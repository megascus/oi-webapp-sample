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
    protected void get(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        MstCustomer mstCustomer = convertParameter(request);
        CustomerEditBean bean = new CustomerEditBean();
        if (StringUtils.isNotEmpty(mstCustomer.getCustomerId())) {
            Optional<MstCustomer> find = service.find(mstCustomer.getCustomerId());
            if (find.isPresent()) {
                bean.setMstCustomer(find.get());
                bean.setChange(true);
            }
        }
        request.setAttribute("bean", bean);
    }

    @Override
    protected void post(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        MstCustomer mstCustomer = convertParameter(request);
        CustomerEditBean bean = new CustomerEditBean();
        if (StringUtils.isNotEmpty(request.getParameter("change"))) {
            bean.setChange(true);
        }
        List<String> errors = validate(mstCustomer);
        bean.setErrors(errors);
        if (errors.isEmpty()) {
            try {
                service.edit(mstCustomer);
                bean.setActionMessage(bean.getViewTitle() + "完了しました。");
            } catch (Exception e) {
                bean.setActionMessage(bean.getViewTitle() + "に失敗しました。");
            }
        }
        bean.setMstCustomer(mstCustomer);
        request.setAttribute("bean", bean);
    }
}
