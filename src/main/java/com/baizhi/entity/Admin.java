package com.baizhi.entity;

import java.io.Serializable;

public class Admin implements Serializable{
	private String m_id;
	private String m_username;
	private String m_password;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String m_id, String m_username, String m_password) {
		super();
		this.m_id = m_id;
		this.m_username = m_username;
		this.m_password = m_password;
	}
	@Override
	public String toString() {
		return "Admin [m_id=" + m_id + ", m_username=" + m_username
				+ ", m_password=" + m_password + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((m_id == null) ? 0 : m_id.hashCode());
		result = prime * result
				+ ((m_password == null) ? 0 : m_password.hashCode());
		result = prime * result
				+ ((m_username == null) ? 0 : m_username.hashCode());
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
		Admin other = (Admin) obj;
		if (m_id == null) {
			if (other.m_id != null)
				return false;
		} else if (!m_id.equals(other.m_id))
			return false;
		if (m_password == null) {
			if (other.m_password != null)
				return false;
		} else if (!m_password.equals(other.m_password))
			return false;
		if (m_username == null) {
			if (other.m_username != null)
				return false;
		} else if (!m_username.equals(other.m_username))
			return false;
		return true;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_username() {
		return m_username;
	}
	public void setM_username(String m_username) {
		this.m_username = m_username;
	}
	public String getM_password() {
		return m_password;
	}
	public void setM_password(String m_password) {
		this.m_password = m_password;
	}
	
}
