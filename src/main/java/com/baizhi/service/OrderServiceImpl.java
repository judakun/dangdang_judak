package com.baizhi.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.AdminDAO;
import com.baizhi.dao.BookDAO;
import com.baizhi.dao.OrderDAO;
import com.baizhi.entity.Address;
import com.baizhi.entity.Book;
import com.baizhi.entity.Order;
import com.baizhi.entity.OrderItem;
import com.baizhi.entity.User;
import com.baizhi.util.MD5Utils;
import com.baizhi.util.MybatisUtil;

public class OrderServiceImpl implements OrderService {

	@Override
	public List<Address> selectAddress(String u_id) {
		OrderDAO dao = MybatisUtil.getSqlsession().getMapper(OrderDAO.class);
		List<Address> list = dao.selectAddress(u_id);
		MybatisUtil.close();
		return list;
	}

	@Override
	public void addOrder(Address address) {
		//获取用户
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		Double total = (Double) session.getAttribute("total");
		OrderDAO dao = MybatisUtil.getSqlsession().getMapper(OrderDAO.class);
		try {
			//1、处理地址表
			System.out.println(address.getD_id()+"&&&&&&&&&");
			if(address.getD_id()==null||address.getD_id().equals("")){
				System.out.println("---------------新地址--------------");
				//1.1新地址
				System.out.println("查看地址详细信息===="+address);
				address.setD_id(UUID.randomUUID().toString());
				address.setUser_id(user.getU_id());
				dao.addAddress(address);
			}else{
				//1.2旧地址是否修改
				System.out.println("---------------旧地址--------------");
				Address address2 = dao.selectOneAddress(address);
				if(!address2.equals(address)){
					dao.updateAddress(address);
				}
				
			}
			//2、处理订单表，将订单插入
			Order order = new Order();
			Date date = new Date();
			order.setO_id(UUID.randomUUID().toString());
			order.setO_createDate(date);
			//order.setO_orderNum(date.toString()+total);
			String orderNum = new SimpleDateFormat("yyyyMMddHHmmss").format(date)+MD5Utils.getNum();
			order.setO_orderNum(orderNum);
			order.setO_total(total);
			order.setUser_id(user.getU_id());
			order.setO_toAddress(address.getD_local());
			order.setO_toUName(address.getD_name());
			//在结算完成界面展示
			session.setAttribute("order", order);
			boolean addOrder = dao.addOrder(order);
			//3、处理订单明细表
			Map<String,Map<Book,Integer>> map = (Map<String, Map<Book, Integer>>) session.getAttribute("cart");
			Set<String> set = map.keySet();
			for (String book_id : set) {
				OrderItem item = new OrderItem();
				Map<Book, Integer> map2 = map.get(book_id);
				Set<Book> set2 = map2.keySet();
				for (Book book : set2) {
					//map2中只有一种书
					item.setOb_id(UUID.randomUUID().toString());
					item.setBook_id(book_id);
					item.setItem_id(order.getO_id());
					item.setOb_BCover(book.getB_face());
					item.setOb_BName(book.getB_name());
					item.setOb_count(map2.get(book));
					item.setOb_createDate(order.getO_createDate());
					item.setOb_YPrice(book.getB_price());
					item.setOb_XPrice(book.getB_price());
				}
				System.out.println("订单明细表======="+item);
				boolean addOrderItem = dao.addOrderItem(item);
				System.out.println("订单明细表插入是否成功======="+addOrderItem);
				
			}
			//4、修改图书表，库存，销量
			AdminDAO adminDAO = MybatisUtil.getSqlsession().getMapper(AdminDAO.class);
			for (String book_id : set) {
				Map<Book, Integer> map2 = map.get(book_id);
				Set<Book> set2 = map2.keySet();
				for (Book book : set2) {
					Book book2 = new Book();
					book2.setB_kc(book.getB_kc()-map2.get(book));				
					book2.setB_saleNum(book.getB_saleNum()+map2.get(book));
					book2.setB_id(book.getB_id());
					boolean updateBook = dao.updateBook(book2);
				}
			}
			//5、销毁购物车
			session.removeAttribute("cart");
			session.removeAttribute("total");
			session.removeAttribute("save");
			MybatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
		}
		
	}

	@Override
	public List<Order> selectOrderByUser() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		OrderDAO dao = MybatisUtil.getSqlsession().getMapper(OrderDAO.class);
		List<Order> list = dao.selectOrderByUser(user.getU_id());
		MybatisUtil.close();
		return list;
	}

	@Override
	public Order selectOrderItemByO_id(String o_id) {
		// TODO Auto-generated method stub
		OrderDAO dao = MybatisUtil.getSqlsession().getMapper(OrderDAO.class);
		Order order = dao.selectOrderItemByO_id(o_id);
		return order;
	}
	
}
