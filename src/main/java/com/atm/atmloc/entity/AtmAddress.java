package com.atm.atmloc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "atm_addresses", schema = "atms")
public class AtmAddress {

	@Id
	private Integer addressId;
	private String street;
	private String housenumber;
	private String postalcode;
	private String city;
	private String latitude;
	private String longitude;
}
