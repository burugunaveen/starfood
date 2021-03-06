package com.nibble.starfood.hibernatemodel;

// Generated 12 Sep, 2015 6:26:32 PM by Hibernate Tools 3.6.0

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TasteRel generated by hbm2java
 */
@Entity
@Table(name = "taste_rel", catalog = "starfoodlocal")
public class TasteRel implements java.io.Serializable {

	private Integer id;
	private int foodItmId;
	private int tasteId;

	public TasteRel() {
	}

	public TasteRel(int foodItmId, int tasteId) {
		this.foodItmId = foodItmId;
		this.tasteId = tasteId;
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

	@Column(name = "food_itm_id", nullable = false)
	public int getFoodItmId() {
		return this.foodItmId;
	}

	public void setFoodItmId(int foodItmId) {
		this.foodItmId = foodItmId;
	}

	@Column(name = "taste_id", nullable = false)
	public int getTasteId() {
		return this.tasteId;
	}

	public void setTasteId(int tasteId) {
		this.tasteId = tasteId;
	}

}
