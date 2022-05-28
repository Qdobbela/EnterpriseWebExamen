package com.examen.fifa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.VoetbalService;
import service.VoetbalServiceImpl;

@RestController
@RequestMapping(value="/fifaDetail")
public class FifaRestController {
	
	private VoetbalService voetbalService = new VoetbalServiceImpl();

	@GetMapping(value="/{id}")
	public String[] getWedstrijd(@PathVariable String id) {
		
		String[] landen =  voetbalService.getWedstrijd(id).getWedstrijd().getLanden();
		return landen;
	}
}
