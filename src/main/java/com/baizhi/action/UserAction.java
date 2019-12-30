package com.baizhi.action;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.service.UserServiceImp;
import com.baizhi.util.MD5Utils;
import com.baizhi.util.SendEmailUtil;

public class UserAction {
	//输出异常信息
	private String message;
	//获取注册验证码
	private String code;
	//获取注册的用户信息
	private User user;
	//邮箱验证，根据id修改
	//private String u_id;
	//发送邮件验证码
	private String emailCode;
	
	//-------------------用户注册---------------
	public String UserRegist(){
		//处理验证码
		HttpSession session = ServletActionContext.getRequest().getSession();
		String sessionCode=(String)session.getAttribute("code");
		UserService service=new UserServiceImp();
		if(code.equals(sessionCode)){
			try {
				service.registUser(user);
				return "registSuccess";
			} catch (Exception e) {
				message=e.getMessage();
				return "registFalse";
			}
		}else{
			message="验证码错误";
			return "registFalse";
		}
	}
	//----------------发送邮件Action 
	public String sendEmail(){
		System.out.println("进入邮件Action");
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		emailCode = MD5Utils.getNum();
		System.out.println("随机码产生==="+emailCode);
		session.setAttribute("emailCode", emailCode);
		System.out.println("注册的邮箱获取==="+user.getU_email());
		SendEmailUtil.sendMessage(user.getU_email(), emailCode);
		return "sendEmail";
	}
	//-----------------用户邮箱验证--------------
	public String register_ok(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		//获取邮件验证码+输入框输入的验证
		String emailCode=(String) session.getAttribute("emailCode");
			if(emailCode.equals(user.getU_code())){
				try {
					UserService service=new UserServiceImp();
					service.register_ok(user);
				} catch (Exception e) {
					message=e.getMessage();
				}
				return "register_ok";
			}else{
				message="验证码不正确";
				return "register_error";
			}
	}
	//--------------用户登陆-------------
	public String loginAction(){
		UserService service=new UserServiceImp();
		//获取邮箱和密码
		String email=user.getU_email();
		String password=user.getU_password();
		System.out.println("邮箱=="+email+",密码==="+password);
		try {
			service.loginUser(user);
			return "loginSuccess";
		} catch (Exception e) {
			message=e.getMessage();
			return "loginFalse";
		}
	}
	//-------------用户退出---------
	public String userExit(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("user");
		return "userExit";
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}

	public String getEmailCode() {
		return emailCode;
	}

	public void setEmailCode(String emailCode) {
		this.emailCode = emailCode;
	}


	/*public String getU_id() {
		return u_id;
	}


	public void setU_id(String u_id) {
		this.u_id = u_id;
	}*/
	
}
