package com.atm.atmloc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "atm_operating_details", schema = "atms")
@Setter
@Getter
public class AtmOperatingDetails {

	@Id
	private Integer operatingId;
	
	private Integer atmId;
	private Integer dayOfWeek;
	private String hourFrom;
	private String hourTo;
}
