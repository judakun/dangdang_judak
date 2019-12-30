package com.baizhi.entity;

import java.util.Date;
import java.util.List;

public class OrderItem {
	private String ob_id;
	private String book_id;
	private String item_id;
	private Integer ob_count;
	private Date ob_createDate;
	private String ob_BName;
	private Double ob_YPrice;
	private Double ob_XPrice;
	private String ob_BCover;
	private List<Book> bookList;
	private List<Order>  orderList;
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderItem(String ob_id, String book_id, String item_id,
			Integer ob_count, Date ob_createDate, String ob_BName,
			Double ob_YPrice, Double ob_XPrice, String ob_BCover,
			List<Book> bookList, List<Order> orderList) {
		super();
		this.ob_id = ob_id;
		this.book_id = book_id;
		this.item_id = item_id;
		this.ob_count = ob_count;
		this.ob_createDate = ob_createDate;
		this.ob_BName = ob_BName;
		this.ob_YPrice = ob_YPrice;
		this.ob_XPrice = ob_XPrice;
		this.ob_BCover = ob_BCover;
		this.bookList = bookList;
		this.orderList = orderList;
	}
	@Override
	public String toString() {
		return "OrderItem [ob_id=" + ob_id + ", book_id=" + book_id
				+ ", item_id=" + item_id + ", ob_count=" + ob_count
				+ ", ob_createDate=" + ob_createDate + ", ob_BName=" + ob_BName
				+ ", ob_YPrice=" + ob_YPrice + ", ob_XPrice=" + ob_XPrice
				+ ", ob_BCover=" + ob_BCover + ", bookList=" + bookList
				+ ", orderList=" + orderList + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bookList == null) ? 0 : bookList.hashCode());
		result = prime * result + ((book_id == null) ? 0 : book_id.hashCode());
		result = prime * result + ((item_id == null) ? 0 : item_id.hashCode());
		result = prime * result
				+ ((ob_BCover == null) ? 0 : ob_BCover.hashCode());
		result = prime * result
				+ ((ob_BName == null) ? 0 : ob_BName.hashCode());
		result = prime * result
				+ ((ob_XPrice == null) ? 0 : ob_XPrice.hashCode());
		result = prime * result
				+ ((ob_YPrice == null) ? 0 : ob_YPrice.hashCode());
		result = prime * result
				+ ((ob_count == null) ? 0 : ob_count.hashCode());
		result = prime * result
				+ ((ob_createDate == null) ? 0 : ob_createDate.hashCode());
		result = prime * result + ((ob_id == null) ? 0 : ob_id.hashCode());
		result = prime * result
				+ ((orderList == null) ? 0 : orderList.hashCode());
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
		OrderItem other = (OrderItem) obj;
		if (bookList == null) {
			if (other.bookList != null)
				return false;
		} else if (!bookList.equals(other.bookList))
			return false;
		if (book_id == null) {
			if (other.book_id != null)
				return false;
		} else if (!book_id.equals(other.book_id))
			return false;
		if (item_id == null) {
			if (other.item_id != null)
				return false;
		} else if (!item_id.equals(other.item_id))
			return false;
		if (ob_BCover == null) {
			if (other.ob_BCover != null)
				return false;
		} else if (!ob_BCover.equals(other.ob_BCover))
			return false;
		if (ob_BName == null) {
			if (other.ob_BName != null)
				return false;
		} else if (!ob_BName.equals(other.ob_BName))
			return false;
		if (ob_XPrice == null) {
			if (other.ob_XPrice != null)
				return false;
		} else if (!ob_XPrice.equals(other.ob_XPrice))
			return false;
		if (ob_YPrice == null) {
			if (other.ob_YPrice != null)
				return false;
		} else if (!ob_YPrice.equals(other.ob_YPrice))
			return false;
		if (ob_count == null) {
			if (other.ob_count != null)
				return false;
		} else if (!ob_count.equals(other.ob_count))
			return false;
		if (ob_createDate == null) {
			if (other.ob_createDate != null)
				return false;
		} else if (!ob_createDate.equals(other.ob_createDate))
			return false;
		if (ob_id == null) {
			if (other.ob_id != null)
				return false;
		} else if (!ob_id.equals(other.ob_id))
			return false;
		if (orderList == null) {
			if (other.orderList != null)
				return false;
		} else if (!orderList.equals(other.orderList))
			return false;
		return true;
	}
	public String getOb_id() {
		return ob_id;
	}
	public void setOb_id(String ob_id) {
		this.ob_id = ob_id;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public Integer getOb_count() {
		return ob_count;
	}
	public void setOb_count(Integer ob_count) {
		this.ob_count = ob_count;
	}
	public java.sql.Date getOb_createDate() {
		return new java.sql.Date(ob_createDate.getTime());
	}
	public void setOb_createDate(Date ob_createDate) {
		this.ob_createDate = ob_createDate;
	}
	public String getOb_BName() {
		return ob_BName;
	}
	public void setOb_BName(String ob_BName) {
		this.ob_BName = ob_BName;
	}
	public Double getOb_YPrice() {
		return ob_YPrice;
	}
	public void setOb_YPrice(Double ob_YPrice) {
		this.ob_YPrice = ob_YPrice;
	}
	public Double getOb_XPrice() {
		return ob_XPrice;
	}
	public void setOb_XPrice(Double ob_XPrice) {
		this.ob_XPrice = ob_XPrice;
	}
	public String getOb_BCover() {
		return ob_BCover;
	}
	public void setOb_BCover(String ob_BCover) {
		this.ob_BCover = ob_BCover;
	}
	public List<Book> getBookList() {
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	public List<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
}
