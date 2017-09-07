package com.shopmart.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopmart.entity.Product;

@Repository
public class ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts() {
		return this.sessionFactory.getCurrentSession().createQuery("FROM PRODUCT").list();
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProductById(int productId) {
		return this.sessionFactory.getCurrentSession().createQuery(" FROM PRODUCT WHERE PRODUCT_ID = " + productId)
				.list();
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProductByCategory(int categoryId) {
		return this.sessionFactory.getCurrentSession().createQuery(" FROM PRODUCT WHERE CATEGORY_ID = " + categoryId)
				.list();
	}
}
