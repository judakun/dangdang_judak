package com.baizhi.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		if(user!=null){
			if(user.getU_code()!=null||!"".equals(user.getU_code())){
				ai.invoke();
				return null;
			}else{
				return "notActive";
			}
		}else{
			return "notLogin";
		}
	}
	
	/*@Override
	public String intercept(ActionInvocation ai) throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		if(user!=null){
			ai.invoke();
		}
		return "notLogin";
	}*/
}
