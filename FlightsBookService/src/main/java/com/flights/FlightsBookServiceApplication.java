package com.flights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.flights")
public class FlightsBookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightsBookServiceApplication.class, args);
	}
}
