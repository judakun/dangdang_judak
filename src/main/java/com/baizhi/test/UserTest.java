package com.baizhi.test;

import java.util.Date;

import org.junit.Test;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.service.UserServiceImp;
import com.baizhi.util.MD5Utils;
import com.baizhi.util.MybatisUtil;
import com.baizhi.util.SendEmailUtil;

public class UserTest {
	@Test
	public void test1(){
		UserDAO dao = MybatisUtil.getSqlsession().getMapper(UserDAO.class);
		User user = new User("qqq", "qname", "qemail", "qpassword", "激活", "qqq", "盐", new Date());
		boolean b = dao.registUser(user);
		
	}
	@Test
	public void test2(){
		UserService service=new UserServiceImp();
		User user = new User();
		user.setU_nickname("U006");
		user.setU_email("www@qq.com");
		user.setU_password("123");
		user.setU_salt("盐");
		//user.setU_code("code");
		service.registUser(user);
	}
	@Test
	public void test3(){
		SendEmailUtil.sendMessage("948014794@qq.com", MD5Utils.getNum());
	}
	
}
