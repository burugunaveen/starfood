package com.nibble.starfood.webservices.model;

public class GetFoodItems {
//	private int foodId;
	private int mealTime;
	private String dates;
	private int foodTypeId;
	private int priceDurationId;
	private int mealPlanId;
	private int start;
	private int end;

	/*public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}*/

	

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getMealTime() {
		return mealTime;
	}

	public void setMealTime(int mealTime) {
		this.mealTime = mealTime;
	}

	public int getPriceDurationId() {
		return priceDurationId;
	}

	public void setPriceDurationId(int priceDurationId) {
		this.priceDurationId = priceDurationId;
	}

	public int getFoodTypeId() {
		return foodTypeId;
	}

	public void setFoodTypeId(int foodTypeId) {
		this.foodTypeId = foodTypeId;
	}

	public int getMealPlanId() {
		return mealPlanId;
	}

	public void setMealPlanId(int mealPlanId) {
		this.mealPlanId = mealPlanId;
	}
	


}
