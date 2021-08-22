package com.atm.atmloc.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AtmAddressDto {

	String street;
	String housenumber;
	String postalcode;
	String city;
	GeoLocationDto geoLocation;
}
