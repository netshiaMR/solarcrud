package com.solar.crud.solarcrud.repository ;



import org.springframework.data.jpa.repository.JpaRepository;

import com.solar.crud.solarcrud.model.Meter;

public interface MeterRepository extends JpaRepository<Meter, Long>{
	
	
}
