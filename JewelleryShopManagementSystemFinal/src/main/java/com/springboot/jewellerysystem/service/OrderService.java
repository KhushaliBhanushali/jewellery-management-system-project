package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.Order;
import java.util.List;

public interface OrderService { 

  List<Order> getAllOrder();

Order loadOrderById(Integer id );

Order createOrUpdateOrder(Order order);

void removeOrder(Integer id);

} 
