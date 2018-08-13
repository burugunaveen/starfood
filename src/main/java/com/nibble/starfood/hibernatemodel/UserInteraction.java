package com.nibble.starfood.hibernatemodel;

// Generated 12 Sep, 2015 6:26:32 PM by Hibernate Tools 3.6.0

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * UserInteraction generated by hbm2java
 */
@Entity
@Table(name = "user_interaction", catalog = "starfoodlocal")
public class UserInteraction implements java.io.Serializable {

	private int id;
	private int custId;
	private String interactionType;
	private String interactionShortDesc;
	private String interactionDetails;
	private Date interactionDate;

	public UserInteraction() {
	}

	public UserInteraction(int id, int custId, String interactionType,
			String interactionShortDesc, Date interactionDate) {
		this.id = id;
		this.custId = custId;
		this.interactionType = interactionType;
		this.interactionShortDesc = interactionShortDesc;
		this.interactionDate = interactionDate;
	}

	public UserInteraction(int id, int custId, String interactionType,
			String interactionShortDesc, String interactionDetails,
			Date interactionDate) {
		this.id = id;
		this.custId = custId;
		this.interactionType = interactionType;
		this.interactionShortDesc = interactionShortDesc;
		this.interactionDetails = interactionDetails;
		this.interactionDate = interactionDate;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "cust_id", nullable = false)
	public int getCustId() {
		return this.custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	@Column(name = "interaction_type", nullable = false, length = 45)
	public String getInteractionType() {
		return this.interactionType;
	}

	public void setInteractionType(String interactionType) {
		this.interactionType = interactionType;
	}

	@Column(name = "interaction_short_desc", nullable = false)
	public String getInteractionShortDesc() {
		return this.interactionShortDesc;
	}

	public void setInteractionShortDesc(String interactionShortDesc) {
		this.interactionShortDesc = interactionShortDesc;
	}

	@Column(name = "interaction_details", length = 65535)
	public String getInteractionDetails() {
		return this.interactionDetails;
	}

	public void setInteractionDetails(String interactionDetails) {
		this.interactionDetails = interactionDetails;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Interaction_date", nullable = false, length = 10)
	public Date getInteractionDate() {
		return this.interactionDate;
	}

	public void setInteractionDate(Date interactionDate) {
		this.interactionDate = interactionDate;
	}

}
