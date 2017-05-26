package com.jstartpro.springfit.model;

public class Stats {
	private int statsId;
	private String wDate;
	private int strength;
	private int cardio;
	private int playerId;

	public Stats(int statsId, String wDate, int strength, int cardio, int playerId) {
		this.statsId = statsId;
		this.wDate = wDate;
		this.strength = strength;
		this.cardio = cardio;
		this.playerId = playerId;
	}
	public int getStatsId() {
		return statsId;
	}
	public void setStatsId(int statsId) {
		this.statsId = statsId;
	}
	public String getwDate() {
		return wDate;
	}
	public void setwDate(String wDate) {
		this.wDate = wDate;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getCardio() {
		return cardio;
	}
	public void setCardio(int cardio) {
		this.cardio = cardio;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}


}
