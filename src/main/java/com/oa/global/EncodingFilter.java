package com.oa.global;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EncodingFilter implements Filter {

    private String encoding = "utf-8";

    /***
     * 获取web.xml容器中配置的fileter过滤的初始化参数
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {
        if(config.getInitParameter("encoding") != null){
            encoding = config.getInitParameter("encoding");
        }
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //HttpServletRequest继承了ServletRequest
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        //HttpServletResponse继承了ServletResponse
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletRequest.setCharacterEncoding(encoding);
        httpServletResponse.setCharacterEncoding(encoding);
        //调用过滤器链执行doFileter()方法，让过滤器链继续执行
        chain.doFilter(httpServletRequest, httpServletResponse);
    }
}
