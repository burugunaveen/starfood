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
 * RawMatCatg generated by hbm2java
 */
@Entity
@Table(name = "raw_mat_catg")
public class RawMatCatg implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String rawMatCatgDesc;
	private Boolean rawMatCatgF;
	private Date crtTs;
	private Date updTs;
	private String crtId;
	private String updId;

	public RawMatCatg() {
	}

	public RawMatCatg(String rawMatCatgDesc, Date crtTs, Date updTs) {
		this.rawMatCatgDesc = rawMatCatgDesc;
		this.crtTs = crtTs;
		this.updTs = updTs;
	}

	public RawMatCatg(String rawMatCatgDesc, Boolean rawMatCatgF, Date crtTs,
			Date updTs, String crtId, String updId) {
		this.rawMatCatgDesc = rawMatCatgDesc;
		this.rawMatCatgF = rawMatCatgF;
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

	@Column(name = "raw_mat_catg_desc", nullable = false, length = 1000)
	public String getRawMatCatgDesc() {
		return this.rawMatCatgDesc;
	}

	public void setRawMatCatgDesc(String rawMatCatgDesc) {
		this.rawMatCatgDesc = rawMatCatgDesc;
	}

	@Column(name = "raw_mat_catg_f")
	public Boolean getRawMatCatgF() {
		return this.rawMatCatgF;
	}

	public void setRawMatCatgF(Boolean rawMatCatgF) {
		this.rawMatCatgF = rawMatCatgF;
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
