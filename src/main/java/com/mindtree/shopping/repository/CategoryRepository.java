package com.mindtree.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.shopping.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
