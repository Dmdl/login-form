package com.lakmal.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lakmal.entity.Role;
import com.lakmal.entity.User;
import com.lakmal.repository.RoleRepository;
import com.lakmal.repository.UserRepository;

@Service
public class InitDb {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@PostConstruct
	public void initializeDb() {
		BCryptPasswordEncoder encorder = new BCryptPasswordEncoder();
		User adminUser = new User();
		adminUser.setName("admin");
		adminUser.setPassword(encorder.encode("admin"));
		adminUser.setEnabled(true);

		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);

		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);

		List<Role> roles = new ArrayList<>();
		roles.add(roleUser);
		roles.add(roleAdmin);
		adminUser.setRoles(roles);
		userRepository.save(adminUser);
	}
}
