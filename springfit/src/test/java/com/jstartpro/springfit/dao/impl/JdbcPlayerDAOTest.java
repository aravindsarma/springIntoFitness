package com.jstartpro.springfit.dao.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jstartpro.springfit.dao.PlayerDAO;
import com.jstartpro.springfit.model.Player;

public class JdbcPlayerDAOTest {
	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	PlayerDAO playerDAO = (PlayerDAO) context.getBean("playerDAO");

	@Test
	public void testGetAllPlayers() {
		ArrayList<Player> allPlayers = playerDAO.getAllPlayers();
	    assertEquals(9, allPlayers.size());
	}

	@Test
	public void testGetPlayer() {
		int playerId = 1;
		Player player = playerDAO.getPlayer(playerId);
		assertEquals("Aravind", player.getPlayerName());
	}

}
