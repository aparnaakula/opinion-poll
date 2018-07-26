package com.mycapstone.opinionpoll.controllers;

import com.mycapstone.opinionpoll.models.Category;
import com.mycapstone.opinionpoll.models.Query;
import com.mycapstone.opinionpoll.repositories.CategoryRepository;
import com.mycapstone.opinionpoll.repositories.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static com.mycapstone.opinionpoll.controllers.AbstractController.MESSAGE_KEY;

@Controller
public class QueryController {


	@Autowired
	private QueryRepository queryRepository;

	@Autowired
	private CategoryRepository categoryRepository;



    @GetMapping
    public String listEvents(Model model) {
        List<Query> allQueries = queryRepository.findAll();
        model.addAttribute("queries", allQueries);
        return "query/list";
        }

    @GetMapping(value = "create")
    public String displayCreateEventForm(Model model, HttpServletRequest request) {
        model.addAttribute(new Query());
        model.addAttribute("actionUrl", request.getRequestURI());
        model.addAttribute("title", "Create Query");
        model.addAttribute("categories", categoryRepository.findAll());
		return "query/create-or-update";
	}

    @PostMapping(value = "create")
    public String processAddQueryForm(@ModelAttribute @Valid Query query, Errors errors,
                                      @RequestParam(name = "categories", required = false) List<Integer> categoryUids
									  , Model model) {

		if (errors.hasErrors()) {
			model.addAttribute("title", "Add Query");
			return "query/create-or-update";
		}
		syncCategoryLists(categoryUids, query.getCategories());
		queryRepository.save(query);


		return "redirect:/query/detail/" + query.getUid();
	}
    @GetMapping(value = "detail/{uid}")
    public String displayQueryDetails(@PathVariable int uid, Model model) {

        model.addAttribute("title", "Event Details");

        Optional<Query> result = queryRepository.findById(uid);
        if (result.isPresent()) {
            Query query = result.get();
            model.addAttribute(query);
            model.addAttribute("CategoryNames", query.getCategoriessFormatted());
        } else {
            model.addAttribute(MESSAGE_KEY, "warning|No event found with id: " + Integer.toString(uid));
        }

        return "query/details";
    }
    @GetMapping(value = "update/{uid}")
    public String displayUpdateQueryForm(@PathVariable int uid, Model model, HttpServletRequest request) {

        model.addAttribute("title", "Update Event");
        model.addAttribute("actionUrl", request.getRequestURI());

        Optional<Query> query =queryRepository.findById(uid);
        if (query.isPresent()) {
            model.addAttribute(query.get());
            model.addAttribute("volunteers", categoryRepository.findAll());
        } else {
            model.addAttribute(MESSAGE_KEY, "warning|No event found with id: " + Integer.toString(uid));
        }

        return "query/create-or-update";
    }

    @PostMapping(value = "update/{uid}")
    public String processUpdateQueryForm(@Valid @ModelAttribute Query query,
                                         RedirectAttributes model,
                                         Errors errors,
                                         @RequestParam(name = "categories", required = false) List<Integer> categoryUids) {

        if (errors.hasErrors())
            return "query/create-or-update";

        syncCategoryLists(categoryUids, query.getCategories());
        queryRepository.save(query);
        model.addFlashAttribute(MESSAGE_KEY, "success|Updated Query: " + query.getTitle());

        return "redirect:/query/detail/" + query.getUid();
    }


    @PostMapping(value = "delete/{uid}")
    public String processDeleteQueryForm(@PathVariable int uid, RedirectAttributes model) {

        Optional<Query> result = queryRepository.findById(uid);
        if (result.isPresent()) {
            queryRepository.delete(result.get());
            model.addFlashAttribute(MESSAGE_KEY, "success|Event deleted");
            return "redirect:/query";
        } else {
            model.addFlashAttribute(MESSAGE_KEY, "danger|Event with ID does not exist: " +  uid);
            return "redirect:/query";
        }
    }

	private void syncCategoryLists(List<Integer> categoryUids, List<Category> categories) {

		if (categoryUids == null)
			return;

		List<Category> newCategoryList = (List<Category>) categoryRepository.findAllById(categoryUids);
		categories.removeIf(v -> categoryUids.contains(v.getUid()));
		categories.addAll(newCategoryList);
	}

}