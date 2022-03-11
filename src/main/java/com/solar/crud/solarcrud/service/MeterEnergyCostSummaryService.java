package com.solar.crud.solarcrud.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solar.crud.solarcrud.model.MeterDaily;
import com.solar.crud.solarcrud.model.MeterEnergyCost;
import com.solar.crud.solarcrud.repository.MeterDataSummaryRepository;
import com.solar.crud.solarcrud.repository.MeterDailySummaryRepository;
@Service
public class MeterEnergyCostSummaryService {
	private static Logger logger = LoggerFactory.getLogger(MeterDataSummaryRepository.class);

	@Autowired
	MeterDataSummaryRepository repository;
	
	@Autowired
	MeterDailySummaryRepository MeterDailySummaryRepository;
	
	
	@Autowired
	MeterService meterService;

	public List<MeterEnergyCost> findMeterEnergyCostParMeterId(Long meterid) {
		List<MeterEnergyCost> list = null;
		try {
			list = repository.get24MeterEnergyCostSummary(meterid);
		} catch (SQLException e) {
			logger.error("Unexcepted error has Occured. " + e.getCause().getMessage());
		}
		return list;
	}

	public Map<String, Double> hourlySummeryMap(List<MeterEnergyCost> hourlySummeryList) {
		Map<String, Double> hourlySummeryMap = new LinkedHashMap<String, Double>();
		meterService.findAllMeter().forEach(meter -> {
			MeterEnergyCost meterEnergyCost = new MeterEnergyCost();
			findMeterEnergyCostParMeterId(meter.getMeterId()).forEach(meters -> {
				meterEnergyCost.setMeterid(meters.getMeterid());
				meterEnergyCost.setMeterName(meters.getMeterName());
				meterEnergyCost.setTimeStamp(meters.getTimeStamp());
				meterEnergyCost.setCost(meters.getCost());
				meterEnergyCost.setMin_cost(meters.getMin_cost());
				meterEnergyCost.setMax_cost(meters.getMax_cost());
				meterEnergyCost.setTotal_cost(meters.getTotal_cost());
				meterEnergyCost.setKwh(meters.getKwh());
				meterEnergyCost.setMin_kwh(meters.getMin_kwh());
				meterEnergyCost.setMax_kwh(meters.getMax_kwh());
				meterEnergyCost.setTotal_kwh(meters.getTotal_kwh());
				hourlySummeryMap.put(meters.getMeterName() + " TOTALkWH" + " H" + meters.getHours(),
						Double.valueOf(meters.getTotal_kwh()));
				hourlySummeryMap.put(meters.getMeterName() + " MAXkWH" + " H" + meters.getHours(), meters.getMax_kwh());
				hourlySummeryMap.put(meters.getMeterName() + " MINkWH" + " H" + meters.getHours(), meters.getMin_kwh());
				hourlySummeryMap.put(meters.getMeterName() + " AVGkWH" + " H" + meters.getHours(), meters.getAvgkwh());
				hourlySummeryMap.put(meters.getMeterName() + " TOTALCOST" + " H" + meters.getHours(),
						Double.valueOf(meters.getTotal_cost()));
				hourlySummeryMap.put(meters.getMeterName() + " MAXCOST" + " H" + meters.getHours(),
						meters.getMax_cost());
				hourlySummeryMap.put(meters.getMeterName() + " MINCOST" + " H" + meters.getHours(),
						meters.getMin_cost());
				hourlySummeryMap.put(meters.getMeterName() + " AVGCOST" + " H" + meters.getHours(),
						meters.getAvgcost());
				hourlySummeryList.add(meterEnergyCost);
			});
		});
		return hourlySummeryMap;
	}

	public List<MeterEnergyCost> findAllMeterEnergyCost() {
		List<MeterEnergyCost> hourlySummeryList = new ArrayList<MeterEnergyCost>();
		meterService.findAllMeter().forEach(meter -> {
			MeterEnergyCost meterEnergyCost = new MeterEnergyCost();
			findMeterEnergyCostParMeterId(meter.getMeterId()).forEach(meters -> {
				meterEnergyCost.setMeterid(meters.getMeterid());
				meterEnergyCost.setMeterName(meters.getMeterName());
				meterEnergyCost.setTimeStamp(meters.getTimeStamp());
				meterEnergyCost.setCost(meters.getCost());
				meterEnergyCost.setMin_cost(meters.getMin_cost());
				meterEnergyCost.setMax_cost(meters.getMax_cost());
				meterEnergyCost.setTotal_cost(meters.getTotal_cost());
				meterEnergyCost.setKwh(meters.getKwh());
				meterEnergyCost.setMin_kwh(meters.getMin_kwh());
				meterEnergyCost.setMax_kwh(meters.getMax_kwh());
				meterEnergyCost.setTotal_kwh(meters.getTotal_kwh());
				hourlySummeryList.add(meterEnergyCost);
			});
		});
		return hourlySummeryList;
	}

	public List<MeterDaily> getDailyMeterKwhProduced() {
		List<MeterDaily> meterCostSummaryList = null;
		try {
			meterCostSummaryList = repository.getDailyMeterCost();
		} catch (SQLException e) {

		}
		return meterCostSummaryList;

	}

	public List<MeterDaily> getDailyMeterCost() {
		List<MeterDaily> meterCostSummaryList = null;
		try {
			meterCostSummaryList = repository.getDailyMeterKwhProduced();
		} catch (SQLException e) {

		}
		return meterCostSummaryList;
	}

	
}
