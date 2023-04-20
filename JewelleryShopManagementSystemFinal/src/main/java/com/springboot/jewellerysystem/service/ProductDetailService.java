package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.ProductDetail;
import java.util.List;

public interface ProductDetailService { 

  List<ProductDetail> getAllProductDetail();

ProductDetail loadProductDetailById(Integer id );

ProductDetail createOrUpdateProductDetail(ProductDetail productDetail);

void removeProductDetail(Integer id);

} 
