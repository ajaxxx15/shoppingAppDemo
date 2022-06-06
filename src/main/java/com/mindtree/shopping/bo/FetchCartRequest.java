package com.mindtree.shopping.bo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Valid
public class FetchCartRequest {

	
	@NotNull(message = "User Id can't be null/empty")
	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
