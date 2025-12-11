package com.service;

import com.dto.Product;

public interface ProductService {
	public void createProduct(String name,int price, int category_id);
	public Product getProduct(int id);
	public void updateProduct(int id , int price);
	public void deleteProduct(int id);

}
