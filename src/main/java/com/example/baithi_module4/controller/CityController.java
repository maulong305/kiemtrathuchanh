package com.example.baithi_module4.controller;

import com.example.baithi_module4.model.City;
import com.example.baithi_module4.model.Country;
import com.example.baithi_module4.repository.CityRepository;
import com.example.baithi_module4.service.CityService;
import com.example.baithi_module4.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("cities")
public class CityController {
    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @ModelAttribute("countries")
    public Iterable<Country> allCountries() {
        return countryService.findAll();
    }

    @GetMapping
    public ModelAndView showList(Optional<String> s, Pageable pageInfo) {
        ModelAndView modelAndView = new ModelAndView("cities/list");
        Page<City> cities = s.isPresent() ? search(s, pageInfo) : getPage(pageInfo);
        modelAndView.addObject("keyword", s.orElse(null));
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @GetMapping("{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("cities/info");
        City city = cityService.findById(id);
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @PostMapping
    public String updateCustomer(City city) {
        cityService.save(city);
        return "redirect:/cities";
    }

    private Page<City> getPage(Pageable pageInfo) {
        return cityService.findAll(pageInfo);
    }

    private Page<City> search(Optional<String> s, Pageable pageInfo) {
        return cityService.search(s.get(), pageInfo);
    }

    @GetMapping("/create-city")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/cities/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }


    @PostMapping("/create-city")
    public ModelAndView saveCity(@Validated @ModelAttribute("city")City city, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("cities/create");
            modelAndView.addObject("message", "You entered incorrectly, please re-enter");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("cities/create");
        cityService.save(city);
        modelAndView.addObject("city", new City());
        modelAndView.addObject("message", "Created Successfully");
        return modelAndView;
    }

    @GetMapping("/edit-city/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        City city = cityService.findById(id);
        if(city != null) {
            ModelAndView modelAndView = new ModelAndView("/cities/edit");
            modelAndView.addObject("city", city);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        }
    }



    @PostMapping("/edit-city")
    public ModelAndView updateProvince(@Validated @ModelAttribute("city") City city,BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("cities/edit");
            modelAndView.addObject("message", "You entered incorrectly, please re-enter");
            return modelAndView;
        }
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("cities/edit");
        Iterable<City> cities= cityService.findAll();;
        modelAndView.addObject("city", city);
        modelAndView.addObject("message", "Update Successfully");
        return modelAndView;
    }

    @GetMapping("/delete-city/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        City city = cityService.findById(id);
        if(city != null) {
            ModelAndView modelAndView = new ModelAndView("/cities/delete");
            modelAndView.addObject("city", city);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        }
    }

    @PostMapping("/delete-city")
    public String deleteCity(@ModelAttribute("city") City city){
        cityService.delete(city.getId());
        return "redirect:/cities";
    }
}
