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
 * Cntry generated by hbm2java
 */
@Entity
@Table(name = "cntry")
public class Cntry implements java.io.Serializable {
	private static final long serialVersionUID = 1L; Integer id;
	private String cntryDesc;
	private String lat;
	private String long_;
	private boolean cntryF;
	private Date crtTs;
	private Date updTs;
	private String crtId;
	private String updId;

	public Cntry() {
	}

	public Cntry(String cntryDesc, boolean cntryF, Date crtTs, Date updTs,
			String crtId, String updId) {
		this.cntryDesc = cntryDesc;
		this.cntryF = cntryF;
		this.crtTs = crtTs;
		this.updTs = updTs;
		this.crtId = crtId;
		this.updId = updId;
	}

	public Cntry(String cntryDesc, String lat, String long_, boolean cntryF,
			Date crtTs, Date updTs, String crtId, String updId) {
		this.cntryDesc = cntryDesc;
		this.lat = lat;
		this.long_ = long_;
		this.cntryF = cntryF;
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

	@Column(name = "cntry_desc", nullable = false, length = 100)
	public String getCntryDesc() {
		return this.cntryDesc;
	}

	public void setCntryDesc(String cntryDesc) {
		this.cntryDesc = cntryDesc;
	}

	@Column(name = "lat", length = 500)
	public String getLat() {
		return this.lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	@Column(name = "long", length = 500)
	public String getLong_() {
		return this.long_;
	}

	public void setLong_(String long_) {
		this.long_ = long_;
	}

	@Column(name = "cntry_f", nullable = false)
	public boolean isCntryF() {
		return this.cntryF;
	}

	public void setCntryF(boolean cntryF) {
		this.cntryF = cntryF;
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

	@Column(name = "crt_id", nullable = false, length = 100)
	public String getCrtId() {
		return this.crtId;
	}

	public void setCrtId(String crtId) {
		this.crtId = crtId;
	}

	@Column(name = "upd_id", nullable = false, length = 100)
	public String getUpdId() {
		return this.updId;
	}

	public void setUpdId(String updId) {
		this.updId = updId;
	}

}
