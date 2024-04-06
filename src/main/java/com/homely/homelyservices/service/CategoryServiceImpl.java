package com.homely.homelyservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homely.homelyservices.model.Category;
import com.homely.homelyservices.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}

	
}
