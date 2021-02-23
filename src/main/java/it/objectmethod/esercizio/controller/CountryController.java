package it.objectmethod.esercizio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.esercizio.entity.Country;
import it.objectmethod.esercizio.repository.CountryRepository;

@RestController
@RequestMapping("/api/country")
public class CountryController {
	
	@Autowired
	private CountryRepository countryRep;
	
	@GetMapping("/continent")
	public List<Country> getContinents() {
		List<Country> conts = countryRep.findAll();

		return conts;
	}
	
	@GetMapping("/get-name")
	public List<Country> countryNameGet(@RequestParam("cont") String continente) {
		List<Country> country = countryRep.findByContinent(continente);

		return country;
	}
	
}

