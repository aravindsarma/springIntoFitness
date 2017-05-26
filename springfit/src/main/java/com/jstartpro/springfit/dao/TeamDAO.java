package com.jstartpro.springfit.dao;

import java.util.ArrayList;

import com.jstartpro.springfit.model.Team;

public interface TeamDAO {
	public ArrayList<Team> getAllTeams();
	public Team getTeam(int teamId);
}
