package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Address;
import com.baizhi.entity.Order;

public interface OrderService {
	List<Address> selectAddress(String u_id);
	void addOrder(Address address);
	List<Order> selectOrderByUser();
	Order selectOrderItemByO_id(String o_id);
}
