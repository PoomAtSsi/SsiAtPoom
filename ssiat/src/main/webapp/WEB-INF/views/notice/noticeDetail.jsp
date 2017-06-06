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
<h1 align="center">공지글 상세 보기 페이지</h1>


<form action="noticeUpdate.do" method="post">

 <br><hr>
 
<c:forEach items="${ nlist }" var="n">
	<table width="600" align="center">
	<tr><td>공지글번호</td>
	   <td><input type="text" name="notice_no" value="${ n.notice_no }" disabled></td></tr>
	<tr><td>작 성 자</td>
	   <td><input type="text" name="notice_nickname" value="${ n.notice_nickname }" disabled></td></tr>
	<tr><td>공지글제목</td>
	   <td><input type="text" name="notice_title" value="${ n.notice_title }" disabled></td></tr>
	<tr><td>공지글내용</td>
	   <td><textarea name="notice_contents" rows="7" cols="50" disabled>${ n.notice_contents }</textarea></td></tr>
	<tr><td>첨부파일</td>
		<td><input type="text" name="notice_file" value="${ n.notice_file }" disabled></td></tr>
	<tr><td>작성날짜</td>
	   <td><input type="text" name="notice_date" value="${ n.notice_date }" disabled></td></tr>
 
 	<tr><td colspan="2" align="center">
 	
 	
	<c:if test="${ loginUser.nickname == n.notice_nickname }">
	 	<c:url var="ndelete" value="nDelete.do"><!--  상대경로만 사용가능 -->
			<c:param name="notice_no" value="${ n.notice_no }" />
		</c:url>
 		<a href="${ ndelete }">삭제하기</a>
		&nbsp; &nbsp;
	</c:if>
	
	<c:if test="${ loginUser.nickname == n.notice_nickname }">
		<input type="hidden" name="notice_no" value="${ n.notice_no }" /> 
		<input type="submit" value="수정하러가기">
		&nbsp; &nbsp;
	</c:if>
	
	
	<%-- <form:form action="delete" action="${n.notice_no}">
	<!-- method="post" -->
		<input type="submit" value="삭제하기">
		&nbsp; &nbsp;
	</form:form> --%>
 	
	
	<a href="noticeList.do">목록으로</a></td></tr>
	</table>
</c:forEach>



</form>
</body>
</html>