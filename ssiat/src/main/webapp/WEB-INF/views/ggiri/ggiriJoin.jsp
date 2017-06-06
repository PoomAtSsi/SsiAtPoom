<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<form action="/sap/ggiri/gJoin.do" method="post">
<div align="center">
<h4 style="text-align:center;">신청하시겠습니까?</h4><br>
<c:forEach items="${glist}" var="g">
<input type="hidden" name="g_j_nickname" value="${sessionScope.loginUser.nickname }">
<input type="hidden" name="g_no" value="${g.g_no }">
<input type="hidden" name="g_j_no" value="${g.g_no }">

<button type="submit" style="width:80px;height:30px;background:#fca55d;border:none;border-radius:30px;">예</button>
<button style="width:80px;height:30px;background:#fca55d;border:none;border-radius:30px;">아니오</button>
</div>
</c:forEach>
</form>
</body>
</html>