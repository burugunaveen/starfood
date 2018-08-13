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
 * Appointment generated by hbm2java
 */
@Entity
@Table(name = "appointment")
public class Appointment implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String cntcNo;
	private String email;
	private String specialNotes;
	private String noOfGuest;
	private String bookTyp;
	private String newDate;
	private String time;
	private String tblAssign;
	private String crtId;
	private Date crtTs;
	private String updId;
	private Date updTs;

	public Appointment() {
	}

	public Appointment(String name, String cntcNo, String email,
			String specialNotes, String newDate, String time, Date crtTs,
			Date updTs) {
		this.name = name;
		this.cntcNo = cntcNo;
		this.email = email;
		this.specialNotes = specialNotes;
		this.newDate = newDate;
		this.time = time;
		this.crtTs = crtTs;
		this.updTs = updTs;
	}

	public Appointment(String name, String cntcNo, String email,
			String specialNotes, String noOfGuest, String bookTyp,
			String newDate, String time, String tblAssign, String crtId,
			Date crtTs, String updId, Date updTs) {
		this.name = name;
		this.cntcNo = cntcNo;
		this.email = email;
		this.specialNotes = specialNotes;
		this.noOfGuest = noOfGuest;
		this.bookTyp = bookTyp;
		this.newDate = newDate;
		this.time = time;
		this.tblAssign = tblAssign;
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

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "cntc_no", nullable = false, length = 100)
	public String getCntcNo() {
		return this.cntcNo;
	}

	public void setCntcNo(String cntcNo) {
		this.cntcNo = cntcNo;
	}

	@Column(name = "email", nullable = false, length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "special_notes", nullable = false, length = 45)
	public String getSpecialNotes() {
		return this.specialNotes;
	}

	public void setSpecialNotes(String specialNotes) {
		this.specialNotes = specialNotes;
	}

	@Column(name = "no_of_guest", length = 100)
	public String getNoOfGuest() {
		return this.noOfGuest;
	}

	public void setNoOfGuest(String noOfGuest) {
		this.noOfGuest = noOfGuest;
	}

	@Column(name = "book_typ", length = 100)
	public String getBookTyp() {
		return this.bookTyp;
	}

	public void setBookTyp(String bookTyp) {
		this.bookTyp = bookTyp;
	}

	@Column(name = "new_date", nullable = false, length = 45)
	public String getNewDate() {
		return this.newDate;
	}

	public void setNewDate(String newDate) {
		this.newDate = newDate;
	}

	@Column(name = "time", nullable = false, length = 45)
	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Column(name = "tbl_assign", length = 100)
	public String getTblAssign() {
		return this.tblAssign;
	}

	public void setTblAssign(String tblAssign) {
		this.tblAssign = tblAssign;
	}

	@Column(name = "crt_id", length = 100)
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

	@Column(name = "upd_id", length = 100)
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
