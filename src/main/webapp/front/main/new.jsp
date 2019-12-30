<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
</h2>
<div class="book_c_04">
	<c:forEach items="${cjDateList}" var="cjd">
	<!--热销图书A开始-->
	<div class="second_d_wai">
		<div class="img">
			<a href="${pageContext.request.contextPath}/B1/bookDetail?bookName=${cjd.b_name}" target='_blank'>
				<img src="${cjd.b_face}" border=0 /> 
			</a>
		</div>
		<div class="shuming">
			<a href="${pageContext.request.contextPath}/B1/bookDetail?bookName=${cjd.b_name}" target="_blank">${cjd.b_name}</a><a href="${pageContext.request.contextPath}/B1/bookDetail?bookName=${cjd.b_name}" target="_blank"></a>
		</div>
		<div class="price">
			定价：￥${cjd.b_price}
		</div>
		<div class="price">
			当当价：￥${cjd.b_dprice}
		</div>
		<div class="price">
			销量：<font color="red">${cjd.b_saleNum}</font>
		</div>
	</div>
	<div class="book_c_xy_long"></div>
	<!--热销图书A结束-->
	</c:forEach>
</div>
<div class="clear"></div>