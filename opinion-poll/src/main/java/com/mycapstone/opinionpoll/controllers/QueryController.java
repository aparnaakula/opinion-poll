package com.mycapstone.opinionpoll.controllers;

import com.mycapstone.opinionpoll.models.Category;
import com.mycapstone.opinionpoll.models.Query;
import com.mycapstone.opinionpoll.models.data.CategoryDao;
import com.mycapstone.opinionpoll.models.data.QueryDao;
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
	private QueryDao queryDao;
	@Autowired
	private NotificationService notifyService;

	@Autowired
	private CategoryDao categoryDao;

	@RequestMapping("/queries/view/{id}")
	public String view(@PathVariable("id") int id, Model model) {
		Query query = postService.findById(id);
		if (query == null) {
			notifyService.addErrorMessage("Cannot find queries #" + id);
			return "redirect:/";
		}
		model.addAttribute("queries", query);
		return "queries/view";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String displayAddQueryForm(Model model) {
		model.addAttribute("title", "Add Query");
		model.addAttribute(new Query());
		model.addAttribute("categories", categoryDao.findAll());
		return "queries/add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String processAddQueryForm(@ModelAttribute @Valid Query newQuery, @RequestParam int categoryId,
			Errors errors, Model model) {

		if (errors.hasErrors()) {
			model.addAttribute("title", "Add Query");
			return "queries/add";
		}

		Category cat = categoryDao.findById(categoryId).get();
		newQuery.setCategory(cat);
		queryDao.save(newQuery);
		return "redirect:";
	}

	@RequestMapping(value = "remove", method = RequestMethod.GET)
	public String displayRemoveQueryForm(Model model) {
		model.addAttribute("queries", queryDao.findAll());
		model.addAttribute("title", "Remove Cheese");
		return "cheese/remove";
	}

	@RequestMapping(value = "remove", method = RequestMethod.POST)
	public String processRemoveQueryForm(@RequestParam int[] queryIds) {

		for (int queryId : queryIds) {
			queryDao.deleteById(queryId);
		}

		return "redirect:";
	}

	@RequestMapping(value = "edit/{queryId}", method = RequestMethod.GET)
	public String displayEditQueryForm(Model model, @PathVariable int queryId) {

		model.addAttribute("title", "Edit Query");
		model.addAttribute("query", queryDao.findById(queryId));
		model.addAttribute("categories", categoryDao.findAll());
		return "queries/edit";
	}

	@RequestMapping(value = "edit/{queryId}", method = RequestMethod.POST)
	public String processEditForm(Model model, @PathVariable int queryId, @ModelAttribute @Valid Query newQuery,
			@RequestParam int categoryId, Errors errors) {

		if (errors.hasErrors()) {
			model.addAttribute("title", "Add Query");
			return "queries/edit";
		}

		Query editedQuery = queryDao.findById(queryId).get();
		editedQuery.setTitle(newQuery.getTitle());
		editedQuery.setBody(newQuery.getBody());
		editedQuery.setCategory(categoryDao.findById(categoryId).get());
		queryDao.save(editedQuery);
		
		return "redirect:/queries";
	}

}