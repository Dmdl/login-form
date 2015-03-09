package com.lakmal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lakmal.entity.Role;
import com.lakmal.entity.User;
import com.lakmal.repository.RoleRepository;
import com.lakmal.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Transactional
	public void save(User user) {
		user.setEnabled(true);
		BCryptPasswordEncoder encorder = new BCryptPasswordEncoder();
		user.setPassword(encorder.encode(user.getPassword()));
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);

		userRepository.save(user);
	}

	public User findOne(String name) {
		return userRepository.findByName(name);
	}
}
