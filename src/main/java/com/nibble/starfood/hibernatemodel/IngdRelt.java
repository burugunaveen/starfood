package com.nibble.starfood.hibernatemodel;

// Generated 12 Sep, 2015 6:26:32 PM by Hibernate Tools 3.6.0

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
 * IngdRelt generated by hbm2java
 */
@Entity
@Table(name = "ingd_relt", catalog = "starfoodlocal")
public class IngdRelt implements java.io.Serializable {

	private Integer id;
	private int foodItmId;
	private int rawMatItmId;
	private int ingdQty;
	private int mesrId;
	private Date crtTs;
	private Date updTs;
	private String crtId;
	private String updId;

	public IngdRelt() {
	}

	public IngdRelt(int foodItmId, int rawMatItmId, int ingdQty, int mesrId,
			Date crtTs, String crtId) {
		this.foodItmId = foodItmId;
		this.rawMatItmId = rawMatItmId;
		this.ingdQty = ingdQty;
		this.mesrId = mesrId;
		this.crtTs = crtTs;
		this.crtId = crtId;
	}

	public IngdRelt(int foodItmId, int rawMatItmId, int ingdQty, int mesrId,
			Date crtTs, Date updTs, String crtId, String updId) {
		this.foodItmId = foodItmId;
		this.rawMatItmId = rawMatItmId;
		this.ingdQty = ingdQty;
		this.mesrId = mesrId;
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

	@Column(name = "food_itm_id", nullable = false)
	public int getFoodItmId() {
		return this.foodItmId;
	}

	public void setFoodItmId(int foodItmId) {
		this.foodItmId = foodItmId;
	}

	@Column(name = "raw_mat_itm_id", nullable = false)
	public int getRawMatItmId() {
		return this.rawMatItmId;
	}

	public void setRawMatItmId(int rawMatItmId) {
		this.rawMatItmId = rawMatItmId;
	}

	@Column(name = "ingd_qty", nullable = false)
	public int getIngdQty() {
		return this.ingdQty;
	}

	public void setIngdQty(int ingdQty) {
		this.ingdQty = ingdQty;
	}

	@Column(name = "mesr_id", nullable = false)
	public int getMesrId() {
		return this.mesrId;
	}

	public void setMesrId(int mesrId) {
		this.mesrId = mesrId;
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

	@Column(name = "crt_id", nullable = false, length = 100)
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
