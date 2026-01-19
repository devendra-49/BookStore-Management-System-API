package com.devendra.bookstoremanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devendra.bookstoremanagementsystem.entity.Order;
import com.devendra.bookstoremanagementsystem.repository.OrderJPARepository;


@Service
public class OrderService {
	
	@Autowired
	private OrderJPARepository ojpa;
	
	public Order placeOrder(Order order) {
	    order.setOrderDate(java.time.LocalDateTime.now());
	    order.setStatus("PENDING");
	    return ojpa.save(order);
	}

	
	public List<Order> getAllOrders(){
		return ojpa.findAll();
	}
	
	public Order getOrderById(Long id) {
		return ojpa.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
	}
}
