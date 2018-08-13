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
 * WaiterCall generated by hbm2java
 */
@Entity
@Table(name = "waiter_call", catalog = "spiceboxcoupon")
public class WaiterCall implements java.io.Serializable {

	private Integer id;
	private int tableNo;
	private String deviceId;
	private String status;
	private Date crtTs;
	private Date updTs;
	private String crtId;
	private String updId;
	private String reqTyp;

	public WaiterCall() {
	}

	public WaiterCall(int tableNo, Date crtTs, Date updTs, String crtId) {
		this.tableNo = tableNo;
		this.crtTs = crtTs;
		this.updTs = updTs;
		this.crtId = crtId;
	}

	public WaiterCall(int tableNo, String deviceId, String status, Date crtTs,
			Date updTs, String crtId, String updId, String reqTyp) {
		this.tableNo = tableNo;
		this.deviceId = deviceId;
		this.status = status;
		this.crtTs = crtTs;
		this.updTs = updTs;
		this.crtId = crtId;
		this.updId = updId;
		this.reqTyp = reqTyp;
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

	@Column(name = "table_no", nullable = false)
	public int getTableNo() {
		return this.tableNo;
	}

	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}

	@Column(name = "device_id", length = 100)
	public String getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Column(name = "status", length = 50)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	@Column(name = "crt_id", nullable = false, length = 2555)
	public String getCrtId() {
		return this.crtId;
	}

	public void setCrtId(String crtId) {
		this.crtId = crtId;
	}

	@Column(name = "upd_id")
	public String getUpdId() {
		return this.updId;
	}

	public void setUpdId(String updId) {
		this.updId = updId;
	}

	@Column(name = "req_typ", length = 45)
	public String getReqTyp() {
		return this.reqTyp;
	}

	public void setReqTyp(String reqTyp) {
		this.reqTyp = reqTyp;
	}

}
