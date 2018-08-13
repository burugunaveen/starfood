package com.nibble.starfood.hibernatemodel;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "android_push_msg")
@org.hibernate.annotations.Entity(dynamicUpdate=true)

public class AndroidPushMsg {
    private int id;
    private String name;
    private String email;
    private String regId;
    private Date crtTs;
    private Date updTs;
    private String crtId;
    private String updId;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    @Column(name = "name", length = 250)
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Column(name = "regId", length = 250)
    public String getRegId() {
	return regId;
    }

    public void setRegId(String regId) {
	this.regId = regId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "crt_ts", nullable = false, length = 0)
    public Date getCrtTs() {
	return this.crtTs;
    }

    public void setCrtTs(Date crtTs) {
	this.crtTs = crtTs;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "upd_ts", nullable = false, length = 0)
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

    @Column(name = "email", length = 250)
    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

}
