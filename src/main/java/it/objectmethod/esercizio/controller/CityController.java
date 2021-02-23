package it.objectmethod.esercizio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.esercizio.entity.City;
import it.objectmethod.esercizio.repository.CityRepository;

@RestController
@RequestMapping("/api/city")
public class CityController {
	
	@Autowired
	private CityRepository cityRepo;
	
	@GetMapping("/{country-code}")
	public List<City> findCityByCountryCode(@PathVariable("country-code") String codiceNazione) {
		List<City> city = cityRepo.findByCountryCode(codiceNazione);

		return city;
	}
	
	@GetMapping("/get")
	public List<City> findCityByNameOrCountry(@RequestParam("nomeCitta") String citta, @RequestParam("codiceNazione") String codice) {
		List<City> city = cityRepo.findByNameOrCountryCode(citta, codice);
		 
		return city;
	}
	
	@GetMapping("/{id}/find")
	public ResponseEntity<City> findCityById(@PathVariable("id") Long id) {
		ResponseEntity<City> resp;
	
		try {
			City city = cityRepo.findById(id).get();
			resp = new ResponseEntity<>(city,HttpStatus.ACCEPTED);
		} catch (Exception e) {
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return resp;
	}
	
	@PutMapping("/save")
	public City save(@RequestBody City c) {
		City city;
		try {
			city = cityRepo.findById(c.getId()).get();
		} catch (Exception e) {
			city = new City();
		}
		
		city.setName(c.getName());
		city.setCountryCode(c.getCountryCode());
		city.setDistrict(c.getDistrict());
		city.setPopulation(c.getPopulation());

		city = cityRepo.save(city);
		return city;
	}
}
