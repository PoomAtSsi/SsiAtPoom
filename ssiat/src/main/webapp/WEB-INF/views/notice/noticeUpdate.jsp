<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="noticeError.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 --%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지글 상세보기</title>
</head>
<body>
<br><hr><br>
<h1 align="center">공지글 수정하기 페이지</h1>


<form action="nUpdate.do" method="post">

 <br><hr>
 
<c:forEach items="${ nlist }" var="n">
	<table width="600" align="center">
	<tr><td>공지글번호</td>
	   <td><input type="text" name="notice_no" value="${ n.notice_no }" disabled></td></tr>
	<tr><td>작 성 자</td>
	   <td><input type="text" name="notice_nickname" value="${ n.notice_no }" disabled></td></tr>
	<tr><td>공지글제목</td>
	   <td><input type="text" name="notice_title" value="${ n.notice_title }" ></td></tr>
	<tr><td>공지글내용</td>
	   <td><textarea name="notice_contents" rows="7" cols="50" >${ n.notice_contents }</textarea></td></tr>
	<tr><td>첨부파일</td>
		<td><input type="text" name="notice_file" value="${ n.notice_file }" ></td></tr>
	<tr><td>작성날짜</td>
	   <td><input type="text" name="notice_date" value="${ n.notice_date }" disabled></td></tr>
 
 	<tr><td colspan="2" align="center">
 	
 	
			
	<input type="hidden" name="notice_no" value="${ n.notice_no }" /> 
	<input type="submit" value="수정 완료">
	&nbsp; &nbsp;
 	
 	
 	<c:url var="nupdatecancel" value="noticeDetail.do"><!--  상대경로만 사용가능 -->
		<c:param name="notice_no" value="${ n.notice_no }" />
	</c:url>
	<a href="${ nupdatecancel }">수정 취소</a>
	&nbsp; &nbsp;
	
	
	</table>
</c:forEach>

</form>
</body>
</html>