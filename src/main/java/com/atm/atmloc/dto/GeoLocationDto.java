package com.atm.atmloc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GeoLocationDto {

	@JsonProperty("lat")
	String latitude;
	
	@JsonProperty("lng")
	String longitude;
}
