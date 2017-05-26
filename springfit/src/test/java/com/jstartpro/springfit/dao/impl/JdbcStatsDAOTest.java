package com.jstartpro.springfit.dao.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jstartpro.springfit.dao.StatsDAO;
import com.jstartpro.springfit.model.Stats;

public class JdbcStatsDAOTest {
	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	StatsDAO statsDAO = (StatsDAO) context.getBean("statsDAO");


	@Test
	public void testGetStats() {

        ArrayList<Stats> allStats = statsDAO.getStats();
        assertEquals(225, allStats.size());
	}

	@Test
	public void testGetStatsBetween() {
		String startDate = "2016-03-07";
        String endDate = "2016-03-11";
        ArrayList<Stats> week1Stats = statsDAO.getStatsBetween(startDate, endDate);
        assertEquals(45, week1Stats.size());

	}

}
