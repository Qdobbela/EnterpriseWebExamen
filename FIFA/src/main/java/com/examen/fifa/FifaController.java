package com.examen.fifa;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import domain.Aankoop;
import domain.Stadium;
import domain.WedstrijdTicket;
import service.VoetbalService;
import validation.AankoopValidation;

@Controller
public class FifaController {

	@Autowired
	private VoetbalService voetbalService;
	
	@Autowired
	private AankoopValidation aankoopValidation;
	
	@GetMapping("/fifa")
	public String showChooseStadium(Model model) {
		model.addAttribute("stadia", voetbalService.getStadiumList());
		model.addAttribute("stadium", new Stadium());
		return "chooseStadium";
	}
	
	@PostMapping("/fifa")
	public String onVoerUit(@ModelAttribute Stadium stadium, Model model) {
		model.addAttribute("stadium", stadium);
		model.addAttribute("wedstrijden", voetbalService.getWedstrijdenByStadium(stadium.getName()));
		return "matchOverview";
	}
	
	@GetMapping("fifa/{id}")
	public String toonWedstrijd(@PathVariable String id, Model model) {

		WedstrijdTicket wedT = voetbalService.getWedstrijd(id);
		if(wedT.getTickets() == 0) {
			return "redirect:/fifa?gekocht=0";
		}
		
		model.addAttribute("wedstrijd", wedT);
		model.addAttribute("aankoop", new Aankoop());
		return "koopTickets"; 
	}
	
	@PostMapping("fifa/{id}")
	public String onKoop(@Valid Aankoop aankoop, BindingResult result, @PathVariable String id, Model model, Locale locale) {
		
		aankoopValidation.validate(aankoop, result);
		if(result.hasErrors()) {
			
			model.addAttribute("wedstrijd", voetbalService.getWedstrijd(id));
			
			return "koopTickets";
		}
		
		int gekocht = voetbalService.getWedstrijd(id).ticketsKopen(aankoop.getAantal());
		
		return  "redirect:/fifa?gekocht=" + gekocht;
	}
	 
}
