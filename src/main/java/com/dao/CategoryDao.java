package com.dao;

import com.dto.Category;

public interface CategoryDao {
		public Category createCategory(Category category);
		public Category getCategory(int id);
		public Category updateCategory(Category category);
		public void deleteCategory(Category category);
}
