package com.oisix.sample.base;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oisix.sample.bean.ModelBean;
import com.oisix.sample.util.EJBFactory;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "welcome", urlPatterns = "/welcome", initParams = {
    @WebInitParam(name = "debug", value = "1"),
    @WebInitParam(name = "controllerName", value = "welcome"),
    @WebInitParam(name = "defaultModelName", value = "StaticBean")})
public class ControllerServlet extends HttpServlet {

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

    private final String modelPackage = "com.oisix.sample.bean.";
    private final String jspDir = "WEB-INF/jsp/";

    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String name = request.getParameter("model");

        ModelBean modelBean = null;
        try {
            @SuppressWarnings("unchecked")
            Class<ModelBean> clazz = (Class<ModelBean>) Class.forName(modelPackage + name + "Bean");
            modelBean = EJBFactory.getEJB(clazz);

        } catch (Exception e) {
            log(e.getMessage());
        } // log逵∫払

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
