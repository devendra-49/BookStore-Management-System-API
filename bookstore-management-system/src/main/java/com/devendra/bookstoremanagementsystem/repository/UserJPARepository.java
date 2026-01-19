package com.devendra.bookstoremanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devendra.bookstoremanagementsystem.entity.User;

public interface UserJPARepository extends JpaRepository<User, Long> {
	
	public Optional<User> findByEmail(String email);
}
 