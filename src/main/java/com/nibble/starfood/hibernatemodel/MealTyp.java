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
 * MealTyp generated by hbm2java
 */
@Entity
@Table(name = "meal_typ")

public class MealTyp implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private int mealTypF;
	private String mealTypDesc;
	@JsonIgnore
	private String crtId;
	@JsonIgnore
	private Date crtTs;
	@JsonIgnore
	private String updId;
	@JsonIgnore
	private Date updTs;
	@JsonIgnore
	private Set<CustOrdDet> orders = new HashSet<CustOrdDet>();
	@JsonIgnore
	private Set<PkgSizTyp> pkgSizTyp = new HashSet<PkgSizTyp>();

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "meal_typ_desc", nullable = false, length = 200)
	public String getMealTypDesc() {
		return this.mealTypDesc;
	}

	public void setMealTypDesc(String mealTypDesc) {
		this.mealTypDesc = mealTypDesc;
	}

	@Column(name = "meal_typ_f", nullable = false)
	public int isMealTypF() {
		return this.mealTypF;
	}

	public void setMealTypF(int mealTypF) {
		this.mealTypF = mealTypF;
	}

	@Column(name = "crt_id", nullable = false, length = 200)
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
	@OneToMany(mappedBy = "mealType")
	public Set<CustOrdDet> getOrders() {
		return orders;
	}

	public void setOrders(Set<CustOrdDet> orders) {
		this.orders = orders;
	}
	@OneToMany(mappedBy = "mealType")
	public Set<PkgSizTyp> getPkgSizTyp() {
		return pkgSizTyp;
	}

	public void setPkgSizTyp(Set<PkgSizTyp> pkgSizTyp) {
		this.pkgSizTyp = pkgSizTyp;
	}

}