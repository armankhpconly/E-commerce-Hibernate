package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.dto.Product;

import utility.Utility;

public class ProductDaoImpl implements ProductDao{

	@Override
	public void saveProduct(Product product) {
		EntityManager entityManager = Utility.getEntityManager();
		EntityTransaction eTransaction = entityManager.getTransaction();
		eTransaction.begin();
		entityManager.persist(product);
		eTransaction.commit();
		entityManager.close();
		
	}

	@Override
	public Product getProduct(int id) {
		EntityManager eManager = Utility.getEntityManager();
		EntityTransaction eTransaction = eManager.getTransaction();
		eTransaction.begin();
		Product product = eManager.find(Product.class, id);
		eManager.close();
		return product;
	}

	@Override
	public void updateProduct(Product product) {
		EntityManager eManager = Utility.getEntityManager();
		EntityTransaction eTransaction = eManager.getTransaction();
		eTransaction.begin();
		eManager.merge(product);
		eTransaction.commit();
		eManager.close();
	}

	@Override
	public void deleteProduct(Product product) {
		EntityManager eManager = Utility.getEntityManager();
		EntityTransaction eTransaction = eManager.getTransaction();
		eTransaction.begin();
		Product merge = eManager.merge(product);
		eManager.remove(merge);
		eTransaction.commit();
		eManager.close();
	}

}
