//package com.mycapstone.opinionpoll.controllers;
//
//
//import com.mycapstone.opinionpoll.forms.UserForm;
//import com.mycapstone.opinionpoll.user.EmailExistException;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import javax.validation.Valid;
//import java.security.Principal;
//
//@Controller
//public class AuthenticationController extends AbstractController {
//
//    @GetMapping(value = "/register")
//    public String registerForm(Model model) {
//        model.addAttribute(new UserForm());
//        model.addAttribute("title", "Register");
//        return "register";
//    }
//
//    @PostMapping(value = "/register")
//    public String register(@ModelAttribute @Valid UserForm userForm, Errors errors) {
//
//        if (errors.hasErrors())
//            return "register";
//
//        try {
//            userService.save(userForm);
//        } catch (EmailExistException e) {
//            errors.rejectValue("email", "email.alreadyexists", e.getMessage());
//            return "register";
//        }
//
//        return "redirect:/";
//    }
//
//    @GetMapping(value = "/login")
//    public String login(Model model, Principal user, String error, String logout) {
//
//        if (user != null)
//            return "redirect:/";
//
//        if (error != null)
//            model.addAttribute(MESSAGE_KEY, "danger|Your username and password are invalid");
//
//        if (logout != null)
//            model.addAttribute(MESSAGE_KEY, "info|You have logged out");
//
//        return "login";
//    }
//
//}
