package com.nibble.starfood.hibernatemodel;

// Generated 12 Sep, 2015 3:44:29 PM by Hibernate Tools 3.6.0

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * FoodCatg generated by hbm2java
 */
@Entity
@Table(name = "food_catg")
public class FoodCatg implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
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

	public FoodCatg() {
	}

	public FoodCatg(int catgSection, int kotCatg, String foodCatgTypDescEn,
			int foodCatgSrlNo, boolean foodCatgVisF, Date crtTs) {
		this.catgSection = catgSection;
		this.kotCatg = kotCatg;
		this.foodCatgTypDescEn = foodCatgTypDescEn;
		this.foodCatgSrlNo = foodCatgSrlNo;
		this.foodCatgVisF = foodCatgVisF;
		this.crtTs = crtTs;
	}

	public FoodCatg(Integer foodCatgTypCode, int catgSection, int kotCatg,
			String foodCatgTypDescEn, String foodCatgTypDescHn,
			String foodCatgTypDescUr, String catgImage, int foodCatgSrlNo,
			boolean foodCatgVisF, Date crtTs, Date updTs, String crtId,
			String updId) {
		this.foodCatgTypCode = foodCatgTypCode;
		this.catgSection = catgSection;
		this.kotCatg = kotCatg;
		this.foodCatgTypDescEn = foodCatgTypDescEn;
		this.foodCatgTypDescHn = foodCatgTypDescHn;
		this.foodCatgTypDescUr = foodCatgTypDescUr;
		this.catgImage = catgImage;
		this.foodCatgSrlNo = foodCatgSrlNo;
		this.foodCatgVisF = foodCatgVisF;
		this.crtTs = crtTs;
		this.updTs = updTs;
		this.crtId = crtId;
		this.updId = updId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "food_catg_typ_code")
	public Integer getFoodCatgTypCode() {
		return this.foodCatgTypCode;
	}

	public void setFoodCatgTypCode(Integer foodCatgTypCode) {
		this.foodCatgTypCode = foodCatgTypCode;
	}

	@Column(name = "catg_section", nullable = false)
	public int getCatgSection() {
		return this.catgSection;
	}

	public void setCatgSection(int catgSection) {
		this.catgSection = catgSection;
	}

	@Column(name = "kot_catg", nullable = false)
	public int getKotCatg() {
		return this.kotCatg;
	}

	public void setKotCatg(int kotCatg) {
		this.kotCatg = kotCatg;
	}

	@Column(name = "food_catg_typ_desc_en", nullable = false)
	public String getFoodCatgTypDescEn() {
		return this.foodCatgTypDescEn;
	}

	public void setFoodCatgTypDescEn(String foodCatgTypDescEn) {
		this.foodCatgTypDescEn = foodCatgTypDescEn;
	}

	@Column(name = "food_catg_typ_desc_hn")
	public String getFoodCatgTypDescHn() {
		return this.foodCatgTypDescHn;
	}

	public void setFoodCatgTypDescHn(String foodCatgTypDescHn) {
		this.foodCatgTypDescHn = foodCatgTypDescHn;
	}

	@Column(name = "food_catg_typ_desc_ur")
	public String getFoodCatgTypDescUr() {
		return this.foodCatgTypDescUr;
	}

	public void setFoodCatgTypDescUr(String foodCatgTypDescUr) {
		this.foodCatgTypDescUr = foodCatgTypDescUr;
	}

	@Column(name = "catg_image", length = 100)
	public String getCatgImage() {
		return this.catgImage;
	}

	public void setCatgImage(String catgImage) {
		this.catgImage = catgImage;
	}

	@Column(name = "food_catg_srl_no", nullable = false)
	public int getFoodCatgSrlNo() {
		return this.foodCatgSrlNo;
	}

	public void setFoodCatgSrlNo(int foodCatgSrlNo) {
		this.foodCatgSrlNo = foodCatgSrlNo;
	}

	@Column(name = "food_catg_vis_f", nullable = false)
	public boolean isFoodCatgVisF() {
		return this.foodCatgVisF;
	}

	public void setFoodCatgVisF(boolean foodCatgVisF) {
		this.foodCatgVisF = foodCatgVisF;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "crt_ts", nullable = false, length = 19)
	public Date getCrtTs() {
		return this.crtTs;
	}

	public void setCrtTs(Date crtTs) {
		this.crtTs = crtTs;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "upd_ts", length = 19)
	public Date getUpdTs() {
		return this.updTs;
	}

	public void setUpdTs(Date updTs) {
		this.updTs = updTs;
	}

	@Column(name = "crt_id", length = 100)
	public String getCrtId() {
		return this.crtId;
	}

	public void setCrtId(String crtId) {
		this.crtId = crtId;
	}

	@Column(name = "upd_id", length = 100)
	public String getUpdId() {
		return this.updId;
	}

	public void setUpdId(String updId) {
		this.updId = updId;
	}

}
