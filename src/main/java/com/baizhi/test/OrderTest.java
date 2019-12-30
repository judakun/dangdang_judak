package com.baizhi.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.baizhi.dao.OrderDAO;
import com.baizhi.entity.Address;
import com.baizhi.entity.Order;
import com.baizhi.util.MybatisUtil;

public class OrderTest {
	@Test
	public void test1(){
		OrderDAO dao = MybatisUtil.getSqlsession().getMapper(OrderDAO.class);
		List<Address> list = dao.selectAddress("4f2728f4-cb45-4ed6-84e7-b15469008ad0");
		System.out.println(list);
	}
	@Test
	public void test2(){
		OrderDAO dao = MybatisUtil.getSqlsession().getMapper(OrderDAO.class);
		Order order = new Order("o001", "002", 22.0, new Date(), "U001", "das", "sda",null);
		boolean b = dao.addOrder(order);
		System.out.println(b);
	}
	
	@Test
	public void test3(){
		OrderDAO dao = MybatisUtil.getSqlsession().getMapper(OrderDAO.class);
		Order order = dao.selectOrderItemByO_id("4a679511-5550-4770-aa17-fcaa5b9c3ecc");
		System.out.println(order);
	}
}
