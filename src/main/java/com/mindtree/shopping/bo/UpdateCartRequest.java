package com.mindtree.shopping.bo;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Valid
public class UpdateCartRequest {

	@NotNull(message = "Id can't be null")
	private Integer id;
	
	@NotNull(message = "Quantity can't be null")
	@Min(value = 0,message = "Quantity can not be negative")
	private Integer quantity;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
