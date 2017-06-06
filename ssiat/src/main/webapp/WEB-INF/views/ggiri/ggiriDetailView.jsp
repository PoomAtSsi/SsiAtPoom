<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
    <title>studydetail1</title>
    <link rel="stylesheet" href="/sap/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/sap/resources/css/Product-Details.css">
    <link rel="stylesheet" href="/sap/resources/css/ggiriDetailstyles.css">
    <script src="/sap/resources/js/jquery.min.js"></script>
    <script src="/sap/resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

    <!-- 다음 지도 API용 css -->
	<style>
	    .map_wrap {position:relative;width:100%;height:185px;}
	    .title {font-weight:bold;display:block;}
	    .hAddr {position:absolute;left:10px;top:10px;border-radius: 2px;background:#fff;background:rgba(255,255,255,0.8);z-index:1;padding:5px;}
	    #centerAddr {display:block;margin-top:2px;font-weight: normal;}
	    .bAddr {padding:5px;text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
	</style>

</head>

<body>
<c:forEach items="${ glist }" var="g">
	<div class="container" >
	    <div class="row">
	        <div class="col-lg-1 col-md-1 hidden-sm hidden-xs"></div>
	      	  <div class="col-md-6" style="background-color:#F8F9F9;">
	            <div class="row" >
	                <div class="col-md-3 col-sm-3 col-xs-3">
	                
					<!-- 프로필사진 -->
					<c:forEach items="${gplist }" var="gp">
						<input type="hidden" name="g_nickname" value="${g.g_nickname}"/>
	          			<img src="${gp.profile }" id="profile"/>
	          			<input type="text" value="${gp.profile }"/>
	               	</c:forEach>                
	          			<p></p>
	               		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	               		${g.g_nickname }
	               </div>
	                
	                <!-- 경력 -->     
	                <div class="col-md-5 col-sm-5 col-xs-5">
	            		 <br><br>
	                    - ${g.g_career }<br>
	                    <br>
	                </div>
	                
	                <div class="col-md-3 col-sm-3 col-xs-3">
	                <!-- 즐겨찾기 버튼 이미지 -->
	              <!--   <img src="/sap/resources/img/star2.png" id="star"/> -->
	              <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                <img id="star" onclick="changeImage()" src="/sap/resources/img/star2.png">
	                <!-- <img src="/sap/resources/img/star1.png" id="fullstar"/> -->
	                <!-- 즐겨찾기 보낼 넘버/닉네임 -->
	                <form name="testForm" id="testForm">
	                <input type="hidden" name="g_no" value="${g.g_no }"/>
	                <input type="hidden" name="g_l_nickname" value="${loginUser.nickname}"/>
	                <input type="hidden" name="g_l_no" value="${g.g_no }"/>
	                </form>
	                </div>
	            </div>
	            <br>
	           <!-- 즐겨찾기 추가 -->
	            <script>
	            function changeImage() {
	                var image = document.getElementById('star');
	                if (image.src.match("star1")) {
	                    image.src = "/sap/resources/img/star2.png";
	                    //삭제
	                    var queryString = $("form[name=testForm]").serialize();
						$.ajax({
							type:"POST",
							url: "gUnlike.do?g_no=${g.g_no}",
							data: queryString,
							dataType:"json",
							error:function(status,error){
								alert("즐겨찾기 추가 성공");
							},
							success: function(json) {
								alert("success");
							},
						});
	                } else {
	                   		image.src = "/sap/resources/img/star1.png";
	                  	  //추가
	    					var queryString = $("form[name=testForm]").serialize();
	    					$.ajax({
	    						type:"POST",
	    						url: "gLike.do?g_no=${g.g_no}",
	    						data: queryString,
	    						dataType:"json",
	    						error:function(status,error){
	    							alert("즐겨찾기 취소");
	    						},
	    						success: function(json) {
	    							alert("success");
	    						},
	    					});
	                }
	            }
				</script> 
				
	            <!-- 디테일사진들 -->
	            <div class="row">
	                <div class="col-md-12"><img class="center-block" src="${g.g_file }" style="width:85%;"/></div>
	            </div>
	            <div class="row">
	                <div class="col-md-12"><img class="center-block" src="/sap/resources/img/yoga2.jpg" style="width:85%;"/></div>
	            </div>
	            <div class="row">
	                <div class="col-md-12"><img class="center-block" src="/sap/resources/img/yoga3.jpg"style="width:85%;" /></div>
	            </div>
	            <div class="row">
	                <div class="col-md-12"><img class="center-block" src="/sap/resources/img/yoga.jpg" style="width:85%;"/></div>
	            </div>
	            <!-- 디테일내용 -->
	            <div class="row">&nbsp;&nbsp;&nbsp;&nbsp;
	                -${g.g_detail }<br>
	            </div>
	            <hr>
	            
	           <!-- 모임신청한사람 프로필사진나열 -->
	            &nbsp;&nbsp;참석씨앗들<br><br>
	            <c:forEach items="${gjlist}" var="gj">
	            <div class="user-avatar" style="width:80px;float:left;margin-left:10px;">
	            <input type="hidden" name="g_j_no" value="${g.g_no }"/>
	            <%-- <input type="text" value="${gj.profile }" class="user"/> --%>
	            <img src="${gj.profile }" style="width:100%;"/>
	            </div>
	            </c:forEach>
	        </div>
	        
	        
	        <!-- 고정된 디테일창 -->
	        <div class="col-md-4 hidden-sm hidden-xs" style="border-color:silver; position:fixed; left:58%;top:3%;height:570px;width:400px;background-color:white;">
	            <h4>${g.g_title }</h4>
	            <p id="fee" style="font-size:11pt;margin-top:-10px;">${g.g_fee }원</p>
	            
	            <!-- 날짜/인원수/위치정보 보여지는 div -->
	            <div class="option" style="line-height:60%;text-align:left;margin-top:-10px;">
	                <span class="soption">
	          			<img src="/sap/resources/img/calendar.png"/>
						&nbsp; ${g.g_dday }               
	              		<br><br>
	                </span>
	                
	                <span class="soption">
	              	  <img src="/sap/resources/img/user.png"/>&nbsp;
	         		  	    최대${g.g_maxppl }명(최소${g.g_minppl }명)
	         		</span>&nbsp;
	                <br><br>
	                
	                <span class="soption">
	               		 <img src="/sap/resources/img/hourglass.png"/>&nbsp;
	               		 ${g.g_dday } 까지
	               	</span><br><br>
	               
	               	<!-- 모이는장소 -->
	                <span class="soption">
	              	  <img src="/sap/resources/img/placeholder.png"/>&nbsp;
	              	 	${g.g_location }</span>&nbsp;
	               		 <br><br>
	              		<input type="hidden" id="db_loc" value="${g.g_location }"/>
				 	   	<input type="hidden" id="db_lat" value="${g.g_lx }"/>
				 	   	<input type="hidden" id="db_lng" value="${g.g_ly }"/>
                	
                	<!-- 지도 -->
                	<div class="map_wrap" style="font-size:11pt;">
					    <div id="map" style="max-width:400px;max-height:200px;width:100%;height:100%;position:relative;overflow:hidden;"></div>
					</div>
	            </div>
	            
	            
	            <!-- 공유하기 -->
	            <div class="share" style="border-color:silver;">
					<form id="myform">
						<input type="hidden" id="title" value="${g.g_title }"/>
					</form>
					
					<img src="/sap/resources/img/share.jpg" style="width:50px;margin-right:30px;"/>
		            <a href="#"><img src="/sap/resources/img/facebook.png" id="facebook" onclick="shareF();"/></a>
					<a href="#"><img src="/sap/resources/img/naver.png" id="naver" onclick="shareN()" style="margin-left:30px;margin-right:30px;"/></a>
					<a href="https://story.kakao.com/share?url=URL" onclick="window.open(this.href, '', 'resizable=no,status=no,location=no,toolbar=no,menubar=no,fullscreen=no,scrollbars=no,dependent=no,width=600,height=600'); return false;">
					<img src="/sap/resources/img/kakaos.png" style="border-radius:24px;width:45px;height:45px;"/>
					</a>
					<br>
					<br>
					<script type="text/javascript">
						<!-- 네이버/페이스북 공유하기 -->
					    function shareN() {
					        var url = location.href;
					        var title = encodeURI(myform.title.value);
					        var shareURL = "http://share.naver.com/web/shareView.nhn?url=" + url + "&title=" + title;
					        document.location = shareURL;
					      }
					    function shareF() {
					        var url = location.href;
					        var title = encodeURI(myform.title.value);
					        var shareURL = "http://www.facebook.com/sharer.php?s=" + url + "&title=" + title;
					        document.location = shareURL;
					      }
					   </script>
	            </div>
	            
	            <script>
				<!-- 신청하기버튼클릭시 예/아니고 팝업창 -->	
				$(function(){		
					$('#btnJoin').click(function(){
						 /*   var add = "${g.g_no}"; */
						var popUrl="gJoinForm.do?g_no="+${g.g_no};
						var popOption = "width=300, height=100, resizable=no, scrollbars=no, status=no;";
						window.open(popUrl,"", popOption);  
						
					});
				});	
				</script>
				   
				<!-- 로그인유저와 작성자가 다르면 신청하기 아니면 수정하기버튼 -->
				<c:if test="${loginUser.nickname != g.g_nickname }"> 
					<button class="btn btn-danger btn-lg center-block" type="button" id="btnJoin" style="height:37px;width:300px;font-size:13pt;">신청하기
					</button>
				</c:if> 
				<c:if test="${loginUser.nickname == g.g_nickname}"> 
					<a href="ggiriUpdateForm.do?g_no=${g.g_no }">
					 <button class="btn btn-danger btn-lg center-block" type="button" style="height:37px;width:300px;font-size:13pt;">수정하기</button>
					</a>
				</c:if> 
	        </div>
	    </div>
	</div>
	
</c:forEach>
</body>
	<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=81519983fca4821881cd6c90faa6fb09&libraries=services"></script>
	<script type="text/javascript">
		<!-- 카카오스토리공유하기 -->
		/* //<![CDATA[
		// 사용할 앱의 JavaScript 키를 설정해 주세요.
		Kakao.init('9426bc2a9c33d653d380322971eb383c');
		// 스토리 공유 버튼을 생성합니다.
		Kakao.Story.createShareButton({
		  container: '#kakaostory-share-button',
		  url: location.href,
		  text:'dd'
		});
		//]]> */
		
		//지도api키 	
	    // 씨앗끼리 방장이 아닌 타 회원이 볼때 나타나지는 지도
		var loc = $("#db_loc").val(); //DB 에 주소값 불러오기
		var lat = $("#db_lat").val(); //DB 에 위도 lat 정보 불러오기
		var lng = $("#db_lng").val(); //DB 에 경도 lng 정보 불러오기
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	  	  mapOption = { 
	     	   center: new daum.maps.LatLng(lat, lng), // 지도의 중심좌표
	     	   level: 3 // 지도의 확대 레벨
	 				   };

		var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
		
		// 마커를 표시할 위치입니다 
		var position =  new daum.maps.LatLng(lat, lng);
		
		// 마커를 생성합니다
		var marker = new daum.maps.Marker({
		  position: position
		});
		
		// 마커를 지도에 표시합니다.
		marker.setMap(map);
		
		// 마커에 커서가 오버됐을 때 마커 위에 표시할 인포윈도우를 생성합니다
		var iwContent = '<div class="bAddr">'  + loc + '</div>'; // 인포윈도우에 표출될 내용으로 DB에 LOC 컬럼의 값을 땡겨오면 됩니다
		// 인포윈도우를 생성합니다
		var infowindow = new daum.maps.InfoWindow({
		    content : iwContent
		});
		
		// 마커에 마우스오버 이벤트를 등록합니다
		daum.maps.event.addListener(marker, 'mouseover', function() {
		  // 마커에 마우스오버 이벤트가 발생하면 인포윈도우를 마커위에 표시합니다
		    infowindow.open(map, marker);
		});
		
		// 마커에 마우스아웃 이벤트를 등록합니다
		daum.maps.event.addListener(marker, 'mouseout', function() {
		    // 마커에 마우스아웃 이벤트가 발생하면 인포윈도우를 제거합니다
		    infowindow.close();
		});
</script>   
</html>