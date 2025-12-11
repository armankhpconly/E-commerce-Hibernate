package com.controller;

import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;


import com.dto.Customer;
import com.dto.OrderItem;
import com.dto.Orders;
import com.dto.Product;
import com.dto.Category;
import com.service.CategoryService;
import com.service.CategoryServiceImpl;
import com.service.CustomerService;
import com.service.CustomerServiceImpl;
import com.service.OrderService;
import com.service.OrderServiceImpl;
import com.service.ProductService;
import com.service.ProductServiceImpl;


public class Driver {
	public static Scanner scanner = new Scanner(System.in);

	public static void customerMethods() {
		System.out.println("Press 1 to create New Customer"
				+ "\nPress 2 to get customer via Id"
				+ "\nPress 3 to update Customer name"
				+ "\nPress 4 to delete partiuclar customer");
		CustomerService customerService = new CustomerServiceImpl();
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
		{
			scanner.nextLine();
			System.out.println("Enter name ");
			String name = scanner.nextLine();
			System.out.println("Enter email");
			String email = scanner.nextLine();
			System.out.println("Enter city ");
			String city = scanner.nextLine();
			System.out.println("Enter Pincode");
			int pincode = scanner.nextInt();
			customerService.createCustomer(name, email, city, pincode);
			break;
		}
		case 2:
		{
			System.out.println("Enter id of customer you want detail of");
			int id = scanner.nextInt();
			Customer searchCustomer = customerService.searchCustomer(id);
			System.out.println(searchCustomer);
			break;
		}
		case 3:
		{
			System.out.println("Enter id of customer you want detail of");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the updated name you want");
			String name = scanner.nextLine();
			customerService.updateCustomer(id, name);
			break;
		}
		case 4:
		{
			System.out.println("Enter the id of customer you want to delete");
			int id = scanner.nextInt();
			Customer targetCustomer = customerService.searchCustomer(id);
			customerService.deleteCustomer(targetCustomer);
			break;
		}
		default:
			break;
		}
		
	}
	
	public static void categoryMethod() {
		System.out.println("Press 1 to create New Category"
				+ "\nPress 2 to get Category via Id"
				+ "\nPress 3 to update Category name"
				+ "\nPress 4 to delete partiuclar Category");
		CategoryService categoryService = new CategoryServiceImpl();
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
		{
			System.out.println("Enter the name for category");
			scanner.nextLine();
			String name = scanner.nextLine();
			categoryService.createCategory(name);
			break;
		}
		case 2:{
			System.out.println("Enter the id of category you want detail of");
			int id = scanner.nextInt();
			Category category = categoryService.getCategory(id);
			System.out.println(category);
		}
		case 3:{
			System.out.println("Enter the id of category you want to update name of ");
			int id =scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the updated name ");
			String name = scanner.nextLine();
			categoryService.updateCategory(id, name);
			
		}
		case 4:{
			System.out.println("Enter the id of category you want to delete ");
			int id =scanner.nextInt();
			categoryService.deleteCategory(id);
			
		}
		default:
			break;
		}

	}
	
	public static void productMethod() {
		System.out.println("Press 1 to create New Product"
				+ "\nPress 2 to get Product via Id"
				+ "\nPress 3 to update Product Name"
				+ "\nPress 4 to delete partiuclar Product");
		ProductService productService = new ProductServiceImpl();
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:{
			scanner.nextLine();
			System.out.println("Enter the name of prodcut");
			String name = scanner.nextLine();
			System.out.println("Enter the price of product");
			int price = scanner.nextInt();
			System.out.println("Enter the id of category this product belongs to ");
			int cat_id = scanner.nextInt();
			productService.createProduct(name,price,cat_id);
			break;
		}
		case 2:{
			System.out.println("Enter the id of product you want details of ");
			int id = scanner.nextInt();
			Product product = productService.getProduct(id);
			System.out.println(product);
			break;
		}
		case 3:{
			System.out.println("Enter the id of prodcut for which you want to update price");
			int id = scanner.nextInt();
			System.out.println("Enter the updated price");
			int price = scanner.nextInt();
			productService.updateProduct(id,price);
			System.out.println("PRice updated");
			break;
		}
		case 4:{
			System.out.println("Enter the id of prodcut you wnat to delete ");
			int id = scanner.nextInt();	
			productService.deleteProduct(id);
			}
		default:
			break;
		}
		
	}
	
	public static void orderMethod() {
		System.out.println("Press 1 to create New order"
				+ "\nPress 2 to get order via Id"
				+ "\nPress 3 to update order quantity"
				+ "\nPress 4 to delete partiuclar Order");
		OrderService orderService = new OrderServiceImpl();
		int choice = scanner.nextInt();
		scanner.nextLine();
		switch (choice) {
		case 1:{
			System.out.println("Enter the detail of address first ");
			System.out.println("Enter the city name : ");
			String city = scanner.nextLine();
			System.out.println("Enter the pincode : ");
			int pincode = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter today date in (YYYY-MM-DD)");
			String date = scanner.nextLine();
			System.out.println("Enter how many product you want to buy ");
			int numberOfProduct = scanner.nextInt();
			int quantities;
			int product_id;
			List<Integer> product = new ArrayList<>();
			List<Integer> quantity = new ArrayList<>();

			for(int i =1; i<=numberOfProduct;i++) {
				System.out.println("Enter the id of product you want to buy ");
				product_id = scanner.nextInt();
				product.add(product_id);
				System.out.println("Enter the quantity for this ");
				quantities = scanner.nextInt();
				quantity.add(quantities);
			}
			orderService.createOrder(city,pincode,date,product,quantity);
			break;
		}
		case 2:{
			System.out.println(" Enter the id of order for which you want details");
			int id = scanner.nextInt();
			Orders orderById = orderService.getOrderById(id);
			System.out.println(orderById);
		}
		case 3:{
			System.out.println("Enter the id of order item you want to update quantity of : ");
			int id = scanner.nextInt();
			System.out.println("Enter the new quantity");
			int quantity = scanner.nextInt();
			OrderItem updateOrderItem = orderService.updateOrderItem(id, quantity);
			System.out.println(updateOrderItem);
		}
		case 4 :{
			System.out.println("Enter the id of order which you want to delete");
			int id = scanner.nextInt();
			orderService.deleteOrders(id);
		}
		default:
			break;
		}
		
	
	}
	public static void main(String[] args) {
		System.out.println("main driver");
		System.out.println("Enter what you want ");
		System.out.println("\n Press 1 for Customer Related Operations"
				+ "\n Press 2 for Category Related Operations"
				+ "\n Press 3 for Product Releted Operations"
				+ "\n Press 4 for Order releted Operations");
	
		int selection = scanner.nextInt();
		switch (selection) {
		case 1:
			customerMethods();
			break;
		case 2:
			categoryMethod();
			break;
		case 3:
			productMethod();
			break;
		case 4:
			orderMethod();
		default:
			break;
		}
		
	}

}
