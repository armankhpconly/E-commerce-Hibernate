package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.dto.Category;

import utility.Utility;

public class CategoryDaoImpl implements CategoryDao{

	@Override
	public Category createCategory(Category category) {
		EntityManager eManager = Utility.getEntityManager();
		EntityTransaction eTransaction = eManager.getTransaction();
		eTransaction.begin();
		eManager.persist(category);
		eTransaction.commit();
		eManager.close();
		return category;
		
	}

	@Override
	public Category getCategory(int id) {
		EntityManager eManager = Utility.getEntityManager();
		EntityTransaction eTransaction = eManager.getTransaction();
		eTransaction.begin();
		Category category = eManager.find(Category.class, id);
		return category;
		
	}

	@Override
	public Category updateCategory(Category category) {
		EntityManager eManager = Utility.getEntityManager();
		EntityTransaction eTransaction = eManager.getTransaction();
		eTransaction.begin();
		eManager.merge(category);
		eTransaction.commit();
		eManager.close();
		return category;
	}

	@Override
	public void deleteCategory(Category category) {
		EntityManager eManager = Utility.getEntityManager();
		EntityTransaction eTransaction = eManager.getTransaction();
		eTransaction.begin();
		Category merge = eManager.merge(category);
		eManager.remove(merge);
		eTransaction.commit();
		eManager.close();
	}
	

}
