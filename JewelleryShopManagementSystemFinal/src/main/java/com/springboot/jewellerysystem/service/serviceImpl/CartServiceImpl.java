package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.CartDAO; 
import com.springboot.jewellerysystem.entity.Cart; 
import com.springboot.jewellerysystem.service.CartService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CartServiceImpl implements CartService { 

@Autowired
 private CartDAO cartDao;
 
 @Override 
    public List<Cart> getAllCart() { 
        return cartDao.findAll(); 
    } 

@Override 
  public Cart loadCartById(Integer id) {
 return cartDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Cart with ID " + id + " Not Found"));
 }

@Override 
    public Cart createOrUpdateCart(Cart cart) {
return cartDao.save(cart);
   }

  @Override
 	    public void removeCart(Integer id) {
 	        cartDao.deleteById(id);
 	    }

}
