package com.nibble.starfood.webservices.model;

public class OrderCancel {

	private int orderId;
    private int quantity;
    private int custId;
    //private String cupnCode;
    private String cancelDate;
    
    public String getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}

	private int mealPricePerDay;

    public int getOrderId() {
	return orderId;
    }

    public void setOrderId(int orderId) {
	this.orderId = orderId;
    }

    public int getQuantity() {
	return quantity;
    }

    public void setQuantity(int quantity) {
	this.quantity = quantity;
    }

    public int getCustId() {
	return custId;
    }

    public void setCustId(int custId) {
	this.custId = custId;
    }

    

	/*public String getCupnCode() {
		return cupnCode;
	}

	public void setCupnCode(String cupnCode) {
		this.cupnCode = cupnCode;
	}*/

	public int getMealPricePerDay() {
		return mealPricePerDay;
	}

	public void setMealPricePerDay(int mealPricePerDay) {
		this.mealPricePerDay = mealPricePerDay;
	}

}
