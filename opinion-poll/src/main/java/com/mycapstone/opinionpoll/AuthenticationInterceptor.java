package com.mycapstone.opinionpoll;

import com.mycapstone.opinionpoll.controllers.AbstractController;
import com.mycapstone.opinionpoll.models.User;
import com.mycapstone.opinionpoll.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        // Authentication white list; add all publicly visible pages here
        List<String> nonAuthPages = Arrays.asList("/login", "/register");

        // Require sign-in for auth pages
        if ( !nonAuthPages.contains(request.getRequestURI()) ) {

            Integer userId = (Integer) request.getSession().getAttribute(AbstractController.userSessionKey);

            if (userId != null) {
                User user = userRepository.findOne(userId);

                if (user != null)
                    return true;
            }

            response.sendRedirect("/login");
            return false;
        }

        return true;
    }

}