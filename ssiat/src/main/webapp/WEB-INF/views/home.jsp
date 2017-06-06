<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/sap/resources/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="/sap/resources/js/jquery.min.js"></script>
<script src="/sap/resources/bootstrap/js/bootstrap.min.js"></script>

<title>Home</title>

<style type="text/css">
   #modal_fn{
   text-decoration:none;
   }
   
   ul{
         list-style:none;
         text-align:left;
     }
     
     /* 파일 업로드 부분 시작 */
     .dragAndDropDiv {
                border: 2px dashed #92AAB0;
                width: 650px;
                height: 200px;
                color: #92AAB0;
                text-align: center;
                vertical-align: middle;
                padding: 10px 0px 10px 10px;
                font-size:200%;
                display: table-cell;
            }
            .progressBar {
                width: 200px;
                height: 22px;
                border: 1px solid #ddd;
                border-radius: 5px; 
                overflow: hidden;
                display:inline-block;
                margin:0px 10px 5px 5px;
                vertical-align:top;
            }
              
            .progressBar div {
                height: 100%;
                color: #fff;
                text-align: right;
                line-height: 22px; /* same as #progressBar height if we want text middle aligned */
                width: 0;
                background-color: #0ba1b5; border-radius: 3px; 
            }
            .statusbar{
                border-top:1px solid #A9CCD1;
                min-height:25px;
                width:99%;
                padding:10px 10px 0px 10px;
                vertical-align:top;
            }
            .statusbar:nth-child(odd){
                background:#EBEFF0;
            }
            .filename{
                display:inline-block;
                vertical-align:top;
                width:250px;
            }
            .filesize{
                display:inline-block;
                vertical-align:top;
                color:#30693D;
                width:100px;
                margin-left:10px;
                margin-right:5px;
            }
            .abort{
                background-color:#A8352F;
                -moz-border-radius:4px;
                -webkit-border-radius:4px;
                border-radius:4px;display:inline-block;
                color:#fff;
                font-family:arial;font-size:13px;font-weight:normal;
                padding:4px 15px;
                cursor:pointer;
                vertical-align:top
            }
            /* 파일 업로드 부분 끝 */
</style>

