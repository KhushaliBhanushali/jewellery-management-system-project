package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.ProductImage;
import java.util.List;

public interface ProductImageService { 

  List<ProductImage> getAllProductImage();

ProductImage loadProductImageById(Integer id );

ProductImage createOrUpdateProductImage(ProductImage productImage);

void removeProductImage(Integer id);

} 
