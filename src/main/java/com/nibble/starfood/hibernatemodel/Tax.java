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
 * Tax generated by hbm2java
 */
@Entity
@Table(name = "tax")
public class Tax implements java.io.Serializable {

	private Integer id;
	
	private int taxCode;
	private String taxDesc;
	
	private String taxPnct;
	@JsonIgnore
	private int taxVisF;
	@JsonIgnore
	private Date crtTs;
	@JsonIgnore
	private Date updTs;
	@JsonIgnore
	private String crtId;
	@JsonIgnore
	private String updId;
	@JsonIgnore
	private Set<PkgSizTyp> pkgSizTyp = new HashSet<PkgSizTyp>();
	public Tax() {
	}

	public Tax(int taxCode, String taxDesc, String taxPnct, int taxVisF,
			Date crtTs) {
		this.taxCode = taxCode;
		this.taxDesc = taxDesc;
		this.taxPnct = taxPnct;
		this.taxVisF = taxVisF;
		this.crtTs = crtTs;
	}

	public Tax(int taxCode, String taxDesc, String taxPnct, int taxVisF,
			Date crtTs, Date updTs, String crtId, String updId) {
		this.taxCode = taxCode;
		this.taxDesc = taxDesc;
		this.taxPnct = taxPnct;
		this.taxVisF = taxVisF;
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

	@Column(name = "tax_code", nullable = false)
	public int getTaxCode() {
		return this.taxCode;
	}

	public void setTaxCode(int taxCode) {
		this.taxCode = taxCode;
	}

	@Column(name = "tax_desc", nullable = false, length = 65535)
	public String getTaxDesc() {
		return this.taxDesc;
	}

	public void setTaxDesc(String taxDesc) {
		this.taxDesc = taxDesc;
	}

	@Column(name = "tax_pnct", nullable = false, length = 65535)
	public String getTaxPnct() {
		return this.taxPnct;
	}

	public void setTaxPnct(String taxPnct) {
		this.taxPnct = taxPnct;
	}

	@Column(name = "tax_vis_f", nullable = false)
	public int isTaxVisF() {
		return this.taxVisF;
	}

	public void setTaxVisF(int taxVisF) {
		this.taxVisF = taxVisF;
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

	@Column(name = "crt_id", length = 100)
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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tax")
	public Set<PkgSizTyp> getPkgSizTyp() {
		return pkgSizTyp;
	}

	public void setPkgSizTyp(Set<PkgSizTyp> pkgSizTyp) {
		this.pkgSizTyp = pkgSizTyp;
	}

}