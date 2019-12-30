<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
	
		<c:forEach items="${tjList}" var="tj">
			<div class=second_c_02_b1>
							<div class=second_c_02_b1_1>
								<a href='${pageContext.request.contextPath}/B1/bookDetail?bookName=${tj.b_name}' target='_blank'>
									<img src="${tj.b_face}" width=70 border=0 /> 
								</a>
							</div>
					
						   <div class=second_c_02_b1_2>
									<h3>
										<a href='${pageContext.request.contextPath}/B1/bookDetail?bookName=${tj.b_name}' target='_blank' title='输赢'>${tj.b_name}</a>
									</h3>
									<h4>
										作者：${tj.b_author} 著
										<br />
										出版社：${tj.b_cbs}&nbsp;&nbsp;&nbsp;&nbsp;
										出版时间：<fmt:formatDate value="${tj.b_cbDate}" pattern="yyyy-MM-dd"/> 
									</h4>
									<h5>
										书籍简介：${tj.b_intro}
									</h5>
							         <h6>
										定价：￥${tj.b_price}&nbsp;&nbsp;
										当当价：￥${tj.b_dprice}
										销量：<font color="red">${tj.b_saleNum}</font>
								    </h6>
							<div class=line_xx></div>
				</div>
		</div>
		</c:forEach>
				
		
	</div>
</div>
