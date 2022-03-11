package com.solar.crud.solarcrud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.solar.crud.solarcrud.model.Meter;
import com.solar.crud.solarcrud.model.MeterData;
import com.solar.crud.solarcrud.repository.MeterDataSummaryRepository;
import com.solar.crud.solarcrud.repository.MeterRepository;

@Service
@Transactional
public class MeterService {
	private static Logger logger = LoggerFactory.getLogger(MeterDataSummaryRepository.class);
	@Autowired
	MeterRepository meterRepository;
	
	@Autowired
	MeterDataService meterDataService;

	public List<Meter> findAllMeter() {
		logger.info("find All Meter detail from DB ");
		return meterRepository.findAll();

	}

	public Optional<Meter> findMeterById(Long meterID) {
		logger.info("find Meter By Id invoked for Meter Id : "+ meterID);
		return meterRepository.findById(meterID);
	}

	@Transactional
	public Meter createMeter(Meter meter) {
		logger.info("Create Meter Transactional invoked for Meter Id : "+ meter.getMeterId());
		return meterRepository.save(meter);
	}

	@Transactional
	public void  deleteByID(Long meterid) {
		logger.info("Delete Transactional invoked for Meter Id : "+ meterid);
		List<MeterData> listOFMeterDataFound = meterDataService.findMeterDataForEachMeterId(meterid);
		if (!listOFMeterDataFound.isEmpty()) {
			meterDataService.deleteByListOfID(listOFMeterDataFound);
		} else {
			logger.info("No Meter Data associated with meterid : "+ meterid + " That can be deleted" );
		}
		meterRepository.deleteById(meterid);

	}
	
	@Transactional
	public void delete(Meter meter) {
		logger.info("Delete Transactional invoked for Meter Id : "+ meter.getMeterId());
		meterRepository.delete(meter);

	}

}
