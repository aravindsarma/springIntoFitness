package com.jstartpro.springfit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.jstartpro.springfit.dao.StatsDAO;
import com.jstartpro.springfit.model.Stats;

public class JdbcStatsDAO implements StatsDAO{

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public ArrayList<Stats> getStats() {
		String sql = "SELECT * FROM statstb";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ArrayList<Stats> statsList = new ArrayList<Stats>();
			Stats stats;
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				stats = new Stats(
					rs.getInt("idStatsTb"),
					rs.getString("wDate"),
					rs.getInt("strength"),
					rs.getInt("cardio"),
					rs.getInt("PlayerTb_idPlayerTb")
				);
				statsList.add(stats);
			}
			rs.close();
			ps.close();
			return statsList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}

	}

	@Override
	public ArrayList<Stats> getStatsBetween(String startDate, String endDate) {
		String sql = "SELECT idStatsTb,wDate,strength,cardio,PlayerTb_idPlayerTb"
				+ " FROM statstb WHERE wDate BETWEEN ? and ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, startDate);
			ps.setString(2, endDate);
			ArrayList<Stats> statsList = new ArrayList<Stats>();
			Stats stats;
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				stats = new Stats(
					rs.getInt("idStatsTb"),
					rs.getString("wDate"),
					rs.getInt("strength"),
					rs.getInt("cardio"),
					rs.getInt("PlayerTb_idPlayerTb")
				);
				statsList.add(stats);
			}
			rs.close();
			ps.close();
			return statsList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public Stats getStats(String wDate, int playerId) {
		String sql = "SELECT idStatsTb,wDate,strength,cardio,PlayerTb_idPlayerTb "
				+ "FROM statstb "
				+ "WHERE wDate = ? AND PlayerTb_idPlayerTb = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, wDate);
			ps.setInt(2, playerId);
			Stats stats = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				stats = new Stats(
					rs.getInt("idStatsTb"),
					rs.getString("wDate"),
					rs.getInt("strength"),
					rs.getInt("cardio"),
					rs.getInt("PlayerTb_idPlayerTb")
				);
			}
			rs.close();
			ps.close();
			return stats;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}

	}
}
