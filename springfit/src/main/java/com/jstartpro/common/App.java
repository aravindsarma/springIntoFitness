package com.jstartpro.common;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jstartpro.springfit.dao.StatsDAO;
import com.jstartpro.springfit.model.Stats;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

        StatsDAO statsDAO = (StatsDAO) context.getBean("statsDAO");

        String wDate = "2016-03-07";
        int playerId = 1;
        Stats stats = statsDAO.getStats(wDate, playerId);
        System.out.println("Stats.getStrength():"+stats.getStrength());

        ArrayList<Stats> allStats = statsDAO.getStats();
        System.out.println("Number of all records in database: " + allStats.size());

        String startDate = "2016-03-07";
        String endDate = "2016-03-11";
        ArrayList<Stats> week1Stats = statsDAO.getStatsBetween(startDate, endDate);
        System.out.println("Number of records for Week 1: " + week1Stats.size());
	}

}
