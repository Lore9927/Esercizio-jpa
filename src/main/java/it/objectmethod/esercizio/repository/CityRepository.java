package it.objectmethod.esercizio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.objectmethod.esercizio.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

	@Query(value = "SELECT c FROM City c WHERE (c.name LIKE CONCAT('%', ?1, '%') OR '' = ?1) AND (c.countryCode = ?2 OR '' = ?2)")
	public List<City> findByNameOrCountryCode(String name, String code);
	
	public List<City> findByCountryCode(String code);
}
