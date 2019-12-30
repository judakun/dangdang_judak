package com.baizhi.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Scenic implements Serializable {
	private Integer s_id;
	private String s_name;
	private String s_image;
	private Date s_uptime;
	private Double s_upprice;
	private Date s_downtime;
	private Double s_downprice;
	private String s_introduction;
	private Integer s_province_id;

	public java.sql.Date getS_uptime() {
		return new java.sql.Date(s_uptime.getTime());
	}
	public void setS_uptime(Date s_uptime) {
		this.s_uptime = s_uptime;
	}
	public Scenic() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Scenic(Integer s_id, String s_name, String s_image, Date s_uptime,
			Double s_upprice, Date s_downtime, Double s_downprice,
			String s_introduction, Integer s_province_id) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_image = s_image;
		this.s_uptime = s_uptime;
		this.s_upprice = s_upprice;
		this.s_downtime = s_downtime;
		this.s_downprice = s_downprice;
		this.s_introduction = s_introduction;
		this.s_province_id = s_province_id;
	}
	@Override
	public String toString() {
		return "Scenic [s_id=" + s_id + ", s_name=" + s_name + ", s_image="
				+ s_image + ", s_uptime=" + s_uptime + ", s_upprice="
				+ s_upprice + ", s_downtime=" + s_downtime + ", s_downprice="
				+ s_downprice + ", s_introduction=" + s_introduction
				+ ", s_province_id=" + s_province_id + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((s_downprice == null) ? 0 : s_downprice.hashCode());
		result = prime * result
				+ ((s_downtime == null) ? 0 : s_downtime.hashCode());
		result = prime * result + ((s_id == null) ? 0 : s_id.hashCode());
		result = prime * result + ((s_image == null) ? 0 : s_image.hashCode());
		result = prime * result
				+ ((s_introduction == null) ? 0 : s_introduction.hashCode());
		result = prime * result + ((s_name == null) ? 0 : s_name.hashCode());
		result = prime * result
				+ ((s_province_id == null) ? 0 : s_province_id.hashCode());
		result = prime * result
				+ ((s_upprice == null) ? 0 : s_upprice.hashCode());
		result = prime * result
				+ ((s_uptime == null) ? 0 : s_uptime.hashCode());
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
		Scenic other = (Scenic) obj;
		if (s_downprice == null) {
			if (other.s_downprice != null)
				return false;
		} else if (!s_downprice.equals(other.s_downprice))
			return false;
		if (s_downtime == null) {
			if (other.s_downtime != null)
				return false;
		} else if (!s_downtime.equals(other.s_downtime))
			return false;
		if (s_id == null) {
			if (other.s_id != null)
				return false;
		} else if (!s_id.equals(other.s_id))
			return false;
		if (s_image == null) {
			if (other.s_image != null)
				return false;
		} else if (!s_image.equals(other.s_image))
			return false;
		if (s_introduction == null) {
			if (other.s_introduction != null)
				return false;
		} else if (!s_introduction.equals(other.s_introduction))
			return false;
		if (s_name == null) {
			if (other.s_name != null)
				return false;
		} else if (!s_name.equals(other.s_name))
			return false;
		if (s_province_id == null) {
			if (other.s_province_id != null)
				return false;
		} else if (!s_province_id.equals(other.s_province_id))
			return false;
		if (s_upprice == null) {
			if (other.s_upprice != null)
				return false;
		} else if (!s_upprice.equals(other.s_upprice))
			return false;
		if (s_uptime == null) {
			if (other.s_uptime != null)
				return false;
		} else if (!s_uptime.equals(other.s_uptime))
			return false;
		return true;
	}
	public Integer getS_id() {
		return s_id;
	}
	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_image() {
		return s_image;
	}
	public void setS_image(String s_image) {
		this.s_image = s_image;
	}
	public Double getS_upprice() {
		return s_upprice;
	}
	public void setS_upprice(Double s_upprice) {
		this.s_upprice = s_upprice;
	}
	public java.sql.Date getS_downtime() {
		return new java.sql.Date(s_downtime.getTime());
	}
	public void setS_downtime(Date s_downtime) {
		this.s_downtime = s_downtime;
	}
	public Double getS_downprice() {
		return s_downprice;
	}
	public void setS_downprice(Double s_downprice) {
		this.s_downprice = s_downprice;
	}
	public String getS_introduction() {
		return s_introduction;
	}
	public void setS_introduction(String s_introduction) {
		this.s_introduction = s_introduction;
	}
	public Integer getS_province_id() {
		return s_province_id;
	}
	public void setS_province_id(Integer s_province_id) {
		this.s_province_id = s_province_id;
	}
	
	 
}
