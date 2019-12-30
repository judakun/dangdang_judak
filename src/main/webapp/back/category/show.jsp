<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/btn.css" />
	</head>
	<body style="background-color: #f0f9fd;text-align: center;">
	
		<div style="font-size:25px">类别管理</div><hr/>
		<div style="margin-bottom: 10px;">
			<div class="button btn-p" onclick="location.href='${pageContext.request.contextPath}/back/category/add-first.jsp'">添加一级类别&raquo;</div>
			<div class="button btn-p" onclick="location.href='${pageContext.request.contextPath}/back/addSecondCate1'">添加二级类别&raquo;</div>
		</div>
		<table bordercolor='#898E90' align='center' border='3px' cellpadding='10px' cellspacing="0px" >
			<tr bgcolor='lightblue'>
				<td>Id</td>
				<td>类别名</td>
				<td>所属类别</td>
				<td>级别</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${categoryList}" var="cate">
			<tr>
				<td>${cate.f_id }</td>
				<td>${cate.f_name }</td>
				<td>${cate.f_Category.f_name }</td>
				<td>${cate.f_levels }</td>
				<td>
					<div class="button" onclick="location.href='${pageContext.request.contextPath}/back/deleteCategory?category.f_id=${cate.f_id }' ">删除 &raquo;</div>	
				</td>
			</tr>
			</c:forEach>
			
		</table><br/>
		
	</body>  
</html>



