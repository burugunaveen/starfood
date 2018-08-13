package com.nibble.starfood.hibernatemodel;

// Generated 12 Sep, 2015 3:44:29 PM by Hibernate Tools 3.6.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Frequency generated by hbm2java
 */
@Entity
@Table(name = "frequency", catalog = "spiceboxcoupon", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Frequency implements java.io.Serializable {

	private int id;
	private String name;
	private String description;

	public Frequency() {
	}

	public Frequency(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Frequency(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name", unique = true, nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}