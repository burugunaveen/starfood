package com.nibble.starfood.hibernatemodel;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;



@Entity
@Table(name = "ord_dts")
public class OrderDateDetails implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int activeflag;
	private float dayPrie;
	private String ordDate;
	private int quantity;
	//private int custOrdId;
	@JsonIgnore
	private CustOrdDet custOrdDetId;
	@JsonIgnore
	private Date crtTs;
	/*@JsonIgnore
	private String crtId;
	@JsonIgnore
	private String updId;
	@JsonIgnore
	private Date updTs;*/
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	/*@Column(name = "ord_det_id", nullable = false)
	public int getCustOrdId() {
		return custOrdId;
	}

	public void setCustOrdId(int custOrdId) {
		this.custOrdId = custOrdId;
	}*/
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ord_det_id", nullable = false)
	public CustOrdDet getCustOrdDetId() {
		return custOrdDetId;
	}

	public void setCustOrdDetId(CustOrdDet custOrdDetId) {
		this.custOrdDetId = custOrdDetId;
	}

	@Column(name = "active_f", length = 500)
	public int getActiveflag() {
		return activeflag;
	}

	public void setActiveflag(int activeflag) {
		this.activeflag = activeflag;
	}

	@Column(name = "day_price", length = 500)
	public float getDayPrie() {
		return dayPrie;
	}

	public void setDayPrie(float dayPrie) {
		this.dayPrie = dayPrie;
	}
	@Column(name = "ord_dt", length = 500)
	public String getOrdDate() {
		return ordDate;
	}

	public void setOrdDate(String ordDate) {
		this.ordDate = ordDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "crt_ts", nullable = false, length = 19)
	public Date getCrtTs() {
		return crtTs;
	}

	public void setCrtTs(Date crtTs) {
		this.crtTs = crtTs;
	}

/*	@Column(name = "upd_id", length = 45)
	public String getUpdId() {
		return this.updId;
	}

	public void setUpdId(String updId) {
		this.updId = updId;
	}*/

	/*@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "upd_ts", length = 19)
	public Date getUpdTs() {
		return this.updTs;
	}

	public void setUpdTs(Date updTs) {
		this.updTs = updTs;
	}
	
	@Column(name = "crt_id", length = 45)
	public String getCrtId() {
		return this.crtId;
	}

	public void setCrtId(String crtId) {
		this.crtId = crtId;
	}*/
	@Column(name = "quantity")
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}
