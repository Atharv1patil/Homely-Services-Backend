package com.homely.homelyservices.service;

import java.util.List;

import com.homely.homelyservices.model.Category;

public interface CategoryService {
	
	public List<Category> getAllCategory();
	
	public Category addCategory(Category category);
}
