package com.solar.crud.solarcrud.request;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.solar.crud.solarcrud.model.Meter;

public class MeterDataUpdateRequest {
	private Long id;
	private Long meterId;
	private String derivedData;

	private String differenceExpKwh;

	private String differenceImpKwh;

	private String epochTstamp;

	private String expkvarh;

	private String expwh;

	private String impkvarh;

	private String impwh;

	private String kwh;

	private String ptot;

	private String q1varh;

	private String q2varh;

	private String q3varh;

	private String q4varh;

	private String qtot;

	private String ratePerKwh;

	private String stot;

	@DateTimeFormat(pattern = "DD/MM/YYYY HH:mm:ss")
	private Date tStamp;

	private String vah;
	private String cost;

	public MeterDataUpdateRequest(Long id,Long meterId, String derivedData, String differenceExpKwh, String differenceImpKwh, String epochTstamp,
			String expkvarh, String expwh, String impkvarh, String impwh, String kwh, String ptot, String q1varh,
			String q2varh, String q3varh, String q4varh, String qtot, String ratePerKwh, String stot, Date tStamp,
			String vah, String cost) {
		this.id = id;
		this.meterId = meterId;
		this.derivedData = derivedData;
		this.differenceExpKwh = differenceExpKwh;
		this.differenceImpKwh = differenceImpKwh;
		this.epochTstamp = epochTstamp;
		this.expkvarh = expkvarh;
		this.expwh = expwh;
		this.impkvarh = impkvarh;
		this.impwh = impwh;
		this.kwh = kwh;
		this.ptot = ptot;
		this.q1varh = q1varh;
		this.q2varh = q2varh;
		this.q3varh = q3varh;
		this.q4varh = q4varh;
		this.qtot = qtot;
		this.ratePerKwh = ratePerKwh;
		this.stot = stot;
		this.tStamp = tStamp;
		this.vah = vah;
		this.cost = cost;
	}

	public MeterDataUpdateRequest() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMeterId() {
		return meterId;
	}

	public void setMeterId(Long meterId) {
		this.meterId = meterId;
	}

	public String getDerivedData() {
		return derivedData;
	}

	public void setDerivedData(String derivedData) {
		this.derivedData = derivedData;
	}

	public String getDifferenceExpKwh() {
		return differenceExpKwh;
	}

	public void setDifferenceExpKwh(String differenceExpKwh) {
		this.differenceExpKwh = differenceExpKwh;
	}

	public String getDifferenceImpKwh() {
		return differenceImpKwh;
	}

	public void setDifferenceImpKwh(String differenceImpKwh) {
		this.differenceImpKwh = differenceImpKwh;
	}

	public String getEpochTstamp() {
		return epochTstamp;
	}

	public void setEpochTstamp(String epochTstamp) {
		this.epochTstamp = epochTstamp;
	}

	public String getExpkvarh() {
		return expkvarh;
	}

	public void setExpkvarh(String expkvarh) {
		this.expkvarh = expkvarh;
	}

	public String getExpwh() {
		return expwh;
	}

	public void setExpwh(String expwh) {
		this.expwh = expwh;
	}

	public String getImpkvarh() {
		return impkvarh;
	}

	public void setImpkvarh(String impkvarh) {
		this.impkvarh = impkvarh;
	}

	public String getImpwh() {
		return impwh;
	}

	public void setImpwh(String impwh) {
		this.impwh = impwh;
	}

	public String getKwh() {
		return kwh;
	}

	public void setKwh(String kwh) {
		this.kwh = kwh;
	}

	public String getPtot() {
		return ptot;
	}

	public void setPtot(String ptot) {
		this.ptot = ptot;
	}

	public String getQ1varh() {
		return q1varh;
	}

	public void setQ1varh(String q1varh) {
		this.q1varh = q1varh;
	}

	public String getQ2varh() {
		return q2varh;
	}

	public void setQ2varh(String q2varh) {
		this.q2varh = q2varh;
	}

	public String getQ3varh() {
		return q3varh;
	}

	public void setQ3varh(String q3varh) {
		this.q3varh = q3varh;
	}

	public String getQ4varh() {
		return q4varh;
	}

	public void setQ4varh(String q4varh) {
		this.q4varh = q4varh;
	}

	public String getQtot() {
		return qtot;
	}

	public void setQtot(String qtot) {
		this.qtot = qtot;
	}

	public String getRatePerKwh() {
		return ratePerKwh;
	}

	public void setRatePerKwh(String ratePerKwh) {
		this.ratePerKwh = ratePerKwh;
	}

	public String getStot() {
		return stot;
	}

	public void setStot(String stot) {
		this.stot = stot;
	}

	public Date gettStamp() {
		return tStamp;
	}

	public void settStamp(Date tStamp) {
		this.tStamp = tStamp;
	}

	public String getVah() {
		return vah;
	}

	public void setVah(String vah) {
		this.vah = vah;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "MeterDataRequest [id=" + id + ", meterId=" + meterId + ", derivedData=" + derivedData
				+ ", differenceExpKwh=" + differenceExpKwh + ", differenceImpKwh=" + differenceImpKwh + ", epochTstamp="
				+ epochTstamp + ", expkvarh=" + expkvarh + ", expwh=" + expwh + ", impkvarh=" + impkvarh + ", impwh="
				+ impwh + ", kwh=" + kwh + ", ptot=" + ptot + ", q1varh=" + q1varh + ", q2varh=" + q2varh + ", q3varh="
				+ q3varh + ", q4varh=" + q4varh + ", qtot=" + qtot + ", ratePerKwh=" + ratePerKwh + ", stot=" + stot
				+ ", tStamp=" + tStamp + ", vah=" + vah + ", cost=" + cost + "]";
	}

	
}
