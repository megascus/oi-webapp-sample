package com.oisix.sample.base;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * なんちゃってフレームワークです。
 * サーブレットを起動した後にcatchしていない例外が投げられなければServlet名と同名のjspへforwardします。
 * エラーが有った場合はerror.jspを表示しようとしますが、error.jspは未実装です。
 * @author s.kubo
 */
@SuppressWarnings("serial")
public abstract class BaseServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        try {
            get(request, response);
            forward(request, response);
        } catch (Exception e) {
            log("uncatched exception", e);
            forward("error.jsp", request, response);
        }
    }

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        try {
            post(request, response);
            forward(request, response);
        } catch (Exception e) {
            log("uncatched exception", e);
            forward("error.jsp", request, response);
        }
    }

    private final String jspDir = "/WEB-INF/jsp/";

    protected void forward(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(jspDir + jsp);
        rd.forward(request, response);
    }

    protected void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jsp = getServletName() + ".jsp";
        forward(jsp, request, response);
    }

    /**
     * 実際の処理を記述します。 
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    protected abstract void get(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;

    /**
     * 実際の処理を記述します。 
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    protected abstract void post(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;

}
