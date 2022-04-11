package com.vasyerp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private long productId;

	@Column(name="product_name")
	private String productName;

	@Column(name="product_price")
	private long productPrice;

	@Column(name="product_quantity")
	private long productQuantity;

	public Product() {
		super();
	}

	public Product(String productName, long productPrice, long productQuantity) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
	}

	public Product(long productId, String productName, long productPrice, long productQuantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}

	public long getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(long productQuantity) {
		this.productQuantity = productQuantity;
	}
}