package com.atm.atmloc.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.atm.atmloc.dto.AtmDetailsLocDTO;
import com.atm.atmloc.entity.AtmAddress;
import com.atm.atmloc.entity.AtmDetails;
import com.atm.atmloc.entity.AtmOperatingDetails;
import com.atm.atmloc.repository.AtmAddressRepository;
import com.atm.atmloc.repository.AtmDetailsRepository;
import com.atm.atmloc.repository.AtmOperatingDetailsRepository;
import com.atm.atmloc.serice.impl.AtmDetailsServiceImpl;

public class AtmDetailsServiceImplTest {

	@InjectMocks
	AtmDetailsServiceImpl atmDetailsService;
	
	@Mock
	AtmAddressRepository addressRepo;
	
	@Mock
	AtmDetailsRepository atmDetailsRepo;
	
	@Mock
	AtmOperatingDetailsRepository atmOperatingDetailsRepo;
	
	List<AtmDetails> atmsDetList = new ArrayList<>();
	List<AtmAddress> atmAddressList = new ArrayList<>();
	List<AtmOperatingDetails> atmOperatingDetailsList = new ArrayList<>();
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		
		AtmDetails atmDetails = new AtmDetails();
		atmDetails.setAtmId(1);
		atmDetails.setAddressId(1);
		atmDetails.setDistance(0);
		atmDetails.setFunctionality("Functionality");
		atmDetails.setType("Type");
		
		atmsDetList.add(atmDetails);
		
		AtmAddress atmAddress = new AtmAddress();
		
		atmAddress.setCity("Hyderabad");
		atmAddress.setHousenumber("2-4-123/65");
		atmAddress.setPostalcode("500039");
		atmAddress.setStreet("Uppal");
		atmAddress.setAddressId(1);
		atmAddress.setLatitude("53.456");
		atmAddress.setLongitude("23.45");
		
		atmAddressList.add(atmAddress);
		
		
		AtmOperatingDetails atmOperationDetails1 = new AtmOperatingDetails();
		atmOperationDetails1.setAtmId(1);
		atmOperationDetails1.setOperatingId(1);
		atmOperationDetails1.setDayOfWeek(1);
		atmOperationDetails1.setHourFrom("07:00");
		atmOperationDetails1.setHourTo("23:00");
		atmOperatingDetailsList.add(atmOperationDetails1);
		
		AtmOperatingDetails atmOperationDetails2 = new AtmOperatingDetails();
		atmOperationDetails2.setAtmId(1);
		atmOperationDetails2.setOperatingId(1);
		atmOperationDetails2.setDayOfWeek(1);
		atmOperationDetails2.setHourFrom("07:00");
		atmOperationDetails2.setHourTo("23:00");
		atmOperatingDetailsList.add(atmOperationDetails2);
		
		AtmOperatingDetails atmOperationDetails3 = new AtmOperatingDetails();
		atmOperationDetails3.setAtmId(1);
		atmOperationDetails3.setOperatingId(1);
		atmOperationDetails3.setDayOfWeek(1);
		atmOperationDetails3.setHourFrom("07:00");
		atmOperationDetails3.setHourTo("23:00");
		atmOperatingDetailsList.add(atmOperationDetails3);
		
		AtmOperatingDetails atmOperationDetails4 = new AtmOperatingDetails();
		atmOperationDetails4.setAtmId(1);
		atmOperationDetails4.setOperatingId(1);
		atmOperationDetails4.setDayOfWeek(1);
		atmOperationDetails4.setHourFrom("07:00");
		atmOperationDetails4.setHourTo("23:00");
		atmOperatingDetailsList.add(atmOperationDetails4);
		
		when(atmDetailsRepo.getAllAtmDetails()).thenReturn(atmsDetList);
		when(atmDetailsRepo.getAtmDetailsOnCityName("Test")).thenReturn(atmsDetList);
		List<Integer> addrIdList = Arrays.asList(1);
		when(addressRepo.getAddressOnIds(addrIdList)).thenReturn(atmAddressList);
		when(atmOperatingDetailsRepo.findByAtmId(1)).thenReturn(atmOperatingDetailsList);
		
	}
	
	@Test
	void testGetAtmDetail() {
		List<AtmDetailsLocDTO> atmDetailsList = atmDetailsService.getAtmDetails();
		assertNotNull(atmDetailsList);
	}
	
	@Test
	void testGetAtmDetailOnCity() {
		List<AtmDetailsLocDTO> atmDetailsList = atmDetailsService.getAtmDetailsOnCity("Test");
		assertNotNull(atmDetailsList);
	}
}
