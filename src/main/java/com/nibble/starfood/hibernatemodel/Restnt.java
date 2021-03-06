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
 * Restnt generated by hbm2java
 */
@Entity
@Table(name = "restnt", catalog = "starfoodlocal")
public class Restnt implements java.io.Serializable {

	private Integer id;
	private int cityId;
	private int areaId;
	private String restntDesc;
	private byte restntF;
	private String addr;
	private String cntcNo1;
	private String cntcNo2;
	private String cntcN;
	private String mapLog;
	private String mapLat;
	private String strtHrs;
	private String endHrs;
	private String minOrdAmnt;
	private String ordDelDist;
	private String crtId;
	private Date crtTs;
	private String updId;
	private Date updTs;

	public Restnt() {
	}

	public Restnt(int cityId, int areaId, String restntDesc, byte restntF,
			String addr, String cntcN, String mapLog, String mapLat,
			String strtHrs, String endHrs, String minOrdAmnt, Date crtTs,
			Date updTs) {
		this.cityId = cityId;
		this.areaId = areaId;
		this.restntDesc = restntDesc;
		this.restntF = restntF;
		this.addr = addr;
		this.cntcN = cntcN;
		this.mapLog = mapLog;
		this.mapLat = mapLat;
		this.strtHrs = strtHrs;
		this.endHrs = endHrs;
		this.minOrdAmnt = minOrdAmnt;
		this.crtTs = crtTs;
		this.updTs = updTs;
	}

	public Restnt(int cityId, int areaId, String restntDesc, byte restntF,
			String addr, String cntcNo1, String cntcNo2, String cntcN,
			String mapLog, String mapLat, String strtHrs, String endHrs,
			String minOrdAmnt, String ordDelDist, String crtId, Date crtTs,
			String updId, Date updTs) {
		this.cityId = cityId;
		this.areaId = areaId;
		this.restntDesc = restntDesc;
		this.restntF = restntF;
		this.addr = addr;
		this.cntcNo1 = cntcNo1;
		this.cntcNo2 = cntcNo2;
		this.cntcN = cntcN;
		this.mapLog = mapLog;
		this.mapLat = mapLat;
		this.strtHrs = strtHrs;
		this.endHrs = endHrs;
		this.minOrdAmnt = minOrdAmnt;
		this.ordDelDist = ordDelDist;
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

	@Column(name = "city_id", nullable = false)
	public int getCityId() {
		return this.cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	@Column(name = "area_id", nullable = false)
	public int getAreaId() {
		return this.areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	@Column(name = "restnt_desc", nullable = false, length = 1000)
	public String getRestntDesc() {
		return this.restntDesc;
	}

	public void setRestntDesc(String restntDesc) {
		this.restntDesc = restntDesc;
	}

	@Column(name = "restnt_f", nullable = false)
	public byte getRestntF() {
		return this.restntF;
	}

	public void setRestntF(byte restntF) {
		this.restntF = restntF;
	}

	@Column(name = "addr", nullable = false, length = 1000)
	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Column(name = "cntc_no1", length = 1000)
	public String getCntcNo1() {
		return this.cntcNo1;
	}

	public void setCntcNo1(String cntcNo1) {
		this.cntcNo1 = cntcNo1;
	}

	@Column(name = "cntc_no2", length = 1000)
	public String getCntcNo2() {
		return this.cntcNo2;
	}

	public void setCntcNo2(String cntcNo2) {
		this.cntcNo2 = cntcNo2;
	}

	@Column(name = "cntc_n", nullable = false, length = 1000)
	public String getCntcN() {
		return this.cntcN;
	}

	public void setCntcN(String cntcN) {
		this.cntcN = cntcN;
	}

	@Column(name = "map_log", nullable = false, length = 1000)
	public String getMapLog() {
		return this.mapLog;
	}

	public void setMapLog(String mapLog) {
		this.mapLog = mapLog;
	}

	@Column(name = "map_lat", nullable = false, length = 1000)
	public String getMapLat() {
		return this.mapLat;
	}

	public void setMapLat(String mapLat) {
		this.mapLat = mapLat;
	}

	@Column(name = "strt_hrs", nullable = false, length = 1000)
	public String getStrtHrs() {
		return this.strtHrs;
	}

	public void setStrtHrs(String strtHrs) {
		this.strtHrs = strtHrs;
	}

	@Column(name = "end_hrs", nullable = false, length = 1000)
	public String getEndHrs() {
		return this.endHrs;
	}

	public void setEndHrs(String endHrs) {
		this.endHrs = endHrs;
	}

	@Column(name = "min_ord_amnt", nullable = false, length = 1000)
	public String getMinOrdAmnt() {
		return this.minOrdAmnt;
	}

	public void setMinOrdAmnt(String minOrdAmnt) {
		this.minOrdAmnt = minOrdAmnt;
	}

	@Column(name = "ord_del_dist", length = 1000)
	public String getOrdDelDist() {
		return this.ordDelDist;
	}

	public void setOrdDelDist(String ordDelDist) {
		this.ordDelDist = ordDelDist;
	}

	@Column(name = "crt_id", length = 1000)
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

	@Column(name = "upd_id", length = 1000)
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
