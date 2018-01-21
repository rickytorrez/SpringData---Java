package com.project.Lookify.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.List;

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

import com.project.Lookify.services.LookifyService;

import com.project.Lookify.controllers.*;
import com.project.Lookify.services.*;
import com.project.Lookify.models.*;
import java.util.ArrayList;
import java.util.Collections;


@Controller
@RequestMapping("/*") // Wildcard all routes.
public class Router{
		private LookifyService lookifyService;

		public Router(LookifyService lookifyService){
			this.lookifyService = lookifyService;
		}

	@RequestMapping("index")
	public String index(){
		return "index";
	}

	@RequestMapping("dashboard")
	public String dashboard(@ModelAttribute("lookify") Lookify lookify, Model model){
		ArrayList<Lookify>lookify1 = lookifyService.all();
		model.addAttribute("lookify", lookify1);
		return "dashboard";
	}

	@RequestMapping("newAdd")
	public String newAdd(){
		return "newAdd";
	}

	@PostMapping("newSong")
	public String newSong(
		@RequestParam("title") String title, 
		@RequestParam("artist") String artist, 	
		@RequestParam("rating") int rating,
		Model model){
			Lookify lookify = new Lookify(title, artist, rating);
			lookifyService.create(lookify);
			// long id = (lookify.getId());
			return "redirect:/dashboard";
	}


	@RequestMapping("/display/{id}")
	public String display(@PathVariable("id") long id, Model model){
		Lookify lookify = lookifyService.findById(id);
		model.addAttribute("lookify", lookify);
		return "display";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id){
		lookifyService.delete(id);
		return "redirect:/dashboard";
	}

	@RequestMapping("topTen")
	public String topTen(Model model){
		List<Lookify> songs=lookifyService.findTopTen();
		model.addAttribute("songs", songs);
		return "topTen";
	}

	@PostMapping("search")
	public String search(@RequestParam(value="search")String search, Model model){
		System.out.println(search);
		model.addAttribute("lookify", lookifyService.findByArtist(search));
		return "search";
	}













	@RequestMapping("")
	public String redirect(HttpServletRequest req){		
		String url = req.getRequestURI().toString();
		return "redirect:/index";
	}







}
