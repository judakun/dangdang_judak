package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;

public interface BookDAO {
	//查询分类
	List<Category> selectCategory(Category category);
	//查询图书按销量排序，过滤销量为0的书籍
	List<Book> selectBookBySale();
	//按照上架时间排序，取前四个
	List<Book> selectBookBySjDate();
	//上架时间&销量
	List<Book> selectBookBySjDate_Sale();
	//查询书籍一共多少条
	Integer bookCount(@Param("fid")String fid,@Param("sid")String sid);
	//分页展示书籍信息
	List<Book> selectByCateBook(@Param("fid")String fid,@Param("sid")String sid,@Param("begin")Integer begin,@Param("end")Integer end);
	//根据b_id查询书籍
	Book selectBook(Book book);
}
