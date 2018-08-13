package com.nibble.starfood.ServiceImpl;

import java.util.List;

import com.nibble.starfood.webservices.model.Paymod;

public class PaymentStatusWrapper {

	private List<Paymod> paymod;

	public List<Paymod> getPaymod() {
		return paymod;
	}

	public void setPaymod(List<Paymod> paymod) {
		this.paymod = paymod;
	}
}
