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
 * ReqCall generated by hbm2java
 */
@Entity
@Table(name = "req_call", catalog = "spiceboxcoupon")
public class ReqCall implements java.io.Serializable {

	private Integer id;
	private int reqDetailsId;
	private int tblNo;
	private boolean flag;
	private String crtId;
	private Date crtTs;
	private String updId;
	private Date updTs;

	public ReqCall() {
	}

	public ReqCall(int reqDetailsId, int tblNo, boolean flag, Date crtTs,
			Date updTs) {
		this.reqDetailsId = reqDetailsId;
		this.tblNo = tblNo;
		this.flag = flag;
		this.crtTs = crtTs;
		this.updTs = updTs;
	}

	public ReqCall(int reqDetailsId, int tblNo, boolean flag, String crtId,
			Date crtTs, String updId, Date updTs) {
		this.reqDetailsId = reqDetailsId;
		this.tblNo = tblNo;
		this.flag = flag;
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

	@Column(name = "req_details_id", nullable = false)
	public int getReqDetailsId() {
		return this.reqDetailsId;
	}

	public void setReqDetailsId(int reqDetailsId) {
		this.reqDetailsId = reqDetailsId;
	}

	@Column(name = "tbl_no", nullable = false)
	public int getTblNo() {
		return this.tblNo;
	}

	public void setTblNo(int tblNo) {
		this.tblNo = tblNo;
	}

	@Column(name = "flag", nullable = false)
	public boolean isFlag() {
		return this.flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
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
