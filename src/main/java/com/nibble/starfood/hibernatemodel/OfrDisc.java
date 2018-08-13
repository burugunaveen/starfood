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
 * OfrDisc generated by hbm2java
 */
@Entity
@Table(name = "ofr_disc")
public class OfrDisc implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private int ofrDisCode;
	private String ofrDisDesc;
	private Date crtTs;
	private Date updTs;
	private String crtId;
	private String updId;

	public OfrDisc() {
	}

	public OfrDisc(int ofrDisCode, String ofrDisDesc, Date crtTs, Date updTs,
			String crtId) {
		this.ofrDisCode = ofrDisCode;
		this.ofrDisDesc = ofrDisDesc;
		this.crtTs = crtTs;
		this.updTs = updTs;
		this.crtId = crtId;
	}

	public OfrDisc(int ofrDisCode, String ofrDisDesc, Date crtTs, Date updTs,
			String crtId, String updId) {
		this.ofrDisCode = ofrDisCode;
		this.ofrDisDesc = ofrDisDesc;
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

	@Column(name = "ofr_dis_code", nullable = false)
	public int getOfrDisCode() {
		return this.ofrDisCode;
	}

	public void setOfrDisCode(int ofrDisCode) {
		this.ofrDisCode = ofrDisCode;
	}

	@Column(name = "ofr_dis_desc", nullable = false, length = 65535)
	public String getOfrDisDesc() {
		return this.ofrDisDesc;
	}

	public void setOfrDisDesc(String ofrDisDesc) {
		this.ofrDisDesc = ofrDisDesc;
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

	@Column(name = "upd_id", length = 100)
	public String getUpdId() {
		return this.updId;
	}

	public void setUpdId(String updId) {
		this.updId = updId;
	}

}