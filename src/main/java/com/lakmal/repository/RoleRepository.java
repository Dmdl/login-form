package com.lakmal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lakmal.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String string);

}
