package com.shopmart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shopmart.beans.Product;
import com.shopmart.services.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/getProducts")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	
	@RequestMapping(value="/hello")
	/*, method = RequestMethod.GET, 
			produces=MediaType.APPLICATION_XML_VALUE)*/
	public String hello(){
		return "Hi";
	}

}
