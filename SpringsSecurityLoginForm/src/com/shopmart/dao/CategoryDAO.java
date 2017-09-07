package com.shopmart.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopmart.entity.Category;

@Repository
public class CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Category> getAllCategory() {
		return this.sessionFactory.getCurrentSession().createQuery("FROM CATEGORY").list();
	}
}
