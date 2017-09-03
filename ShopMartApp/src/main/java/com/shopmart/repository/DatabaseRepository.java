package com.shopmart.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shopmart.beans.Product;

@Repository
public class DatabaseRepository {

	   @Autowired
	    private JdbcTemplate jdbcTemplate;

	    public List<Product> getAllProducts() {
	        List<Product> result = jdbcTemplate.query(
	                "SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_DESCRIPTION,"
	                + " CATEGORY_ID, AVAILABLE_QUANTITY, SOLD_QUANTITY FROM PRODUCT",
	                (rs, rowNum) -> new Product(
	                		rs.getInt("PRODUCT_ID"),
	                        rs.getString("PRODUCT_NAME"),
	                        rs.getDouble("PRODUCT_PRICE"), 
	                        rs.getString("PRODUCT_DESCRIPTION"), 
	                        rs.getInt("CATEGORY_ID"), 
	                        rs.getInt("AVAILABLE_QUANTITY"), 
	                        rs.getInt("SOLD_QUANTITY")
	                        ));
	        return result;
	    }
}
