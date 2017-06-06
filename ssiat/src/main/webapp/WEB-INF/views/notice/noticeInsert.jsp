<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<h2 align="center">공지사항 등록 페이지</h2>
	
	
	<form action="nInsert.do" method="post" 
		id="frm" name="frm" enctype="multipart/form-data">
		
		
		
		<table align="center" width="600">
		
			<tr>
				<td>공지글 제목</td>
				<td><input type="text" name="notice_title"></td>
			</tr>
			<tr>
				<td>작성자 아이디</td>
				<td>
					<input type="text" name="notice_nickname" value="${ sessionScope.loginUser.nickname}" readonly>
				</td>
			</tr>
			<tr>
				<td>공지글 내용</td>
				<td><textarea name="notice_contents" rows="7" cols="50"></textarea></td>
			</tr>
			<tr>
				<td>파일 업로드</td>
				<td><input type="file" name="notice_file"></td>
			</tr>
			
			
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="등록하기"> 
				
				&nbsp; &nbsp; 
				<a href="noticeList.do" id="noticeList" >목록으로</a>
				
				</td>
			</tr>
			
		</table>
		
		
	</form>
	
	
</body>
</html>






