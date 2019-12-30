package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDAO {
	boolean registUser(User user);
	User loginUser(User user);
}
