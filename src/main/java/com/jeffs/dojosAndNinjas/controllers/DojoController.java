package com.jeffs.dojosAndNinjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.jeffs.dojosAndNinjas.models.Dojo;
import com.jeffs.dojosAndNinjas.services.DojoService;

@Controller
public class DojoController {
	
	@Autowired
	private DojoService dojoServ;
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo")Dojo dojo){
		return "index.jsp";
		
	}
	
	@PostMapping("/dojos/create")
	public String createDojo(@ModelAttribute("dojo")Dojo dojo, BindingResult result) {
		dojoServ.createDojo(dojo);
		return "redirect:/dojos/new";
	}
	
	@GetMapping("/dojos/{dojoId}")
	public String showDojo(@PathVariable(name="dojoId") Long id, Model model) {
		model.addAttribute("dojo", dojoServ.findDojo(id));
		return "showDojo.jsp";
	}

}
