package com.mycapstone.opinionpoll.controllers;

import com.mycapstone.opinionpoll.models.User;
import com.mycapstone.opinionpoll.repositories.UserRepository;
import com.mycapstone.opinionpoll.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

//
//import com.mycapstone.opinionpoll.models.User;
//import com.mycapstone.opinionpoll.models.UserDao;
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
@Controller
public abstract class AbstractController {

    @Autowired
    UserService userService;

    @Autowired
    protected UserRepository userRepository;

    protected static final String MESSAGE_KEY = "message";

    @ModelAttribute("user")
    public User getLoggedInUser(Principal principal) {
        if (principal != null)
            return userService.findByEmail(principal.getName());
        return null;
    }
    public static final String userSessionKey = "user_id";

    protected User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        return userId == null ? null : userRepository.findOne(userId);
    }

    protected void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getId());
    }

    @ModelAttribute("user")
    public User getUserForModel(HttpServletRequest request) {
        return getUserFromSession(request.getSession());
    }

}