package com.coronavirus.coronatrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoronaTrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronaTrackApplication.class, args);
	}

}
