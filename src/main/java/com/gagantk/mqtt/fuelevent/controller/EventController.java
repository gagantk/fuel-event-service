package com.gagantk.mqtt.fuelevent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gagantk.mqtt.fuelevent.exceptions.ExceptionMessages;
import com.gagantk.mqtt.fuelevent.exceptions.MqttException;
import com.gagantk.mqtt.fuelevent.model.FuelEvent;
import com.gagantk.mqtt.fuelevent.service.FuelEventService;

@RestController
public class EventController {
	
	@Autowired
	public FuelEventService fuelEventService;
	
	@PostMapping("/api/publish")
	public void publishEventFromAPI(@RequestBody FuelEvent fuelEvent, BindingResult bindingResult) throws JsonProcessingException, org.eclipse.paho.client.mqttv3.MqttException {
		if (bindingResult.hasErrors()) {
			throw new MqttException(ExceptionMessages.INVALID_PARAMETERS);
		}
		fuelEventService.publishEvent(fuelEvent);
	}
	
	

}
