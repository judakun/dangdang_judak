package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.entity.Order;
import com.baizhi.entity.User;

public interface AdminService {
	void m_login(Admin admin);
	List<Category> categoryList();
	void addFirstCate(Category category);
	void deleteCategory(Category category);
	List<Book> getBookList(Book book);
	List<Category> categoryList(Category category);
	void addBook(Book book);
	void deleteBook(String b_id);
	List<Book> getBDelList(Book book);
	void updateBook(Book book);
	List<User> selectAllUser();
	List<Order> selectOrder(Order order);
	boolean updateUserStatus(User user);
}
