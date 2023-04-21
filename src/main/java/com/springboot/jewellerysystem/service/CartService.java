package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.Cart;
import java.util.List;

public interface CartService { 

  List<Cart> getAllCart();

Cart loadCartById(Integer id );

Cart createOrUpdateCart(Cart cart);

void removeCart(Integer id);

} 
