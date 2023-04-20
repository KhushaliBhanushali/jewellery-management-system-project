package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.WishlistDAO; 
import com.springboot.jewellerysystem.entity.Wishlist; 
import com.springboot.jewellerysystem.service.WishlistService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class WishlistServiceImpl implements WishlistService { 

@Autowired
 private WishlistDAO wishlistDao;
 
 @Override 
    public List<Wishlist> getAllWishlist() { 
        return wishlistDao.findAll(); 
    } 

@Override 
  public Wishlist loadWishlistById(Integer id) {
 return wishlistDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Wishlist with ID " + id + " Not Found"));
 }

@Override 
    public Wishlist createOrUpdateWishlist(Wishlist wishlist) {
return wishlistDao.save(wishlist);
   }

  @Override
 	    public void removeWishlist(Integer id) {
 	        wishlistDao.deleteById(id);
 	    }

}
