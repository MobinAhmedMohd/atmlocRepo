package com.atm.atmloc.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.atm.atmloc.dto.AtmAddressDto;
import com.atm.atmloc.dto.AtmDetailsLocDTO;
import com.atm.atmloc.dto.AtmOperatingHoursDto;
import com.atm.atmloc.dto.AtmOperatingsDto;
import com.atm.atmloc.dto.GeoLocationDto;
import com.atm.atmloc.serice.impl.AtmDetailsServiceImpl;

public class AtmDetailsControllerTest {

	@InjectMocks
	AtmDetailsController atmDetailsController;
	
	@Mock
	AtmDetailsServiceImpl atmDetailsService;
	
	List<AtmDetailsLocDTO> atmDetailsDtos = new ArrayList<>();
	
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		AtmDetailsLocDTO atmDetailsDto = new AtmDetailsLocDTO();
		GeoLocationDto geoLocationDto = new GeoLocationDto();
		geoLocationDto.setLatitude("53.456");
		geoLocationDto.setLongitude("23.45");
		
		AtmAddressDto atmAddressDto = new AtmAddressDto();
		atmAddressDto.setCity("Hyderabad");
		atmAddressDto.setGeoLocation(geoLocationDto);
		atmAddressDto.setHousenumber("2-4-123/65");
		atmAddressDto.setPostalcode("500039");
		atmAddressDto.setStreet("Uppal");
		
		atmDetailsDto.setAddress(atmAddressDto);
		List<AtmOperatingsDto> atmOperatingsDtos = new ArrayList<>();
		AtmOperatingsDto oprDet = new AtmOperatingsDto();
		oprDet.setDayOfWeek(1);
		List<AtmOperatingHoursDto> atmoperatingsHrs = new ArrayList<>();
		AtmOperatingHoursDto atmOperatingHoursDto = new AtmOperatingHoursDto();
		atmOperatingHoursDto.setHourFrom("07:00");
		atmOperatingHoursDto.setHourTo("23:00");
		atmoperatingsHrs.add(atmOperatingHoursDto);
		
		oprDet.setHours(atmoperatingsHrs);
		atmOperatingsDtos.add(oprDet);
		atmDetailsDto.setOperatings(atmOperatingsDtos);
		atmDetailsDtos.add(atmDetailsDto);
	}
	
	@Test
	void testGetAllAtmDetails() throws Exception{
		when(atmDetailsService.getAtmDetails()).thenReturn(atmDetailsDtos);
		List<AtmDetailsLocDTO> atmAddressDtoList = atmDetailsController.getAtmDetails(null);
		assertEquals(atmDetailsDtos, atmAddressDtoList);
		
		when(atmDetailsService.getAtmDetailsOnCity("Test")).thenReturn(atmDetailsDtos);
		List<AtmDetailsLocDTO> atmAddressDtoList1 = atmDetailsController.getAtmDetails("Test");
		assertEquals(atmDetailsDtos, atmAddressDtoList1);
		
	}

}
