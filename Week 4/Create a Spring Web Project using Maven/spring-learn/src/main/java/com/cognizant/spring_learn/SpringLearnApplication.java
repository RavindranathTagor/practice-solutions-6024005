package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		// First run our displayCountry method
		displayCountry();
		
		// Then start the Spring Boot application
		SpringApplication.run(SpringLearnApplication.class, args);
	}

	/**
	 * Method to read country bean from spring configuration file and display country details
	 */
	public static void displayCountry() {
		LOGGER.debug("Starting displayCountry() method.");
		
		// Load the Spring configuration file
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		
		// Get the country bean from the context
		Country country = (Country) context.getBean("country", Country.class);
		
		// Display the country details
		LOGGER.debug("Country : {}", country.toString());
		
		// Close the context (good practice for ClassPathXmlApplicationContext)
		((ClassPathXmlApplicationContext) context).close();
		
		LOGGER.debug("Completed displayCountry() method.");
	}

}
