package com.mindtree.shopping.bo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mindtree.shopping.vo.ProductVO;
import com.mindtree.shopping.vo.Response;

public class FetchProductResponse extends Response {
	
	@JsonInclude(Include.NON_NULL)
	private List<ProductVO> productList;

	public FetchProductResponse(boolean success, String message) {
		super(success, message);
		// TODO Auto-generated constructor stub
	}

	public List<ProductVO> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductVO> productList) {
		this.productList = productList;
	}

	

	
	
	
	

}
