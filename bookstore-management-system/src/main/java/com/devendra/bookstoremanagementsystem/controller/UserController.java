package com.devendra.bookstoremanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devendra.bookstoremanagementsystem.entity.User;
import com.devendra.bookstoremanagementsystem.repository.UserJPARepository;
import com.devendra.bookstoremanagementsystem.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	private User registerUser(@RequestBody User user) {
		 return userService.registerUser(user);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody User user) {
	    return userService.login(user.getEmail(), user.getPassword());
	}
	
	@PutMapping("/users/{id}")
	public User updateUser(
	        @PathVariable Long id,
	        @RequestBody User user) {

	    return userService.updateUser(id, user);
	}


	
	
}
