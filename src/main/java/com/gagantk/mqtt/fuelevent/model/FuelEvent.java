package com.gagantk.mqtt.fuelevent.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Fuel Event details")
public class FuelEvent {

	@ApiModelProperty(notes="Indicates fuelLid is open or close, should be true or false")
	private Boolean fuelLid;
	
	@ApiModelProperty(notes="Any Indian city name")
	private String city;

	public Boolean getFuelLid() {
		return fuelLid;
	}

	public void setFuelLid(Boolean fuelLid) {
		this.fuelLid = fuelLid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public FuelEvent(Boolean fuelLid, String city) {
		super();
		this.fuelLid = fuelLid;
		this.city = city;
	}

	@Override
	public String toString() {
		return "FuelEvent [fuelLid=" + fuelLid + ", city=" + city + "]";
	}

}
