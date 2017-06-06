<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>놀이터 목록보기</title>


<link rel="stylesheet"
	href="resources/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/assets/css/styles.css">
<link rel="stylesheet" href="resources/assets/css/tabbed_slider.css">
<link rel="stylesheet" href="resources/assets/css/tabbed_slider1.css">


<script type="text/javascript" charset="utf-8"
	src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="js/jquery-3.2.1.js"></script>

<script type="text/javascript"></script>

</head>
<body>
	<jsp:include page="menu/menuList.do" />
	<hr>
	<br>
	<br>
	<div>
		<table class="table" align="center" width="700" border="1"
			cellspacing="0">
			<tr>
				<th>카테고리</th>
				<th>번 호</th>
				<th>닉네임</th>
				<th>제 목</th>
				<th>내 용</th>
				<th>동영상 여부</th>
				<th>동영상 경로</th>
				<th>career</th>
				<th>water</th>
				<th>like</th>
				<th>조회수</th>
				<th>작성일자</th>
			</tr>

			<c:forEach items="${ nlist }" var="n">


				<c:if test="${ n.visibility == 0 }">


					<tr>
						<td>${ n.category }</td>
						<td>${ n.classNo }</td>
						<td>${ n.nickname }</td>
						<td><c:url var="ndetail" value="noriterDetail.do">
								<!--  상대경로만 사용가능 -->
								<c:param name="classNo" value="${ n.classNo }" />
							</c:url> <c:if test="${ !empty sessionScope.loginUser }">
								<a href="${ ndetail }"> ${ n.classTitle } </a>
							</c:if> <c:if test="${ empty sessionScope.loginUser }">	
					${ n.classTitle }
				</c:if></td>
						<td>${ n.detail }</td>
						<td><c:if test="${ !empty n.videopath }">
								<h2>●</h2>
							</c:if> <c:if test="${ empty n.videopath }">
				Ⅹ</c:if></td>
						<td>${ n.videopath }</td>
						<td>${ n.career }</td>
						<td>${ n.water }</td>
						<td>${ n.like }</td>
						<td>${ n.count }</td>
						<td>${ n.date }</td>

					</tr>


				</c:if>


			</c:forEach>

		</table>
	</div>

	<!-- 페이징 -->
	<div>
		<nav>
		<ul class="pagination">

			<li><a aria-label="Previous"
				href="/sap/?page=1"><span>«</span></a></li>

			<c:if test="${ page <= 1 }">
				<li><a>이전</a></li>
			</c:if>
			<c:if test="${ page > 1 }">
				<li><a href="/sap/?page=${ page - 1 }">이전</a></li>
			</c:if>

			<c:forEach var="item" varStatus="status" begin="${ startPage }"
				end="${ endPage }" step="1">

				<c:if test="${ page == item }">

					<li><a>${ item }</a></li>

				</c:if>
				<c:if test="${ page != item }">

					<li><a href="/sap/?page=${ item }">${ item }</a></li>

				</c:if>
			</c:forEach>


			<c:if test="${ page >= totalPage }">

				<li><a>다음</a></li>

			</c:if>
			<c:if test="${ page < totalPage }">
				<li><a href="/sap/?page=${ page + 1 }">다음</a></li>

			</c:if>

			<li><a aria-label="Next"
				href="/sap/?page=${ totalPage }"><span>»</span></a></li>

			<%-- </c:forEach> --%>
		</ul>
		</nav>
	</div>

	<script src="resources/assets/js/jquery.min.js"></script>
	<script src="resources/assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="resources/assets/js/tabbed_slider.js"></script>
</body>
</html>





