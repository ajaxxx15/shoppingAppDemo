package com.mindtree.shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mindtree.shopping.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	@Query("select c from Cart c where c.user.id=:userId")
	public List<Cart> findByUserId(@Param("userId") Integer userId);
}
