package com.mindtree.shopping.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mindtree.shopping.bo.FetchProductRequest;
import com.mindtree.shopping.bo.FetchProductResponse;
import com.mindtree.shopping.exception.ProductNotExistException;
import com.mindtree.shopping.model.Product;
import com.mindtree.shopping.repository.ProductRepository;
import com.mindtree.shopping.service.ProductService;
import com.mindtree.shopping.vo.ProductVO;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepo;

	@Override
	public ResponseEntity<FetchProductResponse> fetchProduct(FetchProductRequest request) throws ProductNotExistException {
		
		FetchProductResponse response = new FetchProductResponse(false, null);
		ResponseEntity<FetchProductResponse> responseEntity =new ResponseEntity<FetchProductResponse>(response,HttpStatus.OK);
		List<Product> productList = new ArrayList<Product>();
		
		
		try {
			
			if(StringUtils.isNumeric(request.getSearchString())) {
				productList = productRepo.findByIdList(Integer.valueOf(request.getSearchString()));
			}else {
				productList = productRepo.findProduct(request.getSearchString().toLowerCase());
			}
			
			if(null!=productList && !productList.isEmpty()) {
				
				
				List<ProductVO> listproductVo = new ArrayList<>();
				productList.forEach(product->{
					ProductVO productVO = new ProductVO();
					
					
					if(null!=product.getId()) {
						productVO.setId(product.getId());
					}
						productVO.setPrice(product.getPrice());
					
					if(StringUtils.isNotBlank(product.getName())) {
						productVO.setName(product.getName());
					}
					listproductVo.add(productVO);
				});
				
				response.setProductList(listproductVo);
				response.setMessage("Successfull");
				response.setSuccess(true);
				
				
			}else {
				throw new ProductNotExistException("No Product Found");
			}
			
		} catch (Exception e) {
			throw e;
		}
		
		return responseEntity;
	}

	@Override
	public ResponseEntity<FetchProductResponse> fetchAllProduct() throws ProductNotExistException{
		FetchProductResponse response = new FetchProductResponse(false, null);
		ResponseEntity<FetchProductResponse> responseEntity =null;
		List<Product> productList = new ArrayList<Product>();
		
		
		try {
			
				productList = productRepo.findAll();
			
			if(null!=productList && !productList.isEmpty()) {
				
				
				List<ProductVO> listproductVo = new ArrayList<>();
				productList.forEach(product->{
					ProductVO productVO = new ProductVO();
					
					
					if(null!=product.getId()) {
						productVO.setId(product.getId());
					}
						productVO.setPrice(product.getPrice());
					
					if(StringUtils.isNotBlank(product.getName())) {
						productVO.setName(product.getName());
					}
					listproductVo.add(productVO);
				});
				
				response.setProductList(listproductVo);
				response.setMessage("Successfull");
				response.setSuccess(true);
				responseEntity = new ResponseEntity<FetchProductResponse>(response,HttpStatus.OK);
				
				
				
			}else {
				throw new ProductNotExistException("No Product Found");
			}
			
		} catch (Exception e) {
			throw e;
		}
		
		return responseEntity;
	}

}
