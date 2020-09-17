package com.example.baithi_module4.service.impl;

import com.example.baithi_module4.model.Country;
import com.example.baithi_module4.repository.CountryRepository;
import com.example.baithi_module4.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    private Stream<Country> streamAll() {
        return StreamSupport.stream(countryRepository.findAll().spliterator(), false);
    }

    private Stream<Country> streamAll(Iterable<Country> countries) {
        return StreamSupport.stream(countries.spliterator(), false);
    }

    @Override
    public List<Country> findAll() {
        return streamAll().collect(Collectors.toList());
    }
    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public void remove(Long id) {
        countryRepository.deleteById(id);
    }
    @Override
    public Country findById(Long id) {
        Optional<Country> find = countryRepository.findById(id);
        return find.orElse(null);
    }


}
