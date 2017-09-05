package com.shopmart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopmart.entity.Product;
import com.shopmart.service.ProductService;


@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/getAllProducts")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	
	@RequestMapping("/getProductById/{productId}")
	public List<Product> getProductById(@PathVariable int productId){
		return productService.getProductById(productId);
	}
	
	
	@RequestMapping("/getProductByCategory/{categoryId}")
	public List<Product> getProductByCategory(@PathVariable int categoryId){
		return productService.getProductByCategory(categoryId);
	}

}
