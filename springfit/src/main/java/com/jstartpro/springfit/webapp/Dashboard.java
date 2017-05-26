package com.jstartpro.springfit.webapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jstartpro.springfit.model.PlayerWeekTotal;

public class Dashboard {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/*
	 * SELECT PlayerTb_idPlayerTb AS playerId,
	SUM(cardio) AS cardioTotal,SUM(strength) AS strengthTotal ,
	SUM(strength+cardio) AS workoutTotal
	FROM statstb WHERE PlayerTb_idPlayerTb = ? AND
	wDate BETWEEN '2016-04-04' AND '2016-04-08'
	*/
	public PlayerWeekTotal getPlayerWeekTotalDatabase(int playerId,int week){
		PlayerWeekTotal playerWeekTotal = null;

		String weekStart = getWeekStart(week);
		String weekEnd = getWeekEnd(week);
		String sql = "SELECT "
				+ "PlayerTb_idPlayerTb AS playerId,"
				+ "SUM(cardio) AS cardioTotal,"
				+ "SUM(strength) AS strengthTotal ,"
				+ "SUM(strength+cardio) AS workoutTotal "
				+ "FROM statstb "
				+ "WHERE PlayerTb_idPlayerTb = ? AND wDate BETWEEN ? AND ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, playerId);
			ps.setString(2, weekStart);
			ps.setString(3, weekEnd);

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				playerWeekTotal = new PlayerWeekTotal(
					rs.getInt("playerId"),
					rs.getInt("cardioTotal"),
					rs.getInt("strengthTotal"),
					rs.getInt("workoutTotal")
				);
			}
			rs.close();
			ps.close();
			return playerWeekTotal;
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

	private String getWeekStart(int week) {
		String date = null;
		switch(week){
			case 1: date ="2016-03-07";break;
			case 2: date ="2016-03-14";break;
			case 3: date ="2016-03-21";break;
			case 4: date ="2016-04-28";break;
			case 5: date ="2016-04-04";break;
			case 6: date ="2016-04-11";break;
		}

		return date;
	}

	private String getWeekEnd(int week) {
		String date = null;
		switch(week){
			case 1: date ="2016-03-11";break;
			case 2: date ="2016-03-18";break;
			case 3: date ="2016-03-25";break;
			case 4: date ="2016-04-01";break;
			case 5: date ="2016-04-08";break;
			case 6: date ="2016-04-15";break;
		}

		return date;
	}

	public PlayerWeekTotal getPlayerWeekTotalWeb(int playerId) {
		System.setProperty("webdriver.chrome.driver", "F:\\swdtools\\SeleniumDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		int cardio = 0;
		int strength = 0;
		int workout = 0;
		try{

			driver.get("http://localhost/kudoscontest");
			wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver webDriver){
					System.out.println("Opening Dashboard....");
					return webDriver.findElement(By.id("p1cwt"))!=null;
				}
			});
			String cardioTotal =  driver.findElement(By.id("p"+playerId+"cwt")).getText();

			cardio = Integer.parseInt(cardioTotal);

			String strengthTotal =  driver.findElement(By.id("p"+playerId+"swt")).getText();
			strength = Integer.parseInt(strengthTotal);

			String workoutTotal =  driver.findElement(By.id("p"+playerId+"cswt")).getText();
			workout = Integer.parseInt(workoutTotal);


		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			driver.close();
		}
		PlayerWeekTotal actualPlayerWeekTotal = new PlayerWeekTotal(playerId, cardio, strength,workout);
		return actualPlayerWeekTotal;
	}
}
