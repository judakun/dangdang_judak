package com.baizhi.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Address;
import com.baizhi.entity.Order;
import com.baizhi.entity.User;
import com.baizhi.service.OrderService;
import com.baizhi.service.OrderServiceImpl;

public class OrderAction {
	//地址列表
	private List<Address> addressList;
	//获取地址id
	private String d_id;
	//获取地址的的详细信息
	private Address address;
	//接收异常信息
	private String message;
	//我的当当
	private List<Order> orderList;
	public String selectAddList1(){
		System.out.println("查看接收到的地址id==="+d_id);
		//1、获取session中的userid
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		//2、根据u_id查找对应的地址列表
		OrderService service = new OrderServiceImpl();
		addressList=service.selectAddress(user.getU_id());
		if(d_id!=null||!d_id.equals("")){
			for (Address add : addressList) {
				if(d_id.equals(add.getD_id())){
					address=add;
				}
			}
			ServletActionContext.getRequest().setAttribute("d_id",d_id);
		}
		return  "selectAddList1";
	}
	//地址选择后，处理订单
	public String OrderAction(){
		System.out.println("Action查看接收到的地址id==="+d_id);
		System.out.println("Action接收的地址信息====="+address);
		address.setD_id(d_id);
		OrderService service = new OrderServiceImpl();
		try {
			service.addOrder(address);
		} catch (Exception e) {
			message=e.getMessage();
		}
		return "OrderAction";
	} 
	//我的当当
	public String myOrder(){
		OrderService service = new OrderServiceImpl();
		orderList = service.selectOrderByUser();
		return "myOrder";
	}
	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public String getD_id() {
		return d_id;
	}

	public void setD_id(String d_id) {
		this.d_id = d_id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	
	
	
}
