package com.mindtree.shopping.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.mindtree.shopping.model.Cart;
import com.mindtree.shopping.model.Product;
import com.mindtree.shopping.model.User;
import com.mindtree.shopping.repository.CartRepository;
import com.mindtree.shopping.repository.ProductRepository;
import com.mindtree.shopping.service.CartService;
import com.mindtree.shopping.vo.CartVO;
import com.mindtree.shopping.vo.ProductVO;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepo;

	@Autowired
	private ProductRepository productRepo;

	@Override
	public ResponseEntity<AddToCartResponse> addProductCart(AddToCartRequest request) throws ProductNotExistException {
		AddToCartResponse response = new AddToCartResponse();
		ResponseEntity<AddToCartResponse> responseEntity = new ResponseEntity<AddToCartResponse>(response,
				HttpStatus.CREATED);
		List<Cart> avlCartList = new ArrayList<>();
		Cart enCart = new Cart();
		try {

			avlCartList = cartRepo.findByUserId(Integer.valueOf(request.getUserId()));

			Optional<Product> avlProduct = productRepo.findById(request.getProductId());

			if (!avlProduct.isPresent()) {
				throw new ProductNotExistException("No Product Found with product id: " + request.getProductId());
			}

			if (null != avlCartList && !avlCartList.isEmpty()) {

				avlCartList.forEach(cart -> {
					if (cart.getProduct().getId() == Integer.valueOf(request.getProductId())) {

						enCart.setUser(new User(request.getUserId()));

						enCart.setProduct(new Product(request.getProductId()));

						enCart.setQuantity(request.getQuantity() + cart.getQuantity());

						enCart.setId(cart.getId());

					} else {
						if (null != request.getUserId()) {
							enCart.setUser(new User(Integer.valueOf(request.getUserId())));
						}

						if (null != request.getProductId()) {
							enCart.setProduct(new Product(Integer.valueOf(request.getProductId())));
						}

						if (null != request.getQuantity() && request.getQuantity() > 0) {
							enCart.setQuantity(request.getQuantity());
						}

					}
				});

			} else {

				if (null != request.getUserId()) {
					enCart.setUser(new User(Integer.valueOf(request.getUserId())));
				}

				if (null != request.getProductId()) {
					enCart.setProduct(new Product(Integer.valueOf(request.getProductId())));
				}

				if (null != request.getQuantity() && request.getQuantity() > 0) {
					enCart.setQuantity(request.getQuantity());
				}

			}

			if (null != enCart)
				cartRepo.save(enCart);

			response.setMessage("Prodcut added Successfully");
			response.setSuccess(true);

		} catch (Exception e) {
			throw e;
		}
		return responseEntity;
	}

	@Override
	public ResponseEntity<UpdateCartResponse> updateProductCart(UpdateCartRequest request)
			throws CartItemNotExistException {

		UpdateCartResponse response = new UpdateCartResponse();
		ResponseEntity<UpdateCartResponse> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);

		try {
			Optional<Cart> avlCartInfo = cartRepo.findById(request.getId());

			if (!avlCartInfo.isPresent())
				throw new CartItemNotExistException("No Cart Info Found with id: " + request.getId());

			response.setMessage("Cart Updated SuccesFully");
			response.setSuccess(true);

			if (request.getQuantity() > 0) {
				avlCartInfo.get().setQuantity(request.getQuantity());

				cartRepo.save(avlCartInfo.get());

			} else {
				cartRepo.delete(avlCartInfo.get());
			}
		} catch (Exception e) {
			throw e;
		}

		return responseEntity;
	}

	@Override
	public ResponseEntity<RemoveCartResponse> removeProductCart(RemoveCartRequest request)
			throws CartItemNotExistException {
		RemoveCartResponse response = new RemoveCartResponse();
		ResponseEntity<RemoveCartResponse> responseEntity = new ResponseEntity<RemoveCartResponse>(response,
				HttpStatus.OK);

		try {
			Optional<Cart> avlCartInfo = cartRepo.findById(request.getId());

			if (!avlCartInfo.isPresent())
				throw new CartItemNotExistException("No Cart Info Found with id: " + request.getId());

			cartRepo.delete(avlCartInfo.get());
			response.setMessage("Removed Successfully");
			response.setSuccess(true);
		} catch (Exception e) {
			throw e;
		}

		return responseEntity;
	}

	@Override
	public ResponseEntity<FetchCartResponse> fetchCart(FetchCartRequest request) throws CartItemNotExistException {

		FetchCartResponse response = new FetchCartResponse();
		ResponseEntity<FetchCartResponse> responseEntity = new ResponseEntity<FetchCartResponse>(response,
				HttpStatus.OK);
		List<Cart> avlCartList = new ArrayList<>();
		List<CartVO> listCartVo = new ArrayList<>();

		Double totalAmount = 0.0;

		try {
			avlCartList = cartRepo.findByUserId(Integer.valueOf(request.getUserId()));

			if (null != avlCartList && !avlCartList.isEmpty()) {
				for (Cart cart : avlCartList) {
					CartVO boCartVO = new CartVO();
					ProductVO boProductVO = new ProductVO();

					if (null != cart.getProduct().getId())
						boProductVO.setId(cart.getProduct().getId());

					if (StringUtils.isNotBlank(cart.getProduct().getName()))
						boProductVO.setName(cart.getProduct().getName());

					if (cart.getProduct().getPrice() > 0)
						boProductVO.setPrice(cart.getProduct().getPrice());

					if (null != cart.getId())
						boCartVO.setId(cart.getId());

					if (null != cart.getQuantity())
						boCartVO.setQuantity(cart.getQuantity());

					if (null != cart.getUser().getId())
						boCartVO.setUserId(cart.getUser().getId());

					if (null != cart.getQuantity() && cart.getProduct().getPrice() > 0)
						totalAmount += (cart.getProduct().getPrice() * cart.getQuantity());

					boCartVO.setProduct(boProductVO);

					listCartVo.add(boCartVO);

				}

				response.setcartItems(listCartVo);
				response.setTotalAmount(totalAmount);

				response.setMessage("Cart Fetched Successfully");
				response.setSuccess(true);

			} else {
				throw new CartItemNotExistException("No cart Info Found for user id: " + request.getUserId());
			}

		} catch (Exception e) {
			throw e;
		}

		return responseEntity;
	}

}
