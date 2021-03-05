package com.gagantk.mqtt.fuelevent.component;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.gagantk.mqtt.fuelevent.service.FuelEventService;

@Component
@Profile("!test")
public class MessageQueueLoader implements CommandLineRunner {

    @Autowired
    private FuelEventService fuelEventService;
    
    @Override
	public void run(String... args) throws Exception {
		while (true) {
			fuelEventService.publishRandomEvent();
			TimeUnit.SECONDS.sleep(120);
		}
	}

}
