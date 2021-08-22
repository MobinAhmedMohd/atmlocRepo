package com.atm.atmloc.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AtmOperatingsDto {

	Integer dayOfWeek;
	List<AtmOperatingHoursDto> hours;
}
