package com.atm.atmloc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.atm.atmloc.entity.AtmDetails;

public interface AtmDetailsRepository extends JpaRepository<AtmDetails, Integer>{

	@Query(value = "SELECT ad FROM AtmDetails AS ad WHERE ad.addressId IN (SELECT addr.addressId from AtmAddress AS addr WHERE addr.city = :city)")
	List<AtmDetails> getAtmDetailsOnCityName(@Param("city") String city);
	
	@Query(value = "SELECT ad FROM AtmDetails AS ad")
	List<AtmDetails> getAllAtmDetails();
	
}
