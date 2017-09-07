package com.shopmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopmart.dao.ProductDAO;
import com.shopmart.entity.Product;


@Service
public class ProductService {

	@Autowired
	private ProductDAO productdao;

	@Transactional
	public List<Product> getAllProducts() {
		return productdao.getAllProducts();
	}

	@Transactional
	public List<Product> getProductById(int productId) {
		return productdao.getProductById(productId);
	}

	@Transactional
	public List<Product> getProductByCategory(int categoryId) {
		return productdao.getProductByCategory(categoryId);
	}

}
