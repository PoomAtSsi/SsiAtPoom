<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<%-- <jsp:include page="/category/clist.do"/> --%> 
<br>
 <div class="container">
    <div class="option">
  	  <c:if test="${!empty loginUser }">
        <button id="studyopen"><a href="ggiriInsertForm.do" type="button">방만들기</a></button>
      </c:if>
        
        <select id="sort">
            <option value="sort">최신순</option>
            <option value="">제목순</option>
        </select>
        <br>
        <p></p>
    </div>
    
	<div class="row">
          <c:forEach items="${ glist }" var="g">
        <div class="col-lg-3 col-md-4 col-sm-4">
            <article class="col-item">
            	<div class="photo">
        			<div class="options">
		        				<button class="btn btn-default" type="submit" data-toggle="tooltip" data-placement="top" title="like">
		        					<i class="fa fa-heart"></i>
		        				</button>
        				<c:if test="${loginUser.nickname eq 'admin'} ">
	        				<a href="gDelete.do?g_no=${g.g_no}">
	        					<button class="btn btn-default" type="submit" data-toggle="tooltip" data-placement="top" title="delete" >
	        						<i class="fa fa-close"></i>
	        					</button>
	        				</a>
        				</c:if>
        			</div>
        			
        			<c:url var="gdetail" value="gDetail.do">
					<c:param name="g_no" value="${g.g_no }" />
					</c:url> 
        			<a href="${gdetail }"> <img src="${g.g_file }" class="img-responsive" alt="Product Image" style="height:170px;" /> </a>
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
   </div>
</body>
</html>