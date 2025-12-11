package com.service;

import com.dto.Category;

public interface CategoryService {
		public Category createCategory(String name);
		public Category getCategory(int id);
		public Category updateCategory(int id , String name);
		public void deleteCategory(int id);
}
