package com.solar.crud.solarcrud.model;

import java.util.Date;

public class MeterDaily {
	private Long meter_id;
	private String meterName;
	private Date datehour;
	private Double min;
	private Double max;
	private Double avg;
	private Integer total;
	
	public MeterDaily() {
		super();
	}
	public MeterDaily(Long meter_id, String meterName, Date datehour, Double min, Double max,Double avg,  Integer total) {
		super();
		this.meter_id = meter_id;
		this.meterName = meterName;
		this.datehour = datehour;
		this.min = min;
		this.max = max;
		this.avg = avg;
		this.total = total;
	}
	public Long getMeter_id() {
		return meter_id;
	}
	public void setMeter_id(Long meter_id) {
		this.meter_id = meter_id;
	}
	public String getMeterName() {
		return meterName;
	}
	public void setMeterName(String meterName) {
		this.meterName = meterName;
	}
	public Date getDatehour() {
		return datehour;
	}
	public void setDatehour(Date datehour) {
		this.datehour = datehour;
	}
	public Double getMin() {
		return min;
	}
	public void setMin(Double min) {
		this.min = min;
	}
	public Double getMax() {
		return max;
	}
	public void setMax(Double max) {
		this.max = max;
	}
	
	public Double getAvg() {
		return avg;
	}
	public void setAvg(Double avg) {
		this.avg = avg;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
	
}
