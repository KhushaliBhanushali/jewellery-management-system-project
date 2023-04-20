package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.Wishlist;
import java.util.List;

public interface WishlistService { 

  List<Wishlist> getAllWishlist();

Wishlist loadWishlistById(Integer id );

Wishlist createOrUpdateWishlist(Wishlist wishlist);

void removeWishlist(Integer id);

} 
