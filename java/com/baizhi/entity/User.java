package com.baizhi.entity;

import java.io.Serializable;

import org.apache.ibatis.annotations.Param;

public class User{
	private Integer u_id;
	private String u_name;
	private String u_password;
	private String u_email;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String u_name, String u_password) {
		super();
		this.u_name = u_name;
		this.u_password = u_password;
	}
	public User(Integer u_id, String u_name, String u_password, String u_email) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_password = u_password;
		this.u_email = u_email;
	}
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_name=" + u_name + ", u_password="
				+ u_password + ", u_email=" + u_email + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((u_email == null) ? 0 : u_email.hashCode());
		result = prime * result + ((u_id == null) ? 0 : u_id.hashCode());
		result = prime * result + ((u_name == null) ? 0 : u_name.hashCode());
		result = prime * result
				+ ((u_password == null) ? 0 : u_password.hashCode());
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
		User other = (User) obj;
		if (u_email == null) {
			if (other.u_email != null)
				return false;
		} else if (!u_email.equals(other.u_email))
			return false;
		if (u_id == null) {
			if (other.u_id != null)
				return false;
		} else if (!u_id.equals(other.u_id))
			return false;
		if (u_name == null) {
			if (other.u_name != null)
				return false;
		} else if (!u_name.equals(other.u_name))
			return false;
		if (u_password == null) {
			if (other.u_password != null)
				return false;
		} else if (!u_password.equals(other.u_password))
			return false;
		return true;
	}
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	
	
}
