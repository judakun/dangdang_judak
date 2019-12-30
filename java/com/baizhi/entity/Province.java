package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

public class Province implements Serializable {
	private Integer p_id;
	private String p_name;
	private String p_lable;
	private List<Scenic> scenic;
	public Province() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Province(Integer p_id, String p_name, String p_lable,
			List<Scenic> scenic) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_lable = p_lable;
		this.scenic = scenic;
	}
	@Override
	public String toString() {
		return "Province [p_id=" + p_id + ", p_name=" + p_name + ", p_lable="
				+ p_lable + ", scenic=" + scenic + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((p_id == null) ? 0 : p_id.hashCode());
		result = prime * result + ((p_lable == null) ? 0 : p_lable.hashCode());
		result = prime * result + ((p_name == null) ? 0 : p_name.hashCode());
		result = prime * result + ((scenic == null) ? 0 : scenic.hashCode());
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
		Province other = (Province) obj;
		if (p_id == null) {
			if (other.p_id != null)
				return false;
		} else if (!p_id.equals(other.p_id))
			return false;
		if (p_lable == null) {
			if (other.p_lable != null)
				return false;
		} else if (!p_lable.equals(other.p_lable))
			return false;
		if (p_name == null) {
			if (other.p_name != null)
				return false;
		} else if (!p_name.equals(other.p_name))
			return false;
		if (scenic == null) {
			if (other.scenic != null)
				return false;
		} else if (!scenic.equals(other.scenic))
			return false;
		return true;
	}
	public Integer getP_id() {
		return p_id;
	}
	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_lable() {
		return p_lable;
	}
	public void setP_lable(String p_lable) {
		this.p_lable = p_lable;
	}
	public List<Scenic> getScenic() {
		return scenic;
	}
	public void setScenic(List<Scenic> scenic) {
		this.scenic = scenic;
	}
	
}
