package com.service;

import java.util.List;

import com.dao.AddressDao;
import com.dao.AddressDaoImpl;
import com.dao.OrderDao;
import com.dao.OrderDaoImpl;
import com.dao.ProductDao;
import com.dao.ProductDaoImpl;
import com.dto.Address;
import com.dto.OrderItem;
import com.dto.Orders;
import com.dto.Product;

public class OrderServiceImpl implements OrderService{
	OrderDao orderDao = new OrderDaoImpl();

	@Override
	public void createOrder(String city,int pincode, String date, List<Integer> product,List<Integer> quantity) {
		AddressDao addressDao = new AddressDaoImpl();
		ProductDao productDao = new ProductDaoImpl();
		Address address = new Address();
		address.setCity(city);
		address.setPincode(pincode);
		Address savedAddress = addressDao.saveAddress(address);
		Orders orders = new Orders();
		orders.setOrderDate(date);
		orders.setAddress(savedAddress);
		Orders savedOrder = orderDao.saveOrder(orders);
		for(int i = 0;i<product.size();i++) {
			OrderItem orderItem = new OrderItem();
			Product products = productDao.getProduct(product.get(i));
			orderItem.setProduct(products);
			orderItem.setQuantity(quantity.get(i));
			savedOrder.getOrderitems().add(orderItem);
		}
		orderDao.updateOrders(savedOrder);
		
	}

	@Override
	public Orders getOrderById(int id) {
		Orders orderById = orderDao.getOrderById(id);
		return orderById;
	}
	

	@Override
	public OrderItem updateOrderItem(int id, int quantity) {
		OrderItem orderItem = orderDao.getOrderItem(id);
		orderItem.setQuantity(quantity);
		OrderItem updateOrderItem = orderDao.updateOrderItem(orderItem);
		return updateOrderItem;
		
	}

	@Override
	public void deleteOrders(int id) {
		Orders orders = orderDao.getOrderById(id);
		orderDao.deleteOrder(orders);
	}

	
	
}
