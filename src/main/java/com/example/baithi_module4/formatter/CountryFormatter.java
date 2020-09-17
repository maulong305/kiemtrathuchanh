package com.example.baithi_module4.formatter;

import com.example.baithi_module4.model.Country;
import com.example.baithi_module4.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CountryFormatter implements Formatter<Country> {
    private CountryService countryService;

    @Autowired
    public CountryFormatter(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public Country parse(String text, Locale locale) throws ParseException {
        return countryService.findById(Long.valueOf(text));
    }

    @Override
    public String print(Country object, Locale locale) {
        return object.toString();
    }
}
