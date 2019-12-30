package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import com.baizhi.mybatisUtil.MybatisUtil;

public class UserServiceImpl implements UserService {

	@Override
	public boolean registerUser(User user) {
		UserDAO userDAO = MybatisUtil.getSqlsession().getMapper(UserDAO.class);
		boolean b=userDAO.registUser(user);
		if(b){
			MybatisUtil.commit();
			return true;
		}else{
			MybatisUtil.rollback();
			return false;
		}	
	}

	@Override
	public User loginUser(User user) {
		UserDAO dao = MybatisUtil.getSqlsession().getMapper(UserDAO.class);
		User user2 = dao.loginUser(user);
		MybatisUtil.close();
		if(user2!=null){
			return user2;
			}else{
				return null;
			}
		
		
	}

}
