package com.baizhi.test;

import java.util.List;

import org.junit.Test;

import com.baizhi.dao.BookDAO;
import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.util.MybatisUtil;

public class BookTest {
	@Test
	public void test1(){
		BookDAO dao = MybatisUtil.getSqlsession().getMapper(BookDAO.class);
		Category c = new Category();
		c.setF_levels("1");
		List<Category> list = dao.selectCategory(c);
		for (Category cc : list) {
			System.out.println(cc);
		}
	}
	@Test
	public void test2(){
		BookDAO dao = MybatisUtil.getSqlsession().getMapper(BookDAO.class);
		List<Book> list = dao.selectBookBySale();
		for (Book book : list) {
			System.out.println(book);
		}
	}
	@Test
	public void test3(){
		BookDAO dao = MybatisUtil.getSqlsession().getMapper(BookDAO.class);
		List<Book> list = dao.selectByCateBook("f4", null, 1, 4);
		System.out.println(list.size());
		for (Book book : list) {
			System.out.println(book);
		}
	}

}
