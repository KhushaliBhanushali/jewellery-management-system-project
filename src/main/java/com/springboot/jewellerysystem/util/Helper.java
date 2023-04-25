package com.springboot.jewellerysystem.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.springboot.jewellerysystem.entity.Category;
import com.springboot.jewellerysystem.entity.Product;
import com.springboot.jewellerysystem.service.CategoryService;

public class Helper {
	
	
	public List<Category> getCategoryList(int[] ids, CategoryService categoryService){
		List<Category> list = new ArrayList<>();
		List<Product> product_list = new ArrayList<>();
		for(int i=0; i<ids.length;i++) {
		Category category = categoryService.loadCategoryById(ids[i]);
		for (Iterator iterator2 = category.getProducts().iterator(); iterator2.hasNext();) {
			Product p = (Product) iterator2.next();
			product_list.add(p);
		}
		
		if(product_list.size() >10)
		{	product_list= product_list.subList(0, 10);
		Set<Product> product_set = new HashSet<>();
		product_set.addAll(product_list);
		category.setProducts(product_set);
		}
		
				
		list.add(category);
		}
		
		return list; 
	}

}
