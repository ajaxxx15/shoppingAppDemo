package com.mindtree.shopping.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mindtree.shopping.bo.AddToCartRequest;
import com.mindtree.shopping.bo.AddToCartResponse;
import com.mindtree.shopping.bo.FetchCartRequest;
import com.mindtree.shopping.bo.FetchCartResponse;
import com.mindtree.shopping.bo.RemoveCartRequest;
import com.mindtree.shopping.bo.RemoveCartResponse;
import com.mindtree.shopping.bo.UpdateCartRequest;
import com.mindtree.shopping.bo.UpdateCartResponse;
import com.mindtree.shopping.exception.CartItemNotExistException;
import com.mindtree.shopping.exception.ProductNotExistException;

@Service
public interface CartService {

	public ResponseEntity<AddToCartResponse> addProductCart(AddToCartRequest request) throws ProductNotExistException;
	public ResponseEntity<RemoveCartResponse> removeProductCart(RemoveCartRequest request) throws CartItemNotExistException;
	public ResponseEntity<FetchCartResponse> fetchCart(FetchCartRequest request) throws CartItemNotExistException;
	public ResponseEntity<UpdateCartResponse> updateProductCart(UpdateCartRequest request) throws CartItemNotExistException;
}
