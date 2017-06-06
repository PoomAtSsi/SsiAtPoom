<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지글 목록보기</title>
	<script type="text/javascript" src="/sample/js/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#stitleView").hide();
		$("#swriterView").hide();
		$("#sdateView").hide();
		
		$("#stitle").click(function(){			
			if($(this).is(":checked")){
				$("#stitleView").show();
				$("#swriterView").hide();
				$("#sdateView").hide();
			}
		});
		
		$("#swriter").click(function(){
			if($(this).is(":checked")){
				$("#stitleView").hide();
				$("#swriterView").show();
				$("#sdateView").hide();
			}
		});
		
		$("#sdate").click(function(){
			if($(this).is(":checked")){
				$("#stitleView").hide();
				$("#swriterView").hide();
				$("#sdateView").show();
			}
		});
	});
</script>
</head>
<body>

<br><hr><br>

<a href="noticeInsert.do" type="button" >공지사항 등록</a>
&nbsp;&nbsp;
<a href=".." type="button" >메인페이지로</a>

<br><hr><br>




<br>
<table align="center" width="700" border="1" cellspacing="0">
	<tr>
		<th>번호</th>
		<th>작성자</th>
		<th width="300">공지제목</th>
		<th width="300">내용</th>
		<th width="100">첨부파일</th>
		<th width="200">작성날짜</th>
	</tr>
	
	<c:forEach items="${ nlist }" var="n">
	<tr>
		<td>${ n.notice_no }</td>

		
		<td>${ n.notice_nickname }</td>
		<td>
			<c:url var="ndetail" value="noticeDetail.do"><!--  상대경로만 사용가능 -->
				<c:param name="notice_no" value="${ n.notice_no }" />
			</c:url>
			
			<c:if test="${ !empty sessionScope.loginUser }">
				<a href="${ ndetail }">
					${ n.notice_title }
				</a>
			</c:if>
			
			<c:if test="${ empty sessionScope.loginUser }">	
				${ n.notice_title }
			</c:if>
		</td>
		<td>${ n.notice_contents }</td>
		<td>${ n.notice_file }</td>
 		<td>${ n.notice_date }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>





