package com.solar.crud.solarcrud.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solar.crud.solarcrud.model.Meter;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "meter_data")
@NamedQuery(name = "MeterData.findAll", query = "SELECT m FROM MeterData m")
@NamedQuery(name = "MeterData.findMaxId", query = "SELECT MAX(m.id) FROM MeterData m")
public class MeterData {
	@Id
	private Long id;

	@Column(name = "derived_data")
	private String derivedData;

	@Column(name = "difference_exp_kwh")
	private String differenceExpKwh;

	@Column(name = "difference_imp_kwh")
	private String differenceImpKwh;

	@Column(name = "epoch_tstamp")
	private String epochTstamp;

	private String expkvarh;

	private String expwh;

	private String impkvarh;

	private String impwh;//

	private String kwh;// up

	private String ptot;

	private String q1varh;

	private String q2varh;

	private String q3varh;

	private String q4varh;

	private String qtot;

	@Column(name = "rate_per_kwh")
	private String ratePerKwh;

	private String stot;

	@Column(name = "t_stamp")
	private Date tStamp;

	private String vah;
	private String cost;
	// bi-directional many-to-one association to Meter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "meter_id")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Meter meter;

	public MeterData() {
		super();
	}

	public MeterData(Long id,String derivedData, String differenceExpKwh, String differenceImpKwh, String epochTstamp,
			String expkvarh, String expwh, String impkvarh, String impwh, String kwh, String ptot, String q1varh,
			String q2varh, String q3varh, String q4varh, String qtot, String ratePerKwh, String stot, Date tStamp,
			String vah, String cost, Meter meter) {
		super();
		this.id = id;
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
		this.meter = meter;
	}

	public MeterData(String derivedData, String differenceExpKwh, String differenceImpKwh, String epochTstamp,
			String expkvarh, String expwh, String impkvarh, String impwh, String kwh, String ptot, String q1varh,
			String q2varh, String q3varh, String q4varh, String qtot, String ratePerKwh, String stot, Date tStamp,
			String vah, String cost, Meter meter) {
		super();
		this.id = id;
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
		this.meter = meter;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Meter getMeter() {
		return meter;
	}

	public void setMeter(Meter meter) {
		this.meter = meter;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cost, derivedData, differenceExpKwh, differenceImpKwh, epochTstamp, expkvarh, expwh, id,
				impkvarh, impwh, kwh, meter, ptot, q1varh, q2varh, q3varh, q4varh, qtot, ratePerKwh, stot, tStamp, vah);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MeterData other = (MeterData) obj;
		return Objects.equals(cost, other.cost) && Objects.equals(derivedData, other.derivedData)
				&& Objects.equals(differenceExpKwh, other.differenceExpKwh)
				&& Objects.equals(differenceImpKwh, other.differenceImpKwh)
				&& Objects.equals(epochTstamp, other.epochTstamp) && Objects.equals(expkvarh, other.expkvarh)
				&& Objects.equals(expwh, other.expwh) && Objects.equals(id, other.id)
				&& Objects.equals(impkvarh, other.impkvarh) && Objects.equals(impwh, other.impwh)
				&& Objects.equals(kwh, other.kwh) && Objects.equals(meter, other.meter)
				&& Objects.equals(ptot, other.ptot) && Objects.equals(q1varh, other.q1varh)
				&& Objects.equals(q2varh, other.q2varh) && Objects.equals(q3varh, other.q3varh)
				&& Objects.equals(q4varh, other.q4varh) && Objects.equals(qtot, other.qtot)
				&& Objects.equals(ratePerKwh, other.ratePerKwh) && Objects.equals(stot, other.stot)
				&& Objects.equals(tStamp, other.tStamp) && Objects.equals(vah, other.vah);
	}

	@Override
	public String toString() {
		return "MeterData [id=" + id + ", derivedData=" + derivedData + ", differenceExpKwh=" + differenceExpKwh
				+ ", differenceImpKwh=" + differenceImpKwh + ", epochTstamp=" + epochTstamp + ", expkvarh=" + expkvarh
				+ ", expwh=" + expwh + ", impkvarh=" + impkvarh + ", impwh=" + impwh + ", kwh=" + kwh + ", ptot=" + ptot
				+ ", q1varh=" + q1varh + ", q2varh=" + q2varh + ", q3varh=" + q3varh + ", q4varh=" + q4varh + ", qtot="
				+ qtot + ", ratePerKwh=" + ratePerKwh + ", stot=" + stot + ", tStamp=" + tStamp + ", vah=" + vah
				+ ", cost=" + cost + ", meter=" + meter + "]";
	}

}
