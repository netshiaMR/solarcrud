package com.solar.crud.solarcrud.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.solar.crud.solarcrud.controller.hepler.ControllerPathHelper;
import com.solar.crud.solarcrud.model.Meter;
import com.solar.crud.solarcrud.service.MeterService;

@Controller
public class MeterController extends ControllerPathHelper {
	private static Logger logger = LoggerFactory.getLogger(MeterDatasController.class);
	@Autowired
	MeterService meterService;
	

	@GetMapping("/createMeterForm")
	public String createMeterForm(Model model) {
		logger.info("Request initiated  for createMeterForm Action");
		Meter meter = new Meter();
		model.addAttribute("meter", meter);
		return _METER_CREATE_PAGE_PATH;
	}

	@GetMapping("/editMeterFrom/{id}")
	public String editMeterFrom(@PathVariable(value = "id") long id, Model model) {
		Optional<Meter> meters = meterService.findMeterById(id);
		model.addAttribute("meter", meters.get());
		return _METER_EDIT_OR_UPDATE_PAGE_PATH;
	}

	@PostMapping("/save")
	public String saveMeter(@ModelAttribute("meter") Meter meter) {
		logger.info("Request initiated  for save meter Action");
		meterService.createMeter(meter);
		return _METER_LISTING_PAGE_PATH;
	}

	@GetMapping("/deleteMeter/{id}")
	public String deleteMeter(@PathVariable(value = "id") long id, Model model) {
		meterService.deleteByID(id);
		model.addAttribute("id", id);
		model.addAttribute("isDeleteMeterOperation", true);
		return _RECORD_DELETE_PAGE_PATH;
	}
}
