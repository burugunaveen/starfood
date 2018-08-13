package com.nibble.starfood.hibernatemodel;

// Generated 12 Sep, 2015 6:26:32 PM by Hibernate Tools 3.6.0

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ServeCntDetails generated by hbm2java
 */
@Entity
@Table(name = "serve_cnt_details", catalog = "starfoodlocal")
public class ServeCntDetails implements java.io.Serializable {

	private Integer id;
	private int startSrvCnt;
	private int endSrvCnt;
	private int cntFlag;

	public ServeCntDetails() {
	}

	public ServeCntDetails(int startSrvCnt, int endSrvCnt, int cntFlag) {
		this.startSrvCnt = startSrvCnt;
		this.endSrvCnt = endSrvCnt;
		this.cntFlag = cntFlag;
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

	@Column(name = "start_srv_cnt", nullable = false)
	public int getStartSrvCnt() {
		return this.startSrvCnt;
	}

	public void setStartSrvCnt(int startSrvCnt) {
		this.startSrvCnt = startSrvCnt;
	}

	@Column(name = "end_srv_cnt", nullable = false)
	public int getEndSrvCnt() {
		return this.endSrvCnt;
	}

	public void setEndSrvCnt(int endSrvCnt) {
		this.endSrvCnt = endSrvCnt;
	}

	@Column(name = "cnt_flag", nullable = false)
	public int getCntFlag() {
		return this.cntFlag;
	}

	public void setCntFlag(int cntFlag) {
		this.cntFlag = cntFlag;
	}

}
