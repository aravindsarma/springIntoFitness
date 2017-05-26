package com.jstartpro.springfit.dao.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jstartpro.springfit.dao.TeamDAO;
import com.jstartpro.springfit.model.Team;

public class JdbcTeamDAOTest {
	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	TeamDAO teamDAO = (TeamDAO) context.getBean("teamDAO");

	@Test
	public void testGetAllTeams() {
		ArrayList<Team> teamList = teamDAO.getAllTeams();
		assertEquals(3, teamList.size());
	}

	@Test
	public void testGetTeam() {
		int teamId = 3;
		Team team = teamDAO.getTeam(teamId);
		assertEquals("Lean Men A",team.getTeamName());
	}

}