<script type="text/javascript">
	function fn_login(){
	   $("#frm_login").submit();
	}

	function fn_msg() {
		var obj = {};
		obj["onUser"] = "${loginUser.nickname}";
		
		$.ajax({
			dataType:'json',
			url:'/sap/message/msgList.do',
			type:'POST',
			contentType: 'application/json',
			data:JSON.stringify(obj),
			success:function(response){
				modalOn(response);
			},
			error:function(request,status,error){
				alert(response.message);
			}
		});
	}
   function modalOn(res){
	 var ulMsgList = $("#ulMsgList");
	 var nick = "${loginUser.nickname}";
	 var tag = "";
	 
	 for(var i = 0; i < res.message.length; i++) {
	  var memNick = "";
	  if(nick == res.message[i].m_sender) {
	   memNick = res.message[i].m_receiver;
	  } else if(nick == res.message[i].m_receiver) {
	   memNick = res.message[i].m_sender;
	  }
	  
	  tag += '<li>';
	  tag += '<input type="checkbox" class="chkSelect" name="chk" onclick="start();"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
	  tag += '<a href="javascript:open_msgDetail();" onclick="showDetail();">';
	  tag += '<img src="" alt="(이미지)"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
	  tag += '<span>'+ memNick +'</span>';
	  tag += '</a>';
	  tag += '</li>';
	 }
	 
	 ulMsgList.html("");
	 ulMsgList.html(tag);
	 
	 //처리 후 modal창 띄우기
	   $("#myModal").modal('show');
	}
   function start(){
      //체크박스 하나하나를 배열 속성 으로 만들고 for문으로 배열 속성값을 하나하나 체크 확인 후
      //체크가 있을 시 버튼 모양을 바꾸는 기능
      var flagChecked = false;
      var chkbox = $(".chkSelect");
      for(var i=0; i<chkbox.length; i++){
          if (chkbox[i].checked == true){
              flagChecked = true;
              break;
          }
      }
      if (flagChecked){
         //체크가 되면
         document.getElementById('spMemoWrite').style.display = "none";
         document.getElementById('spDelete').style.display = "";
      }else{
         //체크가 해제 되면
         document.getElementById('spMemoWrite').style.display = "";
         document.getElementById('spDelete').style.display = "none";
      }
   }
      //독립적 체크박스 확인 기능 끝
      
      //전체선택 체크박스 기능
   $(document).ready(function(){
       //최상단 체크박스 클릭
       $("#chkAll").click(function(){
           //클릭되었으면
           if($("#chkAll").prop("checked")){
               //전체 선택
               $(".chkSelect").prop("checked",true);
               document.getElementById('spMemoWrite').style.display = "none";
               document.getElementById('spDelete').style.display = "";
               //클릭이 안되있으면
           }else{
               //전체 선택 해제
               $(".chkSelect").prop("checked",false);
               document.getElementById('spMemoWrite').style.display = "";
               document.getElementById('spDelete').style.display = "none";
           }
       })
       
       //메세지 상세보기 기본숨김 설정
       document.getElementById('msgDetail').style.display = "none";
       
   });
   
      //메세지 상세보기 클릭시 div 생성
      function showDetail(){
	   if(document.getElementById('msgDetail').style.display == "none"){
		   document.getElementById('msgDetail').style.display = "";
	   }else{
		   document.getElementById('msgDetail').style.display = "none";
	   }
   }
      
      //메세지 보기 두번째 modal창 여는 함수
      function open_msgDetail(){
    	  window.open('home','new','left=50, top=50, width=800, height=600');
      }
      
      
      /* 파일 업로드 부분 시작 */
        $(document).ready(function(){
                var objDragAndDrop = $(".dragAndDropDiv");
                 
                $(document).on("dragenter",".dragAndDropDiv",function(e){
                    e.stopPropagation();
                    e.preventDefault();
                    $(this).css('border', '2px solid #0B85A1');
                });
                $(document).on("dragover",".dragAndDropDiv",function(e){
                    e.stopPropagation();
                    e.preventDefault();
                });
                $(document).on("drop",".dragAndDropDiv",function(e){
                     
                    $(this).css('border', '2px dotted #0B85A1');
                    e.preventDefault();
                    var files = e.originalEvent.dataTransfer.files;
                 
                    handleFileUpload(files,objDragAndDrop);
                });
                 
                $(document).on('dragenter', function (e){
                    e.stopPropagation();
                    e.preventDefault();
                });
                $(document).on('dragover', function (e){
                  e.stopPropagation();
                  e.preventDefault();
                  objDragAndDrop.css('border', '2px dotted #0B85A1');
                });
                $(document).on('drop', function (e){
                    e.stopPropagation();
                    e.preventDefault();
                });
                 
                function handleFileUpload(files,obj)
                {
                   for (var i = 0; i < files.length; i++) 
                   {
                        var fd = new FormData();
                        fd.append('file', files[i]);
                  
                        var status = new createStatusbar(obj); //Using this we can set progress.
                        status.setFileNameSize(files[i].name,files[i].size);
                        sendFileToServer(fd,status);
                  
                   }
                }
                 
                var rowCount=0;
                function createStatusbar(obj){
                         
                    rowCount++;
                    var row="odd";
                    if(rowCount %2 ==0) row ="even";
                    this.statusbar = $("<div class='statusbar "+row+"'></div>");
                    this.filename = $("<div class='filename'></div>").appendTo(this.statusbar);
                    this.size = $("<div class='filesize'></div>").appendTo(this.statusbar);
                    this.progressBar = $("<div class='progressBar'><div></div></div>").appendTo(this.statusbar);
                    this.abort = $("<div class='abort'>중지</div>").appendTo(this.statusbar);
                     
                    obj.after(this.statusbar);
                  
                    this.setFileNameSize = function(name,size){
                        var sizeStr="";
                        var sizeKB = size/1024;
                        if(parseInt(sizeKB) > 1024){
                            var sizeMB = sizeKB/1024;
                            sizeStr = sizeMB.toFixed(2)+" MB";
                        }else{
                            sizeStr = sizeKB.toFixed(2)+" KB";
                        }
                  
                        this.filename.html(name);
                        this.size.html(sizeStr);
                    }
                     
                    this.setProgress = function(progress){       
                        var progressBarWidth =progress*this.progressBar.width()/ 100;  
                        this.progressBar.find('div').animate({ width: progressBarWidth }, 10).html(progress + "% ");
                        if(parseInt(progress) >= 100)
                        {
                            this.abort.hide();
                        }
                    }
                     
                    this.setAbort = function(jqxhr){
                        var sb = this.statusbar;
                        this.abort.click(function()
                        {
                            jqxhr.abort();
                            sb.hide();
                        });
                    }
                }
                 
                function sendFileToServer(formData,status)
                {
                    var uploadURL = "/fileUpload/post"; //Upload URL
                    var extraData ={}; //Extra Data.
                    var jqXHR=$.ajax({
                            xhr: function() {
                            var xhrobj = $.ajaxSettings.xhr();
                            if (xhrobj.upload) {
                                    xhrobj.upload.addEventListener('progress', function(event) {
                                        var percent = 0;
                                        var position = event.loaded || event.position;
                                        var total = event.total;
                                        if (event.lengthComputable) {
                                            percent = Math.ceil(position / total * 100);
                                        }
                                        //Set progress
                                        status.setProgress(percent);
                                    }, false);
                                }
                            return xhrobj;
                        },
                        url: uploadURL,
                        type: "POST",
                        contentType:false,
                        processData: false,
                        cache: false,
                        data: formData,
                        success: function(data){
                            status.setProgress(100);
                  
                            //$("#status1").append("File upload Done<br>");           
                        }
                    }); 
                  
                    status.setAbort(jqXHR);
                }
                 
            });
      /* 파일 업로드 부분 끝 */
      
