package com.gagantk.mqtt.fuelevent;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gagantk.mqtt.fuelevent.service.FuelEventService;

@SpringBootApplication
public class FuelEventApplication implements CommandLineRunner {
	
	@Autowired
	private FuelEventService fuelEventService;

	public static void main(String[] args) {
		SpringApplication.run(FuelEventApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		while (true) {
			fuelEventService.publishRandomEvent();
			TimeUnit.SECONDS.sleep(120);
		}
	}

}
