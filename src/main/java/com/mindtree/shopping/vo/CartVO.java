package com.mindtree.shopping.vo;

public class CartVO {

	private Integer id;
	private Integer userId;
	private Integer quantity;
	private ProductVO product;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public ProductVO getProduct() {
		return product;
	}

	public void setProduct(ProductVO product) {
		this.product = product;
	}

}
