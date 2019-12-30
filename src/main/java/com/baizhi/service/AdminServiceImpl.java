package com.baizhi.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.AdminDAO;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.entity.Order;
import com.baizhi.entity.User;
import com.baizhi.util.MybatisUtil;

public class AdminServiceImpl implements AdminService {

	@Override
	public void m_login(Admin admin) {
		AdminDAO loginDAO = MybatisUtil.getSqlsession().getMapper(AdminDAO.class);
		Admin a = loginDAO.m_login(admin.getM_username());
		if(a==null) throw new RuntimeException("该用户不存在");
		if(!a.getM_password().equals(admin.getM_password())) throw new RuntimeException("密码错误");
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("adminLogin", a);
		MybatisUtil.close();

	}

	@Override
	public List<Category> categoryList() {
		AdminDAO loginDAO = MybatisUtil.getSqlsession().getMapper(AdminDAO.class);
		List<Category> categoryList = loginDAO.categoryList();
		MybatisUtil.close();
		return categoryList;
	}

	@Override
	public void addFirstCate(Category category) {
		AdminDAO loginDAO = MybatisUtil.getSqlsession().getMapper(AdminDAO.class);
		Category cate2 = new Category();
		cate2.setF_name(category.getF_name());
		List<Category> selectCate = loginDAO.selectCate(cate2);
		if(selectCate.size()!=0){
			MybatisUtil.close();
			 throw new RuntimeException("该目录已经存在，重新输入");
		}else{
			try {
				loginDAO.addFirstCate(category);
				MybatisUtil.commit();
			} catch (Exception e) {
				MybatisUtil.rollback();
			}
			
		}
		
		
	}

	/* (non-Javadoc)
	 * @see com.baizhi.service.AdminService#deleteCategory(com.baizhi.entity.Category)
	 */
	@Override
	public void deleteCategory(Category category) {
		AdminDAO dao = MybatisUtil.getSqlsession().getMapper(AdminDAO.class);
		//1、查询分类f_id是几级分类
			//1.1二级分类删除，查询所有的书籍，将分类id=f_id的书籍删除
			//1.2一级分类删除，查询所有f_parent_id=f_id，查询所有的书籍，
			   //将分类id=f_parent_id的书籍删除，
			   //删除f_parent_id=f_id的二级分类
			   //删除f_id的一级分类
		//删除分类，先将parent_id=f_id的分类删除，在将f_id的分类删除
			//category只有f_id
		List<Category> list = dao.selectCate(category);
		//不用循环，根据id查询，有且只有一个对象
		String level = list.get(0).getF_levels();
		if(level.equals("1")){
			//删除一级分类,查询父类是该id的分类，批量删除
			Category category2 = new Category();
			category2.setF_parent_id(category.getF_id());
			List<Category> list2 = dao.selectCate(category2);
			Category category3 = new Category();
			try {
				for (Category cate : list2) {
					category3.setF_parent_id(cate.getF_parent_id());
					dao.deleteCategory(category3);
				}
				//二级批量删除后，删除一级分类
				dao.deleteCategory(category);
				MybatisUtil.commit();
			} catch (Exception e) {
				MybatisUtil.rollback();
				throw new RuntimeException("删除失败");
			}
		}else{
			//删除二级分类，先直接删除，有图书表之后再说
			/*
			 * 先创建Book实体类才能操作
			 * 
			 */
			//category里只有f_id
			try {
				dao.deleteCategory(category);
				MybatisUtil.commit();
			} catch (Exception e) {
				MybatisUtil.rollback();
				throw new RuntimeException("删除失败");
			}
			
		}
		
	}

	@Override
	public List<Book> getBookList(Book book) {
		AdminDAO dao = MybatisUtil.getSqlsession().getMapper(AdminDAO.class);
		List<Book> bookList = dao.getBookList(book);
		MybatisUtil.close();
		return bookList;
	}

	@Override
	public List<Category> categoryList(Category category) {
		AdminDAO dao = MybatisUtil.getSqlsession().getMapper(AdminDAO.class);
		List<Category> selectCate = dao.selectCate(category);
		return selectCate;
	}

	@Override
	public void addBook(Book book) {
		AdminDAO dao = MybatisUtil.getSqlsession().getMapper(AdminDAO.class);
		Book one = dao.selectOne(book.getB_name());
		System.out.println(one+"0000图书插入000000000");
		if(one==null){
			try {
				dao.addBook(book);
				MybatisUtil.commit();
			} catch (Exception e) {
				//e.printStackTrace();
				MybatisUtil.rollback();
				throw new RuntimeException("插入失败，请检查数据的完整性");
			}
		}else{
			MybatisUtil.close();
			throw new RuntimeException("书名已存在");
		}
		
		
		
	}

	@Override
	public void deleteBook(String b_id) {
		AdminDAO dao = MybatisUtil.getSqlsession().getMapper(AdminDAO.class);
		try {
			dao.deleteBook(b_id);
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
			throw new RuntimeException("删除失败");
		}
		
		
	}

	@Override
	public List<Book> getBDelList(Book book) {
		AdminDAO dao = MybatisUtil.getSqlsession().getMapper(AdminDAO.class);
		List<Book> list = dao.getBDelList(book);
		MybatisUtil.close();
		return list;
	}

	@Override
	public void updateBook(Book book) {
		AdminDAO dao = MybatisUtil.getSqlsession().getMapper(AdminDAO.class);
		try {
			boolean b = dao.updateBook(book);
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
			e.printStackTrace();
			//throw new RuntimeException("更新异常");
		}
		
		
	}

	@Override
	public List<User> selectAllUser() {
		AdminDAO loginDAO = MybatisUtil.getSqlsession().getMapper(AdminDAO.class);
		List<User> allUser = loginDAO.selectAllUser();
		MybatisUtil.close();
		return allUser;
	}

	@Override
	public List<Order> selectOrder(Order order) {
		// TODO Auto-generated method stub
		AdminDAO loginDAO = MybatisUtil.getSqlsession().getMapper(AdminDAO.class);
		List<Order> list = loginDAO.selectOrder(order);
		MybatisUtil.close();
		return list;
	}

	@Override
	public boolean updateUserStatus(User user) {
		AdminDAO loginDAO = MybatisUtil.getSqlsession().getMapper(AdminDAO.class);
		if(user.getU_status().equals("禁用")){
			user.setU_status("正常");
		}else{
			user.setU_status("禁用");
		}
		boolean b=loginDAO.updateUserStatus(user);
		MybatisUtil.commit();
		return b;
	}

	

}
