package com.solar.crud.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.solar.crud.model.MeterDailySummary;

public interface MeterDailySummaryRepository extends JpaRepository<MeterDailySummary, Long>{
}
