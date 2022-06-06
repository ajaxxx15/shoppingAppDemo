package com.mindtree.shopping.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mindtree.shopping.bo.FetchProductRequest;
import com.mindtree.shopping.bo.FetchProductResponse;
import com.mindtree.shopping.exception.ProductNotExistException;

@Service
public interface ProductService {

	public ResponseEntity<FetchProductResponse> fetchProduct(FetchProductRequest request) throws ProductNotExistException;
	public ResponseEntity<FetchProductResponse> fetchAllProduct() throws ProductNotExistException;
}
