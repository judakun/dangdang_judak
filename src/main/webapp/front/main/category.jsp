<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		<!--1级分类开始-->
		<c:forEach items="${cateList}" var="fcate">
			<div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
				<h3>
					[<a href='${pageContext.request.contextPath}/B1/CategoryView?fid=${fcate.f_id}'>${fcate.f_name}</a>]
				</h3>
				<ul class="ul_left_list">
						<!--2级分类开始-->
						<c:forEach items="${fcate.s_Category}" var="scate">
						<li>
							<a href='${pageContext.request.contextPath}/B1/CategoryView?fid=${scate.f_parent_id}&sid=${scate.f_id}'>${scate.f_name}</a>
						</li>
						<!--2级分类结束-->
						</c:forEach>
				</ul>
				<div class="empty_left">
				</div>
			</div>

			<div class="more2">
			</div>
		<!--1级分类结束-->
		</c:forEach>

		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>
