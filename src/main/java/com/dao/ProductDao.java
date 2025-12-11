package com.dao;

import com.dto.Product;

public interface ProductDao {
	public void saveProduct(Product product);
	public Product getProduct(int id);
	public void updateProduct(Product product);
	public void deleteProduct(Product product);

}
