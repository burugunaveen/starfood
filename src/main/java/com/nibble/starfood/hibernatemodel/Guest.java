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
 * Guest generated by hbm2java
 */
@Entity
@Table(name = "guest", catalog = "spiceboxcoupon")
public class Guest implements java.io.Serializable {

	private Integer id;
	private String guestName;
	private String contactNo;
	private String questEmailId;
	private String tableSeater;
	private Date crtTs;
	private Date updTs;
	private String crtId;
	private String updId;
	private int status;

	public Guest() {
	}

	public Guest(String guestName, String contactNo, Date crtTs, Date updTs,
			String crtId, int status) {
		this.guestName = guestName;
		this.contactNo = contactNo;
		this.crtTs = crtTs;
		this.updTs = updTs;
		this.crtId = crtId;
		this.status = status;
	}

	public Guest(String guestName, String contactNo, String questEmailId,
			String tableSeater, Date crtTs, Date updTs, String crtId,
			String updId, int status) {
		this.guestName = guestName;
		this.contactNo = contactNo;
		this.questEmailId = questEmailId;
		this.tableSeater = tableSeater;
		this.crtTs = crtTs;
		this.updTs = updTs;
		this.crtId = crtId;
		this.updId = updId;
		this.status = status;
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

	@Column(name = "guest_name", nullable = false, length = 65535)
	public String getGuestName() {
		return this.guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	@Column(name = "contact_no", nullable = false, length = 100)
	public String getContactNo() {
		return this.contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Column(name = "quest_email_id", length = 65535)
	public String getQuestEmailId() {
		return this.questEmailId;
	}

	public void setQuestEmailId(String questEmailId) {
		this.questEmailId = questEmailId;
	}

	@Column(name = "table_seater", length = 65535)
	public String getTableSeater() {
		return this.tableSeater;
	}

	public void setTableSeater(String tableSeater) {
		this.tableSeater = tableSeater;
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

	@Column(name = "status", nullable = false)
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}