package com.example.baithi_module4;

import com.example.baithi_module4.service.CityService;
import com.example.baithi_module4.service.CountryService;
import com.example.baithi_module4.service.impl.CityServiceImpl;
import com.example.baithi_module4.service.impl.CountryServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BaithiModule4Application {

	public static void main(String[] args) {
		SpringApplication.run(BaithiModule4Application.class, args);
	}

	@Bean
	public CityService cityService() {
		return new CityServiceImpl();
	}

	@Bean
	public CountryService countryService() {
		return new CountryServiceImpl();
	}


}
