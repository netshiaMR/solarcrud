package com.solar.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.solar.crud.model.MeterData;


public interface MeterDataRepository extends JpaRepository<MeterData, Long>{
	public Long findMaxId();
}
