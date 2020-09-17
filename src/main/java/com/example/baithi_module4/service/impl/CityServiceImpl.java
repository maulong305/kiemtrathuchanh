package com.example.baithi_module4.service.impl;

import com.example.baithi_module4.model.City;
import com.example.baithi_module4.repository.CityRepository;
import com.example.baithi_module4.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findById(Long id) {
        Optional<City> test = cityRepository.findById(id);
        return test.orElse(null);
    }

    @Override
    public Page<City> findAll(Pageable pageInfo) {
        return cityRepository.findAll(pageInfo);
    }

    @Override
    public List<City> search(String keyword) {
        Iterable<City> searchResult = cityRepository
                .findAllByNameContains(keyword);
        return streamAll(searchResult).collect(Collectors.toList());
    }

    @Override
    public Page<City> search(String keyword, Pageable pageInfo) {
        return cityRepository
                .findAllByNameContains(keyword, pageInfo);
    }


    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public List<City> save(List<City> cities) {

        for(City city:cities){
            cityRepository.save(city);

        }
        return cities;
    }

    @Override
    public boolean exists(Long id) {
        return cityRepository.existsById(id);
    }

    @Override
    public List<City> findAll(List<Long> ids) {

        List<City> cityList = new ArrayList<>();
        for (Long id: ids){
            Optional<City> city = cityRepository.findById(id);
            if (city.isPresent())
            {
                cityList.add(city.get());
            }
        }

        return cityList;
    }

    @Override
    public long count() {
        return cityRepository.count();
    }

    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public void delete(City city) {
        cityRepository.delete(city);
    }

    @Override
    public void delete(List<City> cities) {
        cityRepository.deleteAll(cities);
    }

    @Override
    public void deleteAll() {
        cityRepository.deleteAll();
    }

    private Stream<City> streamAll() {
        return StreamSupport.stream(cityRepository.findAll().spliterator(), false);
    }

    private Stream<City> streamAll(Iterable<City> cities) {
        return StreamSupport.stream(cities.spliterator(), false);
    }
}
