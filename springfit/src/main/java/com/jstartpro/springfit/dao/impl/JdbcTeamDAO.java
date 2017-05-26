package com.jstartpro.springfit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.jstartpro.springfit.dao.TeamDAO;
import com.jstartpro.springfit.model.Team;

public class JdbcTeamDAO implements TeamDAO{
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public ArrayList<Team> getAllTeams() {
		String sql = "SELECT * FROM teamtb";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ArrayList<Team> teamList = new ArrayList<Team>();
			Team team;
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				team = new Team(
					rs.getInt("idTeamTb"),
					rs.getString("teamName")
				);
				teamList.add(team);
			}
			rs.close();
			ps.close();
			return teamList;
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
	public Team getTeam(int teamId) {
		String sql = "SELECT * FROM teamtb WHERE idTeamTb = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, teamId);
			Team team = null;
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				team = new Team(
					rs.getInt("idTeamTb"),
					rs.getString("teamName")
				);
			}
			rs.close();
			ps.close();
			return team;
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
