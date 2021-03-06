package com.nibble.starfood.hibernatemodel;

// Generated 12 Sep, 2015 3:44:29 PM by Hibernate Tools 3.6.0

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ProdProdItemJoin generated by hbm2java
 */
@Entity
@Table(name = "prod_prod_item_join")
public class ProdProdItemJoin implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private ProdProdItemJoinId id;

	public ProdProdItemJoin() {
	}

	public ProdProdItemJoin(ProdProdItemJoinId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false)),
			@AttributeOverride(name = "productItemId", column = @Column(name = "product_item_id", nullable = false)) })
	public ProdProdItemJoinId getId() {
		return this.id;
	}

	public void setId(ProdProdItemJoinId id) {
		this.id = id;
	}

}
