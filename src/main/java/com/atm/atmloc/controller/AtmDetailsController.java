package com.atm.atmloc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atm.atmloc.dto.AtmDetailsLocDTO;
import com.atm.atmloc.service.AtmDetailsService;

@RestController
public class AtmDetailsController {

	@Autowired
	private AtmDetailsService atmDetailsService;
	
	@GetMapping(value = "/atmdetails")
	public List<AtmDetailsLocDTO> getAtmDetails(@RequestParam(value = "city", required = false) String cityName){
		if(cityName != null && cityName.trim().length() > 0) {
			return atmDetailsService.getAtmDetailsOnCity(cityName);
		}else {
			return atmDetailsService.getAtmDetails();
		}
	}

}
