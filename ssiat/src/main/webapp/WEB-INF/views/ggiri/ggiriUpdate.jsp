<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>studymake</title>
    <link rel="stylesheet" href="/sap/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/sap/resources/css/ggirimakestyles.css">
    <link rel="stylesheet" href="/sap/resources/css/ggirimake.css">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="/sap/resources/js/jquery.min.js"></script>
    <script src="/sap/resources/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/sap/resources/js/jquery.min.js"></script>
 	 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- 다음 지도 API용 css -->
<style>
    .map_wrap {position:relative;width:100%;height:220px;left:25px;}
    .title {font-weight:bold;display:block;}
    #centerAddr {display:block;margin-top:2px;font-weight: normal;}
    .bAddr {padding:5px;text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
    input::-webkit-input-placeholder {color:silver;}
    textarea::-webkit-textarea-placeholder{color:silver;}
</style>

	<script>
     $(function() {
         $( "#datepicker" ).datepicker({
         	dateFormat: 'yy-mm-dd'
         });
       });
     
     function goSubmit(){
     	document.frm.submit();
     };
         
	</script>
</head>
<body>
<div class="container">
    <h2 align="center"> <img src="/sap/resources/img/sprout1.png"/>  씨앗끼리 수정하기</h2>
    <hr>
    
    <form name="frm" action="/sap/ggiri/gUpdate.do" method="post" onclick="return false;">
     
    <c:forEach items="${glist }" var="g">
    <div class="row">
        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
            <div class="col-lg-10 col-md-10 col-xs-10">
                <input type="hidden" name="g_nickname" value="${sessionScope.loginUser.nickname }" readonly>
				<input type="hidden" name="g_no" value="${g.g_no }">
					 
                <select id="cateselect">
                    <option value="g_category">카테고리 선택</option>
                    <option value="1">전체</option>
                    <option value="2">라이프스타일</option>
                    <option value="3">영어/외국어</option>
                    <option value="4">컴퓨터</option>
                    <option value="5">디자인/미술</option>
                    <option value="6">국가고시</option>
                    <option value="7">취업</option>
                    <option value="8">음악/공연</option>
                    <option value="9">스포츠</option>
                    <option value="10">뷰티/미용</option>
                    <option value="11">게임</option>
                    <option value="12">기타</option>
                </select>
                <input type="hidden" id="catSelect" name="g_category" placeholder="${g.category }"></input>
                <p></p>
                <br>
                
                <input type="text" id="ggiriname" name="g_title" value="${g.g_title }">
                <P></p>
                <br>
                
                <textarea rows="5" id="career" name="g_career">${g.g_career }</textarea>
                <p></p>
                <br>
                <br>
                <div id="imgbtn">
                <input type="text">
                    <button id="imagebtn">이미지등록</button></div>
       		 	<br>
       		 	
           		<textarea rows="5" id="career" name="g_detail" >${g.g_detail }</textarea>
            </div>
        </div>
        
        <!-- 오른쪼 -->
        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
          <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
            <p></p>
        	   <img src="/sap/resources/img/calendar.png"/>&nbsp;
               <input type="text" id="datepicker" name="g_dday" value="${g.g_dday }"style="width:90%;height:40px;border:none;border-bottom:solid 2px #fca55d;color:silver;font-size:13pt;">
	              <p></p>
           		   <br>
              <img src="/sap/resources/img/user.png"/>
              <select id="minpselect">
					<option value="minp">최소인원</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
					<option value="25">25</option>
					<option value="26">26</option>
					<option value="27">27</option>
					<option value="28">28</option>
					<option value="29">29</option>
					<option value="30">30</option>
					<option value="31">31</option>
					<option value="32">32</option>
					<option value="33">33</option>
					<option value="34">34</option>
					<option value="35">35</option>
					<option value="36">36</option>
					<option value="37">37</option>
					<option value="38">38</option>
					<option value="39">39</option>
					<option value="40">40</option>
					<option value="41">41</option>
					<option value="42">42</option>
					<option value="43">43</option>
					<option value="44">44</option>
					<option value="45">45</option>
					<option value="46">46</option>
					<option value="47">47</option>
					<option value="48">48</option>
					<option value="49">49</option>
					<option value="50">50</option>
              </select>
              <p></p>
              <img src="/sap/resources/img/users.png"/>
                <select id="maxpselect" style="width:90%;height:40px;border:none;border-bottom:solid 2px #fca55d;color:silver;font-size:13pt;">
					<option value="minp">최대인원</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
					<option value="25">25</option>
					<option value="26">26</option>
					<option value="27">27</option>
					<option value="28">28</option>
					<option value="29">29</option>
					<option value="30">30</option>
					<option value="31">31</option>
					<option value="32">32</option>
					<option value="33">33</option>
					<option value="34">34</option>
					<option value="35">35</option>
					<option value="36">36</option>
					<option value="37">37</option>
					<option value="38">38</option>
					<option value="39">39</option>
					<option value="40">40</option>
					<option value="41">41</option>
					<option value="42">42</option>
					<option value="43">43</option>
					<option value="44">44</option>
					<option value="45">45</option>
					<option value="46">46</option>
					<option value="47">47</option>
					<option value="48">48</option>
					<option value="49">49</option>
					<option value="50">50</option>
              </select> 
              
                <input type="hidden" id="ppl" name="g_minppl"></input>
                <input type="hidden" id="xppl" name="g_maxppl"></input>
                
              <p></p>
              <img src="/sap/resources/img/growth.png"/>
              <input type="text" id="fee" name="g_fee" value="${g.g_fee }">
              <p></p>
              <br>
               <img src="/sap/resources/img/placeholder.png"/>&nbsp;
				<input type="text" id="txtAddress" name="g_location" placeholder="${g.g_location }" style="width:90%;height:40px;border:none;border-bottom:solid 2px #fca55d;color:silver;font-size:13pt;"/>
				<p></p>
				
				<!-- 타입을 hidden으로 두고 db에 값만 보낼 애들입니다 -->
				<input type="hidden" id="lat" name="g_lx" value="${g.g_lx }"></input>
				<input type="hidden" id="lng" name="g_ly" value="${g.g_ly }"></input>
				
				<div class="map_wrap">
			    <div id="map" style="max-width:400px;max-height:200px;width:100%;height:100%;position:relative;overflow:hidden;"></div>
				</div>
				
                  <br>
            </div>
        </div>
    </div>
	</c:forEach>
    </form>
</div>
<div class="col-lg-12" style="text-align:center;">
<span>
	<input type="button" id="btn_submit" value="등록하기" onclick="goSubmit();"style="
	  height:40px;
	  width:15%;
	  background-color:#fcad55;
	  border:none;
	  border-radius:5px;
	  color:white;
	  font-size:12pt;
	">
</span>
<span>
	<input type="button" id="btn_cancel" value="취소" style="
	  height:40px;
	  width:15%;
	  background-color:#fcad55;
	  border:none;
	  border-radius:5px;
	  color:white;
	  font-size:12pt;
	">
</span>
</div>
   
</body>

<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=81519983fca4821881cd6c90faa6fb09&libraries=services"></script>
<script>
	$("#cateselect").change(function() {
	    var selectVar = $("#cateselect option:selected").val();
	    $("#catSelect").val(selectVar);
	 });
          
     $("#minpselect").change(function() {
         var selectVar = $("#minpselect option:selected").val();
            $("#ppl").val(selectVar);
      });
     
     $("#maxpselect").change(function() {
     	var selectv = $("#maxpselect option:selected").val();
         $("#xppl").val(selectv);
      });
     
     
    /* 지도 script */
	$("#map").ready(function() {
		//검색창에 엔터 입력시 좌표 검색
	    $("#txtAddress").keydown(function(e) {
	        if (e.keyCode == 13) {
	            Search();
	        }
	    });
	});
		
	//씨앗끼리 방 개설 화면에 나타나는 지도 화면 중 기본적으로 화면에 표시되는 지도기능 입니다.
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
	    center: new daum.maps.LatLng($("#lat").val(),$("#lng").val()), // 지도의 중심좌표
	    level: 4, // 지도의 확대 레벨
	    mapTypeId: daum.maps.MapTypeId.ROADMAP //지도의 종류 (지하철역 표시 잘되는것으로 선택함)
	};  
	
	//지도를 생성합니다    
	var map = new daum.maps.Map(mapContainer, mapOption); 
	
	var center = new daum.maps.LatLng($("#lat").val(),$("#lng").val()),  // 지도의 중심좌표
	marker = new daum.maps.Marker({
        position: center
    });
	marker.setMap(map);
	
	//주소-좌표 변환 객체를 생성합니다
	var geocoder = new daum.maps.services.Geocoder();
	
	var marker = new daum.maps.Marker(), // 클릭한 위치를 표시할 마커입니다
	infowindow = new daum.maps.InfoWindow({zindex:1}); // 클릭한 위치에 대한 주소를 표시할 인포윈도우입니다
	
	//지도를 클릭했을 때 클릭 위치 좌표에 대한 주소정보를 표시하도록 이벤트를 등록합니다
	daum.maps.event.addListener(map, 'click', function(mouseEvent) {
		 if (marker != '') {
	         marker.setMap(null);
	     }
	searchDetailAddrFromCoords(mouseEvent.latLng, function(status, result) {
	    if (status === daum.maps.services.Status.OK) {
	        var detailAddr = !!result[0].roadAddress.name ? '<div>도로명주소 : ' + result[0].roadAddress.name + '</div>' : '';
	        detailAddr += '<div>지번 주소 : ' + result[0].jibunAddress.name + '</div>';
	        
	        var content = '<div class="bAddr">' +
	                        '<span class="title">선택한 주소정보</span>' + 
	                        detailAddr + 
	                    '</div>';
	                    
	          var jibunAdd = result[0].jibunAddress.name;
	          $("#txtAddress").val(jibunAdd);
	          
	          //좌표값 넣기
	          var lat =mouseEvent.latLng.getLat();
	          var lng = mouseEvent.latLng.getLng();
			 //좌표 출력
				$("#lat").val(lat.toString().substr(0, 10));
				$("#lng").val(lng.toString().substr(0, 10));
	
	        // 마커를 클릭한 위치에 표시합니다 
	        marker.setPosition(mouseEvent.latLng);
	        marker.setMap(map);
	
	        // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
	        infowindow.setContent(content);
	        infowindow.open(map, marker);
	    }   
	});
	});
	
	//중심 좌표나 확대 수준이 변경됐을 때 지도 중심 좌표에 대한 주소 정보를 표시하도록 이벤트를 등록합니다
	daum.maps.event.addListener(map, 'idle', function() {
	searchAddrFromCoords(map.getCenter(), displayCenterInfo);
	});
	
	function searchAddrFromCoords(coords, callback) {
	// 좌표로 행정동 주소 정보를 요청합니다
	geocoder.coord2addr(coords, callback);         
	}
	
	function searchDetailAddrFromCoords(coords, callback) {
	// 좌표로 법정동 상세 주소 정보를 요청합니다
	geocoder.coord2detailaddr(coords, callback);
	}
	
	 //지도 좌측상단에 지도 중심좌표에 대한 주소정보를 표출하는 함수입니다
	function displayCenterInfo(status, result) {
	if (status === daum.maps.services.Status.OK) {
	    var infoDiv = document.getElementById('centerAddr');
	}    
	}
	 
	function Search() {
	    var query = $("#txtAddress").val();
	    if (marker != '') {
	        marker.setMap(null);
	        infowindow.close();
	    }
	    $("#txtAddress").val('');
	    getPoint(query);
		
	}
	
	//주소->좌표로 변환해주는 api 사용
	function getPoint(query) {
	    var oScript = document.createElement("script");
	    oScript.type = "text/javascript";
	    oScript.charset = "utf-8";
	    oScript.src = "http://apis.daum.net/local/geo/addr2coord?apikey=81519983fca4821881cd6c90faa6fb09&output=json&callback=pongSearch&q=" + encodeURI(query);
	    document.getElementsByTagName("head")[0].appendChild(oScript);
	}
	
	//좌표 변환 후 해당 좌표를 이용해 콜백(클릭시와 동일한 동작)
	function pongSearch(data) {
	    marker = '';
	    if (data.channel.item.length == 0) {
	        alert("주소명으로 검색해 주세요");
	    } else {
	        if (marker != '') {
	            marker.setMap(null);
	        }
	        var temp = new daum.maps.LatLng(data.channel.item[0].lat, data.channel.item[0].lng);
	        $("#latlng").html((data.channel.item[0].lat).toString().substring(0, 10) + ", " + (data.channel.item[0].lng).toString().substring(0, 10));
	        map.panTo(temp);
	        marker = new daum.maps.Marker({
	            position: temp
	        });
	        marker.setMap(map);
	    }
	} 
</script>


<!-- 지도 API 관련 자바 스크립트 끝 -->

</html>