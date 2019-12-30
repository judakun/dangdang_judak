package com.baizhi.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.baizhi.dao.AdminDAO;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.entity.Order;
import com.baizhi.service.AdminService;
import com.baizhi.service.AdminServiceImpl;
import com.baizhi.util.MybatisUtil;

public class Mytest {
	@Test
	public void test1(){
		AdminDAO loginDAO = MybatisUtil.getSqlsession().getMapper(AdminDAO.class);
		Admin admin = loginDAO.m_login("admin");
		System.out.println(admin);
		MybatisUtil.close();
	}
	@Test
	public void test2(){
		AdminDAO loginDAO = MybatisUtil.getSqlsession().getMapper(AdminDAO.class);
		List<Category> categoryList = loginDAO.categoryList();
		for (Category category : categoryList) {
			System.out.println(category);
		}
		MybatisUtil.close();
	}
	@Test
	public void test3(){
		AdminDAO loginDAO = MybatisUtil.getSqlsession().getMapper(AdminDAO.class);
		Category ca = new Category();
		ca.setF_id("f123456");
		ca.setF_name("教育");
		ca.setF_levels("1");
		loginDAO.addFirstCate(ca);
		MybatisUtil.commit();
	}
	@Test
	public void test4(){
		AdminDAO loginDAO = MybatisUtil.getSqlsession().getMapper(AdminDAO.class);
		Category category2 = new Category();
		category2.setF_name("测试一级类别");
		List<Category> list = loginDAO.selectCate(category2);
		for (Category category : list) {
			System.out.println(category);
		}
		MybatisUtil.close();
	}
	@Test
	public void test5(){
		AdminDAO dao = MybatisUtil.getSqlsession().getMapper(AdminDAO.class);
		Category c = new Category();
		c.setF_id("f9");
		boolean b = dao.deleteCategory(c);
		System.out.println(b);
		
	}
	@Test
	public void test6(){
		AdminService service=new AdminServiceImpl();
		List<Book> list = service.getBookList(new Book());
		for (Book b : list) {
			System.out.println(b);
		}
		
	}
	@Test
	public void test7(){
		AdminDAO dao = MybatisUtil.getSqlsession().getMapper(AdminDAO.class);
		Book book = new Book("555", "书名", 23.0, 22.0, "作者", "分类", "简介", "作者简介", "出版社", new Date(), new Date(), "版次", "印次", "纸张", 888, "包装", "开本", 888, "isbn", "编辑推荐", "媒体评论", "基本目录", "图片路径", 122, 555, new Date());
		boolean b = dao.addBook(book);
		MybatisUtil.commit();
		System.out.println(b);
	}
	@Test
	public void test8(){
		AdminDAO dao = MybatisUtil.getSqlsession().getMapper(AdminDAO.class);
		Book book = new Book();
		book.setB_id("book001");
		List<Book> list = dao.getBDelList(book);
		for (Book book2 : list) {
			System.out.println(book2);
		}
	}
	@Test
	public void test9(){
		AdminDAO dao = MybatisUtil.getSqlsession().getMapper(AdminDAO.class);
		Order order = new Order();
		System.out.println(order);
		List<Order> list = dao.selectOrder(order);
		for (Order s : list) {
			System.out.println(s);
		}
	}
	@Test
	public void test10(){
		AdminDAO dao = MybatisUtil.getSqlsession().getMapper(AdminDAO.class);
		
	}
}
