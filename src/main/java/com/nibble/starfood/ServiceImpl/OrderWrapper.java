package com.nibble.starfood.ServiceImpl;

import java.util.List;

import com.nibble.starfood.webservices.model.CustOrderDetails;
import com.nibble.starfood.webservices.model.DatesList;

public class OrderWrapper {
	private CustOrderDetails orders;

	public CustOrderDetails getOrders() {
		return orders;
	}

	public void setOrders(CustOrderDetails orders) {
		this.orders = orders;
	}
	
	//private List<DatesList> dates;

	/*public List<CustOrderDetails> getOrders() {
		return orders;
	}

	public void setOrders(List<CustOrderDetails> orders) {
		this.orders = orders;
	}*/

	/*public List<DatesList> getDates() {
		return dates;
	}

	public void setDates(List<DatesList> dates) {
		this.dates = dates;
	}*/
	

}
