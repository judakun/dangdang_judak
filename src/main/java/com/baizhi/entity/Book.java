package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable{
	private String  b_id;
	private String  b_name;
	private Double  b_price;
	private Double  b_dprice;  
	private String  b_author;
	private String  b_category_id;
	private String  b_intro;
	private String  b_auIntro;
	private String  b_cbs;
	private Date    b_cbDate;
	private Date    b_ysDate; 
	private String  b_bc; 
	private String  b_yc;
	private String  b_zz;
	private Integer b_page;
	private String  b_bz;
	private String  b_kb;
	private Integer b_words;
	private String  ISBN;
	private String  b_bjtj;
	private String  b_mtpl;
	private String  b_jbml;
	private String  b_face;
	private Integer b_kc;
	private Integer b_saleNum;
	private Date    b_sjDate;
	
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public Double getB_price() {
		return b_price;
	}
	public void setB_price(Double b_price) {
		this.b_price = b_price;
	}
	public Double getB_dprice() {
		return b_dprice;
	}
	public void setB_dprice(Double b_dprice) {
		this.b_dprice = b_dprice;
	}
	public String getB_author() {
		return b_author;
	}
	public void setB_author(String b_author) {
		this.b_author = b_author;
	}
	public String getB_category_id() {
		return b_category_id;
	}
	public void setB_category_id(String b_category_id) {
		this.b_category_id = b_category_id;
	}
	public String getB_intro() {
		return b_intro;
	}
	public void setB_intro(String b_intro) {
		this.b_intro = b_intro;
	}
	public String getB_auIntro() {
		return b_auIntro;
	}
	public void setB_auIntro(String b_auIntro) {
		this.b_auIntro = b_auIntro;
	}
	public String getB_cbs() {
		return b_cbs;
	}
	public void setB_cbs(String b_cbs) {
		this.b_cbs = b_cbs;
	}
	public java.sql.Date getB_cbDate() {
		return new java.sql.Date(b_cbDate.getTime());
	}
	public void setB_cbDate(Date b_cbDate) {
		this.b_cbDate = b_cbDate;
	}
	public java.sql.Date getB_ysDate() {
		return new java.sql.Date(b_ysDate.getTime());
	}
	public void setB_ysDate(Date b_ysDate) {
		this.b_ysDate = b_ysDate;
	}
	public java.sql.Date getB_sjDate() {
		return new java.sql.Date(b_sjDate.getTime());
	}
	public void setB_sjDate(Date b_sjDate) {
		this.b_sjDate = b_sjDate;
	}
	public String getB_bc() {
		return b_bc;
	}
	public void setB_bc(String b_bc) {
		this.b_bc = b_bc;
	}
	public String getB_yc() {
		return b_yc;
	}
	public void setB_yc(String b_yc) {
		this.b_yc = b_yc;
	}
	public String getB_zz() {
		return b_zz;
	}
	public void setB_zz(String b_zz) {
		this.b_zz = b_zz;
	}
	public Integer getB_page() {
		return b_page;
	}
	public void setB_page(Integer b_page) {
		this.b_page = b_page;
	}
	public String getB_bz() {
		return b_bz;
	}
	public void setB_bz(String b_bz) {
		this.b_bz = b_bz;
	}
	public String getB_kb() {
		return b_kb;
	}
	public void setB_kb(String b_kb) {
		this.b_kb = b_kb;
	}
	public Integer getB_words() {
		return b_words;
	}
	public void setB_words(Integer b_words) {
		this.b_words = b_words;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getB_bjtj() {
		return b_bjtj;
	}
	public void setB_bjtj(String b_bjtj) {
		this.b_bjtj = b_bjtj;
	}
	public String getB_mtpl() {
		return b_mtpl;
	}
	public void setB_mtpl(String b_mtpl) {
		this.b_mtpl = b_mtpl;
	}
	public String getB_jbml() {
		return b_jbml;
	}
	public void setB_jbml(String b_jbml) {
		this.b_jbml = b_jbml;
	}
	public String getB_face() {
		return b_face;
	}
	public void setB_face(String b_face) {
		this.b_face = b_face;
	}
	public Integer getB_kc() {
		return b_kc;
	}
	public void setB_kc(Integer b_kc) {
		this.b_kc = b_kc;
	}
	public Integer getB_saleNum() {
		return b_saleNum;
	}
	public void setB_saleNum(Integer b_saleNum) {
		this.b_saleNum = b_saleNum;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String b_id, String b_name, Double b_price, Double b_dprice,
			String b_author, String b_category_id, String b_intro,
			String b_auIntro, String b_cbs, Date b_cbDate, Date b_ysDate,
			String b_bc, String b_yc, String b_zz, Integer b_page, String b_bz,
			String b_kb, Integer b_words, String iSBN, String b_bjtj,
			String b_mtpl, String b_jbml, String b_face, Integer b_kc,
			Integer b_saleNum, Date b_sjDate) {
		super();
		this.b_id = b_id;
		this.b_name = b_name;
		this.b_price = b_price;
		this.b_dprice = b_dprice;
		this.b_author = b_author;
		this.b_category_id = b_category_id;
		this.b_intro = b_intro;
		this.b_auIntro = b_auIntro;
		this.b_cbs = b_cbs;
		this.b_cbDate = b_cbDate;
		this.b_ysDate = b_ysDate;
		this.b_bc = b_bc;
		this.b_yc = b_yc;
		this.b_zz = b_zz;
		this.b_page = b_page;
		this.b_bz = b_bz;
		this.b_kb = b_kb;
		this.b_words = b_words;
		ISBN = iSBN;
		this.b_bjtj = b_bjtj;
		this.b_mtpl = b_mtpl;
		this.b_jbml = b_jbml;
		this.b_face = b_face;
		this.b_kc = b_kc;
		this.b_saleNum = b_saleNum;
		this.b_sjDate = b_sjDate;
	}
	@Override
	public String toString() {
		return "Book [b_id=" + b_id + ", b_name=" + b_name + ", b_price="
				+ b_price + ", b_dprice=" + b_dprice + ", b_author=" + b_author
				+ ", b_category_id=" + b_category_id + ", b_intro=" + b_intro
				+ ", b_auIntro=" + b_auIntro + ", b_cbs=" + b_cbs
				+ ", b_cbDate=" + b_cbDate + ", b_ysDate=" + b_ysDate
				+ ", b_bc=" + b_bc + ", b_yc=" + b_yc + ", b_zz=" + b_zz
				+ ", b_page=" + b_page + ", b_bz=" + b_bz + ", b_kb=" + b_kb
				+ ", b_words=" + b_words + ", ISBN=" + ISBN + ", b_bjtj="
				+ b_bjtj + ", b_mtpl=" + b_mtpl + ", b_jbml=" + b_jbml
				+ ", b_face=" + b_face + ", b_kc=" + b_kc + ", b_saleNum="
				+ b_saleNum + ", b_sjDate=" + b_sjDate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ISBN == null) ? 0 : ISBN.hashCode());
		result = prime * result
				+ ((b_auIntro == null) ? 0 : b_auIntro.hashCode());
		result = prime * result
				+ ((b_author == null) ? 0 : b_author.hashCode());
		result = prime * result + ((b_bc == null) ? 0 : b_bc.hashCode());
		result = prime * result + ((b_bjtj == null) ? 0 : b_bjtj.hashCode());
		result = prime * result + ((b_bz == null) ? 0 : b_bz.hashCode());
		result = prime * result
				+ ((b_category_id == null) ? 0 : b_category_id.hashCode());
		result = prime * result
				+ ((b_cbDate == null) ? 0 : b_cbDate.hashCode());
		result = prime * result + ((b_cbs == null) ? 0 : b_cbs.hashCode());
		result = prime * result
				+ ((b_dprice == null) ? 0 : b_dprice.hashCode());
		result = prime * result + ((b_face == null) ? 0 : b_face.hashCode());
		result = prime * result + ((b_id == null) ? 0 : b_id.hashCode());
		result = prime * result + ((b_intro == null) ? 0 : b_intro.hashCode());
		result = prime * result + ((b_jbml == null) ? 0 : b_jbml.hashCode());
		result = prime * result + ((b_kb == null) ? 0 : b_kb.hashCode());
		result = prime * result + ((b_kc == null) ? 0 : b_kc.hashCode());
		result = prime * result + ((b_mtpl == null) ? 0 : b_mtpl.hashCode());
		result = prime * result + ((b_name == null) ? 0 : b_name.hashCode());
		result = prime * result + ((b_page == null) ? 0 : b_page.hashCode());
		result = prime * result + ((b_price == null) ? 0 : b_price.hashCode());
		result = prime * result
				+ ((b_saleNum == null) ? 0 : b_saleNum.hashCode());
		result = prime * result
				+ ((b_sjDate == null) ? 0 : b_sjDate.hashCode());
		result = prime * result + ((b_words == null) ? 0 : b_words.hashCode());
		result = prime * result + ((b_yc == null) ? 0 : b_yc.hashCode());
		result = prime * result
				+ ((b_ysDate == null) ? 0 : b_ysDate.hashCode());
		result = prime * result + ((b_zz == null) ? 0 : b_zz.hashCode());
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
		Book other = (Book) obj;
		if (ISBN == null) {
			if (other.ISBN != null)
				return false;
		} else if (!ISBN.equals(other.ISBN))
			return false;
		if (b_auIntro == null) {
			if (other.b_auIntro != null)
				return false;
		} else if (!b_auIntro.equals(other.b_auIntro))
			return false;
		if (b_author == null) {
			if (other.b_author != null)
				return false;
		} else if (!b_author.equals(other.b_author))
			return false;
		if (b_bc == null) {
			if (other.b_bc != null)
				return false;
		} else if (!b_bc.equals(other.b_bc))
			return false;
		if (b_bjtj == null) {
			if (other.b_bjtj != null)
				return false;
		} else if (!b_bjtj.equals(other.b_bjtj))
			return false;
		if (b_bz == null) {
			if (other.b_bz != null)
				return false;
		} else if (!b_bz.equals(other.b_bz))
			return false;
		if (b_category_id == null) {
			if (other.b_category_id != null)
				return false;
		} else if (!b_category_id.equals(other.b_category_id))
			return false;
		if (b_cbDate == null) {
			if (other.b_cbDate != null)
				return false;
		} else if (!b_cbDate.equals(other.b_cbDate))
			return false;
		if (b_cbs == null) {
			if (other.b_cbs != null)
				return false;
		} else if (!b_cbs.equals(other.b_cbs))
			return false;
		if (b_dprice == null) {
			if (other.b_dprice != null)
				return false;
		} else if (!b_dprice.equals(other.b_dprice))
			return false;
		if (b_face == null) {
			if (other.b_face != null)
				return false;
		} else if (!b_face.equals(other.b_face))
			return false;
		if (b_id == null) {
			if (other.b_id != null)
				return false;
		} else if (!b_id.equals(other.b_id))
			return false;
		if (b_intro == null) {
			if (other.b_intro != null)
				return false;
		} else if (!b_intro.equals(other.b_intro))
			return false;
		if (b_jbml == null) {
			if (other.b_jbml != null)
				return false;
		} else if (!b_jbml.equals(other.b_jbml))
			return false;
		if (b_kb == null) {
			if (other.b_kb != null)
				return false;
		} else if (!b_kb.equals(other.b_kb))
			return false;
		if (b_kc == null) {
			if (other.b_kc != null)
				return false;
		} else if (!b_kc.equals(other.b_kc))
			return false;
		if (b_mtpl == null) {
			if (other.b_mtpl != null)
				return false;
		} else if (!b_mtpl.equals(other.b_mtpl))
			return false;
		if (b_name == null) {
			if (other.b_name != null)
				return false;
		} else if (!b_name.equals(other.b_name))
			return false;
		if (b_page == null) {
			if (other.b_page != null)
				return false;
		} else if (!b_page.equals(other.b_page))
			return false;
		if (b_price == null) {
			if (other.b_price != null)
				return false;
		} else if (!b_price.equals(other.b_price))
			return false;
		if (b_saleNum == null) {
			if (other.b_saleNum != null)
				return false;
		} else if (!b_saleNum.equals(other.b_saleNum))
			return false;
		if (b_sjDate == null) {
			if (other.b_sjDate != null)
				return false;
		} else if (!b_sjDate.equals(other.b_sjDate))
			return false;
		if (b_words == null) {
			if (other.b_words != null)
				return false;
		} else if (!b_words.equals(other.b_words))
			return false;
		if (b_yc == null) {
			if (other.b_yc != null)
				return false;
		} else if (!b_yc.equals(other.b_yc))
			return false;
		if (b_ysDate == null) {
			if (other.b_ysDate != null)
				return false;
		} else if (!b_ysDate.equals(other.b_ysDate))
			return false;
		if (b_zz == null) {
			if (other.b_zz != null)
				return false;
		} else if (!b_zz.equals(other.b_zz))
			return false;
		return true;
	}
	
	
	
	
}
