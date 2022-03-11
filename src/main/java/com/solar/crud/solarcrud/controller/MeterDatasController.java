package com.solar.crud.solarcrud.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.solar.crud.solarcrud.controller.hepler.ControllerPathHelper;
import com.solar.crud.solarcrud.model.Meter;
import com.solar.crud.solarcrud.model.MeterData;
import com.solar.crud.solarcrud.repository.MeterDataSummaryRepository;
import com.solar.crud.solarcrud.request.MeterDataRequest;
import com.solar.crud.solarcrud.request.MeterDataUpdateRequest;
import com.solar.crud.solarcrud.service.MeterDataService;
import com.solar.crud.solarcrud.service.MeterService;

@Controller
public class MeterDatasController extends ControllerPathHelper {

	private static Logger logger = LoggerFactory.getLogger(MeterDatasController.class);

	@Autowired
	MeterService meterService;

	@Autowired
	MeterDataService meterDataService;

	@GetMapping("/moreMeterData/{id}")
	public String moreMeterData(@PathVariable(value = "id") long id, Model model) {
		logger.info("Request initiated  for moreMeterData Action with ID : "+ id);
		List<MeterData> meterDatas = meterDataService.findMeterData();// more for meter that is being show
		List<MeterData> meterDataList = new ArrayList<MeterData>();
		meterDatas.forEach(meterData -> {
			if (meterData.getMeter().getMeterId() == id) {
				meterDataList.add(meterData);
			}
		});
		model.addAttribute("meterDatas", meterDataList);
		return _METER_DATA_LISTING_PAGE_PATH;
	}

	@GetMapping("/viewsMeterData/{id}")
	public String viewsMeterData(@PathVariable(value = "id") long id, Model model) {
		logger.info("Request initiated  for viewsMeterData Action with ID : "+ id);
		Optional<Meter> meters = meterService.findMeterById(id);
		Meter meter = meters.get();
		List<MeterData> meterDataList = meterDataService.findMeterDataForEachMeterId(id);
		model.addAttribute("meterDatas", meterDataList);
		model.addAttribute("meter", meter);
		return _METER_VIEW_PAGE_PATH;
	}

	

	@GetMapping("/showMeterData/{id}")
	public String showMeterData(@PathVariable(value = "id") long id, Model model) {
		logger.info("Request initiated  for viewsMeterData Action with ID : "+ id);
		Optional<MeterData> meterDataOptional = meterDataService.findMeterDataById(id);
		model.addAttribute("meterData", meterDataOptional.get());
		return _METER_DATA_VIEW_PAGE_PATH;
	}

	@GetMapping("/createMeterDataFrom")
	public String createMeterDataFrom(Model model) {
		logger.info("Request initiated  for createMeterDataFrom Action");
		MeterDataRequest meterDataRequest = new MeterDataRequest();
		model.addAttribute("meterDataRequest", meterDataRequest);
		return _METER_DATA_CREATE_PAGE_PATH;
	}


	@PostMapping("/saveMeterData")
	public String saveMeter(@ModelAttribute("meterDataRequest") MeterDataRequest request, Model model) {
		logger.info("Request initiated  for saveMeterData Action ");
		MeterData meterData = null;
		try {
			if (request != null) {
				Meter meter = null;
				Optional<Meter> meterOptinal = meterService.findMeterById(request.getMeterId());
				if (meterOptinal.isPresent()) {
					meter = meterOptinal.get();
				} else {
					return _METER_DATA_CREATE_PAGE_PATH;
				}
				meterData = new MeterData(request.getDerivedData(), request.getDifferenceExpKwh(),
						request.getDifferenceImpKwh(), request.getEpochTstamp(), request.getExpkvarh(),
						request.getExpwh(), request.getImpkvarh(), request.getImpwh(), request.getKwh(),
						request.getPtot(), request.getQ1varh(), request.getQ2varh(), request.getQ3varh(),
						request.getQ4varh(), request.getQtot(), request.getRatePerKwh(), request.getStot(),
						request.gettStamp(), request.getVah(), request.getCost(), meter);

				meterDataService.createMeterData(meterData);

				Optional<MeterData> meterDatas = meterDataService.findMeterDataById(meterData.getId());
				model.addAttribute("meterDatas", meterDatas.get());
			}
		} catch (Exception e) {
			logger.error("Unexpected Error With Saving a New Meter Data :"+ meterData.toString());
		}

		return _METER_DATA_LISTING_PAGE_PATH;
	}
	
