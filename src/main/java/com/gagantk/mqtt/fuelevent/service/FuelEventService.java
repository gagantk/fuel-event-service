package com.gagantk.mqtt.fuelevent.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gagantk.mqtt.fuelevent.config.MqttConfig;
import com.gagantk.mqtt.fuelevent.model.FuelEvent;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FuelEventService {

	public static final List<String> cities = Arrays.asList("Agartala", "Aizawl", "Ambala", "Bangalore", "Bhopal",
			"Chandigarh", "Chennai", "Daman", "Dehradun", "Faridabad", "Gandhinagar", "Gangtok", "Ghaziabad", "Gurgaon",
			"Guwahati", "Hyderabad", "Imphal", "Itanagar", "Jaipur", "Jalandhar", "Jammu", "Kohima", "Kolkata",
			"Lucknow", "Mumbai", "New Delhi", "Noida", "Panjim", "Patna", "Port Blair", "Ranchi", "Shillong", "Shimla",
			"Silvassa", "Srinagar", "Trivandrum");
	public static final List<Boolean> fuelLidEvents = Arrays.asList(true, false);

	public void publishEvent(FuelEvent fuelEvent)
			throws org.eclipse.paho.client.mqttv3.MqttException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String event = mapper.writeValueAsString(fuelEvent);
		log.debug(event);
		MqttMessage mqttMessage = new MqttMessage(event.getBytes());
		mqttMessage.setQos(0);
		mqttMessage.setRetained(true);
		MqttConfig.getMqttClient().publish("fuel", mqttMessage);
	}

	public void publishRandomEvent() throws JsonProcessingException, org.eclipse.paho.client.mqttv3.MqttException {
		Random random = new Random();
		String city = cities.get(random.nextInt(cities.size()));
		Boolean fuelLid = fuelLidEvents.get(random.nextInt(fuelLidEvents.size()));
		FuelEvent fuelEvent = new FuelEvent(fuelLid, city);
		publishEvent(fuelEvent);
	}

}
