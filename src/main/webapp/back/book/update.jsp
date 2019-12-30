<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/btn.css" />
	
<style type="text/css">
td{
	padding-top: 8px;
}
#file_upload1 {
	display: none;
}
#file_upload1_label {
	display: inline-block;
	border: 1px solid #aaa;
	width: 120px;
	height: 145px;
	margin-left: 20px;
	text-align: center;
	line-height: 145px;
	cursor: pointer;
}
</style>


</head>

<body style="background-color: #f0f9fd;text-align: center">
	<div style="font-size:25px">修改图书信息</div>
	<hr />
	<div align="center">
	<form action="${pageContext.request.contextPath}/back/updateBook2?book.b_id=${book.b_id}" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>名称：</td>
					<td><input type="text" name="book.b_name" class="el-input__inner" value="${book.b_name}"></td>
					<td rowspan="14" style="width: 300px">
					<td>页数：</td>
					<td><input type="number" name="book.b_page" class="el-input__inner" value="500" ></td>
				</tr>
				<tr>
					<td>所属分类：</td>
					<td>
						<select name="book.b_category_id" class="el-select__inner inner2">
							<c:forEach items="${categoryList}" var="cate">
								<c:if test="${cate.f_id == book.b_category_id }">
									<option value="${cate.f_id}" selected="selected">${cate.f_name}</option>
								</c:if>
								<c:if test="${cate.f_id != book.b_category_id }">
									<option value="${cate.f_id}">${cate.f_name}</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
					<td>字数：</td>
					<td><input type="number" name="book.b_words" class="el-input__inner" value="${book.b_words}" ></td>
				</tr>
				
				<tr>
					<td>原价：</td>
					<td><input type="number" name="book.b_price" class="el-input__inner" value="${book.b_price}"></td>
					<td>封面：</td>
					<td rowspan="3">
						<label id="file_upload1_label" for="file_upload1">
							<img id="uploadimg" src="${book.b_face}" alt="" width="120" height="145" />
						</label> 
						<input type="file" name="uploadimage" class="" id="file_upload1"	onchange="upload_review()">
					</td>
				</tr>
				
				<tr>
					<td>当当价：</td>
					<td><input type=number name="book.b_dprice" class="el-input__inner" value="${book.b_dprice }"></td>
					<td></td>
				</tr>
				<tr>
					<td>库存：</td>
					<td><input type="number" name="book.b_kc" class="el-input__inner" value="${book.b_kc}"></td>
					<td></td>
				</tr>
				<tr>
					<td>作者：</td>
					<td><input type="text" name="book.b_author" class="el-input__inner" value="${book.b_author }"></td>
					<td>编辑推荐：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="book.b_bjtj">${book.b_bjtj}</textarea></td>
				</tr>
				<tr>
					<td>出版社：</td>
					<td><input type="text" name="book.b_cbs" class="el-input__inner" value="${book.b_cbs }"></td>
					<td></td>
				</tr>
				<tr>
					<td>出版时间：</td>
					<td><input type="date" name="book.b_cbDate" class="el-input__inner" value="${book.b_cbDate }"></td>
					<td>内容简介：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="book.b_intro" >${book.b_intro}</textarea></td>
				</tr>
				<tr>
					<td>版次：</td>
					<td><input type="text" name="book.b_bc" class="el-input__inner" value="${book.b_bc }"></td>
					<td></td>
				</tr>
				<tr>
					<td>印刷时间：</td>
					<td><input type="date" name="book.b_ysDate" class="el-input__inner" value="${book.b_ysDate}"></td>
					<td>作者简介：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="book.b_auIntro">${book.b_auIntro }</textarea></td>
				</tr>
				<tr>
					<td>印次：</td>
					<td><input type="text" name="book.b_yc" class="el-input__inner" value="${book.b_yc }"></td>
					<td></td>
				</tr>
				<tr>
					<td>ISBN：</td>
					<td><input type="text" name="book.ISBN" class="el-input__inner" value="${book.ISBN }"></td>
					<td>基本目录：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="book.b_jbml" >${book.b_jbml }</textarea></td>
				</tr>
				<tr>
					<td>开本：</td>
					<td><input type="text" name="book.b_kb" class="el-input__inner" value="${book.b_kb }"></td>
					<td></td>
				</tr>
				<tr>
					<td>纸张：</td>
					<td><input type="text" name="book.b_zz" class="el-input__inner" value="${book.b_zz }"></td>
					<td>媒体评论：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="book.b_mtpl">${book.b_mtpl }</textarea></td>
				</tr>
				<tr>
					<td>包装：</td>
					<td><input type="text" name="book.b_bz" class="el-input__inner" value="${book.b_bz}"></td>
					<td></td>
				</tr>
			</table>
			<input type="submit" class="button btn-p" value="提交" />&emsp; 
			<input type="button" class="button btn-p" value="返回上级" onclick="history.go(-1);" />
		</form>
	</div>
	<script>
		function upload_review() {
			var img = document.getElementById("uploadimg");
			var input = document.getElementById("file_upload1");
			var tip = document.getElementById("uploadtip");			

			var file = input.files.item(0);
			var freader = new FileReader();
			freader.readAsDataURL(file);
			freader.onload = function(e) {
				img.src = e.target.result;
				tip.style.display = "none";
			};
		}
	</script>
</body>
</html>

