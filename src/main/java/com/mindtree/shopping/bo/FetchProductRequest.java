package com.mindtree.shopping.bo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Valid
public class FetchProductRequest {

	@NotNull(message = "Search Content missing")
	private String searchString;

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	
	
}
