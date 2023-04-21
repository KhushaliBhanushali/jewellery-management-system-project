package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.CategoryDAO;
import com.springboot.jewellerysystem.entity.Category;
import com.springboot.jewellerysystem.entity.MainCategory;
import com.springboot.jewellerysystem.service.CategoryService;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDao;

	@Override
	public List<Category> getAllCategory() {
		return categoryDao.findAll();
	}

	@Override
	public Category loadCategoryById(Integer id) {
		return categoryDao.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Category with ID " + id + " Not Found"));
	}

	@Override
	public Category createOrUpdateCategory(Category category) {
		return categoryDao.save(category);
	}

	@Override
	public void removeCategory(Integer id) {
		categoryDao.deleteById(id);
	}

	@Override
	public List<Category> getAllCategoryByMainCategory(MainCategory mainCategory) {
		
		return categoryDao.findByMainCategory(mainCategory) ;
	}

}
