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
 * City generated by hbm2java
 */

@Entity
@Table(name = "city")
public class City implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String cityDesc;
	@JsonIgnore
	private String lat;
	@JsonIgnore
	private String longt;
	@JsonIgnore
	private int stateId;
	@JsonIgnore
	private Integer cityF;
	@JsonIgnore
	private String crtId;
	@JsonIgnore
	private Date crtTs;
	@JsonIgnore
	private String updId;
	@JsonIgnore
	private Date updTs;
	@JsonIgnore
	private Set<Area> areas = new HashSet<Area>(0);
	@JsonIgnore
	private Set<Address> address = new HashSet<Address>(0);
	
	
	/*@JsonManagedReference
	private Set<Address> address = new HashSet<Address>(0);*/

	public City() {
	}

	public City(String cityDesc, int stateId, Integer cityF, Date crtTs) {
		this.cityDesc = cityDesc;
		this.stateId = stateId;
		this.cityF = cityF;
		this.crtTs = crtTs;
	}

	public City(String cityDesc, String lat, String longt, int stateId,
			Integer cityF, String crtId, Date crtTs, String updId, Date updTs) {
		this.cityDesc = cityDesc;
		this.lat = lat;
		this.longt = longt;
		this.stateId = stateId;
		this.cityF = cityF;
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

	@Column(name = "city_desc", nullable = false, length = 1000)
	public String getCityDesc() {
		return this.cityDesc;
	}

	public void setCityDesc(String cityDesc) {
		this.cityDesc = cityDesc;
	}

	@Column(name = "lat", length = 500)
	public String getLat() {
		return this.lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	@Column(name = "long", length = 500)
	public String getLongt() {
		return longt;
	}

	public void setLongt(String longt) {
		this.longt = longt;
	}
	

	@Column(name = "state_id", nullable = false)
	public int getStateId() {
		return this.stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	@Column(name = "city_f", nullable = false)
	public Integer getCityF() {
		return this.cityF;
	}

	public void setCityF(Integer cityF) {
		this.cityF = cityF;
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
	@Column(name = "upd_ts", length = 19)
	public Date getUpdTs() {
		return this.updTs;
	}

	public void setUpdTs(Date updTs) {
		this.updTs = updTs;
	}
	@OneToMany(fetch=FetchType.LAZY,mappedBy="city")
	public Set<Area> getAreas() {
		return areas;
	}

	public void setAreas(Set<Area> areas) {
		this.areas = areas;
	}
/*@OneToMany(fetch=FetchType.LAZY,mappedBy="citys")
public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}*/
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="city")
	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}
	
	

}
