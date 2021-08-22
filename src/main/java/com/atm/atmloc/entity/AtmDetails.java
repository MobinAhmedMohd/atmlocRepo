package com.atm.atmloc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "atm_details", schema="atms")
public class AtmDetails {

	@Id
	private Integer atmId;
	
	private Integer distance;
	private Integer addressId;
	private String functionality;
	private String type;
}
