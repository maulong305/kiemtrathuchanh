package com.example.baithi_module4.repository;

import com.example.baithi_module4.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepository extends PagingAndSortingRepository<City, Long> {
    Iterable<City> findAllByNameContains(String name);

    Page<City> findAllByNameContains(String name, Pageable pageInfo);

}
