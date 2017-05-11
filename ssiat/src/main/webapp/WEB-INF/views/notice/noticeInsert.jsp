<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/include/include-header.jspf"%>
</head>
<body>

	<h2 align="center">notice 등록 페이지</h2>
	<form action="/notice/nInsert" method="post">
		<input type="hidden" name="writer"
			value="${sessionScope.loginUser.userId }">
		<table align="center" width="600">
			<tr>
				<td>공지글 제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>작성자 아이디</td>
				<input type="text" value="${sessionScope.loginUser.userId }"
					readonly>
				</td>
			</tr>
			<tr>
				<td>공지글 내용</td>
				<td><textarea name="content" rows="7" cols="50"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="등록하기"> 
				
				&nbsp; &nbsp; 
				<a href="notice/nList.do">목록으로</a>
				
				<a href="#this" id="nWrite" >작성하기</a>
				<a href="#this" id="nList" >목록으로</a>
				</td>
			</tr>
		</table>
	</form>
	
	<%@ include file="/WEB-INF/include/include-body.jspf" %>
	
</body>
</html>






