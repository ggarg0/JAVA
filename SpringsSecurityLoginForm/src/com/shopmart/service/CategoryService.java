package com.shopmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopmart.dao.CategoryDAO;
import com.shopmart.entity.Category;



@Service
public class CategoryService {
	
	@Autowired
	private CategoryDAO categorydao;	
	
	public List<Category> getAllCategory(){
		return categorydao.getAllCategory();
	}
	
}
