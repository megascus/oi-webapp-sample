package com.oisix.sample.base;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * 文字エンコードを指定します。 APサーバーがやってくれる場合も多いのでその場合は不要です。
 *
 * @author megascus
 */
@WebFilter(filterName = "SetCharactorEncodingFilter", urlPatterns = {"/*"}, initParams = {
    @WebInitParam(name = "encoding", value = "UTF-8")})
public class SetCharactorEncodingFilter implements Filter {

    private String encoding = null;

    public SetCharactorEncodingFilter() {
    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        doBeforeProcessing(request, response);

        try {
            chain.doFilter(request, response);
        } finally {
            doAfterProcessing(request, response);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void destroy() {
    }

}
