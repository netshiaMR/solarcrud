package com.solar.crud.solarcrud.model;

import java.time.LocalDateTime;
import java.util.Date;

public class MeterCalculation {
	private Date  date_hour;
	private Long meter_id;
	private String meter_name;
	private Double sumDailykwh;
	private long  max_kwh;
	public MeterCalculation() {}
	public Date getDate_hour() {
		return date_hour;
	}
	public void setDate_hour(Date date_hour) {
		this.date_hour = date_hour;
	}
	public Long getMeter_id() {
		return meter_id;
	}
	public void setMeter_id(Long meter_id) {
		this.meter_id = meter_id;
	}
	public String getMeter_name() {
		return meter_name;
	}
	public void setMeter_name(String meter_name) {
		this.meter_name = meter_name;
	}
	public Double getSumDailykwh() {
		return sumDailykwh;
	}
	public void setSumDailykwh(Double sumDailykwh) {
		this.sumDailykwh = sumDailykwh;
	}
	public long getMax_kwh() {
		return max_kwh;
	}
	public void setMax_kwh(Long max_kwh) {
		this.max_kwh = max_kwh;
	}
	
	
}
