<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>
  <head>
    <title>index.html</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/btn.css" />
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=GBK">
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery-3.3.1.js"></script>
  	<script type="text/javascript">
  	
  	
  	function fun1(){
  		var fname=document.getElementById("fname");
  		var fnameMsg=document.getElementById("fnameMsg");
  		if(fname.value.length >=2){
  			//fnameMsg.innerHTML="<font style='color:green'>Success √</font>";
  			return true;
  		}else{
  			fnameMsg.innerHTML="<font style='color:green'>Error ×</font>";
  			return false;
  		}
  	}
  	function fun(){
		return fun1();
	}
  	</script>
  
  </head>
  
  <body style="background-color: #f0f9fd;text-align: center">
  	<div style="text-align: center;font-size: 18px">添加商品类别</div><hr/>
  	<span style="color:red;font-size: 21px;margin-left: 45px;">${message}</span>
  	<form action="${pageContext.request.contextPath}/back/addFirstCate" onsubmit="return fun()" method="post">
  		类别名:<input class="el-input__inner" type="text" name="category.f_name" id="fname" onblur="fun1()" placeholder="输入两个字符以上" /><span id="fnameMsg"></span><br/><br/>
  		<input class="button btn-p" type="submit" value="提交">&emsp;
		<div class="button btn-p"  onclick="history.go(-1);">返回上级</div>
  	</form>
    	
  </body>
</html>
