package com.atm.atmloc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.atm.atmloc.entity.AtmAddress;

public interface AtmAddressRepository extends JpaRepository<AtmAddress, Integer> {

	@Query(value = "SELECT addr FROM AtmAddress AS addr WHERE addr.addressId IN :addressIds")
	List<AtmAddress> getAddressOnIds(@Param("addressIds") List<Integer> addressIds);
}
