<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome! sample</title>



</head>
<body>
	<%-- <jsp:forward page="homeStart.do"></jsp:forward> --%>
	<jsp:include page="homeStart.do" />


	<hr>
	<!-- <a href="notice/nList.do" type="button">공지사항</a> -->
	<button type="button" onclick="location.href='notice/noticeList.do'">공지사항</button>
	
<%-- 	<hr>
	<jsp:include page="navereditor.do" />
	<button type="button" onclick="location.href='noriter/noriterList.do'">씨앗놀이터</button>
 --%>
 
<!-- 	<hr>
	<button type="button"
		onclick="location.href='notice/testMapArgumentResolver.do'">notice/testMapArgumentResolver.do</button>
 -->
	<hr>
	<button type="button"
		onclick="location.href='itcp/firstInterceptor.do'">인터셉터</button>

	
<%-- 	<hr>
	<jsp:include page="testvideo.do" />
	 --%>
	
	
<%-- 	<hr>
	<jsp:include page="noriter/navereditor.do" /> --%>
	


	<hr>
	<jsp:include page="menu/menuList.do" />

	<jsp:include page="menu/noriterList.do" />
	

</body>
</html>