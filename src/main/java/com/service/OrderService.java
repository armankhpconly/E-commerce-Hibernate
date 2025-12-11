package com.service;

import java.util.*;

import com.dto.OrderItem;
import com.dto.Orders;

public interface OrderService {
	public void createOrder(String city,int pincode, String date, List<Integer> product,List<Integer> quantity);
	public Orders getOrderById(int id);
	public OrderItem updateOrderItem(int id, int quantity);
	public void deleteOrders(int id);

}
