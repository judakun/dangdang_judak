<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
	<head>
		<title>图书详情</title>
		<link href="${pageContext.request.contextPath}/front/css/public_footer.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/book_detail.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/front/css/book_detail.css"/>
		<link href="${pageContext.request.contextPath}/front/css/public_footer.css" rel="stylesheet" type="text/css" />

	</head>
	<body bgcolor="#F5FFFA">
		<br/>
		<div>
			<h1>
				丛书名：${bookInfo.b_name}
			</h1>
			<hr/>
		</div>
		<table width="80%" border="0" align="center" cellspacing="0" cellpadding="5" bgcolor="#F5FFFA">
			<tr>
				<td rowspan="9" width="20%" valign="top"><img src="${bookInfo.b_face}" width="240px" height="340px" /></td>
				<td colspan="2">作者：${bookInfo.b_author}</td>
			</tr>
			<tr>
				<td colspan="2">出版社：${bookInfo.b_cbs}</td>
			</tr>
			<tr>
				<td>出版时间：<fmt:formatDate value="${tj.b_cbDate}" pattern="yyyy-MM-dd"/> </td>
				<td>字数：${bookInfo.b_words}</td>
			</tr>
			<tr>
				<td>版次：${bookInfo.b_bc}</td>
				<td>页数：${bookInfo.b_page}</td>
			</tr>
			<tr>
				<td>印刷时间：<fmt:formatDate value="${tj.b_ysDate}" pattern="yyyy-MM-dd"/></td>
				<td>开本：${bookInfo.b_kb}</td>
			</tr>
			<tr>
				<td>印次：${bookInfo.b_yc}</td>
				<td>纸张：${bookInfo.b_zz}</td>
			</tr>
			<tr>
				<td>ISBN：${bookInfo.ISBN}</td>
				<td>包装：${bookInfo.b_bz}</td>
			</tr>
			<tr>
				<td colspan="2">定价：￥${bookInfo.b_price}&nbsp;&nbsp;&nbsp;&nbsp;
				<font color="red">当当价：￥${bookInfo.b_dprice}</font>&nbsp;&nbsp;&nbsp;&nbsp;
				节省：￥${bookInfo.b_price-bookInfo.b_dprice}</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="${pageContext.request.contextPath}/B1/BuyCar?bookInfo.b_id=${bookInfo.b_id}">
						<img src='${pageContext.request.contextPath}/front/images/buttom_goumai.gif' />
					</a>
				</td>
			</tr>
		</table>
		<hr style="border:1px dotted #666"/>
		<h2>编辑推荐:${bookInfo.b_bjtj}</h2>
		<p>&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>内容简介:${bookInfo.b_intro}</h2>
		<p>&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>作者简介:${bookInfo.b_auIntro}</h2>
		<p>&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>目录:${bookInfo.b_jbml}</h2>
		<p>&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>媒体评论:${bookInfo.b_mtpl}</h2>
		<p>&nbsp;&nbsp;</p>
<%-- 		<hr style="border:1px dotted #666"/>
		<h2>书摘插图:${bookInfo.b_face}</h2>
		<p>&nbsp;&nbsp;</p> --%>
		<!--页尾开始 -->
		<div class="public_footer">
			<div class="public_footer_bottom">
				<div class="public_footer_icp" style="line-height: 48px;">
					Copyright (C) 当当网 2004-2008, All Rights Reserved
					<a href="#" target="_blank"><img src="${pageContext.request.contextPath}/front/images/bottom/validate.gif" border="0" align="middle" /> </a>
					<a href="#" target="_blank" style="color: #666;">京ICP证041189号</a>
				</div>
			</div>
		</div>
		<!--页尾结束 -->
	</body>
</html>
