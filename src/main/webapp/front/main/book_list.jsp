<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${pageContext.request.contextPath}/front/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/list.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/front/js/prototype-1.6.0.3.js"></script>
	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="${pageContext.request.contextPath}/front/images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href='${pageContext.request.contextPath}/B1/mainShow'>当当图书</a> &gt;&gt;
			<c:forEach items="${cateList}" var="fcate">
				<c:if test="${fcate.f_id==fid}">
					<font style='color: #cc3300'><strong>${fcate.f_name}</strong> </font>
							<c:forEach items="${fcate.s_Category}" var="sc">
								<c:if test="${sid!='' && sc.f_id==sid}">
							 	 &gt;&gt;<font style='color: #cc3300'><strong>${sc.f_name}</strong> </font>
								</c:if>
							</c:forEach>
				</c:if>
			</c:forEach>
		</div>

		<div class="book">
		<c:forEach items="${cateList}" var="fcate">
			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
							<li>
								<div>
									<div class=second_fenlei>										
										<font style='color: #cc3300'><strong>${fcate.f_name}</strong> </font>
									</div>
								</div>
							</li>
							<div class="clear"></div>
						<c:forEach items="${fcate.s_Category}" var="sc">
							<!--2级分类开始-->
							<li>
								<div>
									<div class=second_fenlei>
										&middot;
									</div>
									<div class=second_fenlei>
									<c:if test="${sid!=sc.f_id}">
										<a href="${pageContext.request.contextPath}/B1/CategoryView?fid=${sc.f_parent_id}&sid=${sc.f_id}">${sc.f_name}&nbsp;</a>
									</c:if>
									<c:if test="${sid==sc.f_id}">
										<a href="${pageContext.request.contextPath}/B1/CategoryView?fid=${sc.f_parent_id}&sid=${sc.f_id}"><font style='color: #cc3300'>${sc.f_name}</font>&nbsp;</a>
									</c:if>
									</div>
								</div>
							</li>
						    <div class="clear"></div>
						    </c:forEach>
							<!--2级分类结束-->
							
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</c:forEach>
			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						<select onchange='' name='select_order' size='1'
							class='list_r_title_ml'>
							<option value="">
								按上架时间 降序
							</option>
						</select>
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							
							<div class='list_r_title_text3a'>
							<c:if test="${pageNum==1}">
								<img src='${pageContext.request.contextPath}/front/images/page_up_gray.gif' />
							</c:if>
							<c:if test="${pageNum!=1}">
								<a name=link_page_next href="${pageContext.request.contextPath}/B1/CategoryView?fid=${fid}&sid=${sid}&pageNum=${pageNum}&pageChange=f">
									<img src='${pageContext.request.contextPath}/front/images/page_up.gif' />
								</a>
							</c:if>	
							</div>
							
							<div class='list_r_title_text3a'>
								<c:if test="${pageNum==1}">
									<img src='${pageContext.request.contextPath}/front/images/page_up_gray.gif' /> 
								</c:if>
								<c:if test="${pageNum!=1}">
									<a name=link_page_next href="${pageContext.request.contextPath}/B1/CategoryView?fid=${fid}&sid=${sid}&pageNum=${pageNum}&pageChange=s">
										<img src='${pageContext.request.contextPath}/front/images/page_up.gif' /> 
									</a>
								</c:if>
							</div>

							<div class='list_r_title_text3b'>
								第${pageNum}页/共${totalPage}页
							</div>
							
							<div class='list_r_title_text3a'>
								<c:if test="${pageNum!=totalPage}">
									<a name=link_page_next href="${pageContext.request.contextPath}/B1/CategoryView?fid=${fid}&sid=${sid}&pageNum=${pageNum}&pageChange=a">
										<img src='${pageContext.request.contextPath}/front/images/page_down.gif' /> 
									</a>
								</c:if>
								<c:if test="${pageNum==totalPage}">
									<img src='${pageContext.request.contextPath}/front/images/page_down_gray.gif' /> 
								</c:if>
							</div>
							<div class='list_r_title_text3a'>
								<c:if test="${pageNum!=totalPage}">
									<a name=link_page_next href="${pageContext.request.contextPath}/B1/CategoryView?fid=${fid}&sid=${sid}&pageNum=${pageNum}&pageChange=e">
										<img src='${pageContext.request.contextPath}/front/images/page_down.gif' />
									</a>
								</c:if>
								<c:if test="${pageNum==totalPage}">
									<img src='${pageContext.request.contextPath}/front/images/page_down_gray.gif' />
								</c:if>
							</div>

							<!--分页导航结束-->
						</div>
					</div>
					
					<!--商品条目开始-->
						<div class="list_r_line"></div>
					<c:forEach items="${allList}" var="book">
						<div class="clear"></div>
							<div class="list_r_list">
								<span class="list_r_list_book">
									<a name="link_prd_img" href='#'>
										<img src="${book.b_face}" /> 
									</a>
								</span>
								<h2>
									<a name="link_prd_name" href='${pageContext.request.contextPath}/B1/bookDetail?bookName=${book.b_name}'>${book.b_name}</a>
								</h2>
								<h3>
									顾客评分：100
								</h3>
								<h4 class="list_r_list_h4">
									作 者:
									<a href='#' name='作者'>${book.b_author}</a>
								</h4>
								<h4>
									出版社：
									<a href='#' name='出版社'>${book.b_cbs}</a>
								</h4>
								<h4>
									出版时间：<fmt:formatDate value="${book.b_cbDate}" pattern="yyyy-MM-dd"/>
								</h4>
								<h5>
									${book.b_intro}
								</h5>
								<div class="clear"></div>
								<h6>
									<span class="del">￥${book.b_price}</span>
									<span class="red">￥${book.b_dprice}</span>
									节省：￥${book.b_price-book.b_dprice}
								</h6>
								<span class="list_r_list_button"> 
								<a href="${pageContext.request.contextPath}/B1/BuyCar?bookInfo.b_id=${book.b_id}"> 
									<img src='${pageContext.request.contextPath}/front/images/buttom_goumai.gif' /> 
								</a>
								<span id="cartinfo"></span>
							</div>
						<div class="clear"></div>
                      </c:forEach>
						<!--商品条目结束-->

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
