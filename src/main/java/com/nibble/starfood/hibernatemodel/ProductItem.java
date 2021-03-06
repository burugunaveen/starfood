package com.nibble.starfood.hibernatemodel;

// Generated 12 Sep, 2015 6:26:32 PM by Hibernate Tools 3.6.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ProductItem generated by hbm2java
 */
@Entity
@Table(name = "product_item", catalog = "starfoodlocal")
public class ProductItem implements java.io.Serializable {

	private int id;
	private String name;
	private String descriptiion;

	public ProductItem() {
	}

	public ProductItem(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public ProductItem(int id, String name, String descriptiion) {
		this.id = id;
		this.name = name;
		this.descriptiion = descriptiion;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "descriptiion", length = 300)
	public String getDescriptiion() {
		return this.descriptiion;
	}

	public void setDescriptiion(String descriptiion) {
		this.descriptiion = descriptiion;
	}

}
