package com.nibble.starfood.webservices.model;

public class orderDatesDet {
	
	private String ordDate;
	private float dayPrice;
	public String getOrdDate() {
		return ordDate;
	}
	public void setOrdDate(String ordDate) {
		this.ordDate = ordDate;
	}
	public float getDayPrice() {
		return dayPrice;
	}
	public void setDayPrice(float dayPrice) {
		this.dayPrice = dayPrice;
	}
	@Override
	public String toString() {
		return "orderDateDet [ordDate=" + ordDate + ", dayPrice=" + dayPrice + "]";
	}
	
	

}
