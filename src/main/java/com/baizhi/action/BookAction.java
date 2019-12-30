package com.baizhi.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.service.AdminService;
import com.baizhi.service.AdminServiceImpl;
import com.baizhi.service.BookService;
import com.baizhi.service.BookServiceImpl;

public class BookAction {
	//用户 
	
	//更多书籍
	private List<Book> allList;
	//展示分类的集合
	private List<Category> cateList;
	//编辑推荐，展示随机两本书即可
	private List<Book> tjList;
	//畅销图书，前8本
	private List<Book> cxList;
	//上架时间，前四本
	private List<Book> cjDateList;
	//上架时间&销量
	private List<Book> cjDateSaleList;
	//获取书籍名称
	private String bookName;
	//返回书籍详细信息
	private Book bookInfo;
	//接收category的分类名称cateName
	private Category category;
	//一级分类
	private String fid;
	//二级分类
	private String sid;
	//总页数
	private Integer totalPage;
	//页码
	private Integer pageNum;
	//每页显示条数
	private Integer pageSize=4;
	//接收购物车中需要修改的书籍数量
	private Integer updateCount;
	//下一页
	private String pageChange;
	public String allBookList(){
		AdminService adminService = new AdminServiceImpl();
		allList=adminService.getBookList(new Book());
		return "allBookList";
	}
	//主页面
	public String mainShow(){
		BookService bookService = new BookServiceImpl();
		AdminService adminService = new AdminServiceImpl();
		//目录
		Category c = new Category();
		c.setF_levels("1");
		cateList = bookService.selectCategory(c);
		//编辑推荐
		List<Book> bookList = adminService.getBookList(new Book());
		int a = new Random().nextInt(bookList.size());
		int b = new Random().nextInt(bookList.size());
		tjList=new ArrayList<>();
		while(true){
			if(a==b){
				b = new Random().nextInt(bookList.size());
			}else{
				break;
			}
		}
		tjList.add(bookList.get(a));
		tjList.add(bookList.get(b));
		//畅销图书
		cxList = new ArrayList<>();
		List<Book> list = bookService.selectBookBySale();
		for (Book book : list) {
			if(book.getB_saleNum()!=null){
				cxList.add(book);
			}
		}
		//上架时间
		cjDateList=bookService.selectBookBySjDate();
		//时间，销量排序
		cjDateSaleList=bookService.selectBookBySjDate_Sale();
	    return "mainShow";
	}
	//点击图书，查看详情
	public String bookDetail(){
		BookService bookService = new BookServiceImpl();
		System.out.println("bookName==="+bookName);
		bookInfo = bookService.selectOne(bookName);
		System.out.println("书籍详情："+bookInfo);
		return "bookDetail";
	}
	//点击分类，分页浏览书籍
	public String CategoryView(){
		BookService bookService = new BookServiceImpl();
		Category c = new Category();
		c.setF_id(fid);
		//分类左栏列表cateList
		cateList = bookService.selectCategory(c);
		//分类，当前路径展示所用
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		request.setAttribute("fid", fid);
		request.setAttribute("sid", sid);
		//总页数
		System.out.println(fid+"---------");
		System.out.println(sid+"---------");
		System.out.println(pageSize+"---------");
		totalPage=bookService.totalPage(fid, sid, pageSize);
		System.out.println("查看总页数========="+totalPage);
		//根据传递的id查询对应的图书
		if(pageNum==null){
			//第一次访问，默认第一页
			pageNum=1;
			session.setAttribute("pageNum", pageNum);
		}else{
			//第二次访问，获取jsp界面传递的页数,获取session中的pageNum
		    pageNum = (Integer) session.getAttribute("pageNum");
			//获取页数变化标记pageChange
		    System.out.println("查看更改前的页码pageNum===="+pageNum);
		    System.out.println("获取页数变化标记pageChange===="+pageChange);
			if(pageChange.equals("f")){
				pageNum=1;
			}else if(pageChange.equals("s")){
				pageNum-=1;
			}else if(pageChange.equals("a")){
				pageNum+=1;
			}else if(pageChange.equals("e")){
				pageNum=totalPage;
			}
			System.out.println("查看更改后的页码pageNum===="+pageNum);
			session.setAttribute("pageNum", pageNum);
		}
		allList=bookService.selectByCateBook(fid, sid, pageNum, pageSize);
		return "CategoryView";
	}
	//-----------------购物车-------
	public String addCart(){
		BookService bookService = new BookServiceImpl();
		bookService.addCart(bookInfo);
		return "addCart";
	}
	//--------------修改购物车书籍数量-----------
	public String updateCount(){
		BookService bookService = new BookServiceImpl();
		bookService.updateCart(bookInfo.getB_id(), updateCount);
		return "updateCount";
	}
	//------------------删除购物车的书籍----
	public String deleteCartBook(){
		BookService bookService = new BookServiceImpl();
		bookService.deleteCartBook(bookInfo.getB_id());
		return "deleteCartBook";
	}
	//-----------------下单，获取收货地址----------------
	public String selectAddressByUserId(){
		
		return "addressList";
	}
	public List<Category> getCateList() {
		return cateList;
	}

	public void setCateList(List<Category> cateList) {
		this.cateList = cateList;
	}
	public List<Book> getTjList() {
		return tjList;
	}
	public void setTjList(List<Book> tjList) {
		this.tjList = tjList;
	}



	public List<Book> getCxList() {
		return cxList;
	}



	public void setCxList(List<Book> cxList) {
		this.cxList = cxList;
	}



	public List<Book> getCjDateList() {
		return cjDateList;
	}



	public void setCjDateList(List<Book> cjDateList) {
		this.cjDateList = cjDateList;
	}



	public List<Book> getCjDateSaleList() {
		return cjDateSaleList;
	}



	public void setCjDateSaleList(List<Book> cjDateSaleList) {
		this.cjDateSaleList = cjDateSaleList;
	}



	public List<Book> getAllList() {
		return allList;
	}



	public void setAllList(List<Book> allList) {
		this.allList = allList;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public Book getBookInfo() {
		return bookInfo;
	}


	public void setBookInfo(Book bookInfo) {
		this.bookInfo = bookInfo;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public String getFid() {
		return fid;
	}


	public void setFid(String fid) {
		this.fid = fid;
	}


	public String getSid() {
		return sid;
	}


	public void setSid(String sid) {
		this.sid = sid;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getUpdateCount() {
		return updateCount;
	}

	public void setUpdateCount(Integer updateCount) {
		this.updateCount = updateCount;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public String getPageChange() {
		return pageChange;
	}
	public void setPageChange(String pageChange) {
		this.pageChange = pageChange;
	}


	

	
	

	
	
}
