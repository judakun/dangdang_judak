package com.baizhi.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.entity.Order;
import com.baizhi.entity.User;
import com.baizhi.service.AdminService;
import com.baizhi.service.AdminServiceImpl;
import com.baizhi.service.OrderService;
import com.baizhi.service.OrderServiceImpl;
import com.baizhi.util.SecurityCode;
import com.baizhi.util.SecurityImage;

public class DdAction {
	//获取用户输入的管理员账号
	private Admin admin;
	//返回错误信息
	private String message;
	//获取登陆验证码
	private String code;
	//传递书籍类别集合
	private List<Category> categoryList;
	//获取add-first.jsp传递的一级目录名称
	private Category category;
	//传递一级分类至add_second中展示
	private List<Category> cateFirstList;
	//查询书籍列表
	private List<Book> bookList;
	//接收添加图书的信息
	private Book book;
	//获取添加的图片文件
	private File uploadimage;
	private String uploadimageFileName;
	private String image;
	//获取搜索条件 key 
	private String key;
	//获取搜索内容
	private String content;
	//用户管理，用户userList
	private List<User> userList;
	//管理订单
	private List<Order> orderList;
	//接收订单id查询订单详情
	private Order order;
	//接收用户
	private User user;
	//-----------管理员登陆-----------------------------
	public String adminLogin(){
		AdminService service = new AdminServiceImpl();
		HttpSession session = ServletActionContext.getRequest().getSession();
		String sessionCode=(String)session.getAttribute("code");
		if(code.equals(sessionCode)){
			try {
				service.m_login(admin);
				session.setAttribute("admin", admin);
				return "adLoginSuccess";
			} catch (Exception e) {
				message=e.getMessage();
				return "adLoginError";
			}
		}else{
			return "adLoginError";
		}
	}
	//------------------获取验证码--------------------------
	public String getCode(){
		String code=SecurityCode.getSecurityCode();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("code", code);
		BufferedImage img = SecurityImage.createImage(code);
		OutputStream stream=null;
		try {
			stream=ServletActionContext.getResponse().getOutputStream();
			ImageIO.write(img, "png", stream);
		} catch (Exception e) {
			
		}
		return null;
	}
	//------------------管理员退出----------------------
	public String adminExit(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.getAttribute("admin");
		session.removeAttribute("admin");
		return "exit";
	}
	//----------------展示书籍类别------------------------
	public String categoryList(){
		AdminService service = new AdminServiceImpl();
		categoryList = service.categoryList();
		return "ShowCategoryList";
	}
	//---------------添加一级分类-------------------
	public String addFirstCate(){
		AdminService service = new AdminServiceImpl();
		String f_id=UUID.randomUUID().toString();
		String f_levels="1";
		category.setF_id(f_id);
		category.setF_levels(f_levels);
		try {
			service.addFirstCate(category);
			return "addSuccess";
		} catch (Exception e) {
			message=e.getMessage();
			return "addFalse";
		}

	}
	//--------------添加二级分类--------------
	public String addSecondCate1(){
		//调用categoryList查询所有一级分类，存入一个新的集合，在界面中下拉框展示
		AdminService service = new AdminServiceImpl();
		categoryList = service.categoryList();
		cateFirstList = new ArrayList<>();
		for (Category cate : categoryList) {
			if(cate.getF_levels().equals("1")){
				cateFirstList.add(cate);
			}
		}
		return "addSecondCate1";
	}
	public String addSecondCate2(){
		AdminService service = new AdminServiceImpl();
		String f_id=UUID.randomUUID().toString();
		category.setF_id(f_id);
		category.setF_levels("2");
		try {
			service.addFirstCate(category);
			return "addSuccess";
		} catch (Exception e) {
			message=e.getMessage();
			return "addFalse";
		}	
		
		
	}
	//------------------删除分类-----------------
	public String deleteCategory(){
		AdminService service = new AdminServiceImpl();
		try {
			service.deleteCategory(category);
			return "deleteSuccess";
		} catch (Exception e) {
			message=e.getMessage();
			return "deleteFalse";
		}	
	}
	//--------获取书籍集合，展示所有书籍-->book/show.jsp-------
	public String showBook(){
		AdminService service = new AdminServiceImpl();
		bookList = service.getBookList(new Book());
		return "getBookList";
	}
	//--------添加图书---------------------
	public String addBook1(){
		AdminService service = new AdminServiceImpl();
		category=new Category();
		category.setF_levels("2");
		categoryList = service.categoryList(category);
		return "category2List";
	}
	public String addBook2(){
		String b_id=UUID.randomUUID().toString();
		book.setB_id(b_id);
		book.setB_saleNum(0);
		//------处理图片--------
		String realPath=ServletActionContext.getServletContext().getRealPath(image);
		try {
			FileUtils.copyFile(uploadimage, new File(realPath+"\\"+uploadimageFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//将图片的地址存储在数据库中
		//动态获取项目路径
		String contextPath=ServletActionContext.getRequest().getContextPath();
		String imagePath=contextPath+"/"+image+"/"+uploadimageFileName;
		//System.out.println("存储数据库中的图片地址"+imagePath);
		book.setB_face(imagePath);
		System.out.println("获取图书信息==="+book);
		//调用插入方法
		AdminService service = new AdminServiceImpl();
		try {
			service.addBook(book);
			return "addSuccess";
		} catch (Exception e) {
			message=e.getMessage();
			return "addFalse";
		}
	}
	//-----------根据id删除书籍--------------
	public String deleteBook(){
		AdminService service = new AdminServiceImpl();
		try {
			service.deleteBook(book.getB_id());
			return "deleteBook";
		} catch (Exception e) {
			message=e.getMessage();
			return "deleteBook";
		}
	}
	//------------修改书籍----------
	public String updateBook1(){
		AdminService service = new AdminServiceImpl();
		//分类下拉框
		category=new Category();
		category.setF_levels("2");
		categoryList = service.categoryList(category);
		//获取旧数据
		bookList = service.getBDelList(book);
		book=bookList.get(0);
		return "updateBook1";
	}
	public String updateBook2(){
		AdminService service = new AdminServiceImpl();
		System.out.println("获取图片文件前的信息------------"+book);
		//处理图片
		System.out.println("图片信息========="+uploadimage);
		if(uploadimage != null){
			String realPath=ServletActionContext.getServletContext().getRealPath(image);
			try {
				FileUtils.copyFile(uploadimage, new File(realPath+"\\"+uploadimageFileName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//将图片的地址存储在数据库中
			//动态获取项目路径
			String contextPath=ServletActionContext.getRequest().getContextPath();
			String imagePath=contextPath+"/"+image+"/"+uploadimageFileName;
			//System.out.println("存储数据库中的图片地址"+imagePath);
			book.setB_face(imagePath);
		}
			System.out.println("获取图片文件后的信息========"+book);
		try {
			service.updateBook(book);
			return "updateBook2";
		} catch (Exception e) {
			message=e.getMessage();
			return "updateBook2";
		}
	}
	//------------根据条件查找书籍-------------
	public String serchBook(){
		AdminService service = new AdminServiceImpl();
		book=new Book();
		if(key.equals("b_cbs")){
			book.setB_cbs(content);
		}else if(key.equals("b_name")){
			book.setB_name(content);
		}else{
			book.setB_author(content);
		}
		
		bookList = service.getBookList(book);
		for (Book b : bookList) {
			System.out.println("模糊查询===="+b);
		}
		return "serchBook";
	}
	//用户管理
	public String showUser(){
		AdminService service = new AdminServiceImpl();
		userList = service.selectAllUser();
		return "showUser";
	}
	//订单管理
	public String getAllOrder(){
		AdminService service = new AdminServiceImpl();
		orderList=service.selectOrder(new Order());
		return "getAllOrder";
	}
	//订单详情
	public String orderDetail(){
		OrderService service= new OrderServiceImpl();
		order = service.selectOrderItemByO_id(order.getO_id());
		return "orderDetail";
	}
	//修改用户状态
	public String updateUserStatus(){
		AdminService service = new AdminServiceImpl();
		service.updateUserStatus(user);
		return "updateUserStatus";
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public List<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Category> getCateFirstList() {
		return cateFirstList;
	}
	public void setCateFirstList(List<Category> cateFirstList) {
		this.cateFirstList = cateFirstList;
	}
	public List<Book> getBookList() {
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public File getUploadimage() {
		return uploadimage;
	}
	public void setUploadimage(File uploadimage) {
		this.uploadimage = uploadimage;
	}
	public String getUploadimageFileName() {
		return uploadimageFileName;
	}
	public void setUploadimageFileName(String uploadimageFileName) {
		this.uploadimageFileName = uploadimageFileName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public List<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
