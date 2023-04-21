package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.OrderDetailDAO; 
import com.springboot.jewellerysystem.entity.OrderDetail; 
import com.springboot.jewellerysystem.service.OrderDetailService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService { 

@Autowired
 private OrderDetailDAO orderDetailDao;
 
 @Override 
    public List<OrderDetail> getAllOrderDetail() { 
        return orderDetailDao.findAll(); 
    } 

@Override 
  public OrderDetail loadOrderDetailById(Integer id) {
 return orderDetailDao.findById(id).orElseThrow(() -> new EntityNotFoundException("OrderDetail with ID " + id + " Not Found"));
 }

@Override 
    public OrderDetail createOrUpdateOrderDetail(OrderDetail orderDetail) {
return orderDetailDao.save(orderDetail);
   }

  @Override
 	    public void removeOrderDetail(Integer id) {
 	        orderDetailDao.deleteById(id);
 	    }

}
