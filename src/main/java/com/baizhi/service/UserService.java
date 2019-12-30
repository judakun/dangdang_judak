package com.baizhi.service;

import com.baizhi.entity.User;
public interface UserService {
	//用户注册
	void registUser(User user);
	//修改用户信息（邮箱验证，就是修改用户状态，用户信息）
	void register_ok(User user);
	//用户登陆
	void loginUser(User user);
}
