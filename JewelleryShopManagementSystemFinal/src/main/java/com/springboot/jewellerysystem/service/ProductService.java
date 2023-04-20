package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.Product;
import java.util.List;

public interface ProductService { 

  List<Product> getAllProduct();

Product loadProductById(Integer id );

Product createOrUpdateProduct(Product product);

void removeProduct(Integer id);

} 
