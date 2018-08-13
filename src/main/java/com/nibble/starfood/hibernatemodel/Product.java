package com.nibble.starfood.hibernatemodel;

// Generated 12 Sep, 2015 3:44:29 PM by Hibernate Tools 3.6.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product")
public class Product implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String description;

	public Product() {
	}

	public Product(int id) {
		this.id = id;
	}

	public Product(int id, String name, String description) {
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

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", length = 500)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
