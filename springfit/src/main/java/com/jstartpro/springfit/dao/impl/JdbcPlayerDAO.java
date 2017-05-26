package com.jstartpro.springfit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.jstartpro.springfit.dao.PlayerDAO;
import com.jstartpro.springfit.model.Player;

public class JdbcPlayerDAO implements PlayerDAO{
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public ArrayList<Player> getAllPlayers() {
		String sql = "SELECT * FROM playertb";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ArrayList<Player> playerList = new ArrayList<Player>();
			Player player;
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				player = new Player(
					rs.getInt("idPlayerTb"),
					rs.getString("playerName"),
					rs.getString("TeamTb_idTeamTb")
				);
				playerList.add(player);
			}
			rs.close();
			ps.close();
			return playerList;
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
	public Player getPlayer(int playerId) {
		String sql = "SELECT * FROM playertb WHERE idPlayerTb = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, playerId);
			Player player = null;
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				player = new Player(
					rs.getInt("idPlayerTb"),
					rs.getString("playerName"),
					rs.getString("TeamTb_idTeamTb")
				);
			}
			rs.close();
			ps.close();
			return player;
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
