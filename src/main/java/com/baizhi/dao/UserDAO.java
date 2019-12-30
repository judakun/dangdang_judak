package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.User;

public interface UserDAO {
	//添加用户
	boolean registUser(User user);
	//查询用户
	List<User> selectUser(User user);
	//修改用户信息
	boolean updateUser(User user);
	//用户登陆
}
