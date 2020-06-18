package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class DemoInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) {
        String uri = request.getRequestURI();
        System.out.println(uri);
        if (!uri.startsWith("/api/public/")) {
            throw new RuntimeException("you are not allowed to access this page!");
        }
        return true;
    }
}
