/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oisix.sample.base;

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
        try {
            String forward = get(request, response);
            forward(forward, request, response);
        } catch (Exception e) {
            log("uncatched exception", e);
            e.printStackTrace();
            forward("error.jsp", request, response);
        }
    }

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        try {
            String forward = post(request, response);
            forward(forward, request, response);
        } catch (Exception e) {
            log("uncatched exception", e);
            e.printStackTrace();
            forward("error.jsp", request, response);
        }
    }

    private final String jspDir = "/WEB-INF/jsp/";

    protected void forward(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(StringUtils.isEmpty(jsp)) {
            jsp = getServletName() + ".jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(jspDir + jsp);
        rd.forward(request, response);
    }

    /**
     * 実際の処理を記述します。 戻り値として表示するjspファイル名を返して下さい。
     *
     * @param request
     * @param response
     * @return 表示するjspファイル名
     * @throws IOException
     * @throws ServletException
     */
    protected abstract String get(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;

    /**
     * 実際の処理を記述します。 戻り値として表示するjspファイル名を返して下さい。
     *
     * @param request
     * @param response
     * @return 表示するjspファイル名
     * @throws IOException
     * @throws ServletException
     */
    protected abstract String post(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;

}
