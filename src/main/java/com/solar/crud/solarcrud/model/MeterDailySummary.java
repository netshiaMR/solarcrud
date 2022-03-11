package com.solar.crud.solarcrud.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="meter_daily_summary")
public class MeterDailySummary {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String cost;

	@Column(name="derived_data")
	private String derivedData;

	@Column(name="difference_exp_kwh")
	private String differenceExpKwh;

	@Column(name="difference_imp_kwh")
	private String differenceImpKwh;

	@Column(name="epoch_tstamp")
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

	@Column(name="rate_per_kwh")
	private String ratePerKwh;

	private String stot;

	@Column(name="t_stamp")
	private Date tStamp;

	private String vah;

	//bi-directional many-to-one association to Meter
	@ManyToOne
	@JoinColumn(name="meter_id")
	private Meter meter;
}
