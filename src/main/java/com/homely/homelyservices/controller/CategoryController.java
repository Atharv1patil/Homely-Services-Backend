package com.homely.homelyservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homely.homelyservices.model.Category;
import com.homely.homelyservices.service.CategoryService;




@CrossOrigin ("*")
@RestController
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/category")
	public ResponseEntity<List<Category>> getAllCategory(){
		return new ResponseEntity<>(categoryService.getAllCategory(),HttpStatus.OK);
	}
	
	@PostMapping("/category")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {
		return new ResponseEntity<>(categoryService.addCategory(category),HttpStatus.CREATED);
	}
}
