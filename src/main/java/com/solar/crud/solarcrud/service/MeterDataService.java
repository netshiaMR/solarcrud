package com.solar.crud.solarcrud.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.solar.crud.solarcrud.model.MeterData;
import com.solar.crud.solarcrud.repository.MeterDataRepository;

@Service
@Transactional
public class MeterDataService {

	@Autowired
	private MeterDataRepository meterDataRepository;

	/**
	 * This method is responsible for creating meter data information for a meterid
	 * 
	 * @param meterData
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public MeterData createMeterData(MeterData meterData) throws Exception {
		// id the end
		Long id = meterDataRepository.findMaxId();
		id++;
		meterData.setId(id);
		return meterDataRepository.save(meterData);

	}
	
	@Transactional
	public MeterData editMeterData(MeterData meterData) throws Exception {
		return meterDataRepository.save(meterData);

	}

	/**
	 * 
	 * @return List<MeterData>
	 */
	public List<MeterData> findAllMeterData() {
		List<MeterData> result = (List<MeterData>) meterDataRepository.findAll();
		if (result.size() > 0) {
			return result;
		} else {
			return new ArrayList<MeterData>();
		}
	}

	public List<MeterData> findMeterDataForEachMeterId(long id) {
		List<MeterData> meterDataOptional = findAllMeterData();
		List<MeterData> meterDataList = new ArrayList<MeterData>();
		meterDataOptional.forEach(meterData -> {
			if (meterData.getMeter().getMeterId() == id) {
				meterDataList.add(meterData);
			}
		});
		return meterDataList;
	}
	public Optional<MeterData> findMeterDataById(Long meterId) {
		return meterDataRepository.findById(meterId);
	}
	public Optional<MeterData> findMeterDataByMeterID(Long meterId) {
		 Optional<MeterData>  meterDataOptional = meterDataRepository.findById(meterId);
		return meterDataOptional;
	}
	
	
	public List<MeterData> findMeterData() {
		return meterDataRepository.findAll();
	}

	public void delete(MeterData meterData) {
		 meterDataRepository.delete(meterData);
	}
	
	public void deleteByListOfID(List<MeterData> meterData) {
		 meterDataRepository.deleteAll(meterData);
	}
	
}
