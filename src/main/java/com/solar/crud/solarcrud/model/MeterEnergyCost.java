package com.solar.crud.solarcrud.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class MeterEnergyCost {
	private int hours ;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date timeStamp;
	private Long meterid;
	private String meterName;
	
	private String kwh;
	private String cost;
	
	private double min_cost;
	private double max_cost;
	private double avgcost;
	private Integer total_cost;
	
	private double min_kwh;
	private double max_kwh;
	private double avgkwh;
	private Integer total_kwh;
	
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public Long getMeterid() {
		return meterid;
	}
	public void setMeterid(Long meterid) {
		this.meterid = meterid;
	}
	public String getMeterName() {
		return meterName;
	}
	public void setMeterName(String meterName) {
		this.meterName = meterName;
	}
	public String getKwh() {
		return kwh;
	}
	public void setKwh(String kwh) {
		this.kwh = kwh;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public double getMin_cost() {
		return min_cost;
	}
	public void setMin_cost(double min_cost) {
		this.min_cost = min_cost;
	}
	public double getMax_cost() {
		return max_cost;
	}
	public void setMax_cost(double max_cost) {
		this.max_cost = max_cost;
	}
	public double getAvgcost() {
		return avgcost;
	}
	public void setAvgcost(double avgcost) {
		this.avgcost = avgcost;
	}
	public Integer getTotal_cost() {
		return total_cost;
	}
	public void setTotal_cost(Integer total_cost) {
		this.total_cost = total_cost;
	}
	public double getMin_kwh() {
		return min_kwh;
	}
	public void setMin_kwh(double min_kwh) {
		this.min_kwh = min_kwh;
	}
	public double getMax_kwh() {
		return max_kwh;
	}
	public void setMax_kwh(double max_kwh) {
		this.max_kwh = max_kwh;
	}
	public double getAvgkwh() {
		return avgkwh;
	}
	public void setAvgkwh(double avgkwh) {
		this.avgkwh = avgkwh;
	}
	public Integer getTotal_kwh() {
		return total_kwh;
	}
	public void setTotal_kwh(Integer total_kwh) {
		this.total_kwh = total_kwh;
	}

}
