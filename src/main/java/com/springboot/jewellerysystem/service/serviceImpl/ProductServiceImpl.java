package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.ProductDAO;
import com.springboot.jewellerysystem.entity.Category;
import com.springboot.jewellerysystem.entity.Product;
import com.springboot.jewellerysystem.service.ProductService;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDao;

	@Override
	public List<Product> getAllProduct() {
		return productDao.findAll();
	}

	@Override
	public Product loadProductById(Integer id) {
		return productDao.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Product with ID " + id + " Not Found"));
	}

	@Override
	public Product createOrUpdateProduct(Product product) {
		return productDao.save(product);
	}

	@Override
	public void removeProduct(Integer id) {
		productDao.deleteById(id);
	}

	@Override
	public List<Product> getAllProductByCategory(Category category) {
		
		return productDao.findByCategory(category);
	}

}
