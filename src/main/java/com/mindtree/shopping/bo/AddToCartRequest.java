package com.mindtree.shopping.bo;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Valid
public class AddToCartRequest {

	@NotNull(message = "Product Id can't be null/empty")
	private Integer productId;
	
	@NotNull(message = "User Id can't be null/empty")
	private Integer userId;
	
	@NotNull(message = "Quantity can't be null/empty")
	@Min(value = 1,message = "Quantity can not be negative/zero")
	private Integer quantity;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	 
}
