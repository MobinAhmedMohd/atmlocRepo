package com.atm.atmloc.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AtmDetailsLocDTO {

	Integer distance;
	String functionality;
	String type;
	AtmAddressDto address;
	@JsonProperty("openingHours")
	List<AtmOperatingsDto> operatings;
	
}
