package com.solar.crud.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.solar.crud.model.Meter;
import com.solar.crud.model.MeterDaily;
import com.solar.crud.model.MeterData;
import com.solar.crud.model.MeterEnergyCost;
import com.solar.crud.service.MeterDataService;
import com.solar.crud.service.MeterEnergyCostSummaryService;
import com.solar.crud.service.MeterService;

@RestController
@RequestMapping("/api/meterdata")
public class MeterDataResource {
	@Autowired
	private MeterDataService meterDataService;

	@Autowired
	private MeterService meterService;
	@Autowired
	MeterEnergyCostSummaryService meterEnergyCostSummaryService;

	@GetMapping
	public List<MeterData> getAllMetersData() {
		return meterDataService.findAllMeterData();
	}

	/***
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<MeterData> findUserById(@PathVariable(name = "id") long id) {
		Optional<MeterData> metersData = this.meterDataService.findMeterDataById(id);
		if (metersData.isPresent()) {
			return ResponseEntity.ok().body(metersData.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("hourly/MeterEnergyCost")
	public ResponseEntity<List<MeterEnergyCost>> findAllMeterEnergyCost() {
		List<MeterEnergyCost> meterEnergyCostList = this.meterEnergyCostSummaryService.findAllMeterEnergyCost();
		if (!meterEnergyCostList.isEmpty()) {
			return ResponseEntity.ok().body(meterEnergyCostList);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("hourly/MeterEnergyCost/{id}")
	public ResponseEntity<List<MeterEnergyCost>> findMeterEnergyCostParMeterId(@PathVariable(name = "id") long id) {
		List<MeterEnergyCost> meterEnergyCostList = this.meterEnergyCostSummaryService
				.findMeterEnergyCostParMeterId(id);
		if (!meterEnergyCostList.isEmpty()) {
			return ResponseEntity.ok().body(meterEnergyCostList);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("daily/MeterEnergyProduced/{id}")
	public ResponseEntity<List<MeterDaily>> getDailyMeterKwhProduced() {
		List<MeterDaily> meterEnergyCostList = this.meterEnergyCostSummaryService.getDailyMeterKwhProduced();
		if (!meterEnergyCostList.isEmpty()) {
			return ResponseEntity.ok().body(meterEnergyCostList);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("daily/MeterCostProduced/{id}")
	public ResponseEntity<List<MeterDaily>> getDailyMeterCost() {
		List<MeterDaily> meterEnergyCostList = this.meterEnergyCostSummaryService.getDailyMeterCost();
		if (!meterEnergyCostList.isEmpty()) {
			return ResponseEntity.ok().body(meterEnergyCostList);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@PostMapping
	public ResponseEntity<MeterData> createMeterData(@RequestBody MeterData requestMeterData) {
		Optional<Meter> resultMeter = null;
		MeterData savedMeterDatal;
		URI location = null;
		try {
			resultMeter = meterService.findMeterById((requestMeterData.getMeter().getMeterId()));

			if (!resultMeter.isPresent()) {
				return ResponseEntity.unprocessableEntity().build();
			}

			requestMeterData.setMeter(resultMeter.get());

			savedMeterDatal = meterDataService.createMeterData(requestMeterData);

			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(savedMeterDatal.getId()).toUri();
		} catch (Exception e) {

		}

		return ResponseEntity.created(location).body(requestMeterData);
	}

	@PutMapping("/{id}")
	public ResponseEntity<MeterData> update(@RequestBody MeterData requestMeterData, @PathVariable Long id) {
		Optional<Meter> optionalMeter = meterService.findMeterById(requestMeterData.getMeter().getMeterId());
		if (!optionalMeter.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		Optional<MeterData> optionalMeterData = meterDataService.findMeterDataById(id);
		if (!optionalMeterData.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		requestMeterData.setMeter(optionalMeter.get());
		requestMeterData.setId(optionalMeterData.get().getId());
		try {
			meterDataService.createMeterData(requestMeterData);
		} catch (Exception e) {
		}

		return ResponseEntity.noContent().build();
	}
}
