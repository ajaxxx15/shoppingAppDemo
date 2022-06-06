package com.mindtree.shopping.bo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Valid
public class RemoveCartRequest {

	@NotNull(message = "Id can't be null/empty")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
