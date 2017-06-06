<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome! testvideo1</title>



</head>
<body>

	


		<div id="header" align="center">
	
	
			<!-- <div id="container" align="center">
				<video id="video" preload="auto" autoplay="true" loop="loop"
					muted="muted" volume="0"> <source src="video/ssiat1.mp4"></video>
			</div> -->
			
			
			<div>
				<video width="320" height="240" controls>
					<source src="video/ssiat1.mp4" type="video/mp4">
					<source src="video/ssiat1.mp4" type="video/webm" />
					<source src="video/ssiat1.mp4" type="video/ogg" />
					video 요소를 지원하지 않는 브라우저입니다. 동영상은 다운로드 후 볼 수 있습니다.
				</video>
				
				<p><strong>test video:</strong> video1</p>
			</div>
	
	
		</div>
		
		




</body>
</html>