package com.solar.crud.solarcrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solar.crud.solarcrud.model.MeterDailySummary;


public interface MeterDailySummaryRepository extends JpaRepository<MeterDailySummary, Long>{
}
