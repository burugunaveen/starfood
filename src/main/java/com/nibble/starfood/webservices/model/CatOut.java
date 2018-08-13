package com.nibble.starfood.webservices.model;

import java.util.Date;

public class CatOut {
	private Integer id;
	private Integer foodCatgTypCode;
	private int catgSection;
	private int kotCatg;
	private String foodCatgTypDescEn;
	private String foodCatgTypDescHn;
	private String foodCatgTypDescUr;
	private String catgImage;
	private int foodCatgSrlNo;
	private boolean foodCatgVisF;
	private Date crtTs;
	private Date updTs;
	private String crtId;
	private String updId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFoodCatgTypCode() {
		return foodCatgTypCode;
	}
	public void setFoodCatgTypCode(Integer foodCatgTypCode) {
		this.foodCatgTypCode = foodCatgTypCode;
	}
	public int getCatgSection() {
		return catgSection;
	}
	public void setCatgSection(int catgSection) {
		this.catgSection = catgSection;
	}
	public int getKotCatg() {
		return kotCatg;
	}
	public void setKotCatg(int kotCatg) {
		this.kotCatg = kotCatg;
	}
	public String getFoodCatgTypDescEn() {
		return foodCatgTypDescEn;
	}
	public void setFoodCatgTypDescEn(String foodCatgTypDescEn) {
		this.foodCatgTypDescEn = foodCatgTypDescEn;
	}
	public String getFoodCatgTypDescHn() {
		return foodCatgTypDescHn;
	}
	public void setFoodCatgTypDescHn(String foodCatgTypDescHn) {
		this.foodCatgTypDescHn = foodCatgTypDescHn;
	}
	public String getFoodCatgTypDescUr() {
		return foodCatgTypDescUr;
	}
	public void setFoodCatgTypDescUr(String foodCatgTypDescUr) {
		this.foodCatgTypDescUr = foodCatgTypDescUr;
	}
	public String getCatgImage() {
		return catgImage;
	}
	public void setCatgImage(String catgImage) {
		this.catgImage = catgImage;
	}
	public int getFoodCatgSrlNo() {
		return foodCatgSrlNo;
	}
	public void setFoodCatgSrlNo(int foodCatgSrlNo) {
		this.foodCatgSrlNo = foodCatgSrlNo;
	}
	public boolean isFoodCatgVisF() {
		return foodCatgVisF;
	}
	public void setFoodCatgVisF(boolean foodCatgVisF) {
		this.foodCatgVisF = foodCatgVisF;
	}
	public Date getCrtTs() {
		return crtTs;
	}
	public void setCrtTs(Date crtTs) {
		this.crtTs = crtTs;
	}
	public Date getUpdTs() {
		return updTs;
	}
	public void setUpdTs(Date updTs) {
		this.updTs = updTs;
	}
	public String getCrtId() {
		return crtId;
	}
	public void setCrtId(String crtId) {
		this.crtId = crtId;
	}
	public String getUpdId() {
		return updId;
	}
	public void setUpdId(String updId) {
		this.updId = updId;
	}
	

}
