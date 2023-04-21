package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.OrderDetail;
import java.util.List;

public interface OrderDetailService { 

  List<OrderDetail> getAllOrderDetail();

OrderDetail loadOrderDetailById(Integer id );

OrderDetail createOrUpdateOrderDetail(OrderDetail orderDetail);

void removeOrderDetail(Integer id);

} 
