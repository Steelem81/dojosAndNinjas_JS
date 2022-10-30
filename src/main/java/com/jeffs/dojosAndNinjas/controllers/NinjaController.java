package com.jeffs.dojosAndNinjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jeffs.dojosAndNinjas.models.Ninja;
import com.jeffs.dojosAndNinjas.services.DojoService;
import com.jeffs.dojosAndNinjas.services.NinjaService;

@Controller
public class NinjaController {
	
	@Autowired
	private NinjaService ninjaServ;
	@Autowired
	private DojoService dojoServ;
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja")Ninja ninja, Model model) {
		model.addAttribute("allDojos", dojoServ.findAll());
		return "newNinja.jsp";
	}
	
	@PostMapping("/ninjas/create")
	public String createNinja(@ModelAttribute("ninja")Ninja ninja, BindingResult result) {
		ninjaServ.createNinja(ninja);
		return "redirect:/ninjas/new";
	}

}
