package com.nibble.starfood.webservices.model;

import java.util.List;

import com.nibble.starfood.hibernatemodel.Area;
import com.nibble.starfood.hibernatemodel.Pincode;

public class OrderJsonObject {
	
	int iTotalRecords;
	int iTotalDisplayRecords;
    List<Pincode> aaData;

	public int getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public List<Pincode> getAaData() {
		return aaData;
	}

	public void setAaData(List<Pincode> aaData) {
		this.aaData = aaData;
	}
    

}
