package com.baizhi.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import com.baizhi.util.MD5Utils;
import com.baizhi.util.MybatisUtil;

public class UserServiceImp implements UserService {

	@Override
	public void registUser(User user) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		UserDAO dao = MybatisUtil.getSqlsession().getMapper(UserDAO.class);
		//设置随机id
		String u_id=UUID.randomUUID().toString();
		//获取盐
		User user2 = new User();
		String salt=MD5Utils.getSalt();
		user2.setU_email(user.getU_email());
		List<User> selectUser = dao.selectUser(user2);
		if(selectUser.size()==0){
			try {
				user.setU_id(u_id);
				//用户注册，默认正常，管理员可以禁用					
				user.setU_status("正常");				
				//设置用户注册时间，系统当前时间
				user.setU_createDate(new Date());
				//存盐
				user.setU_salt(salt);
				//获取加密密码，password+salt
				String password = MD5Utils.getPassword(user.getU_password()+salt);
				user.setU_password(password);
				boolean b=dao.registUser(user);
				//登陆成功，存储用户信息
				session.setAttribute("user", user);
				MybatisUtil.commit();
			} catch (Exception e) {
				MybatisUtil.rollback();
				throw new RuntimeException("用户注册失败");
			}
		}else{
			MybatisUtil.close();
			throw new RuntimeException("邮箱已存在");
		}
	}

	@Override
	public void register_ok(User user) {
		UserDAO dao = MybatisUtil.getSqlsession().getMapper(UserDAO.class);
		try {
			dao.updateUser(user);
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
			throw new RuntimeException("激活失败");
		}
		
	}

	@Override
	public void loginUser(User user) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		//1、判断用户是否存在,user中只有email和password,根据邮箱查询
		UserDAO dao = MybatisUtil.getSqlsession().getMapper(UserDAO.class);
		List<User> list = dao.selectUser(user);
		if(list.size()!=0){
			//2、判断密码是否正确,加密的密码校验
			//3、判断账户是否被禁用
				String Mpassword=MD5Utils.getPassword(user.getU_password()+list.get(0).getU_salt());
				if(list.get(0).getU_password().equals(Mpassword)){
						if(list.get(0).getU_status().equals("正常")){
							session.setAttribute("user", list.get(0));
							MybatisUtil.close();
						}else{
							MybatisUtil.close();
							throw new RuntimeException("账户被禁用，联系管理员(鞠达坤)");
						}
				}else{
					MybatisUtil.close();
					throw new RuntimeException("密码不正确");
					}
		}else{
			//用户不存在
			MybatisUtil.close();
			throw new RuntimeException("用户不存在");
		}
	}

}
