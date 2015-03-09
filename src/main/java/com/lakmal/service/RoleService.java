package com.lakmal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lakmal.entity.Role;
import com.lakmal.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Transactional
	public void save(Role role) {
		roleRepository.save(role);
	}
}
