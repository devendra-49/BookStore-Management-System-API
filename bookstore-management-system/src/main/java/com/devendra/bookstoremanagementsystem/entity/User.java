package com.devendra.bookstoremanagementsystem.entity;

import com.devendra.bookstoremanagementsystem.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
	@Column(unique = true, nullable = false)
	private String email;
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;     //ADMIN  or CUSTOMER
	

}
