<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="${pageContext.request.contextPath}/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
			var count = 7;
			function time(){
				count -= 1;
				if(count==0){
					window.location.href="${pageContext.request.contextPath}/B1/mainShow";
				}else{
					$("#aa").html(count);
					setTimeout(time, 1000);
				}
			}
			time();
		
		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<span style="color:red;font-size: 21px;margin-left: 45px;">${message}</span>
		<div class="login_step">
			注册步骤: 1.填写信息 > 2.验证邮箱 >
			<span class="red_bold">3.注册成功</span>
		</div>


		<div class="login_success">
			<div class="login_bj">
				<div class="succ">
					<img src="${pageContext.request.contextPath}/front/images/login_success.jpg" />
				</div>
				<h5>
					${sessionScope.user.u_nickname}，欢迎加入当当网
				</h5>
				<h6>
					请牢记您的登录邮件地址：${sessionScope.user.u_email}
				</h6>
				<h6>
					<span id="aa"></span>秒之后，自动跳转到首页！
				</h6>
				<ul>
					<li class="nobj">
						您现在可以：
					</li>
					<li>
						进入“
						<a href="${pageContext.request.contextPath}/B1/mainShow">我的当当</a>”查看并管理您的个人信息
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/B1/mainShow">浏览并选购商品</a>
					</li>
				</ul>
			</div>
		</div>

		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

