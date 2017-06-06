<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>공지사항</title>


<link rel="stylesheet"
	href="../resources/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="../resources/assets/css/styles.css">
<link rel="stylesheet" href="../resources/assets/css/tabbed_slider.css">
<link rel="stylesheet" href="../resources/assets/css/tabbed_slider1.css">


<script type="text/javascript" charset="utf-8"
	src="../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="../js/jquery-3.2.1.js"></script>

<script type="text/javascript"></script>

</head>
<body>
	<br>
	<hr>
	<br>

	<a href="noticeInsert.do" type="button">공지사항 등록</a> &nbsp;&nbsp;
	<a href=".." type="button">메인페이지로</a>

	<br>
	<hr>
	<br>
	<br>
	<div class="container">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Wrapper for slides -->
			<ul class="nav nav-pills nav-justified">
				<li data-target="#myCarousel" data-slide-to="0" class="active"><a
					href="#">About<small>Lorem ipsum dolor sit</small></a></li>
				<li data-target="#myCarousel" data-slide-to="1"><a href="#">Projects<small>Lorem
							ipsum dolor sit</small></a></li>
				<li data-target="#myCarousel" data-slide-to="2"><a href="#">Portfolio<small>Lorem
							ipsum dolor sit</small></a></li>
				<li data-target="#myCarousel" data-slide-to="3"><a href="#">Services<small>Lorem
							ipsum dolor sit</small></a></li>
			</ul>
			<div class="carousel-inner">
				<div class="item active">
					<img src="http://placehold.it/1200x400/16a085/ffffff&">
					<div class="carousel-caption">
						<table class="table">
							<thead>
								<h1>thead</h1>
							</thead>
							<tbody>
								<h1>tbody</h1>
							</tbody>
						</table>
					</div>
				</div>


				<!-- End Item -->
				<div class="item">
					<img src="http://placehold.it/1200x400/e67e22/ffffff&text=Projects">
					<div class="carousel-caption">
						<h3>Headline</h3>
						<p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr,
							sed diam nonumy eirmod tempor invidunt ut labore et dolore magna
							aliquyam erat, sed diam voluptua. Lorem ipsum dolor sit amet,
							consetetur sadipscing elitr.</p>
					</div>
				</div>
				<!-- End Item -->
				<div class="item">
					<img
						src="http://placehold.it/1200x400/2980b9/ffffff&text=Portfolio">
					<div class="carousel-caption">
						<h3>Headline</h3>
						<p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr,
							sed diam nonumy eirmod tempor invidunt ut labore et dolore magna
							aliquyam erat, sed diam voluptua. Lorem ipsum dolor sit amet,
							consetetur sadipscing elitr.</p>
					</div>
				</div>
				<!-- End Item -->
				<div class="item">
					<img src="http://placehold.it/1200x400/8e44ad/ffffff&text=Services">
					<div class="carousel-caption">
						<h3>Headline</h3>
						<p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr,
							sed diam nonumy eirmod tempor invidunt ut labore et dolore magna
							aliquyam erat, sed diam voluptua. Lorem ipsum dolor sit amet,
							consetetur sadipscing elitr.</p>
					</div>
				</div>
				<!-- End Item -->
			</div>
			<!-- End Carousel Inner -->

		</div>
		<!-- End Carousel -->
	</div>

	<br>
	<div>
		<table class="table" align="center" width="700" border="1"
			cellspacing="0">
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th width="300">공지제목</th>
				<!-- <th width="300">내용</th> -->
				<th width="110">첨부파일 여부</th>
				<!-- <th width="300">첨부파일 경로</th> -->
				<th width="200">작성날짜</th>
			</tr>


			<c:forEach items="${ nlist }" var="n">


				<c:if test="${ n.notice_visibility == 0 }">


					<tr>
						<td>${ n.notice_no }</td>


						<td>${ n.notice_nickname }</td>
						<td><c:url var="ndetail" value="noticeDetail.do">
								<!--  상대경로만 사용가능 -->
								<c:param name="notice_no" value="${ n.notice_no }" />
							</c:url> <c:if test="${ !empty sessionScope.loginUser }">
								<a href="${ ndetail }"> ${ n.notice_title } </a>
							</c:if> <c:if test="${ empty sessionScope.loginUser }">	
				${ n.notice_title }
			</c:if></td>
						<%-- <td>${ n.notice_contents }</td> --%>
						<td><c:if test="${ !empty n.notice_filepath }">
								<h2>●</h2>
							</c:if> <c:if test="${ empty n.notice_filepath }">
			Ⅹ</c:if></td>
						<%-- <td>${ n.notice_filepath }</td> --%>
						<td>${ n.notice_date }</td>
					</tr>


				</c:if>

			</c:forEach>
		</table>
	</div>

	<!-- 페이징 -->
	<div>
		<nav>
		<ul class="pagination">

			<%-- <c:forEach items="${ npaging }" var="p"> --%>

			<li><a aria-label="Previous"
				href="/sap/notice/noticeList.do?page=1"><span>«</span></a></li>

			<c:if test="${ page <= 1 }">
				<li><a>이전</a></li>
			</c:if>
			<c:if test="${ page > 1 }">
				<li><a href="/sap/notice/noticeList.do?page=${ page - 1 }">이전</a></li>
			</c:if>

			<c:forEach var="item" varStatus="status" begin="${ startPage }"
				end="${ endPage }" step="1">
				<%-- <c:forEach var="item" varStatus="status" items="${ npaging }"
					begin="<%=startPage %>" end="<%=endPage %>" step="1" > --%>


				<%-- <c:set var="arr" value="<%=new int[]{1,2,3} %>"/>
					<c:forEach var="x" items="${arr}"> --%>
				<%-- <c:set var="a" value="<%=startPage %>"/>
					<c:set var="b" value="<%=endPage %>"/>
					<h1>"<%=startPage %></h1>
					
					<c:forEach var="item" items="${npaging}" 
					begin="1" end="10" step="1" >
 --%>



				<%-- begin=<%= startPage %> end=<%= endPage %> step=1 > --%>
				<c:if test="${ page == item }">

					<li><a>${ item }</a></li>

				</c:if>
				<c:if test="${ page != item }">

					<li><a href="/sap/notice/noticeList.do?page=${ item }">${ item }</a></li>

				</c:if>
			</c:forEach>


			<c:if test="${ page >= totalPage }">

				<li><a>다음</a></li>

			</c:if>
			<c:if test="${ page < totalPage }">
				<li><a href="/sap/notice/noticeList.do?page=${ page + 1 }">다음</a></li>

			</c:if>

			<li><a aria-label="Next"
				href="/sap/notice/noticeList.do?page=${ totalPage }"><span>»</span></a></li>

			<%-- </c:forEach> --%>
		</ul>
		</nav>
	</div>




	<script src="../resources/assets/js/jquery.min.js"></script>
	<script src="../resources/assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="../resources/assets/js/tabbed_slider.js"></script>
</body>

</html>