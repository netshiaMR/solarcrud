package com.solar.crud.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solar.crud.exception.ResourceNotFoundException;
import com.solar.crud.model.Meter;
import com.solar.crud.service.MeterService;

@RestController()
@RequestMapping("/api/meters")
class MeterResource {

	@Autowired
	MeterService meterSerice;

	@GetMapping
	public List<Meter> getAllMeters() {
		return meterSerice.findAllMeter();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Meter> findUserById(@PathVariable(name = "id") long meterid) {
		System.out.println(meterid);
		Optional<Meter> meters = this.meterSerice.findMeterById(meterid);
		if (meters.isPresent()) {
			return ResponseEntity.ok().body(meters.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public List<Meter> getAllHourlyMeterSummer() {
		return meterSerice.findAllMeter();
	}
	
	@PostMapping
	public Meter createMeter(@RequestBody Meter meter) {
		return meterSerice.createMeter(meter);
	}

	@PutMapping("/{id}")
	public Meter updateUser(@RequestBody Meter meter, @PathVariable("id") long meterid) {
		Meter existingMeter = this.meterSerice.findMeterById(meterid)
				.orElseThrow(() -> new ResourceNotFoundException("Meter not found with id :" + meterid));
		existingMeter.setMeterId(meter.getMeterId());
		existingMeter.setMeterName(meter.getMeterName());
		return this.meterSerice.createMeter(existingMeter);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Meter> deleteUser(@PathVariable("id") long meterid) {
		Meter existingMeter = this.meterSerice.findMeterById(meterid)
				.orElseThrow(() -> new ResourceNotFoundException("Meter not found with id :" + meterid));
		this.meterSerice.delete(existingMeter);
		return ResponseEntity.ok().build();
	}
}
