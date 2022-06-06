package com.mindtree.shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mindtree.shopping.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("select p from Product p where lower(p.name)=:searchString or lower(p.category.categoryName)=:searchString")
	public List<Product> findProduct(@Param("searchString") String searchString);
	
	@Query("select p from Product p where p.id=:id")
	public List<Product> findByIdList(@Param("id")Integer id);
	
}
