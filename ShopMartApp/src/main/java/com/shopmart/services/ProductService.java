package com.shopmart.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.shopmart.beans.Product;
import com.shopmart.repository.DatabaseRepository;

@Service
public class ProductService {

	@Autowired
	private DatabaseRepository dbRepository;

	public List<Product> getAllProducts() {
		return dbRepository.getAllProducts();
	}
}
