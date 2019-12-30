package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Address;
import com.baizhi.entity.Book;
import com.baizhi.entity.Order;
import com.baizhi.entity.OrderItem;

public interface OrderDAO {
	//查询所有的地址信息
	List<Address> selectAddress(String u_ids);
	//添加地址
	boolean addAddress(Address address);
	//修改地址
	boolean updateAddress(Address address);
	//查询地址
	Address selectOneAddress(Address address);
	//添加订单
	boolean addOrder(Order order);
	//添加订单明细
	boolean addOrderItem(OrderItem orderItem);
	//修改书籍的库存和销量
	boolean updateBook(Book book);
	//查看订单
	List<Order> selectOrderByUser(String u_id);
	//根据订单id查看订单明细表
	Order selectOrderItemByO_id(String o_id);
}
