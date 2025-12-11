package com.service;


import com.dao.CategoryDao;
import com.dao.CategoryDaoImpl;
import com.dao.ProductDao;
import com.dao.ProductDaoImpl;
import com.dto.Category;
import com.dto.Product;

public class ProductServiceImpl implements ProductService {
	ProductDao productDao = new ProductDaoImpl();
	CategoryDao categoryDao  = new CategoryDaoImpl();
	@Override
	public void createProduct(String name,int price, int category_id) {
		Category category = categoryDao.getCategory(category_id);
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		productDao.saveProduct(product);
		category.getProducts().add(product);
		categoryDao.updateCategory(category);
	}

	@Override
	public Product getProduct(int id) {
		Product product = productDao.getProduct(id);
		return product;
	}

	@Override
	public void updateProduct(int id, int price) {
		Product product = productDao.getProduct(id);
		product.setPrice(price);
		productDao.updateProduct(product);
	}

	@Override
	public void deleteProduct(int id) {
		Product product = productDao.getProduct(id);
		productDao.deleteProduct(product);
	}



}
