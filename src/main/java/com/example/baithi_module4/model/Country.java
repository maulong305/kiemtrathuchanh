package com.example.baithi_module4.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @OneToMany(mappedBy = "country")
//    private Set<City> cities;

    public Country() {
    }

    public Country(String name) {
        this.name = name;
    }

    public Country(Long id, String name) {
        this.name = name;
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
}
