package com.jstartpro.springfit.dao;

import java.util.ArrayList;

import com.jstartpro.springfit.model.Stats;

public interface StatsDAO {
	public ArrayList<Stats> getStats();
	public ArrayList<Stats> getStatsBetween(String startDate,String endDate);
	public Stats getStats(String wDate,int playerId);
}