	@GetMapping("/editMeterDataFrom/{id}")
	public String editMeterDataFrom(@PathVariable(value = "id") long id, Model model) {
		logger.info("Request initiated  for editMeterDataFrom Action with ID : "+ id);
		Optional<MeterData> metersDataOptional = meterDataService.findMeterDataById(id);
		MeterData request = metersDataOptional.get();
		MeterDataUpdateRequest meterDataRequest = new MeterDataUpdateRequest(request.getId(), request.getMeter().getMeterId(),
				request.getDerivedData(), request.getDifferenceExpKwh(), request.getDifferenceImpKwh(),
				request.getEpochTstamp(), request.getExpkvarh(), request.getExpwh(), request.getImpkvarh(),
				request.getImpwh(), request.getKwh(), request.getPtot(), request.getQ1varh(), request.getQ2varh(),
				request.getQ3varh(), request.getQ4varh(), request.getQtot(), request.getRatePerKwh(), request.getStot(),
				request.gettStamp(), request.getVah(), request.getCost());
		logger.info("MeterDataRequest :  "+request.toString());
		model.addAttribute("meterDataRequest", meterDataRequest);
		return _METER_DATA_EDIT_OR_UPDATE_PAGE_PATH;
	}

	@PostMapping("/update")
	public String editMeterData(@ModelAttribute("meterDataRequest") MeterDataRequest request,  Model model) {
		logger.info("Request initiated  for saveMeterData Action ");
		MeterData meterData = null;
		try {
			logger.info("MeterDataRequest :  "+request.toString());
			if (request != null) {
				Meter meter = null;
				Optional<Meter> meterOptinal = meterService.findMeterById(request.getMeterId());
				if (meterOptinal.isPresent()) {
					meter = meterOptinal.get();
				} else {
					return "redirect:/";
				}
				meterData = new MeterData(request.getId(), request.getDerivedData(), request.getDifferenceExpKwh(),
						request.getDifferenceImpKwh(), request.getEpochTstamp(), request.getExpkvarh(),
						request.getExpwh(), request.getImpkvarh(), request.getImpwh(), request.getKwh(),
						request.getPtot(), request.getQ1varh(), request.getQ2varh(), request.getQ3varh(),
						request.getQ4varh(), request.getQtot(), request.getRatePerKwh(), request.getStot(),
						request.gettStamp(), request.getVah(), request.getCost(), meter);

				meterDataService.editMeterData(meterData);
				Optional<MeterData> meterDatas = meterDataService.findMeterDataById(meterData.getId());
				model.addAttribute("meterDatas", meterDatas.get());
			}
		} catch (Exception e) {
		}

		return _METER_DATA_LISTING_PAGE_PATH;
	}

	@GetMapping("/deleteMeterData/{id}")
	public String deleteMeterData(@PathVariable(value = "id") long id, Model model) {
		logger.info("Meter Data for ID " + id + " about to be Deleted.");
		Optional<MeterData> meterDataOptional = meterDataService.findMeterDataById(id);
		MeterData meterDataToDelete = meterDataOptional.get();
		meterDataService.delete(meterDataToDelete);
		model.addAttribute("id", id);
		model.addAttribute("isDeleteMeterOperation", false);
		return _RECORD_DELETE_PAGE_PATH;
	}
}
