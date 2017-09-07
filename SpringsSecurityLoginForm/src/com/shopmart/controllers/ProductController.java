package com.shopmart.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shopmart.entity.Product;
import com.shopmart.service.CategoryService;
import com.shopmart.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping("/getProductById/{productId}")
	public List<Product> getProductById(@PathVariable int productId){
		return productService.getProductById(productId);
	}
	
	
	@RequestMapping("/getProductByCategory/{categoryId}")
	public ModelAndView getProductByCategory(@PathVariable int categoryId){
		Map<String, Object> model = new HashMap<>();
		model.put("categoryList", categoryService.getAllCategory());
		model.put("productList", productService.getProductByCategory(categoryId));
	
		return new ModelAndView("viewProductByCategoryList", "model", model);

	}

	
	@RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
	public ModelAndView getAllProducts() {
		
		Map<String, Object> model = new HashMap<>();
		model.put("categoryList", categoryService.getAllCategory());
		model.put("productList", productService.getAllProducts());
	
		return new ModelAndView("viewProductList", "model", model);
		
	}
	
}
