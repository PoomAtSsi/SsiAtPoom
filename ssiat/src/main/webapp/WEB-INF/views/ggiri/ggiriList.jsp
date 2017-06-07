<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ssiatggiri</title>
  <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>studylist</title>
    <link rel="stylesheet" href="/sap/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/sap/resources/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="/sap/resources/css/MUSA_product-display.css">
    <link rel="stylesheet" href="/sap/resources/css/MUSA_product-display1.css">
    <link rel="stylesheet" href="/sap/resources/css/ggiristyles.css">
    <script src="/sap/resources/js/jquery.min.js"></script>
    <script src="/sap/resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="/sap/resources/js/MUSA_product-display.js"></script>
</head>
<body>
<br>
<ul class="pagination">
		<li><span>category</span></li>
		<li><a href="glist.do?page=1&category=1"><span>전체보기</span></a></li>
		<li><a href="glist.do?page=1&category=2"><span>라이프스타일</span></a></li>
		<li><a href="glist.do?page=1&category=3"><span>영어/외국어</span></a></li>
		<li><a href="glist.do?page=1&category=4"><span>컴퓨터</span></a></li>
		<li><a href="glist.do?page=1&category=5"><span>디자인/미술</span></a></li>
		<li><a href="glist.do?page=1&category=6"><span>국가고시</span></a></li>
		<li><a href="glist.do?page=1&category=7"><span>취업</span></a></li>
		<li><a href="glist.do?page=1&category=8"><span>음악/공연</span></a></li>
		<li><a href="glist.do?page=1&category=9"><span>스포츠</span></a></li>
		<li><a href="glist.do?page=1&category=10"><span>뷰티/미용</span></a></li>
		<li><a href="glist.do?page=1&category=11"><span>게임</span></a></li>
		<li><a href="glist.do?page=1&category=12"><span>기타</span></a></li>
	</ul>
<br>
 <div class="container">
    <div class="option">
    <!-- 방만들기버튼 로그인했을시에만 -->
  	  <c:if test="${!empty loginUser }">
        <button id="studyopen"><a href="ggiriInsertForm.do" type="button">방만들기</a></button>
      </c:if>
        <br>
        <p></p>
    </div>
    
	<div class="row">
          <c:forEach items="${ glist }" var="g">
        <div class="col-lg-3 col-md-4 col-sm-4">
            <article class="col-item">
            	<div class="photo">
            	
        			<div class="options">
        			<!-- 끼리방에 커서 올렸을때 나타나는 버튼 (즐겨찾기/삭제) -->
        				<c:if test="${!empty loginUser}"> <!-- 로그인했을때만 보임 -->
		        				<button class="btn btn-default" type="submit" data-toggle="tooltip" data-placement="top" title="like">
		        					<i class="fa fa-star"></i>
		        				</button>
		        		</c:if>	
		        		 <!-- 로그인아이디가 admin(관리자)일때만 삭제버튼 보임 -->
        				<c:if test="${loginUser.nickname eq 'admin'} ">
	        				<a href="gDelete.do?g_no=${g.g_no}">
	        					<button class="btn btn-default" type="submit" data-toggle="tooltip" data-placement="top" title="delete" >
	        						<i class="fa fa-close"></i>
	        					</button>
	        				</a>
        				</c:if>
        			</div>
        			
        			<!-- 이미지클릭시 상세보기 페이지로 이동하는 url -->
        			<c:url var="gdetail" value="gDetail.do">
						<c:param name="g_no" value="${g.g_no }" />
					</c:url> 
        			<a href="${gdetail }"><img src="${g.g_file }" class="img-responsive" alt="Product Image" style="height:170px;" /> </a>
        		</div>
               <!--  <img src="/sap/resources/img/images.jpg" id="profile"/> -->
               <p></p>
                &nbsp;${g.g_title }
        		<div class="info">
        			<div class="row">
        				<div class="price-details col-md-6">
                            <span class="address-new">${g.g_location }</span><br>
        					<span class="price-new" style="font-size:11pt;color:pink;">${g.g_fee }원 / 모집중</span>
        				</div>
        			</div>
        		</div>
        	</article>
         </div>
       </c:forEach>
     </div>
     <div>
     
     <!-- 페이징 -->
		<nav>
		<ul class="pagination">

			<li><a aria-label="Previous"
				href="/sap/ggiri/glist.do?page=1&category=${ category }"><span>«</span></a></li>

			<c:if test="${ page <= 1 }">
				<li><a>이전</a></li>
			</c:if>
			<c:if test="${ page > 1 }">
				<li><a href="/sap/ggiri/glist.do?page=${ page - 1 }&category=${ category }">이전</a></li>
			</c:if>

			<c:forEach var="item" varStatus="status" begin="${ startPage }"
				end="${ endPage }" step="1">

				<c:if test="${ page == item }">

					<li><a>${ item }</a></li>

				</c:if>
				<c:if test="${ page != item }">

					<li><a href="/ggiri/glist.do?page=${ item }&category=${ category }">${ item }</a></li>

				</c:if>
			</c:forEach>


			<c:if test="${ page >= totalPage }">

				<li><a>다음</a></li>

			</c:if>
			<c:if test="${ page < totalPage }">
				<li><a href="/sap/ggiri/glist.do?page=${ page + 1 }&category=${ category }">다음</a></li>

			</c:if>

			<li><a aria-label="Next"
				href="/sap/ggiri/glist.do?page=${ totalPage }&category=${ category }"><span>»</span></a></li>

			<%-- </c:forEach> --%>
		</ul>
		</nav>
	</div>
   </div>
</body>
</html>