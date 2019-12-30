package com.baizhi.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;

public interface BookService {
	List<Category> selectCategory(Category c);
	List<Book> selectBookBySale();
	List<Book> selectBookBySjDate();
	List<Book> selectBookBySjDate_Sale();
	Book selectOne(String b_name);
	List<Book> selectByCateBook(String fid,String sid,Integer pageNum,Integer pageSize);
	void addCart(Book book);
	void updateCart(String b_id,Integer updateCount);
	void deleteCartBook(String b_id);
	Integer totalPage(String fid,String sid,Integer pageSize);
}
