package com.baizhi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.AdminDAO;
import com.baizhi.dao.BookDAO;
import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.util.MybatisUtil;

public class BookServiceImpl implements BookService {

	@Override
	public List<Category> selectCategory(Category c) {
		BookDAO dao = MybatisUtil.getSqlsession().getMapper(BookDAO.class);
		List<Category> list = dao.selectCategory(c);
		MybatisUtil.close();
		return list;
	}

	@Override
	public List<Book> selectBookBySale() {
		BookDAO dao = MybatisUtil.getSqlsession().getMapper(BookDAO.class);
		List<Book> list = dao.selectBookBySale();
		MybatisUtil.close();
		return list;
	}

	@Override
	public List<Book> selectBookBySjDate() {
		BookDAO dao = MybatisUtil.getSqlsession().getMapper(BookDAO.class);
		List<Book> list = dao.selectBookBySjDate();
		MybatisUtil.close();
		return list;
	}

	@Override
	public List<Book> selectBookBySjDate_Sale() {
		BookDAO dao = MybatisUtil.getSqlsession().getMapper(BookDAO.class);
		List<Book> list = dao.selectBookBySjDate_Sale();
		MybatisUtil.close();
		return list;
	}

	@Override
	public Book selectOne(String b_name) {
		AdminDAO loginDAO = MybatisUtil.getSqlsession().getMapper(AdminDAO.class);
		Book bookinfo = loginDAO.selectOne(b_name);
		return bookinfo;
	}

	@Override
	public List<Book> selectByCateBook(String fid, String sid, Integer pageNum,
			Integer pageSize) {
		BookDAO dao = MybatisUtil.getSqlsession().getMapper(BookDAO.class);
		//显示数据库的begin条到end条
		Integer begin=(pageNum-1)*pageSize+1;
		Integer end=pageNum*pageSize;
		List<Book> list = dao.selectByCateBook(fid, sid, begin, end);
		MybatisUtil.close();
		return list;
	}

	@Override
	public void addCart(Book book) {
		System.out.println("进入service!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		BookDAO dao = MybatisUtil.getSqlsession().getMapper(BookDAO.class);
		HttpSession session = ServletActionContext.getRequest().getSession();
		//获取书籍信息,book中只有b_id,获取完整的book2信息
		Book book2 = dao.selectBook(book);
		System.out.println("购物车******************查询结果============"+book2);
		//1、判断是否是第一次购买书籍,Map<String(书b_id),Map<Book,Integer(数量)>>
		Map<String,Map<Book,Integer>> map=(Map<String, Map<Book, Integer>>) session.getAttribute("cart");
		Double total=0.0;
		Double save=0.0;
		System.out.println("map集合=="+map);
		if(map==null){
			//购物车为空
			System.out.println("购物车为空");
			map=new HashMap<>();
			HashMap<Book, Integer> map2 = new HashMap<>();
			map2.put(book2, 1);
			map.put(book.getB_id(), map2);
			total =book2.getB_dprice();
			save=book2.getB_price()-book2.getB_dprice();
		}else{
			//已经有了购物车
			System.out.println("已经有了购物车");
			total=(Double) session.getAttribute("total");
			save=(Double) session.getAttribute("save");
			System.out.println("session中的total===="+total);
			System.out.println("session中的save===="+save);
			//判断是否是第一次购买该商品
			if(map.containsKey(book.getB_id())){
				//不是第一次
				System.out.println("已经有了购物车,已经有该书，只修改该书的数量");
				Map<Book, Integer> map2 = map.get(book.getB_id());
				//一本书，对应的map2中其实只有一个值
				Set<Book> keySet = map2.keySet();
				for (Book book3 : keySet) {
					Integer count = map2.get(book3);
					count=count+1;
					map2.put(book3, count);
				}
				map.put(book.getB_id(), map2);
			}else{
				System.out.println("已经有了购物车,新增该书");
				//是第一次
				HashMap<Book,Integer> map2 = new HashMap<>();
				map2.put(book2, 1);
				map.put(book.getB_id(), map2);
			}
			System.out.println("total=total+book2.getB_dprice();========"+book2.getB_dprice());
			save=save+book2.getB_dprice()-book2.getB_dprice();
			System.out.println("添加完成之后的save========="+save);
			total =total+book2.getB_dprice();
			System.out.println("添加完成之后的total========="+total);	
		}
		
		session.setAttribute("cart", map);
		session.setAttribute("total", total);
		session.setAttribute("save", save);
		MybatisUtil.close();
	}

	@Override
	public void updateCart(String b_id, Integer updateCount) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Map<String,Map<Book,Integer>> map=(Map<String, Map<Book, Integer>>) session.getAttribute("cart");
		Double total=(Double) session.getAttribute("total");
		Double save=(Double) session.getAttribute("save");
		//获取id对应的map2
			Set<String> keySet = map.keySet();
			for (String str : keySet) {
				if(b_id.equals(str)){
					Map<Book, Integer> map2 = map.get(str);
					Set<Book> keySet2 = map2.keySet();
					for (Book book : keySet2) {
						//修改map2的value值,key不变
						//重新计算save和total值
						System.out.println("更改前购物车的总价==="+total);
						System.out.println("更改前该书的总价==="+map2.get(book)*book.getB_dprice());
						System.out.println("重新生成该书的总价==="+map2.get(book)*book.getB_price());
						total=total-map2.get(book)*book.getB_dprice()+updateCount*book.getB_dprice();
						System.out.println("更改后购物车总价=更改前购物车的总价-更改前该书的总价+重新生成该书的总价==="+total);
						save=save-(book.getB_price()-book.getB_dprice())*map2.get(book)+(book.getB_price()-book.getB_dprice())*updateCount;
						map2.put(book, updateCount);
					}
					map.put(b_id, map2);
				}
			}
			session.setAttribute("cart", map);
			session.setAttribute("total", total);
			session.setAttribute("save", save);
			MybatisUtil.close();
		
		
	}

	@Override
	public void deleteCartBook(String b_id) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Map<String,Map<Book,Integer>> map=(Map<String, Map<Book, Integer>>) session.getAttribute("cart");
		Double total=(Double) session.getAttribute("total");
		Double save=(Double) session.getAttribute("save");
		Set<String> keySet = map.keySet();
		for (String str : keySet) {
			if(b_id.equals(str)){
				Map<Book, Integer> map2 = map.get(str);
				Set<Book> keySet2 = map2.keySet();
				for (Book book : keySet2) {
					total=total-book.getB_dprice()*map2.get(book);
					save=save-(book.getB_price()-book.getB_dprice())*map2.get(book);		
				}
			}
		}
		map.remove(b_id);
		if(map.size()==0){
			session.removeAttribute("cart");
			session.removeAttribute("total");
			session.removeAttribute("save");
		}else{
			session.setAttribute("cart", map);
			session.setAttribute("total", total);
			session.setAttribute("save", save);
		}
		MybatisUtil.close();
	}
	
	@Override
	public Integer totalPage(String fid, String sid,Integer pageSize) {
		BookDAO dao = MybatisUtil.getSqlsession().getMapper(BookDAO.class);
		//计算book总条数
		Integer count = dao.bookCount(fid, sid);
		//计算总页数
		Integer totalPage=count%pageSize == 0 ? count/pageSize : count/pageSize+1 ;
		return totalPage;
	}
}
