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
 * RawMatItmPurHist generated by hbm2java
 */
@Entity
@Table(name = "raw_mat_itm_pur_hist")
public class RawMatItmPurHist implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private int rawMatItmId;
	private String rawMatUntPrc;
	private Integer rawMatUntPer;
	private int mesrId;
	private int rawMatPurQty;
	private String rawMatPurDt;
	private String rawMatVendId;
	private String rawMatBrndId;
	private Date crtTs;
	private Date updTs;
	private String crtId;
	private String updId;

	public RawMatItmPurHist() {
	}

	public RawMatItmPurHist(int rawMatItmId, String rawMatUntPrc, int mesrId,
			int rawMatPurQty, Date crtTs, Date updTs) {
		this.rawMatItmId = rawMatItmId;
		this.rawMatUntPrc = rawMatUntPrc;
		this.mesrId = mesrId;
		this.rawMatPurQty = rawMatPurQty;
		this.crtTs = crtTs;
		this.updTs = updTs;
	}

	public RawMatItmPurHist(int rawMatItmId, String rawMatUntPrc,
			Integer rawMatUntPer, int mesrId, int rawMatPurQty,
			String rawMatPurDt, String rawMatVendId, String rawMatBrndId,
			Date crtTs, Date updTs, String crtId, String updId) {
		this.rawMatItmId = rawMatItmId;
		this.rawMatUntPrc = rawMatUntPrc;
		this.rawMatUntPer = rawMatUntPer;
		this.mesrId = mesrId;
		this.rawMatPurQty = rawMatPurQty;
		this.rawMatPurDt = rawMatPurDt;
		this.rawMatVendId = rawMatVendId;
		this.rawMatBrndId = rawMatBrndId;
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

	@Column(name = "raw_mat_itm_id", nullable = false)
	public int getRawMatItmId() {
		return this.rawMatItmId;
	}

	public void setRawMatItmId(int rawMatItmId) {
		this.rawMatItmId = rawMatItmId;
	}

	@Column(name = "raw_mat_unt_prc", nullable = false, length = 500)
	public String getRawMatUntPrc() {
		return this.rawMatUntPrc;
	}

	public void setRawMatUntPrc(String rawMatUntPrc) {
		this.rawMatUntPrc = rawMatUntPrc;
	}

	@Column(name = "raw_mat_unt_per")
	public Integer getRawMatUntPer() {
		return this.rawMatUntPer;
	}

	public void setRawMatUntPer(Integer rawMatUntPer) {
		this.rawMatUntPer = rawMatUntPer;
	}

	@Column(name = "mesr_id", nullable = false)
	public int getMesrId() {
		return this.mesrId;
	}

	public void setMesrId(int mesrId) {
		this.mesrId = mesrId;
	}

	@Column(name = "raw_mat_pur_qty", nullable = false)
	public int getRawMatPurQty() {
		return this.rawMatPurQty;
	}

	public void setRawMatPurQty(int rawMatPurQty) {
		this.rawMatPurQty = rawMatPurQty;
	}

	@Column(name = "raw_mat_pur_dt", length = 500)
	public String getRawMatPurDt() {
		return this.rawMatPurDt;
	}

	public void setRawMatPurDt(String rawMatPurDt) {
		this.rawMatPurDt = rawMatPurDt;
	}

	@Column(name = "raw_mat_vend_id", length = 1000)
	public String getRawMatVendId() {
		return this.rawMatVendId;
	}

	public void setRawMatVendId(String rawMatVendId) {
		this.rawMatVendId = rawMatVendId;
	}

	@Column(name = "raw_mat_brnd_id", length = 500)
	public String getRawMatBrndId() {
		return this.rawMatBrndId;
	}

	public void setRawMatBrndId(String rawMatBrndId) {
		this.rawMatBrndId = rawMatBrndId;
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
	@Column(name = "upd_ts", nullable = false, length = 19)
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
