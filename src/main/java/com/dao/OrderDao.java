package com.dao;

import com.dto.OrderItem;
import com.dto.Orders;

public interface OrderDao {
	public Orders saveOrder(Orders orders);
	public Orders getOrderById(int id);
	public OrderItem getOrderItem(int id);
	public Orders updateOrders(Orders savedOrders);
	public OrderItem updateOrderItem(OrderItem orderItem);
	public void deleteOrder(Orders orders);
}
