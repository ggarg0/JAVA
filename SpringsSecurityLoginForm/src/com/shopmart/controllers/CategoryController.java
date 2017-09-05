package com.shopmart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopmart.entity.Category;
import com.shopmart.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/getAllCategory")
	public List<Category> getAllCategory(){
		return categoryService.getAllCategory();
	}
	
}
