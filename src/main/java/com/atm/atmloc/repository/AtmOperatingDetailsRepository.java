package com.atm.atmloc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atm.atmloc.entity.AtmOperatingDetails;

public interface AtmOperatingDetailsRepository extends JpaRepository<AtmOperatingDetails, Integer>{

	//@Query(value = "SELECT aod FROM AtmOperatingDetails AS aod WHERE aod.atmId = :atmId")
	List<AtmOperatingDetails> findByAtmId(Integer atmId);
	
}
