package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Order implements Serializable{
	private String o_id;
	private String o_orderNum;  //订单编号
	private Double o_total;     //订单总价
	private Date   o_createDate;//创建时间
	private String user_id;     //用户id
	private String o_toAddress; //收件地址
	private String o_toUName;   //收件人名称
	private List<OrderItem> items;    //订单明细表
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String o_id, String o_orderNum, Double o_total,
			Date o_createDate, String user_id, String o_toAddress,
			String o_toUName, List<OrderItem> items) {
		super();
		this.o_id = o_id;
		this.o_orderNum = o_orderNum;
		this.o_total = o_total;
		this.o_createDate = o_createDate;
		this.user_id = user_id;
		this.o_toAddress = o_toAddress;
		this.o_toUName = o_toUName;
		this.items = items;
	}
	@Override
	public String toString() {
		return "Order [o_id=" + o_id + ", o_orderNum=" + o_orderNum
				+ ", o_total=" + o_total + ", o_createDate=" + o_createDate
				+ ", user_id=" + user_id + ", o_toAddress=" + o_toAddress
				+ ", o_toUName=" + o_toUName + ", items=" + items + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result
				+ ((o_createDate == null) ? 0 : o_createDate.hashCode());
		result = prime * result + ((o_id == null) ? 0 : o_id.hashCode());
		result = prime * result
				+ ((o_orderNum == null) ? 0 : o_orderNum.hashCode());
		result = prime * result
				+ ((o_toAddress == null) ? 0 : o_toAddress.hashCode());
		result = prime * result
				+ ((o_toUName == null) ? 0 : o_toUName.hashCode());
		result = prime * result + ((o_total == null) ? 0 : o_total.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (o_createDate == null) {
			if (other.o_createDate != null)
				return false;
		} else if (!o_createDate.equals(other.o_createDate))
			return false;
		if (o_id == null) {
			if (other.o_id != null)
				return false;
		} else if (!o_id.equals(other.o_id))
			return false;
		if (o_orderNum == null) {
			if (other.o_orderNum != null)
				return false;
		} else if (!o_orderNum.equals(other.o_orderNum))
			return false;
		if (o_toAddress == null) {
			if (other.o_toAddress != null)
				return false;
		} else if (!o_toAddress.equals(other.o_toAddress))
			return false;
		if (o_toUName == null) {
			if (other.o_toUName != null)
				return false;
		} else if (!o_toUName.equals(other.o_toUName))
			return false;
		if (o_total == null) {
			if (other.o_total != null)
				return false;
		} else if (!o_total.equals(other.o_total))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	public String getO_id() {
		return o_id;
	}
	public void setO_id(String o_id) {
		this.o_id = o_id;
	}
	public String getO_orderNum() {
		return o_orderNum;
	}
	public void setO_orderNum(String o_orderNum) {
		this.o_orderNum = o_orderNum;
	}
	public Double getO_total() {
		return o_total;
	}
	public void setO_total(Double o_total) {
		this.o_total = o_total;
	}
	public java.sql.Date getO_createDate() {
		return new java.sql.Date(o_createDate.getTime());
	}
	public void setO_createDate(Date o_createDate) {
		this.o_createDate = o_createDate;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getO_toAddress() {
		return o_toAddress;
	}
	public void setO_toAddress(String o_toAddress) {
		this.o_toAddress = o_toAddress;
	}
	public String getO_toUName() {
		return o_toUName;
	}
	public void setO_toUName(String o_toUName) {
		this.o_toUName = o_toUName;
	}
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
}
