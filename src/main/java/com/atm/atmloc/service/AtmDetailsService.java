package com.atm.atmloc.service;

import java.util.List;

import com.atm.atmloc.dto.AtmDetailsLocDTO;

public interface AtmDetailsService {

	List<AtmDetailsLocDTO> getAtmDetails();
	
	List<AtmDetailsLocDTO> getAtmDetailsOnCity(String cityName);
}
