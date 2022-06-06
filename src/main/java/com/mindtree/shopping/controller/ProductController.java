package com.mindtree.shopping.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.shopping.bo.FetchProductRequest;
import com.mindtree.shopping.bo.FetchProductResponse;
import com.mindtree.shopping.exception.ProductNotExistException;
import com.mindtree.shopping.service.ProductService;

@RestController
@RequestMapping("/demo")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/getproduct")
	private ResponseEntity<FetchProductResponse> fetchProduct(@Valid @RequestBody FetchProductRequest request) throws ProductNotExistException{
		
		ResponseEntity<FetchProductResponse> response =  productService.fetchProduct(request);
		
		return response;
		
	}
	@GetMapping("/getallproduct")
	private ResponseEntity<FetchProductResponse> fetchAllProduct() throws ProductNotExistException{
		
		ResponseEntity<FetchProductResponse> response =  productService.fetchAllProduct();
		
		return response;
		
	}
}