</script>

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

	<form name="frm" id="frm_msg" action="message/msgList.do" method="post">
   <a href="javascript:fn_msg();">쪽지보내기</a>
   </form>
   <hr>
      
<div class="container">
  <!-- Modal 뷰 부분 -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-sm">
    
      <!-- Modal 실제로 들어가는 내용 부분-->
      <div class="modal-content">
        <div class="modal-header">
          <button class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">쪽지함 </h4>
        </div>
            <!-- 쪽지 기록이 있는 회원 DB에서 목록 불러오는 부분 -->
            <!-- 목록이 바디 크기를 초과 했을때 자동으로 스크롤 생성되며 무한스크롤 되게 처리해둠 -->
        <div class="modal-body" style="max-height:160px;overflow:auto;padding-left:0px;">
         
         <!-- 리스트 결과 출력되는 부분 -->
         <ul id="ulMsgList"></ul>
         <!-- 리스트 결과 출력되는 부분 끝 -->
        </div>
        
        <!-- 쪽지 상세보기 출력부분 시작 -->
        <div id="msgDetail">
	        <hr>
	        <div class="modal-body" style="max-height:210px;overflow:auto;padding-left:0px;">
	        </div>
        </div>
        <!-- 쪽지 상세보기 출력부분 끝 -->
        
        <div class="modal-footer" style="text-align:right;">
          <p class = "col-xs-3">
             <a style="font-size:9pt; text-decoration:none;">SelectAll</a> <input type="checkbox" id="chkAll">
          </p>
          <span id="spMemoWrite">
             <button id="btnMemoWrite" type="button" class="btn btn-primary" onclick="abc();">쪽지쓰기</button>
          </span>
          <span id="spDelete" style="display:none;">
             <button id='btnDelete' typez='button' class='btn btn-danger' onclick="">삭제하기</button>
          </span>
          <button type="button" class="btn btn-default" data-dismiss="modal">창 닫기</button>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- 쪽지보기 modal 창 기능 -->
<div class="container">
  <!-- Modal 뷰 부분 -->
  <div class="modal fade" id="myModal_msgDetail" role="dialog">
    <div class="modal-dialog modal-sm">
    
      <!-- Modal 실제로 들어가는 내용 부분-->
      <div class="modal-content">
        <div class="modal-header">
          <button class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">쪽지함 </h4>
        </div>
            <!-- 쪽지 기록이 있는 회원 DB에서 목록 불러오는 부분 -->
            <!-- 목록이 바디 크기를 초과 했을때 자동으로 스크롤 생성되며 무한스크롤 되게 처리해둠 -->
        <div class="modal-body" style="max-height:160px;overflow:auto;padding-left:0px;">
         
         <!-- 리스트 결과 출력되는 부분 -->
         <ul id="ulMsgList"></ul>
         <!-- 리스트 결과 출력되는 부분 끝 -->
        </div>
        
        <!-- 쪽지 상세보기 출력부분 시작 -->
        <div id="msgDetail">
	        <hr>
	        <div class="modal-body" style="max-height:210px;overflow:auto;padding-left:0px;">
	        </div>
        </div>
        <!-- 쪽지 상세보기 출력부분 끝 -->
        
        <div class="modal-footer" style="text-align:right;">
          <p class = "col-xs-3">
             <a style="font-size:9pt; text-decoration:none;">SelectAll</a> <input type="checkbox" id="chkAll">
          </p>
          <span id="spMemoWrite">
             <button id="btnMemoWrite" type="button" class="btn btn-primary" onclick="abc();">쪽지쓰기</button>
          </span>
          <span id="spDelete" style="display:none;">
             <button id='btnDelete' typez='button' class='btn btn-danger' onclick="">삭제하기</button>
          </span>
          <button type="button" class="btn btn-default" data-dismiss="modal">창 닫기</button>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- 파일 업로드 부분 -->
<div id="fileUpload" class="dragAndDropDiv">
	<textarea id="txt_input" rows="5" cols="30"></textarea>
</div>
<!-- 파일 업로드 부분 -->

</body>
</html>
