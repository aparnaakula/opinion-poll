package com.mycapstone.opinionpoll.controllers;

import com.mycapstone.opinionpoll.models.User;
import com.mycapstone.opinionpoll.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

//
//import com.mycapstone.opinionpoll.models.User;
//import com.mycapstone.opinionpoll.models.data.UserDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.ModelAttribute;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//public class AbstractController {
//
//    @Autowired
//    protected UserDao userDao;
//
//    /*
//     * Other DAOs can be autowired here and they'll be available
//     * to all classes extending AbstractController
//     * */
//
//    public static final String userSessionKey = "user_id";
//
//    protected User getUserFromSession(HttpSession session) {
//        Integer userId = (Integer) session.getAttribute(userSessionKey);
//        return userId == null ? null : userDao.findOne(userId);
//    }
//
//    protected void setUserInSession(HttpSession session, User user) {
//        session.setAttribute(userSessionKey, user.getId());
//    }
//
//    @ModelAttribute("user")
//    public User getUserForModel(HttpServletRequest request) {
//        return getUserFromSession(request.getSession());
//    }
//
//}
//}