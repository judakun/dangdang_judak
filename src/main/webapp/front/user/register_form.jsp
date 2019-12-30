<%@page contentType="text/html;charset=utf-8"  isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="${pageContext.request.contextPath}/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/front/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
	//更换验证码
	function changeImage()
		{
			var pic=document.getElementById("imgVcode");
			var i=Math.random();//目的是使页面不一样
	 		pic.src="${pageContext.request.contextPath}/getCode?id="+i;
		}
	//u_email表单验证
	function fun1(){
		var myforms=document.getElementById("email");
		console.log("-----------------------------------");
		var myemail=myforms.value;
		console.log("-----------------------------------"+myemail);
		var myReg=/^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
		var www=document.getElementById("myspan");
		if(myReg.test(myemail)){
			www.innerHTML="<font style='color:green'>√格式正确 √</font>";
			return true;
		}else{
			www.innerHTML="<font style='color:green'>×格式错误 ×</font>";
			return false;
		}
	}
	
	//验证两次输入密码是否一致
	function fun2(){
		console.log("---------------------------------------------------");
		var span=document.getElementById("password1Info");
		var pws1=document.getElementById("txtPassword");
		var pws2=document.getElementById("txtRepeatPass");
		if(pws1.value===pws2.value){
			span.innerHTML="<font style='color:green'>正确 √</font>";
			return true;
		}else{
			span.innerHTML="<font style='color:green'>错误 ×</font>";
			return false;
		}
	}
	
	//u_nickname表单验证
	function fun3(){
		var myforms=document.getElementById("txtNickName");
		console.log("-----------------------------------");
		var u_nickname=myforms.value;
		console.log("-----------------------------------"+u_nickname);
		var myReg=/^[\u4E00-\u9FA5A-Za-z0-9]{4,20}$/;
		//var myReg=/^[\u4E00-\u9FA5A-Za-z0-9]{4,20}$/gi.test(u_nickname) && u_nickname.replace(/[\u4E00-\u9FA5/gi,'aa').length;
		var www=document.getElementById("nameInfo");
		if(myReg.test(u_nickname)){
			www.innerHTML="<font style='color:green'>√格式正确 √</font>";
			return true;
		}else{
			www.innerHTML="<font style='color:green'>×格式错误 ×</font>";
			return false;
		}
	}
	//u_password表单验证
	function fun4(){
		var myforms=document.getElementById("txtPassword");
		var u_password=myforms.value;
		var myReg=/^[\u4E00-\u9FA5A-Za-z0-9]{4,20}$/;
		var www=document.getElementById("passwordInfo");
		if(myReg.test(u_password)){
			www.innerHTML="<font style='color:green'>√格式正确 √</font>";
			return true;
		}else{
			www.innerHTML="<font style='color:green'>×格式错误 ×</font>";
			return false;
		}
	}
	//提交校验
	function funs(){
		return fun1()&fun2()&fun3()&fun4();
	}
</script>	
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			注册步骤:
			<span class="red_bold">1.填写信息</span> > 2.验证邮箱 > 3.注册成功
		</div>
		<div class="fill_message">
			<form name="ctl00" method="post" action="${pageContext.request.contextPath}/U1/UserRegist" id="f" onsubmit="return funs()">
				<span style="color:red;font-size: 21px;margin-left: 45px;">${message}</span>
				<h2>
					以下均为必填项&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</h2>
				<table class="tab_login" >
					<tr>
						<td valign="top" class="w1">
							请填写您的Email地址：
						</td>
						<td>
							<input name="user.u_email"  type="text" id="email" class="text_input" onblur="fun1()" placeholder="948014794@qq.com"/>
							<div class="text_left" id="emailValidMsg">
								<!-- <span id="myspan"></span> -->
								<p>
									请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。
								</p>
								<span id="myspan"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置您在当当网的昵称：
						</td>
						<td>
							<input name="user.u_nickname"  type="text" id="txtNickName" onblur="fun3()" class="text_input" />
							<div class="text_left" id="nickNameValidMsg">
								<p>
									您的昵称可以由小写英文字母、中文、数字组成，
								</p>
								<p>
									长度4－20个字符，一个汉字为两个字符。
								</p>
								<span id="nameInfo"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置密码：
						</td>
						<td>
							<input name="user.u_password" type="password" id="txtPassword" onblur="fun4()" class="text_input"/>
							<div class="text_left" id="passwordValidMsg">
								<p>
									您的密码可以由大小写英文字母、数字组成，长度6－20位。
								</p>
								<span id="passwordInfo"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							再次输入您设置的密码：
						</td>
						<td>
							<input name="password1" type="password" id="txtRepeatPass" class="text_input" onblur="fun2()"/>
							
							<div class="text_left" id="repeatPassValidMsg">
								<span id="password1Info"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							验证码：
						</td>
						<td>
							<img class="yzm_img" id='imgVcode' src="${pageContext.request.contextPath}/getCode" />
							<input name="code" type="text" id="txtVerifyCode" class="yzm_input"/>
							<div class="text_left t1">
								<p class="t1">
									<span id="vcodeValidMsg">请输入图片中的四个字母。</span>
									<a id="vcodeImgBtn" name="change_code_link" class="code_picww" href="javascript:changeImage()" >看不清楚？换个图片</a>
									<br/>
									<span id="codeInfo"></span>
								</p>
							</div>
						</td>
					</tr>
				</table>
				<div class="login_in">
					<input id="btnClientRegister" class="button_1" name="submit"  type="submit" value="注 册"/>
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

