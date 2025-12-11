package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.dto.OrderItem;
import com.dto.Orders;

import utility.Utility;

public class OrderDaoImpl implements OrderDao {

	@Override
	public Orders saveOrder(Orders orders) {
		EntityManager eManager = Utility.getEntityManager();
		EntityTransaction eTransaction = eManager.getTransaction();
		eTransaction.begin();
		eManager.persist(orders);
		eTransaction.commit();
		eManager.close();
		return orders;
	}

	@Override
	public Orders getOrderById(int id) {
		EntityManager eManager = Utility.getEntityManager();
		EntityTransaction eTransaction = eManager.getTransaction();
		eTransaction.begin();
		String jpql = "SELECT o FROM Orders o LEFT JOIN FETCH o.orderitems WHERE o.id = :id";
		Orders result = eManager.createQuery(jpql, Orders.class)
								.setParameter("id", id)
								.getSingleResult();
		eTransaction.commit();
		eManager.close();
		return result;
	}
	@Override
	public OrderItem getOrderItem(int id) {
		EntityManager eManager = Utility.getEntityManager();
		EntityTransaction eTransaction = eManager.getTransaction();
		eTransaction.begin();
		OrderItem orderItem = eManager.find(OrderItem.class, id);
		eManager.close();
		return orderItem;
		
	}
	@Override
	public Orders updateOrders(Orders savedOrders) {
		EntityManager eManager = Utility.getEntityManager();
		EntityTransaction eTransaction = eManager.getTransaction();
		eTransaction.begin();
		eManager.merge(savedOrders);
		eTransaction.commit();
		eManager.close();
		return savedOrders;
	}
	@Override
	public OrderItem updateOrderItem(OrderItem orderItem) {
		EntityManager eManager = Utility.getEntityManager();
		EntityTransaction eTransaction = eManager.getTransaction();
		eTransaction.begin();
		eManager.merge(orderItem);
		eTransaction.commit();
		eManager.close();
		return orderItem;
	}

	@Override
	public void deleteOrder(Orders orders) {
		EntityManager eManager = Utility.getEntityManager();
		EntityTransaction eTransaction = eManager.getTransaction();
		eTransaction.begin();
		Orders merge = eManager.merge(orders);
		eManager.remove(merge);
		eTransaction.commit();
		eManager.close();
	}


}
