package com.example.rsi.filter;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;

@WebFilter("/*")
public class MyResponseFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        Writer fileWriter = new FileWriter("logs.txt", true);
        fileWriter.write(authentication.getName() + ", " + authentication.getAuthorities().toString() + ", " + new Date() + ", url: " + httpServletRequest.getRequestURI() + ", method: " + httpServletRequest.getMethod() + ", status: " + httpServletResponse.getStatus() + "\n");
        fileWriter.close();

        httpServletResponse.setHeader("Role", authentication.getName());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}