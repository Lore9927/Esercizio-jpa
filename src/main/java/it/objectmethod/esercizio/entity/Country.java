package it.objectmethod.esercizio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {
	
	@Id
	@Column(name = "Code")
	private String code;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Continent")
	private String continent;
	
	@Column(name = "Population")
	private Long population;
	
	@Column(name = "SurfaceArea")
	private Long surfaceArea;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public Long getPopulation() {
		return population;
	}
	public void setPopulation(Long population) {
		this.population = population;
	}
	public Long getSurfaceArea() {
		return surfaceArea;
	}
	public void setSurfaceArea(Long surfaceArea) {
		this.surfaceArea = surfaceArea;
	}
}
