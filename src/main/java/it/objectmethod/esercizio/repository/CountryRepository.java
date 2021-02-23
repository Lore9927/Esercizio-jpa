package it.objectmethod.esercizio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.objectmethod.esercizio.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

	public List<Country> findByContinent(String continent);
}
