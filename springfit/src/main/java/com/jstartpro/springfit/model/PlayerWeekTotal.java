package com.jstartpro.springfit.model;

public class PlayerWeekTotal {
	private int playerId;
	private int cardioTotal;
	private int strengthTotal;
	private int workoutTotal;
	public PlayerWeekTotal(int playerId, int cardioTotal, int strengthTotal, int workoutTotal) {
		super();
		this.playerId = playerId;
		this.cardioTotal = cardioTotal;
		this.strengthTotal = strengthTotal;
		this.workoutTotal = workoutTotal;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public int getCardioTotal() {
		return cardioTotal;
	}
	public void setCardioTotal(int cardioTotal) {
		this.cardioTotal = cardioTotal;
	}
	public int getStrengthTotal() {
		return strengthTotal;
	}
	public void setStrengthTotal(int strengthTotal) {
		this.strengthTotal = strengthTotal;
	}
	public int getWorkoutTotal() {
		return workoutTotal;
	}
	public void setWorkoutTotal(int workoutTotal) {
		this.workoutTotal = workoutTotal;
	}

}
