package com.jstartpro.springfit.webapp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jstartpro.springfit.model.PlayerWeekTotal;

@RunWith(value = Parameterized.class)
public class DashboardTest {

	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	Dashboard dashboard = (Dashboard) context.getBean("dashboard");

	//playerId = 1,2,3 All Tests pass
	//4,5,6,7,8,9 -> 3 tests fail
	//0 -> 1 test fail, 3 test pas
	@Parameter
	public int playerId = 0;//default value
	@Parameters(name = "{index}: playerId - {0}")
    public static Object[] data() {
        return new Object[]{10,1,2,3,4,5,6,7,8,9};
    }

	int week = 5;

	@Test
	public void testGetPlayerWeekTotal_getPlayerId() {
		assertEquals(playerId, dashboard.getPlayerWeekTotalDatabase(playerId, week).getPlayerId());
	}

	@Test
	public void testGetPlayerWeekTotal_getCardioTotal() {
		PlayerWeekTotal expectedPlayerWeekTotal = dashboard.getPlayerWeekTotalDatabase(playerId, week);
		PlayerWeekTotal actualPlayerWeekTotal = dashboard.getPlayerWeekTotalWeb(playerId);
		assertEquals(expectedPlayerWeekTotal.getCardioTotal(),actualPlayerWeekTotal.getCardioTotal());
	}

	@Test
	public void testGetPlayerWeekTotal_getStrengthTotal() {
		PlayerWeekTotal expectedPlayerWeekTotal = dashboard.getPlayerWeekTotalDatabase(playerId, week);
		PlayerWeekTotal actualPlayerWeekTotal = dashboard.getPlayerWeekTotalWeb(playerId);
		assertEquals(expectedPlayerWeekTotal.getStrengthTotal(),actualPlayerWeekTotal.getStrengthTotal());
	}

	@Test
	public void testGetPlayerWeekTotal_getWorkoutTotal() {
		PlayerWeekTotal expectedPlayerWeekTotal = dashboard.getPlayerWeekTotalDatabase(playerId, week);
		PlayerWeekTotal actualPlayerWeekTotal = dashboard.getPlayerWeekTotalWeb(playerId);
		assertEquals(expectedPlayerWeekTotal.getWorkoutTotal(),actualPlayerWeekTotal.getWorkoutTotal());
	}

}
