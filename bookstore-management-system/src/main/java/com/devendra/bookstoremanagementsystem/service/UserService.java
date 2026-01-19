package com.devendra.bookstoremanagementsystem.service;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.devendra.bookstoremanagementsystem.entity.User;
import com.devendra.bookstoremanagementsystem.enums.Role;
import com.devendra.bookstoremanagementsystem.exception.EmailAlreadyExistsException;
import com.devendra.bookstoremanagementsystem.repository.UserJPARepository;
import com.devendra.bookstoremanagementsystem.util.JwtUtil;

@Service
public class UserService {
	
	@Autowired
	private UserJPARepository ujpa;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
//	public User registerUser(User user) {
//		if(ujpa.findByEmail(user.getEmail()).isPresent()) {
//			throw new RuntimeException("Email already registered");
//		}
//		if(user.getRole() == null) {
//			user.setRole(Role.CUSTOMER);
//		}
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
//		return ujpa.save(user);
//	}
	
	 public User registerUser(User user) {

	        if (ujpa.findByEmail(user.getEmail()).isPresent()) {
	            throw new EmailAlreadyExistsException("Email already registered");
	        }
	        if(user.getRole() == null) {
				user.setRole(Role.CUSTOMER);
			}
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
//	        user.setRole(Role.CUSTOMER);

	        return ujpa.save(user);
	    }
	
	public String login(String email, String password) {

	    User user = ujpa.findByEmail(email)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    if (!passwordEncoder.matches(password, user.getPassword())) {
	        throw new RuntimeException("Invalid password");
	    }
//	    return "Login successful";
//	    return JwtUtil.generateToken(user.getEmail());
	    return JwtUtil.generateToken(
	            user.getEmail(),
	            user.getRole().name()
	    );   
	}
	
	public User updateUser(Long id, User updatedUser) {

	    //  Find existing user by ID
	    User existingUser = ujpa.findById(id)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    //  Update name 
	    if (updatedUser.getName() != null) {
	        existingUser.setName(updatedUser.getName());
	    }

	    // Update password (optional)
	    if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
	        existingUser.setPassword(
	                passwordEncoder.encode(updatedUser.getPassword())
	        );
	    }
	    return ujpa.save(existingUser);
	}
}
