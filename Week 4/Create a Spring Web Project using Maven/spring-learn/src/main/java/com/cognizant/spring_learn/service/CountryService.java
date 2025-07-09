package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
    
    public Country getCountry(String code) {
        LOGGER.info("START - getCountry() method with code: {}", code);
        
        // Load the Spring XML configuration and get the country list
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        @SuppressWarnings("unchecked")
        List<Country> countryList = (List<Country>) context.getBean("countryList");
        
        // Find country using lambda expression with case insensitive matching
        Optional<Country> foundCountry = countryList.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst();
        
        ((ClassPathXmlApplicationContext) context).close();
        
        if (foundCountry.isPresent()) {
            LOGGER.info("END - getCountry() method - Country found: {}", foundCountry.get());
            return foundCountry.get();
        } else {
            LOGGER.info("END - getCountry() method - Country not found for code: {}", code);
            return null;
        }
    }
}
