package com.solar.crud.solarcrud.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.solar.crud.solarcrud.controller.hepler.ControllerPathHelper;
import com.solar.crud.solarcrud.model.Meter;
import com.solar.crud.solarcrud.model.MeterDaily;
import com.solar.crud.solarcrud.model.MeterData;
import com.solar.crud.solarcrud.model.MeterEnergyCost;
import com.solar.crud.solarcrud.service.MeterDataService;
import com.solar.crud.solarcrud.service.MeterEnergyCostSummaryService;
import com.solar.crud.solarcrud.service.MeterService;

/**
 * 
 * @author Netshia Rendani.
 *
 */
@Controller
public class NavbarController extends ControllerPathHelper{

	@Autowired
	MeterService meterService;

	@Autowired
	MeterDataService meterDataService;

	@Autowired
	MeterEnergyCostSummaryService meterEnergyCostSerivce;


	@GetMapping(path = "/")
	public String home(Model model) {
		List<MeterDaily> dailyMeterKwhProducedList = meterEnergyCostSerivce.getDailyMeterKwhProduced();
		List<MeterDaily> dailyMeterCostList = meterEnergyCostSerivce.getDailyMeterCost();

		List<MeterEnergyCost> hourlySummeryList = new ArrayList<MeterEnergyCost>();
		Map<String, Double> hourlySummeryMap = meterEnergyCostSerivce.hourlySummeryMap(hourlySummeryList);

		Map<String, Double> kwhMap = new LinkedHashMap<String, Double>();
		dailyMeterKwhProducedList.forEach(dailykwh -> {
			kwhMap.put(dailykwh.getMeterName() + " TOTAL", Double.valueOf(dailykwh.getTotal()));
			kwhMap.put(dailykwh.getMeterName() + " MAX", dailykwh.getMax());
			kwhMap.put(dailykwh.getMeterName() + " MIN", dailykwh.getMin());
			kwhMap.put(dailykwh.getMeterName() + " AVG", dailykwh.getAvg());
		});
		Map<String, Double> costmap = new LinkedHashMap<String, Double>();
		dailyMeterCostList.forEach(dailyCost -> {
			costmap.put(dailyCost.getMeterName() + " TOTAL", Double.valueOf(dailyCost.getTotal()));
			costmap.put(dailyCost.getMeterName() + " MAX", dailyCost.getMax());
			costmap.put(dailyCost.getMeterName() + " MIN", dailyCost.getMin());
			costmap.put(dailyCost.getMeterName() + " AVG", dailyCost.getAvg());
		});

		model.addAttribute("metersize", meterService.findAllMeter().size());
		model.addAttribute("meterdatasize", meterDataService.findAllMeterData().size());

		model.addAttribute("kwhkeySet", kwhMap.keySet());
		model.addAttribute("kwhvalues", kwhMap.values());

		model.addAttribute("costkeySet", costmap.keySet());
		model.addAttribute("costvalues", costmap.values());
		
		model.addAttribute("hourlySummeryKey", hourlySummeryMap.keySet());
		model.addAttribute("hourlySummeryValue", hourlySummeryMap.values());

		model.addAttribute("dailyMeterKwhs", dailyMeterKwhProducedList);
		model.addAttribute("dailyMeterCosts", dailyMeterCostList);
		return _INDEX_HOME_PAGE_PATH;
	}



	@GetMapping("/meters")
	public String viewMetersPage(Model model) {
		List<Meter> meters = meterService.findAllMeter();
		model.addAttribute("meters", meters);
		return _METER_LISTING_PAGE_PATH;
	}

	@GetMapping("/meterdata")
	public String getMeterdata(Model model) {
		List<MeterData> meterDatas = meterDataService.findMeterData();
		model.addAttribute("meterDatas", meterDatas);
		return _METER_DATA_LISTING_PAGE_PATH;
	}

}
