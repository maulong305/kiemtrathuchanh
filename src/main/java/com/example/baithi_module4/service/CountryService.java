package com.example.baithi_module4.service;

import com.example.baithi_module4.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> findAll();
    Country findById(Long id);
    Country save(Country country);
    void remove(Long id);
}
