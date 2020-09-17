package com.example.baithi_module4.service;

import com.example.baithi_module4.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CityService {
    Iterable<City> findAll();

    Page<City> findAll(Pageable pageInfo);

    Page<City> search(String keyword, Pageable pageInfo);

    void delete(Long id);

    City findById(Long id);


    City save(City city);

    List<City> save(List<City> cities);

    boolean exists(Long id);

    List<City> search(String keyword);

    List<City> findAll(List<Long> ids);

    long count();

    void delete(City city);

    void delete(List<City> cities);

    void deleteAll();
}
