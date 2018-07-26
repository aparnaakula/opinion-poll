package com.mycapstone.opinionpoll.controllers;

import com.mycapstone.opinionpoll.models.Query;
import com.mycapstone.opinionpoll.repositories.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    QueryRepository queryRepository;

    @GetMapping(value = "/")
    public String index(Model model) {
        List<Query> allQueries = queryRepository.findAll();
        model.addAttribute("query", allQueries);
        return "query/list";
    }
}