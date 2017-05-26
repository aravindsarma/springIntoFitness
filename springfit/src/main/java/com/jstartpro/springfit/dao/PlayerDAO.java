package com.jstartpro.springfit.dao;

import java.util.ArrayList;

import com.jstartpro.springfit.model.Player;

public interface PlayerDAO {
	public ArrayList<Player> getAllPlayers();
	public Player getPlayer(int playerId);
}
