package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.OrderDAO; 
import com.springboot.jewellerysystem.entity.Order; 
import com.springboot.jewellerysystem.service.OrderService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderServiceImpl implements OrderService { 

@Autowired
 private OrderDAO orderDao;
 
 @Override 
    public List<Order> getAllOrder() { 
        return orderDao.findAll(); 
    } 

@Override 
  public Order loadOrderById(Integer id) {
 return orderDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Order with ID " + id + " Not Found"));
 }

@Override 
    public Order createOrUpdateOrder(Order order) {
return orderDao.save(order);
   }

  @Override
 	    public void removeOrder(Integer id) {
 	        orderDao.deleteById(id);
 	    }

}
