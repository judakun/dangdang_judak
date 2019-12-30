package com.baizhi.entity;

import java.util.Date;

public class User {
	private String u_id;
	private String u_nickname;
	private String u_email;
	private String u_password;
	private String u_status;
	private String u_code;
	private String u_salt;
	private Date u_createDate;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String u_id, String u_nickname, String u_email,
			String u_password, String u_status, String u_code, String u_salt,
			Date u_createDate) {
		super();
		this.u_id = u_id;
		this.u_nickname = u_nickname;
		this.u_email = u_email;
		this.u_password = u_password;
		this.u_status = u_status;
		this.u_code = u_code;
		this.u_salt = u_salt;
		this.u_createDate = u_createDate;
	}
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_nickname=" + u_nickname
				+ ", u_email=" + u_email + ", u_password=" + u_password
				+ ", u_status=" + u_status + ", u_code=" + u_code + ", u_salt="
				+ u_salt + ", u_createDate=" + u_createDate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((u_code == null) ? 0 : u_code.hashCode());
		result = prime * result
				+ ((u_createDate == null) ? 0 : u_createDate.hashCode());
		result = prime * result + ((u_email == null) ? 0 : u_email.hashCode());
		result = prime * result + ((u_id == null) ? 0 : u_id.hashCode());
		result = prime * result
				+ ((u_nickname == null) ? 0 : u_nickname.hashCode());
		result = prime * result
				+ ((u_password == null) ? 0 : u_password.hashCode());
		result = prime * result + ((u_salt == null) ? 0 : u_salt.hashCode());
		result = prime * result
				+ ((u_status == null) ? 0 : u_status.hashCode());
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
		if (u_code == null) {
			if (other.u_code != null)
				return false;
		} else if (!u_code.equals(other.u_code))
			return false;
		if (u_createDate == null) {
			if (other.u_createDate != null)
				return false;
		} else if (!u_createDate.equals(other.u_createDate))
			return false;
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
		if (u_nickname == null) {
			if (other.u_nickname != null)
				return false;
		} else if (!u_nickname.equals(other.u_nickname))
			return false;
		if (u_password == null) {
			if (other.u_password != null)
				return false;
		} else if (!u_password.equals(other.u_password))
			return false;
		if (u_salt == null) {
			if (other.u_salt != null)
				return false;
		} else if (!u_salt.equals(other.u_salt))
			return false;
		if (u_status == null) {
			if (other.u_status != null)
				return false;
		} else if (!u_status.equals(other.u_status))
			return false;
		return true;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_nickname() {
		return u_nickname;
	}
	public void setU_nickname(String u_nickname) {
		this.u_nickname = u_nickname;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public String getU_status() {
		return u_status;
	}
	public void setU_status(String u_status) {
		this.u_status = u_status;
	}
	public String getU_code() {
		return u_code;
	}
	public void setU_code(String u_code) {
		this.u_code = u_code;
	}
	public String getU_salt() {
		return u_salt;
	}
	public void setU_salt(String u_salt) {
		this.u_salt = u_salt;
	}
	public java.sql.Date getU_createDate() {
		return new java.sql.Date(u_createDate.getTime());
	}
	public void setU_createDate(Date u_createDate) {
		this.u_createDate = u_createDate;
	}
	
	
	
	
}
