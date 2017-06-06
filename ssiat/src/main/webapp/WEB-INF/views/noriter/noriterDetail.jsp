<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="noriterError.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 --%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>놀이터 상세보기</title>
</head>
<body>
<br><hr><br>
<h1 align="center">놀이터 상세보기 페이지</h1>


<form action="noriterUpdate.do" method="post">

 <br><hr>
 
<c:forEach items="${ nlist }" var="n">

	<table width="600" align="center">
	
		<tr><td>카테고리</td>
			<td><input type="text" name="category" value="${ n.category }" readonly></td></tr>
		<tr><td>번 호</td>
			<td><input type="text" name="classNo" value="${ n.classNo }" readonly></td></tr>
		<tr><td>닉네임</td>
			<td><input type="text" name="nickname" value="${ n.nickname }" readonly></td></tr>
		<tr><td>제 목</td>
		    <td><input type="text" name="classTitle" value="${ n.classTitle }" readonly ></td></tr>
		
			
		<tr><td>내 용</td>
			<td style="border:1px solid black;">${ n.detail }</td></tr>
			
		
		<%-- <tr><td>동영상</td>
			<td><input type="text" name="video" value="${ n.video }" readonly></td></tr>
		--%>
		<tr>
			<td>동영상</td>
			<td>
				<video width="320" height="240" controls>
					<source src="../video/${ n.videoname }" type="video/mp4">
					<source src="../video/${ n.videoname }" type="video/webm" />
					<source src="../video/${ n.videoname }" type="video/ogg" />
					
					<%-- <source src="video/${ n.videopath }" type="video/mp4">
					<source src="video/${ n.videopath }" type="video/webm" />
					<source src="video/${ n.videopath }" type="video/ogg" /> --%>
					video 요소를 지원하지 않는 브라우저입니다. 동영상은 다운로드 후 볼 수 있습니다.
				</video>
				
				<p><strong>test video:</strong> video1</p>
			</td>
		</tr>
		
			<!-- noriter.getVideo().getOriginalFilename(); -->
			<!-- String getOriginalFilename(); -->
			
		<tr><td>career</td>
			<td><input type="text" name="career" value="${ n.career }" readonly></td></tr>
		<tr><td>water</td>
			<td><input type="text" name="water" value="${ n.water }" readonly></td></tr>
		<tr><td>like</td>
			<td><input type="text" name="like" value="${ n.like }" readonly></td></tr>
		<tr><td>조회수</td>
			<td><input type="text" name="count" value="${ n.count }" readonly></td></tr>
		<%-- <tr><td>hidden</td>
		   <td><input type="text" name="hidden" value="${ n.hidden }" readonly></td></tr> --%>
		<tr><td>작성일자</td>
			<td><input type="text" name="date" value="${ n.date }" readonly></td></tr>
	 
	 	<tr><td colspan="2" align="center">
	 	
	 	
		<c:if test="${ loginUser.nickname == n.nickname }">
			<c:url var="ndelete" value="nDelete.do"><!--  상대경로만 사용가능 -->
				<c:param name="classNo" value="${ n.classNo }" />
			</c:url>
	 		<a href="${ ndelete }">삭제하기</a>
			&nbsp; &nbsp;
		</c:if>
		
		<c:if test="${ loginUser.nickname == n.nickname }">
			<input type="hidden" name="classNo" value="${ n.classNo }" /> 
			<input type="submit" value="수정하러가기">
			&nbsp; &nbsp;
		</c:if>
		z
		<a href="noriterList.do">목록으로</a></td></tr>
		
	</table>
	
</c:forEach>

</form>
</body>
</html>