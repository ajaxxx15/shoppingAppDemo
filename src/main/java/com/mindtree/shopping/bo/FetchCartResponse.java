package com.mindtree.shopping.bo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mindtree.shopping.vo.CartVO;
import com.mindtree.shopping.vo.Response;


public class FetchCartResponse extends Response{

	@JsonInclude(Include.NON_NULL)
	private List<CartVO> cartItems;
	@JsonInclude(Include.NON_NULL)
	private Double totalAmount;

	public List<CartVO> getcartItems() {
		return cartItems;
	}

	public void setcartItems(List<CartVO> cartItems) {
		this.cartItems = cartItems;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
}
