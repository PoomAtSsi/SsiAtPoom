<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="noticeError.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지글 상세보기</title>
</head>
<body>
<br><hr><br>
<h1 align="center">공지글 상세 보기 페이지</h1>
<form action="" method="post">
<%-- <input type="hidden" name="no" value="<%= n.getNoticeNo() %>">
	<table width="600" align="center">
	<tr><td>공지글번호</td>
	   <td><input type="text" readonly value="<%= n.getNoticeNo() %>"></td></tr>
	<tr><td>공지글제목</td>
	   <td><input type="text" name="title" value="<%= n.getNoticeTitle() %>"></td></tr>
	<tr><td>작 성 자</td>
	   <td><input type="text" readonly value="<%= n.getNoticeWriter() %>"></td></tr>
	<tr><td>작성날짜</td>
	   <td><input type="text" readonly value="<%= n.getNoticeDate() %>"></td></tr>
	<tr><td>조회수</td>
		<td><input type="text" readonly value="<%= n.getHit() %>"></td></tr>
	<tr><td>공지글내용</td>
	   <td><textarea name="content" rows="7" cols="50"><%= n.getNoticeContent() %></textarea></td></tr>
 --%>
 


<a href="noticeInsertForm.do" type="button" >공지사항 등록2</a>
 <br><hr>
 
<c:forEach items="${nlist }" var="n">
 	<%-- <input type="hidden" name="no" value="${ n.NOTICE_NO }"> --%>
	<table width="600" align="center">
	<tr><td>공지글번호</td>
	   <td><input type="text" readonly value="${ n.NOTICE_NO }"></td></tr>
	<tr><td>작 성 자</td>
	   <td><input type="text" readonly value="${ n.NOTICE_NICKNAME }"></td></tr>
	<tr><td>공지글제목</td>
	   <td><input type="text" name="title" value="${ n.NOTICE_TITLE }"></td></tr>
	<tr><td>공지글내용</td>
	   <td><textarea name="content" rows="7" cols="50">${ n.NOTICE_CONTENTS }</textarea></td></tr>
	<tr><td>첨부파일</td>
		<td><input type="text" readonly value="${ n.NOTICE_FILE }"></td></tr>
	<tr><td>작성날짜</td>
	   <td><input type="text" readonly value="${ n.NOTICE_DATE }"></td></tr>
 
 	<tr><td colspan="2" align="center"><input type="submit" value="수정하기">
	삭제하기 &nbsp; &nbsp;
	<a href="/start.do">목록으로</a></td></tr>
	</table>
</c:forEach>
</form>
</body>
</html>