<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="/sap/resources/assets/js/jquery.min.js"></script>
<script src="/sap/resources/assets/bootstrap/js/bootstrap.min.js"></script>
  
</head>

<body>
	<c:if test="${empty loginUser }">
		<form class="custom-form" id="frm_insert" action="/sap/member/minsert.do" method="post">
			<div class="row login-form">
			<div class="col-md-4 col-md-offset-4">
	        <h2 class="text-center form-heading">회원 가입</h2>
	            <div class="form-group">
	                <input class="form-control" type="email" placeholder="Email" name="email"/>
	            </div>
	            <div class="form-group">
	                <input class="form-control" type="text" placeholder="이름" name="username"/>
	            </div>
	            <div class="form-group">
	                <input class="form-control" type="email" placeholder="닉네임" name="nickname"/>
	            </div>
	            <div class="form-group">
	                <input class="form-control" type="password" placeholder="Password" name="password"/>
	            </div>
	            <div class="form-group">
	                <input class="form-control" type="password" placeholder="Password check" />
	            </div>
	            <div class="form-group">
	                <input class="form-control" type="text" placeholder="mobile" name="mobile"/>
	            </div>
	                     
	                       
	            <div class="radio">
	                <label>
	                    <input type="radio" name="radio-option" name="gender" value="F"/>여자</label>
	                <label>
	                    <input type="radio" name="radio-option" name="gender" value="M"/>남자</label>
	            </div>
	            
	            <div class="form-group">
	                <input class="form-control" type="text" placeholder="birth" id="birth" name="birth"/>
	            </div>
	            <div class="form-group">
	                <textarea class="form-control" cols=31 rows=3 placeholder="introduce" name="introduce"></textarea>
	            </div>
	            <div class="form-group">
	                <textarea class="form-control" cols=31 rows=3 placeholder="career" name="career"></textarea>
	            </div>
	            <div class="radio">
	                <p>이메일 동의여부</p>
	                <label>
	                    <input type="radio" name="radio-option" />예</label>
	                
	                <label>
	                    <input type="radio" name="radio-option" checked />아니오</label>
	            </div>
	            
	            <button class="btn btn-default btn-block submit-button" type="button" onclick="goSubmit();">회원가입</button>
			    </div>
			</div>
		</form>
	</c:if>

</body>

         
<script>
	/* 생년월일 */
	$(function (){
	  $("#birth").datepicker({
		  dateFormat : 'yy-mm-dd',
		  changeMonth : true,
          changeYear : true,
          yearRange: '-100y:c+nn',
          maxDate: '-1d'
	  });
	});

	
	/* 폼 전송 */
	function goSubmit(){
		 if(confirm("회원 가입을 하시겠습니까?")){
			 $("#frm_insert").submit();
		 }else{
			 return false;
		 }
	}
	
</script>

</html>