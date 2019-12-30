package com.baizhi.entity;

public class Address {
	private String d_id;      //唯一地址id
	private String d_name;    //收件人
	private String d_local;   //收件地址
	private String d_phone;    //收件人电话
	private String d_zipCode;  //收件人邮编
	private String user_id;    //用户id
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String d_id, String d_name, String d_local, String d_phone,
			String d_zipCode, String user_id) {
		super();
		this.d_id = d_id;
		this.d_name = d_name;
		this.d_local = d_local;
		this.d_phone = d_phone;
		this.d_zipCode = d_zipCode;
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Address [d_id=" + d_id + ", d_name=" + d_name + ", d_local="
				+ d_local + ", d_phone=" + d_phone + ", d_zipCode=" + d_zipCode
				+ ", user_id=" + user_id + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((d_id == null) ? 0 : d_id.hashCode());
		result = prime * result + ((d_local == null) ? 0 : d_local.hashCode());
		result = prime * result + ((d_name == null) ? 0 : d_name.hashCode());
		result = prime * result + ((d_phone == null) ? 0 : d_phone.hashCode());
		result = prime * result
				+ ((d_zipCode == null) ? 0 : d_zipCode.hashCode());
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
		Address other = (Address) obj;
		if (d_id == null) {
			if (other.d_id != null)
				return false;
		} else if (!d_id.equals(other.d_id))
			return false;
		if (d_local == null) {
			if (other.d_local != null)
				return false;
		} else if (!d_local.equals(other.d_local))
			return false;
		if (d_name == null) {
			if (other.d_name != null)
				return false;
		} else if (!d_name.equals(other.d_name))
			return false;
		if (d_phone == null) {
			if (other.d_phone != null)
				return false;
		} else if (!d_phone.equals(other.d_phone))
			return false;
		if (d_zipCode == null) {
			if (other.d_zipCode != null)
				return false;
		} else if (!d_zipCode.equals(other.d_zipCode))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	public String getD_id() {
		return d_id;
	}
	public void setD_id(String d_id) {
		this.d_id = d_id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getD_local() {
		return d_local;
	}
	public void setD_local(String d_local) {
		this.d_local = d_local;
	}
	public String getD_phone() {
		return d_phone;
	}
	public void setD_phone(String d_phone) {
		this.d_phone = d_phone;
	}
	public String getD_zipCode() {
		return d_zipCode;
	}
	public void setD_zipCode(String d_zipCode) {
		this.d_zipCode = d_zipCode;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
}