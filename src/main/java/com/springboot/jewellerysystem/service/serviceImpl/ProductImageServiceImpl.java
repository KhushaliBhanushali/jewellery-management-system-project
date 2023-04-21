package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.ProductImageDAO; 
import com.springboot.jewellerysystem.entity.ProductImage; 
import com.springboot.jewellerysystem.service.ProductImageService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductImageServiceImpl implements ProductImageService { 

@Autowired
 private ProductImageDAO productImageDao;
 
 @Override 
    public List<ProductImage> getAllProductImage() { 
        return productImageDao.findAll(); 
    } 

@Override 
  public ProductImage loadProductImageById(Integer id) {
 return productImageDao.findById(id).orElseThrow(() -> new EntityNotFoundException("ProductImage with ID " + id + " Not Found"));
 }

@Override 
    public ProductImage createOrUpdateProductImage(ProductImage productImage) {
return productImageDao.save(productImage);
   }

  @Override
 	    public void removeProductImage(Integer id) {
 	        productImageDao.deleteById(id);
 	    }

}
