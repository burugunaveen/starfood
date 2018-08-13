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
 * Time generated by hbm2java
 */
@Entity
@Table(name = "time", catalog = "starfoodlocal")
public class Time implements java.io.Serializable {

	private Integer id;
	private String timeOne;
	private String timeTwo;
	private String crtId;
	private Date crtTs;
	private String updId;
	private Date updTs;

	public Time() {
	}

	public Time(String timeOne, String timeTwo, Date crtTs, Date updTs) {
		this.timeOne = timeOne;
		this.timeTwo = timeTwo;
		this.crtTs = crtTs;
		this.updTs = updTs;
	}

	public Time(String timeOne, String timeTwo, String crtId, Date crtTs,
			String updId, Date updTs) {
		this.timeOne = timeOne;
		this.timeTwo = timeTwo;
		this.crtId = crtId;
		this.crtTs = crtTs;
		this.updId = updId;
		this.updTs = updTs;
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

	@Column(name = "time_one", nullable = false, length = 45)
	public String getTimeOne() {
		return this.timeOne;
	}

	public void setTimeOne(String timeOne) {
		this.timeOne = timeOne;
	}

	@Column(name = "time_two", nullable = false, length = 45)
	public String getTimeTwo() {
		return this.timeTwo;
	}

	public void setTimeTwo(String timeTwo) {
		this.timeTwo = timeTwo;
	}

	@Column(name = "crt_id", length = 45)
	public String getCrtId() {
		return this.crtId;
	}

	public void setCrtId(String crtId) {
		this.crtId = crtId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "crt_ts", nullable = false, length = 19)
	public Date getCrtTs() {
		return this.crtTs;
	}

	public void setCrtTs(Date crtTs) {
		this.crtTs = crtTs;
	}

	@Column(name = "upd_id", length = 45)
	public String getUpdId() {
		return this.updId;
	}

	public void setUpdId(String updId) {
		this.updId = updId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "upd_ts", nullable = false, length = 19)
	public Date getUpdTs() {
		return this.updTs;
	}

	public void setUpdTs(Date updTs) {
		this.updTs = updTs;
	}

}
