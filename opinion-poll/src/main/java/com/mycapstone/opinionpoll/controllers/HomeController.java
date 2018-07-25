package com.mycapstone.opinionpoll.controllers;

import com.mycapstone.opinionpoll.models.Query;
import com.mycapstone.opinionpoll.repositories.QueryRepository;
import com.mycapstone.opinionpoll.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    @Autowired
    private QueryRepository queryRepository;
    public String index(Model model) {

        model.addAttribute("queries", queryRepository.findAll());
        model.addAttribute("title", "My queries");

        return "index";
    }

//    @RequestMapping("/")
//    public String index(Model model) {
//        List<Query> latest5Queries = postService.findLatest5();
//        model.addAttribute("latest5posts", latest5Queries);
//
//        List<Query> latest3Queries = latest5Queries.stream()
//                .limit(3).collect(Collectors.toList());
//        model.addAttribute("latest3posts", latest3Queries);
//
//        return "index";
//    }
}