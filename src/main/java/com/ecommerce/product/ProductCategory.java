package com.ecommerce.product;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product Category")
public class ProductCategory {
	
	@Id
	private Integer categoryId;
	private String productId;
	private Date createdOn = new Date();
	public Integer getCategoryId() {
		return categoryId;
	}
	
	public ProductCategory(Integer categoryId, String productId, Date createdOn) {
		super();
		this.categoryId = categoryId;
		this.productId = productId;
		this.createdOn = createdOn;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}	
}
