package com.solar.crud.solarcrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.solar.crud.solarcrud.model.Meter;
import com.solar.crud.solarcrud.model.MeterData;


public interface MeterDataRepository extends JpaRepository<MeterData, Long>{
	public Long findMaxId();
}
