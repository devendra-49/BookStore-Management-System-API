package com.devendra.bookstoremanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devendra.bookstoremanagementsystem.entity.Order;

@Repository
public interface OrderJPARepository extends JpaRepository<Order, Long> {

}
