package com.mycapstone.opinionpoll.controllers;

import com.mycapstone.opinionpoll.models.Category;
import com.mycapstone.opinionpoll.models.Query;
import com.mycapstone.opinionpoll.repositories.CategoryRepository;
import com.mycapstone.opinionpoll.repositories.QueryRepository;
import com.mycapstone.opinionpoll.services.NotificationService;
import com.mycapstone.opinionpoll.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class QueryController {
	@Autowired
	private PostService postService;

	@Autowired
	private QueryRepository queryRepository;
	@Autowired
	private NotificationService notifyService;

	@Autowired
	private CategoryRepository categoryRepository;


//	@RequestMapping("/query/view/{id}")
//	public String view(@PathVariable("id") int id, Model model) {
//		Query query = postService.findById(id);
//		if (query == null) {
//			notifyService.addErrorMessage("Cannot find query #" + id);
//			return "redirect:/";
//		}
//		model.addAttribute("query", query);
//		return "query/view";
//	}

	@GetMapping(value = "add")
	public String displayAddQueryForm(Model model, @CookieValue(value="user", defaultValue = "none") String email) {

//		if(email.equals("none")){
//			return "redirect:/login";
//		}
		model.addAttribute("title", "Add Query");
		model.addAttribute("Query", new Query());
		model.addAttribute("categories", categoryRepository.findAll());
		return "query/add";
	}

	@PostMapping(value = "add")
	public String processAddQueryForm(@ModelAttribute @Valid Query query, @RequestParam int categoryId,
									  Errors errors, Model model, @CookieValue(value="user", defaultValue = "none") String email) {

		if(email.equals("none")){
			return "redirect:/login";
		}

		if (errors.hasErrors()) {
			model.addAttribute("title", "Add Query");
			return "query/add";
		}

		Category cat = categoryRepository.findById(categoryId).get();
		query.setCategory(cat);
		queryRepository.save(query);
		return "redirect:";
	}

	@GetMapping(value = "remove")
	public String displayRemoveQueryForm(Model model, @CookieValue(value="user", defaultValue = "none") String email) {

//		if(email.equals("none")){
//			return "redirect:/login";
//		}
		model.addAttribute("query", queryRepository.findAll());
		model.addAttribute("title", "Remove Cheese");
		return "query/remove";
	}

	@PostMapping(value = "remove")
	public String processRemoveQueryForm(@RequestParam int[] queryIds, @CookieValue(value="user", defaultValue = "none") String email) {

		if(email.equals("none")){
			return "redirect:/login";
		}

		for (int queryId : queryIds) {
			queryRepository.deleteById(queryId);
		}

		return "redirect:";
	}

	@GetMapping(value = "edit/{queryId}")
	public String displayEditQueryForm(Model model, @PathVariable int queryId, @CookieValue(value="user", defaultValue = "none") String email) {

		if(email.equals("none")){
			return "redirect:/login";
		}

		model.addAttribute("title", "Edit Query");
		model.addAttribute("query", queryRepository.findById(queryId));
		model.addAttribute("categories", categoryRepository.findAll());
		return "query/edit";
	}

	@PostMapping(value = "edit/{queryId}")
	public String processEditForm(Model model, @PathVariable int queryId, @ModelAttribute @Valid Query newQuery,
			@RequestParam int categoryId, Errors errors, @CookieValue(value="user", defaultValue = "none") String email) {

		if(email.equals("none")){
			return "redirect:/login";
		}

		if (errors.hasErrors()) {
			model.addAttribute("title", "Add Query");
			return "query/edit";
		}

		Query editedQuery = queryRepository.findById(queryId).get();
		editedQuery.setTitle(newQuery.getTitle());
		editedQuery.setBody(newQuery.getBody());
		editedQuery.setCategory(categoryRepository.findById(categoryId).get());
		queryRepository.save(editedQuery);

		return "redirect:";
	}

}