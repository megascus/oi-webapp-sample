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

/**
 *
 * @author s.kubo
 */
@WebServlet(name = "CustomerSearch", urlPatterns = {"/Customer/Search"})
public class CustomerSearchServlet extends BaseServlet {

    @Inject
    CustomerService service;

    @Override
    protected void get(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        CustomerSearchBean bean = new CustomerSearchBean();
        request.setAttribute("bean", bean);
    }

    @Override
    protected void post(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        MstCustomer mstCustomer = convertParameter(request);
        List<MstCustomer> searchResults = service.search(mstCustomer);
        CustomerSearchBean bean = new CustomerSearchBean();
        bean.setSearchCondition(mstCustomer);
        bean.setResults(searchResults);
        request.setAttribute("bean", bean);
    }

}
