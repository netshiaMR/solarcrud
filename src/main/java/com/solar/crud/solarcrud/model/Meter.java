package com.solar.crud.solarcrud.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Meter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="meter_id")
	Long meterId;

	@Column(name="meter_name")
	String meterName;

	public Meter() {
	
	}

	public Meter(Long meterId, String meterName) {
		super();
		this.meterId = meterId;
		this.meterName = meterName;
	}

	public Long getMeterId() {
		return meterId;
	}

	public void setMeterId(Long meterId) {
		this.meterId = meterId;
	}

	public String getMeterName() {
		return meterName;
	}

	public void setMeterName(String meterName) {
		this.meterName = meterName;
	}

	@Override
	public String toString() {
		return "Meter [meterId=" + meterId + ", meterName=" + meterName + "]";
	}

	
	
}
