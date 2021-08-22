package com.atm.atmloc.serice.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atm.atmloc.dto.AtmAddressDto;
import com.atm.atmloc.dto.AtmDetailsLocDTO;
import com.atm.atmloc.dto.AtmOperatingHoursDto;
import com.atm.atmloc.dto.AtmOperatingsDto;
import com.atm.atmloc.dto.GeoLocationDto;
import com.atm.atmloc.entity.AtmAddress;
import com.atm.atmloc.entity.AtmDetails;
import com.atm.atmloc.entity.AtmOperatingDetails;
import com.atm.atmloc.repository.AtmAddressRepository;
import com.atm.atmloc.repository.AtmDetailsRepository;
import com.atm.atmloc.repository.AtmOperatingDetailsRepository;
import com.atm.atmloc.service.AtmDetailsService;
import com.atm.atmloc.utils.ConvertUtils;

@Service
public class AtmDetailsServiceImpl implements AtmDetailsService {
	
	@Autowired
	AtmDetailsRepository atmDetailsRepo;
	
	@Autowired
	AtmAddressRepository atmAddressRepo;
	
	@Autowired
	AtmOperatingDetailsRepository atmOperatingDetailsRepo;

	@Override
	public List<AtmDetailsLocDTO> getAtmDetails() {
		List<AtmDetails> atmDetails = atmDetailsRepo.findAll();
		return fetchAtmDetailsDtoFromListAtmDetails(atmDetails);
	}

	@Override
	public List<AtmDetailsLocDTO> getAtmDetailsOnCity(String cityName) {
		List<AtmDetails> atmDetails = atmDetailsRepo.getAtmDetailsOnCityName(cityName);
		return fetchAtmDetailsDtoFromListAtmDetails(atmDetails);
	}
	
	private List<AtmDetailsLocDTO> fetchAtmDetailsDtoFromListAtmDetails(List<AtmDetails> atmDetails){
		List<AtmDetailsLocDTO> atmDetailslocs = new ArrayList<>();
		List<AtmAddress> atmAddresses = null;
		if(!atmDetails.isEmpty()) {
			List<Integer> addressIds = atmDetails.stream().map(AtmDetails::getAddressId).collect(Collectors.toList());
			atmAddresses = atmAddressRepo.getAddressOnIds(addressIds);
			Map<Integer, AtmAddress> addressMap = ConvertUtils.convertToMap(atmAddresses, AtmAddress::getAddressId);
			
			for(AtmDetails atmDetail: atmDetails) {
				atmDetailslocs.add(getAtmDetailsDtoFromEntity(atmDetail, addressMap));
			}
			
		}
		return atmDetailslocs;
	}
	
	private AtmDetailsLocDTO getAtmDetailsDtoFromEntity(AtmDetails atmDetails, Map<Integer, AtmAddress> addressMap) {
		AtmDetailsLocDTO atmDetailsLocDto = new AtmDetailsLocDTO();
		atmDetailsLocDto.setDistance(atmDetails.getDistance());
		atmDetailsLocDto.setFunctionality(atmDetails.getFunctionality());
		atmDetailsLocDto.setType(atmDetails.getType());
		
		AtmAddress atmAddress = addressMap.get(atmDetails.getAddressId());
		AtmAddressDto atmAddressDto = getAtmAddressDtoFromEntity(atmAddress);
		atmDetailsLocDto.setAddress(atmAddressDto);
		atmDetailsLocDto.setOperatings(getAtmOperatingDetailsOnAtmId(atmDetails.getAtmId()));
		return atmDetailsLocDto;
		
	}
	
	private AtmAddressDto getAtmAddressDtoFromEntity(AtmAddress atmAddress) {
		AtmAddressDto addrDto = new AtmAddressDto();
		addrDto.setStreet(atmAddress.getStreet());
		addrDto.setHousenumber(atmAddress.getHousenumber());
		addrDto.setPostalcode(atmAddress.getPostalcode());
		addrDto.setCity(atmAddress.getCity());
		GeoLocationDto geoLocationDto = new GeoLocationDto();
		geoLocationDto.setLatitude(atmAddress.getLatitude());
		geoLocationDto.setLongitude(atmAddress.getLongitude());
		addrDto.setGeoLocation(geoLocationDto);
		
		return addrDto;
		
		
	}
	
	private List<AtmOperatingsDto> getAtmOperatingDetailsOnAtmId(Integer atmId) {
		List<AtmOperatingsDto> atmOperatingsDtos = new ArrayList<>();
		List<AtmOperatingDetails> atmOperatingDetails = atmOperatingDetailsRepo.findByAtmId(atmId);
		Map<Integer, List<AtmOperatingDetails>> atmOperatingDetailsMapOnday = ConvertUtils.convertToMapWithList(atmOperatingDetails, AtmOperatingDetails::getDayOfWeek);
		atmOperatingDetailsMapOnday.forEach((x, y) -> {
			AtmOperatingsDto atmOperatingsDto = new AtmOperatingsDto();
			atmOperatingsDto.setDayOfWeek(x);
			List<AtmOperatingHoursDto> atmOperatingHoursDtos = new ArrayList<>();
			for(AtmOperatingDetails atmOperatingDetail: y) {
				AtmOperatingHoursDto atmOperatingHoursDto = new AtmOperatingHoursDto();
				atmOperatingHoursDto.setHourFrom(atmOperatingDetail.getHourFrom());
				atmOperatingHoursDto.setHourTo(atmOperatingDetail.getHourTo());
				atmOperatingHoursDtos.add(atmOperatingHoursDto);
			}
			atmOperatingsDto.setHours(atmOperatingHoursDtos);
			atmOperatingsDtos.add(atmOperatingsDto);
		});
		
		return atmOperatingsDtos;
	}
	
}
