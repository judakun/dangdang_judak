package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.entity.Order;
import com.baizhi.entity.User;

/**
 * @author jdk
 *
 */
public interface AdminDAO {
	
	Admin m_login(String m_username);
	List<Category> categoryList();
	//添加一级类别
	List<Category> selectCate(Category category);
	void addFirstCate(Category category);
	//添加二级类别
	void addSecondCate(Category category);
	//删除分类
	boolean deleteCategory(Category category);
	
	boolean deletebookByCateId(String f_id);
	//获取所有书籍--展示所有+条件查询
	List<Book> getBookList(Book book);
	//添加图书
	boolean addBook(Book book);
	Book selectOne(String b_name);
	//删除图书
	boolean deleteBook(String b_id);
	//获取书籍的详细信息---修改
	List<Book> getBDelList(Book book);
	//修改图书的信息
	boolean updateBook(Book book);
	//查询所有订单信息
	List<Order> selectOrder(Order order);
	//查询所有用户
	List<User> selectAllUser();
	//修改用户状态
	boolean updateUserStatus(User user);
	
}
