package com.nibble.starfood.webservices.model;

public class EndDateCal {
	
	
	private int weekDayId;
	private int durationId;
	private String orderStartDate;
	
	public int getDurationId() {
		return durationId;
	}
	public void setDurationId(int durationId) {
		this.durationId = durationId;
	}
	public int getWeekDayId() {
		return weekDayId;
	}
	public void setWeekDayId(int weekDayId) {
		this.weekDayId = weekDayId;
	}
	public String getOrderStartDate() {
		return orderStartDate;
	}
	public void setOrderStartDate(String orderStartDate) {
		this.orderStartDate = orderStartDate;
	}

}
