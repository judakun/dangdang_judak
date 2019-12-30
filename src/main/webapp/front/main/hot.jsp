<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>热销图书
</h2>
<div class="book_c_04">

	<c:forEach items="${cxList}" var="cx">
	<!--热销图书A开始-->
	<div class="second_d_wai">
		<div class="img">
			<a href="${pageContext.request.contextPath}/B1/bookDetail?bookName=${cx.b_name}" target='_blank'>
				<img src="${cx.b_face}" border=0 /> 
			</a>
		</div>
		<div class="shuming">
			<a href="${pageContext.request.contextPath}/B1/bookDetail?bookName=${cx.b_name}" target="_blank">${cx.b_name}</a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			定价：￥${cx.b_price}
		</div>
		<div class="price">
			当当价：￥${cx.b_dprice}
		</div>
		<div class="price">
			销量：<font color="red">${cx.b_saleNum}</font>
		</div>
	</div>
	<div class="book_c_xy_long"></div>
	<!--热销图书A结束-->
	</c:forEach>
</div>
<div class="clear"></div>