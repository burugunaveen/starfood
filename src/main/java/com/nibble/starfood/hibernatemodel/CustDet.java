package com.nibble.starfood.hibernatemodel;

// Generated 12 Sep, 2015 6:26:32 PM by Hibernate Tools 3.6.0

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Proxy;

/**
 * CustDet generated by hbm2java
 */
@Entity
@Table(name = "cust_det")
public class CustDet implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String custName;
	private String cntcNo;
	@JsonIgnore
	private String otp;
	@JsonIgnore
	private int otpF;
	@JsonIgnore
	private Byte addrTypId;
	@JsonIgnore
	private String emailId;
	@JsonIgnore
	private String custCode;
	@JsonIgnore
	private float cupnRedmAmnt;
	@JsonIgnore
	private String fbId;
	@JsonIgnore
	private String twId;
	@JsonIgnore
	private String gplusId;
	@JsonIgnore
	private String linkedinId;
	@JsonIgnore
	private Date crtTs;
	@JsonIgnore
	private Date updTs;
	@JsonIgnore
	private String crtId;
	@JsonIgnore
	private String updId;
	private String custPw;
	private int guestF;
	@JsonIgnore
	private Set<CustOrdDet> orders = new HashSet<CustOrdDet>();

	public CustDet() {
	}

	public CustDet(int otpF, Date crtTs, String crtId, String custPw) {
		this.otpF = otpF;
		this.crtTs = crtTs;
		this.crtId = crtId;
		this.custPw = custPw;
	}

	public CustDet(String custName, String cntcNo, String otp, int otpF,
			Byte addrTypId, String emailId, String custCode,
			int cupnRedmAmnt, String fbId, String twId, String gplusId,
			String linkedinId, Date crtTs, Date updTs, String crtId,
			String updId, String custPw, int guestF) {
		this.custName = custName;
		this.cntcNo = cntcNo;
		this.otp = otp;
		this.otpF = otpF;
		this.addrTypId = addrTypId;
		this.emailId = emailId;
		this.custCode = custCode;
		this.cupnRedmAmnt = cupnRedmAmnt;
		this.fbId = fbId;
		this.twId = twId;
		this.gplusId = gplusId;
		this.linkedinId = linkedinId;
		this.crtTs = crtTs;
		this.updTs = updTs;
		this.crtId = crtId;
		this.updId = updId;
		this.custPw = custPw;
		this.guestF = guestF;
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

	@Column(name = "cust_name", length = 2000)
	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	@Column(name = "cntc_no", length = 200)
	public String getCntcNo() {
		return this.cntcNo;
	}

	public void setCntcNo(String cntcNo) {
		this.cntcNo = cntcNo;
	}

	@Column(name = "otp", length = 500)
	public String getOtp() {
		return this.otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	@Column(name = "otp_f", nullable = false)
	public int isOtpF() {
		return this.otpF;
	}

	public void setOtpF(int otpF) {
		this.otpF = otpF;
	}

	@Column(name = "addr_typ_id")
	public Byte getAddrTypId() {
		return this.addrTypId;
	}

	public void setAddrTypId(Byte addrTypId) {
		this.addrTypId = addrTypId;
	}

	@Column(name = "email_id", length = 500)
	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "cust_code", length = 100)
	public String getCustCode() {
		return this.custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	@Column(name = "cupn_redm_amnt", length = 200)
	public float getCupnRedmAmnt() {
		return this.cupnRedmAmnt;
	}

	public void setCupnRedmAmnt(float cupnRedmAmnt) {
		this.cupnRedmAmnt = cupnRedmAmnt;
	}

	@Column(name = "fb_id", length = 500)
	public String getFbId() {
		return this.fbId;
	}

	public void setFbId(String fbId) {
		this.fbId = fbId;
	}

	@Column(name = "tw_id", length = 500)
	public String getTwId() {
		return this.twId;
	}

	public void setTwId(String twId) {
		this.twId = twId;
	}

	@Column(name = "gplus_id", length = 200)
	public String getGplusId() {
		return this.gplusId;
	}

	public void setGplusId(String gplusId) {
		this.gplusId = gplusId;
	}

	@Column(name = "linkedin_id", length = 200)
	public String getLinkedinId() {
		return this.linkedinId;
	}

	public void setLinkedinId(String linkedinId) {
		this.linkedinId = linkedinId;
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

	@Column(name = "cust_pw",  length = 100)
	public String getCustPw() {
		return this.custPw;
	}

	public void setCustPw(String custPw) {
		this.custPw = custPw;
	}

	@Column(name = "guest_f")
	public int getGuestF() {
		return this.guestF;
	}

	public void setGuestF(int guestF) {
		this.guestF = guestF;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "custDet")
	public Set<CustOrdDet> getOrders() {
		return orders;
	}

	public void setOrders(Set<CustOrdDet> orders) {
		this.orders = orders;
	}

}
