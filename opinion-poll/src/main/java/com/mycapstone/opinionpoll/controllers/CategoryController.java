//package com.mycapstone.opinionpoll.controllers;
//
//import com.mycapstone.opinionpoll.models.Category;
//import com.mycapstone.opinionpoll.repositories.CategoryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.validation.Valid;
//
//@Controller
//@RequestMapping("category")
//public class CategoryController {
//
//	@Autowired
//	private CategoryRepository categoryRepository;
//
//	// Request path: /cheese
//	@RequestMapping(value = "")
//	public String index(Model model) {
//
//		model.addAttribute("categories", categoryRepository.findAll());
//		model.addAttribute("title", "Categories");
//
//		return "category/index";
//	}
//
//	@RequestMapping(value = "add", method = RequestMethod.GET)
//	public String add(Model model) {
//
//		model.addAttribute("title", "Category");
//		model.addAttribute("category", new Category());
//		return "category/add";
//	}
//
//	@RequestMapping(value = "add", method = RequestMethod.POST)
//	public String add(Model model, @ModelAttribute @Valid Category category, Errors errors) {
//
//		if (errors.hasErrors()) {
//			return "category/add";
//		}
//		categoryRepository.save(category);
//		return "redirect:";
//	}
//}