<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<h1>Welcome! Sample Project!</h1>

	<c:if test="${empty loginUser }">
		<P>The time on the server is ${serverTime}.</P>
		<form action="member/login.do" method="post">
			<label>email : <input type="text" name="email"></label><br>
			<label>password : <input type="password" name="password"></label><br>
			<input type="submit" value="로그인">
		</form>
	</c:if>
	
	
	<c:if test="${!empty loginUser }">
		${loginUser.username } 님 <a href="member/logout.do">로그아웃</a>
	</c:if>

	
</body>
</html>
