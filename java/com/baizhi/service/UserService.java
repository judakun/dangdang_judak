package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService {
	boolean registerUser(User user);
	User loginUser(User user);
}
