package com.project.GroupLanguages.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.project.GroupLanguages.models.*;
import com.project.GroupLanguages.services.*;

@Controller
@RequestMapping("/*") // Wildcard all routes.
public class Router{
	private LanguageService languageService;
	
	public Router(LanguageService languageService){
		this.languageService = languageService;
	}
	
	// Routes to the index (home) file
	@RequestMapping("/")
	public String index(@ModelAttribute("language") Languages language, Model model){
		ArrayList<Languages>languages = languageService.all();
		model.addAttribute("languages", languages);
		return "index";
	}
	
	// Method to create a new language
	// Post Route uses @Request Param to ret parameters
	@PostMapping("/kittykatlicklick")
	public String createLanguage(
		@RequestParam("name") String name, 
		@RequestParam("creator") String creator, 	
		@RequestParam("version") double version){
			Languages language = new Languages(name, creator, version);
			languageService.create(language);
			return "redirect:/";
	}

	// Route that sends you to the edit {id} page
	// Pass findById from LanguageServices
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") long id, Model model){
		Languages language = languageService.findById(id);
		model.addAttribute("language", language);
		return "/edit";
	}

	// Method that lets record be updated
	// Use @PathVariable to be able to locate the record by id number
	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") long id, Languages language){
		languageService.edit(language);
		return "redirect:/";
	}

	// Method that lets record be deleted
	// Use @PathVariable to be able to locate the record by id number
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id){
		languageService.delete(id);
		return "redirect:/";
	}

	// Method that lets record be viewed in its separate page
	// Use @PathVariable to be able to locate the record by id number
	@RequestMapping("/info/{id}")
	public String info(@PathVariable("id") long id, Model model){
		Languages language = languageService.findById(id);
		model.addAttribute("languages", language);
		return "info";
	}

	// Find out what this is doing
	@RequestMapping("")
	public String redirect(HttpServletRequest req){		
		String url = req.getRequestURI().toString();
		return "redirect:/index";
	}		
}
