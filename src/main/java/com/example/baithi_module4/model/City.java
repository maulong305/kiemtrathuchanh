package com.example.baithi_module4.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Cities")
public class City implements Cloneable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Not empty")
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Min(value = 1, message = "the area must be greater than 0")
    private Long area;

    @Min(value = 1, message = "Population must be greater than 0")
    private Long population;

    @Min(value = 1, message = "CDP must be greater than 0")
    private Long gdp;

    @NotEmpty(message = "Not empty")
    private String description;

    public City() {
    }

    public City(String name, Country country, Long area, Long population, Long gdp, String description) {
        this.name = name;
        this.country = country;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
    }

    public City(Long id, String name, Country country, Long area, Long population, Long gdp, String description) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Long getGdp() {
        return gdp;
    }

    public void setGdp(Long gdp) {
        this.gdp = gdp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public City clone() {
        City city = new City();
        city.setId(id);
        city.setName(name);
        city.setCountry(country);
        city.setArea(area);
        city.setPopulation(population);
        city.setGdp(gdp);
        city.setDescription(description);
        return city;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                ", area=" + area +
                ", population=" + population +
                ", gdp=" + gdp +
                ", description='" + description + '\'' +
                '}';
    }
}
