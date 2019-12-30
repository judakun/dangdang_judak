package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable{
	private String f_id;
	private String f_name;
	private String f_parent_id;
	private String f_levels;
	private Category f_Category;
	private List<Book> f_bookList;
	private List<Category> s_Category;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String f_id, String f_name, String f_parent_id,
			String f_levels, Category f_Category, List<Book> f_bookList,
			List<Category> s_Category) {
		super();
		this.f_id = f_id;
		this.f_name = f_name;
		this.f_parent_id = f_parent_id;
		this.f_levels = f_levels;
		this.f_Category = f_Category;
		this.f_bookList = f_bookList;
		this.s_Category = s_Category;
	}

	@Override
	public String toString() {
		return "Category [f_id=" + f_id + ", f_name=" + f_name
				+ ", f_parent_id=" + f_parent_id + ", f_levels=" + f_levels
				+ ", f_Category=" + f_Category + ", f_bookList=" + f_bookList
				+ ", s_Category=" + s_Category + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((f_Category == null) ? 0 : f_Category.hashCode());
		result = prime * result
				+ ((f_bookList == null) ? 0 : f_bookList.hashCode());
		result = prime * result + ((f_id == null) ? 0 : f_id.hashCode());
		result = prime * result
				+ ((f_levels == null) ? 0 : f_levels.hashCode());
		result = prime * result + ((f_name == null) ? 0 : f_name.hashCode());
		result = prime * result
				+ ((f_parent_id == null) ? 0 : f_parent_id.hashCode());
		result = prime * result
				+ ((s_Category == null) ? 0 : s_Category.hashCode());
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
		Category other = (Category) obj;
		if (f_Category == null) {
			if (other.f_Category != null)
				return false;
		} else if (!f_Category.equals(other.f_Category))
			return false;
		if (f_bookList == null) {
			if (other.f_bookList != null)
				return false;
		} else if (!f_bookList.equals(other.f_bookList))
			return false;
		if (f_id == null) {
			if (other.f_id != null)
				return false;
		} else if (!f_id.equals(other.f_id))
			return false;
		if (f_levels == null) {
			if (other.f_levels != null)
				return false;
		} else if (!f_levels.equals(other.f_levels))
			return false;
		if (f_name == null) {
			if (other.f_name != null)
				return false;
		} else if (!f_name.equals(other.f_name))
			return false;
		if (f_parent_id == null) {
			if (other.f_parent_id != null)
				return false;
		} else if (!f_parent_id.equals(other.f_parent_id))
			return false;
		if (s_Category == null) {
			if (other.s_Category != null)
				return false;
		} else if (!s_Category.equals(other.s_Category))
			return false;
		return true;
	}

	public String getF_id() {
		return f_id;
	}

	public void setF_id(String f_id) {
		this.f_id = f_id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getF_parent_id() {
		return f_parent_id;
	}

	public void setF_parent_id(String f_parent_id) {
		this.f_parent_id = f_parent_id;
	}

	public String getF_levels() {
		return f_levels;
	}

	public void setF_levels(String f_levels) {
		this.f_levels = f_levels;
	}

	public Category getF_Category() {
		return f_Category;
	}

	public void setF_Category(Category f_Category) {
		this.f_Category = f_Category;
	}

	public List<Book> getF_bookList() {
		return f_bookList;
	}

	public void setF_bookList(List<Book> f_bookList) {
		this.f_bookList = f_bookList;
	}

	public List<Category> getS_Category() {
		return s_Category;
	}

	public void setS_Category(List<Category> s_Category) {
		this.s_Category = s_Category;
	}

	
}
