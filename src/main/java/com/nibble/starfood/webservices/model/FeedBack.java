package com.nibble.starfood.webservices.model;

public class FeedBack {
	
	private int custDetId;
	private int fdbkQuesId;
	private String fdbkQuesResp;
	private String comment;
	public int getCustDetId() {
		return custDetId;
	}
	public void setCustDetId(int custDetId) {
		this.custDetId = custDetId;
	}
	public int getFdbkQuesId() {
		return fdbkQuesId;
	}
	public void setFdbkQuesId(int fdbkQuesId) {
		this.fdbkQuesId = fdbkQuesId;
	}
	public String getFdbkQuesResp() {
		return fdbkQuesResp;
	}
	public void setFdbkQuesResp(String fdbkQuesResp) {
		this.fdbkQuesResp = fdbkQuesResp;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	

}
