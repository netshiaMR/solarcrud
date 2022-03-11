package com.solar.crud.repository ;



import org.springframework.data.jpa.repository.JpaRepository;

import com.solar.crud.model.Meter;

public interface MeterRepository extends JpaRepository<Meter, Long>{
	
	
}
