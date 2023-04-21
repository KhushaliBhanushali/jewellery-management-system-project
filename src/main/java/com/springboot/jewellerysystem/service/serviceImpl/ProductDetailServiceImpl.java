package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.ProductDetailDAO; 
import com.springboot.jewellerysystem.entity.ProductDetail; 
import com.springboot.jewellerysystem.service.ProductDetailService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductDetailServiceImpl implements ProductDetailService { 

@Autowired
 private ProductDetailDAO productDetailDao;
 
 @Override 
    public List<ProductDetail> getAllProductDetail() { 
        return productDetailDao.findAll(); 
    } 

@Override 
  public ProductDetail loadProductDetailById(Integer id) {
 return productDetailDao.findById(id).orElseThrow(() -> new EntityNotFoundException("ProductDetail with ID " + id + " Not Found"));
 }

@Override 
    public ProductDetail createOrUpdateProductDetail(ProductDetail productDetail) {
return productDetailDao.save(productDetail);
   }

  @Override
 	    public void removeProductDetail(Integer id) {
 	        productDetailDao.deleteById(id);
 	    }

}
