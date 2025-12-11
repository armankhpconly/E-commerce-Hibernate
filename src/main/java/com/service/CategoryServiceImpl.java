package com.service;

import com.dao.CategoryDao;
import com.dao.CategoryDaoImpl;
import com.dto.Category;

public class CategoryServiceImpl implements CategoryService{
	CategoryDao categoryDao = new CategoryDaoImpl();
	@Override
	public Category createCategory(String name) {
		Category category = new Category();
		category.setCategory_name(name);
		Category newCategory = categoryDao.createCategory(category);
		return newCategory;
		
	}

	@Override
	public Category getCategory(int id) {
		Category category = categoryDao.getCategory(id);
		return category;
	}

	@Override
	public Category updateCategory(int id, String name) {
		Category category = categoryDao.getCategory(id);
		category.setCategory_name(name);
		Category updateCategory = categoryDao.updateCategory(category);
		return updateCategory;
		
	}

	@Override
	public void deleteCategory(int id) {
		Category category = categoryDao.getCategory(id);
		categoryDao.deleteCategory(category);
	}

}
