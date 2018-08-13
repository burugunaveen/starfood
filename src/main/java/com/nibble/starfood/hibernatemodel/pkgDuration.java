package com.nibble.starfood.hibernatemodel;

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

@Entity
@Table(name = "pkg_duration")
public class pkgDuration implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String pkgDurDesc;
	private int pkgCount;
	
	@JsonIgnore
	private int pkgDurF;
	@JsonIgnore
	private Date crtTs;
	@JsonIgnore
	private Date updTs;
	@JsonIgnore
	private String crtId;
	@JsonIgnore
	private String updId;
	@JsonIgnore
	private Set<CustOrdDet> orders = new HashSet<CustOrdDet>();
	@JsonIgnore
	private Set<PkgSizTyp> pkgSizTyp = new HashSet<PkgSizTyp>();
	public pkgDuration() {
	}

	public pkgDuration(Date crtTs, Date updTs, String crtId, String updId) {
		this.crtTs = crtTs;
		this.updTs = updTs;
		this.crtId = crtId;
		this.updId = updId;
	}

	public pkgDuration(String pkgDurDesc, Date crtTs, Date updTs, String crtId,
			String updId) {
		this.pkgDurDesc = pkgDurDesc;
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

	@Column(name = "pkg_dur_desc", length = 200)
	public String getPkgDurDesc() {
		return this.pkgDurDesc;
	}

	
	
	
	//@Column(name = "pkg_count")
	@Column(name = "pkg_count", nullable = false, length = 200)
	public int getPkgCount() {
		return pkgCount;
	}

	public void setPkgCount(int pkgCount) {
		this.pkgCount = pkgCount;
	}

	public void setPkgDurDesc(String pkgDurDesc) {
		this.pkgDurDesc = pkgDurDesc;
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

	@Column(name = "upd_id", nullable = false, length = 100)
	public String getUpdId() {
		return this.updId;
	}

	public void setUpdId(String updId) {
		this.updId = updId;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pkgDur")
	public Set<CustOrdDet> getOrders() {
		return orders;
	}

	public void setOrders(Set<CustOrdDet> orders) {
		this.orders = orders;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pkgDuration")
	public Set<PkgSizTyp> getPkgSizTyp() {
		return pkgSizTyp;
	}

	public void setPkgSizTyp(Set<PkgSizTyp> pkgSizTyp) {
		this.pkgSizTyp = pkgSizTyp;
	}
	@Column(name = "pkg_dur_f", length = 200)
	public int getPkgDurF() {
		return pkgDurF;
	}

	public void setPkgDurF(int pkgDurF) {
		this.pkgDurF = pkgDurF;
	}


}
