package com.gagantk.mqtt.fuelevent.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class MqttException extends RuntimeException {
	
	public MqttException(String message) {
		super(message);
	}

}
