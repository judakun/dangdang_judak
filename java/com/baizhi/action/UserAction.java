package com.baizhi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.service.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private User user; 
	public String register(){
		UserService userService= new UserServiceImpl();
		boolean b=userService.registerUser(user);
		if(b){
			return "registerSuccess";
		}else{
			return "registerFalse";
		}	
	}
		public String loginExit(){
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.removeAttribute("UserLogin");
			return "ExitSuccess";
		}
	
	
	public String login(){
		HttpSession session = ServletActionContext.getRequest().getSession();

			UserService userService= new UserServiceImpl();
			User user2 = userService.loginUser(user);
			if(user2!=null){
				session.setAttribute("UserLogin", user2);
				return "loginSuccess";
			}else{
				return "loginFalse";
			}	
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
