package com.mindtree.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.shopping.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
