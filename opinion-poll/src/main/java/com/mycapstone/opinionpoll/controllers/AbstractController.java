package com.mycapstone.opinionpoll.controllers;


import com.mycapstone.opinionpoll.models.User;
import com.mycapstone.opinionpoll.repositories.UserRepository;
import com.mycapstone.opinionpoll.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

public class AbstractController {

    @Autowired
    UserService userService;

    protected static final String MESSAGE_KEY = "message";

    @ModelAttribute("user")
    public User getLoggedInUser(Principal principal) {
        if (principal != null)
            return userService.findByEmail(principal.getName());
        return null;
    }
}
