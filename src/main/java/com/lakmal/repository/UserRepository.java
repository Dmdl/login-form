package com.lakmal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lakmal.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByName(String name);
}
