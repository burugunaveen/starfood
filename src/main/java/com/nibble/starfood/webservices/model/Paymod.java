package com.nibble.starfood.webservices.model;

public class Paymod {
	
	private int paymodeId;
	private int custBillId;
	private String transactionId;

	//private int ordBillAmnt;

	public int getPaymodeId() {
		return paymodeId;
	}

	public void setPaymodeId(int paymodeId) {
		this.paymodeId = paymodeId;
	}

	

	public int getCustBillId() {
		return custBillId;
	}

	public void setCustBillId(int custBillId) {
		this.custBillId = custBillId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/*public int getOrdBillAmnt() {
		return ordBillAmnt;
	}

	public void setOrdBillAmnt(int ordBillAmnt) {
		this.ordBillAmnt = ordBillAmnt;
	}*/
	
}
