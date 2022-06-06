package com.mindtree.shopping.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.mindtree.shopping.service.CartService;

@RestController
@RequestMapping("/demo")
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping("/addtocart")
	private ResponseEntity<AddToCartResponse> addProductCart(@Valid @RequestBody AddToCartRequest request) throws ProductNotExistException {

		ResponseEntity<AddToCartResponse> response = cartService.addProductCart(request);

		return response;
	}

	@PutMapping("/updatecart")
	private ResponseEntity<UpdateCartResponse> updateProductCart(@Valid @RequestBody UpdateCartRequest request) throws CartItemNotExistException,ProductNotExistException{

		ResponseEntity<UpdateCartResponse> response = cartService.updateProductCart(request);
		return response;
	}

	@DeleteMapping("/removecart")
	private ResponseEntity<RemoveCartResponse> removeProductCart(@Valid @RequestBody RemoveCartRequest request) throws CartItemNotExistException{

		ResponseEntity<RemoveCartResponse> response = cartService.removeProductCart(request);
		return response;
	}

	@GetMapping("/fetchcart")
	private ResponseEntity<FetchCartResponse> fetchCart(@Valid @RequestBody FetchCartRequest request) throws CartItemNotExistException{

		ResponseEntity<FetchCartResponse> response = cartService.fetchCart(request);

		return response;
	}
}
