package io.getarray.userservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.getarray.userservice.domain.Role;
import io.getarray.userservice.domain.User;
import io.getarray.userservice.repo.RoleRepo;
import io.getarray.userservice.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	RoleRepo roleRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if(user==null) {
			log.error("user not found in the database");
			throw new UsernameNotFoundException("user not found in the database");
		} else {
			log.info("user found in the database");
		}
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		});
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
	}

	@Override
	public User saveUser(User user) {
		log.info("saving new user {} to the database", user.getUsername());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		log.info("saving new role {} to the database", role.getName());
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		log.info("Adding role {} to user{}", roleName, username);
		User user = userRepo.findByUsername(username);
		Role role = roleRepo.findByName(roleName);
		user.getRoles().add(role);
		userRepo.save(user);
	}

	@Override
	public User getUser(String username) {
		log.info("Fetching user {}", username);
		return userRepo.findByUsername(username);
	}

	@Override
	public List<User> getUsers() {
		log.info("Fetching all users");
		return userRepo.findAll();
	}
	
}
