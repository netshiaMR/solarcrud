package com.solar.crud.solarcrud.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.solar.crud.solarcrud.model.MeterDaily;
import com.solar.crud.solarcrud.model.MeterEnergyCost;

public class MeterEnergyCostHelper {

	public MeterEnergyCost mapMeterEnergyCostRow(ResultSet rs) throws SQLException {
		MeterEnergyCost meterEnergyCost = new MeterEnergyCost();
		meterEnergyCost.setMeterid(rs.getLong("meter_id"));
		meterEnergyCost.setMeterName(rs.getString("meter_name"));
		meterEnergyCost.setHours(rs.getInt("hours"));
		meterEnergyCost.setTimeStamp(rs.getTimestamp("t_stamp"));
		meterEnergyCost.setKwh(rs.getString("kwh"));
		meterEnergyCost.setCost(rs.getString("cost"));
		meterEnergyCost.setMin_cost(rs.getDouble("min_cost"));
		meterEnergyCost.setMax_cost(rs.getDouble("max_cost"));
		meterEnergyCost.setAvgcost(rs.getDouble("avgcost"));
		meterEnergyCost.setTotal_cost(rs.getInt("total_cost"));
		meterEnergyCost.setMin_kwh(rs.getDouble("min_kwh"));
		meterEnergyCost.setMax_kwh(rs.getDouble("max_kwh"));
		meterEnergyCost.setAvgkwh(rs.getDouble("avgkwh"));
		meterEnergyCost.setTotal_kwh(rs.getInt("total_kwh"));
		return meterEnergyCost;
	}

	public MeterDaily mapMeterDailyEnergyRow(ResultSet rs) throws SQLException {
		MeterDaily meterDaily = new MeterDaily(rs.getLong("meter_id"), rs.getString("meter_name"),
				rs.getTimestamp("datehour"), rs.getDouble("minkwh"), rs.getDouble("maxkwh"), rs.getDouble("avgkwh"),
				rs.getInt("total"));
		return meterDaily;
	}
	
	public MeterDaily mapMeterDailyCostgRow(ResultSet rs) throws SQLException {
		MeterDaily meterDaily = new MeterDaily();
		meterDaily.setMeter_id(rs.getLong("meter_id"));
		meterDaily.setMeterName(rs.getString("meter_name"));
		meterDaily.setDatehour(rs.getTimestamp("datehour"));
		meterDaily.setMin(rs.getDouble("mincost"));
		meterDaily.setMax( rs.getDouble("maxcost"));
		meterDaily.setAvg(rs.getDouble("avgcost"));
		meterDaily.setTotal(rs.getInt("total_cost"));
		return meterDaily;
	}
}
