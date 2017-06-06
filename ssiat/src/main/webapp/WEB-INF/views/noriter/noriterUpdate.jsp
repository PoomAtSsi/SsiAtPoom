<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="noriterError.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 --%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript"
	src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="../resources/smarteditor2-master/workspace/js/service/HuskyEZCreator.js"></script>

<script type="text/javascript" charset="utf-8"
	src="../resources/smarteditor2-master/dist/js/service/HuskyEZCreator.js"></script>

<script>
	$(function() {
		//전역변수선언
		var editor_object = [];

		nhn.husky.EZCreator
				.createInIFrame({
					oAppRef : editor_object,
					elPlaceHolder : "detail",
					sSkinURI : "../resources/smarteditor2-master/workspace/SmartEditor2Skin.html",
					htParams : {
						// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
						bUseToolbar : true,
						// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
						bUseVerticalResizer : true,
						// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
						bUseModeChanger : true,
					}
				});

		//전송버튼 클릭이벤트
		$("#savebutton").click(function() {
			//id가 smarteditor인 textarea에 에디터에서 대입
			editor_object.getById["detail"].exec("UPDATE_CONTENTS_FIELD", []);

			// 이부분에 에디터 validation 검증

			//폼 submit
			$("#frm").submit();
		});
	});
</script>


<title>놀이터 상세보기</title>
</head>
<body>
<br><hr><br>
<h1 align="center">놀이터 수정하기 페이지</h1>

<form action="nUpdate.do" method="post">

 <br><hr>
 
<c:forEach items="${ nlist }" var="n">

	<table id="frm" width="1200" align="center">
	
		<tr><td>카테고리</td>
			<td><input type="text" name="category" value="${ n.category }" ></td></tr>
		<tr><td>번 호</td>
			<td><input type="text" name="classNo" value="${ n.classNo }" disabled></td></tr>
		<tr><td>닉네임</td>
			<td><input type="text" name="nickname" value="${ n.nickname }" disabled></td></tr>
		<tr><td>제 목</td>
			<td><input type="text" name="classTitle" value="${ n.classTitle }"></td></tr>
		
		
		
		<%-- 
		<tr><td>detail</td>
		   <td><textarea name="detail" rows="7" cols="50" >${ n.detail }</textarea></td></tr>
		 --%>
		<tr><td>내 용</td>
		  <!--  <td><textarea name="detail" rows="7" cols="50" ></textarea></td></tr> -->
		
		<td><textarea id="detail" style="HEIGHT: 220px; WIDTH: 610px" rows="10"
						cols="30" name="detail">${ n.detail }</textarea></td></tr>
		
		
		
		
		
		
		<tr><td>동영상</td>
			<td><input type="text" name="video" value="${ n.video }" ></td></tr>
		<tr><td>career</td>
			<td><input type="text" name="career" value="${ n.career }" ></td></tr>
		<tr><td>water</td>
			<td><input type="text" name="water" value="${ n.water }" disabled></td></tr>
		<tr><td>like</td>
			<td><input type="text" name="like" value="${ n.like }" disabled></td></tr>
		<tr><td>조회수</td>
			<td><input type="text" name="count" value="${ n.count }" disabled></td></tr>
		<%-- <tr><td>hidden</td>
			<td><input type="text" name="hidden" value="${ n.hidden }" disabled></td></tr> --%>
		<tr><td>작성일자</td>
			<td><input type="text" name="date" value="${ n.date }" disabled></td></tr>
	 
	 	<tr><td colspan="2" align="center">
	 	
				
		<input type="hidden" name="classNo" value="${ n.classNo }" /> 
		<input type="submit" value="수정 완료" id="savebutton" type="button">
		&nbsp; &nbsp;
	 	
	 	
	 	<c:url var="nupdatecancel" value="noriterDetail.do"><!--  상대경로만 사용가능 -->
			<c:param name="classNo" value="${ n.classNo }" />
		</c:url>
		<a href="${ nupdatecancel }">수정 취소</a>
		&nbsp; &nbsp;
	
	
	</table>
</c:forEach>

</form>
</body>
</html>