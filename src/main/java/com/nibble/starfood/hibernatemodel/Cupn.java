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



/**
 * Cupn generated by hbm2java
 */
@Entity
@Table(name = "cupn")
@org.hibernate.annotations.Entity(dynamicUpdate=true)
public class Cupn implements java.io.Serializable {
	
    private static final long serialVersionUID = 1L;
    
	private Integer id;
	 @JsonIgnore
	private String cupnTypId;
	 @JsonIgnore
	private boolean cupnTypF;
	private String crtId;
	private Date crtTs;
	private String updId;
	private Date updTs;
	private String cupnAmount;
	private String cupnPrcnt;
	private String cupnAmountTypF;
	private int cupnCatgId;
	private String cupnTypCode;
	private String cupnMinAmnt;
	private String cupnStrtDt;
	private String cupnEndDt;
	private Integer custDetId;
	private String pkgSizTypId;
	private String unltdCupnF;
	private String cupnUsedCnt;
	private Integer pkgDurId;
	private Integer weekTypId;
	private Integer mealTimeId;
	private Integer foodTypId;
	private Integer mealTypId;
	private Integer paymodeId;
	private Float maxCupnAmount;
	  /*private Set<CustCupnRelt> customerCupons = new HashSet<CustCupnRelt>();*/
	public Cupn() {
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

	@Column(name = "cupn_typ_id", nullable = false, length = 45)
	public String getCupnTypId() {
		return this.cupnTypId;
	}

	public void setCupnTypId(String cupnTypId) {
		this.cupnTypId = cupnTypId;
	}

	@Column(name = "cupn_typ_f", nullable = false)
	public boolean isCupnTypF() {
		return this.cupnTypF;
	}

	public void setCupnTypF(boolean cupnTypF) {
		this.cupnTypF = cupnTypF;
	}

	@Column(name = "crt_id", length = 200)
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

	@Column(name = "upd_id", length = 200)
	public String getUpdId() {
		return this.updId;
	}

	public void setUpdId(String updId) {
		this.updId = updId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "upd_ts", length = 19)
	public Date getUpdTs() {
		return this.updTs;
	}

	public void setUpdTs(Date updTs) {
		this.updTs = updTs;
	}

	@Column(name = "cupn_amount", length = 45)
	public String getCupnAmount() {
		return this.cupnAmount;
	}

	public void setCupnAmount(String cupnAmount) {
		this.cupnAmount = cupnAmount;
	}

	@Column(name = "cupn_prcnt", length = 45)
	public String getCupnPrcnt() {
		return this.cupnPrcnt;
	}

	public void setCupnPrcnt(String cupnPrcnt) {
		this.cupnPrcnt = cupnPrcnt;
	}

	@Column(name = "cupn_amount_typ_f", length = 45)
	public String getCupnAmountTypF() {
		return this.cupnAmountTypF;
	}

	public void setCupnAmountTypF(String cupnAmountTypF) {
		this.cupnAmountTypF = cupnAmountTypF;
	}

	@Column(name = "cupn_catg_id", length = 45)
	public int getCupnCatgId() {
		return this.cupnCatgId;
	}

	public void setCupnCatgId(int cupnCatgId) {
		this.cupnCatgId = cupnCatgId;
	}

	@Column(name = "cupn_typ_code", length = 45)
	public String getCupnTypCode() {
		return this.cupnTypCode;
	}

	public void setCupnTypCode(String cupnTypCode) {
		this.cupnTypCode = cupnTypCode;
	}

	@Column(name = "cupn_min_amnt", length = 45)
	public String getCupnMinAmnt() {
		return this.cupnMinAmnt;
	}

	public void setCupnMinAmnt(String cupnMinAmnt) {
		this.cupnMinAmnt = cupnMinAmnt;
	}

	@Column(name = "cupn_strt_dt", length = 45)
	public String getCupnStrtDt() {
		return this.cupnStrtDt;
	}

	public void setCupnStrtDt(String cupnStrtDt) {
		this.cupnStrtDt = cupnStrtDt;
	}

	@Column(name = "cupn_end_dt", length = 45)
	public String getCupnEndDt() {
		return this.cupnEndDt;
	}

	public void setCupnEndDt(String cupnEndDt) {
		this.cupnEndDt = cupnEndDt;
	}

	@Column(name = "cust_det_id")
	public Integer getCustDetId() {
		return this.custDetId;
	}

	public void setCustDetId(Integer custDetId) {
		this.custDetId = custDetId;
	}

	@Column(name = "pkg_siz_typ_id", length = 45)
	public String getPkgSizTypId() {
		return this.pkgSizTypId;
	}

	public void setPkgSizTypId(String pkgSizTypId) {
		this.pkgSizTypId = pkgSizTypId;
	}

	@Column(name = "unltd_cupn_f", length = 45)
	public String getUnltdCupnF() {
		return this.unltdCupnF;
	}

	public void setUnltdCupnF(String unltdCupnF) {
		this.unltdCupnF = unltdCupnF;
	}

	@Column(name = "cupn_used_cnt", length = 45)
	public String getCupnUsedCnt() {
		return this.cupnUsedCnt;
	}

	public void setCupnUsedCnt(String cupnUsedCnt) {
		this.cupnUsedCnt = cupnUsedCnt;
	}

	@Column(name = "pkg_dur_id")
	public Integer getPkgDurId() {
		return this.pkgDurId;
	}

	public void setPkgDurId(Integer pkgDurId) {
		this.pkgDurId = pkgDurId;
	}

	@Column(name = "week_typ_id")
	public Integer getWeekTypId() {
		return this.weekTypId;
	}

	public void setWeekTypId(Integer weekTypId) {
		this.weekTypId = weekTypId;
	}

	@Column(name = "meal_time_id")
	public Integer getMealTimeId() {
		return this.mealTimeId;
	}

	public void setMealTimeId(Integer mealTimeId) {
		this.mealTimeId = mealTimeId;
	}

	@Column(name = "food_typ_id")
	public Integer getFoodTypId() {
		return this.foodTypId;
	}

	public void setFoodTypId(Integer foodTypId) {
		this.foodTypId = foodTypId;
	}

	@Column(name = "meal_typ_id")
	public Integer getMealTypId() {
		return this.mealTypId;
	}

	public void setMealTypId(Integer mealTypId) {
		this.mealTypId = mealTypId;
	}

	@Column(name = "paymode_id")
	public Integer getPaymodeId() {
		return this.paymodeId;
	}

	public void setPaymodeId(Integer paymodeId) {
		this.paymodeId = paymodeId;
	}

	@Column(name = "max_cupn_amount")
	public Float getMaxCupnAmount() {
		return this.maxCupnAmount;
	}

	public void setMaxCupnAmount(Float maxCupnAmount) {
		this.maxCupnAmount = maxCupnAmount;
	}
	/* @OneToMany(fetch = FetchType.LAZY, mappedBy = "cupn")
	public Set<CustCupnRelt> getCustomerCupons() {
		return customerCupons;
	}

	public void setCustomerCupons(Set<CustCupnRelt> customerCupons) {
		this.customerCupons = customerCupons;
	}*/
	

}
