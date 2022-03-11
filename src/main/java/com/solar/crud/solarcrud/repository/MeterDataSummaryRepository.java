package com.solar.crud.solarcrud.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.solar.crud.solarcrud.model.MeterDaily;
import com.solar.crud.solarcrud.model.MeterEnergyCost;

@Repository
public class MeterDataSummaryRepository extends MeterEnergyCostHelper {
	private static Logger logger = LoggerFactory.getLogger(MeterDataSummaryRepository.class);
	private final static String _METER_ENERYG_COST_SUMMARY_24 = "{CALL get24MeterEnergyCostSummary(?)}";
	private final static String _DAILY_METER_COST_SUMMARY = "{CALL getDailyMeterCost()}";
	private final static String _DAILY_METER_ENERYG_PRODUCED_SUMMARY = "{CALL getDailyMeterKwhProduced()}";

	@Autowired
	private JdbcTemplate template;

	private Connection getConnection() throws SQLException {
		return template.getDataSource().getConnection();
	}

	public List<MeterEnergyCost> get24MeterEnergyCostSummary(Long meterid) throws SQLException {
		List<MeterEnergyCost> meterEnergyCostList = new ArrayList<MeterEnergyCost>();
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			callableStatement = connection.prepareCall(_METER_ENERYG_COST_SUMMARY_24);

			callableStatement.setLong(1, meterid);
			rs = callableStatement.executeQuery();
			while (rs.next()) {
				MeterEnergyCost result = mapMeterEnergyCostRow(rs);
				meterEnergyCostList.add(result);
			}
		} catch (SQLException e) {
			logger.error("Unexcepted error has Occured. " + e.getCause().getMessage());
		} finally {
			connection.close();
		}
		return meterEnergyCostList;
	}

	public List<MeterDaily> getDailyMeterCost() throws SQLException {
		List<MeterDaily> meterCostSummaryList = new ArrayList<MeterDaily>();
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			callableStatement = connection.prepareCall(_DAILY_METER_COST_SUMMARY);
			rs = callableStatement.executeQuery();
			while (rs.next()) {
				MeterDaily result = mapMeterDailyCostgRow(rs);
				meterCostSummaryList.add(result);
			}
		} catch (SQLException e) {
			logger.error("Unexcepted error has Occured. " + e.getCause().getMessage());
		} finally {
			connection.close();
		}
		return meterCostSummaryList;
	}

	public List<MeterDaily> getDailyMeterKwhProduced() throws SQLException {
		List<MeterDaily> meterCostSummaryList = new ArrayList<MeterDaily>();
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			if (connection != null) {
				callableStatement = connection.prepareCall(_DAILY_METER_ENERYG_PRODUCED_SUMMARY);
				rs = callableStatement.executeQuery();
				while (rs.next()) {
					MeterDaily result = mapMeterDailyEnergyRow(rs);
					meterCostSummaryList.add(result);
				}
			}
		} catch (SQLException e) {
			logger.error("Unexcepted error has Occured. " + e.getCause().getMessage());
		} finally {
			connection.close();
		}
		return meterCostSummaryList;
	}

}
