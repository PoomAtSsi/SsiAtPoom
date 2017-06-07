<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>likeggiri</title>
    <link rel="stylesheet" href="/sap/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/sap/resources/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="/sap/resources/css/styless.css">
    <link rel="stylesheet" href="/sap/resources/css/Team-Grid.css">
</head>

<body>
    <div class="team-grid">
    <div class="container">
        <div class="intro">
            <h2 class="text-left">My SSIAT</h2>
             <div class="panel-heading">
        <h3 class="panel-title"><span class="fa-stack">
            <i class="fa fa-circle fa-stack-2x text-muted"></i>
            <i class="fa fa-heart fa-stack-1x fa-inverse text-left favoritemember"></i></span>내가 만든 씨앗놀이터</h3>
            </div>
        </div>
        <div class="row people">
                    <input type="hidden" name="nickname" value="${loginUser.nickname }"/>
        <c:forEach items="${mnlist }" var="mn">
            <div class="col-md-3 col-sm-6 item">
                <div class="box" style="background-image:url(/sap/resources/img/1.jpg)">
                    <div class="cover">
                        <h3 class="name">${mn.classTitle }</h3>
                        <p class="title">${mn.date }</p>
                        <p class="title">신청한 인원 : ${mn.count } 명</p>
                        <br><button class="btn btn-primary" type="button"> 
                        <i class="fa fa-trash-o"></i></button>
                    </div>
                </div>
            </div>
            </c:forEach>
              <div class="row">
            <div class="col-md-12">
                <nav>
                    <ul class="pagination">
                        <li><a aria-label="Previous"><span aria-hidden="true">«</span></a></li>
                        <li class="active"><a>1</a></li>
                        <li><a>2</a></li>
                        <li><a>3</a></li>
                        <li><a>4</a></li>
                        <li><a>5</a></li>
                        <li><a aria-label="Next"><span aria-hidden="true">»</span></a></li>
                    </ul>
                </nav>
            </div>
            </div>
        </div>
        </div>
    </div>

    <div class="team-grid">
    <br><br><br>
    <div class="container">
        <div class="intro">
             <div class="panel-heading">
        <h3 class="panel-title"><span class="fa-stack">
            <i class="fa fa-circle fa-stack-2x text-muted"></i>
            <i class="fa fa-heart fa-stack-1x fa-inverse text-left favoritemember"></i></span>내가 만든 씨앗끼리</h3>
            </div>
        </div>
        <div class="row people">
                    <input type="hidden" name="g_nickname" value="${loginUser.nickname }"/>
        <c:forEach items="${mglist }" var="mg">
            <div class="col-md-3 col-sm-6 item">
                <div class="box" style="background-image:url(/sap/resources/img/1.jpg)">
                    <div class="cover">
                        <h3 class="name">${mg.g_title }</h3>
                        <p class="title">${mg.g_dday }</p>
                        <p class="title">신청한 인원 : ${mg.g_countppl } 명</p>
                        <!-- <div class="social"><a href="#"><i class="fa fa-facebook-official"></i></a><a href="#"><i class="fa fa-twitter"></i></a><a href="#"><i class="fa fa-instagram"></i></a></div> -->
                   <br><button class="btn btn-primary" type="button"> 
                        <i class="fa fa-trash-o"></i></button>
                    </div>
                </div>
            </div>
            </c:forEach>
          
              <div class="row">
            <div class="col-md-12">
                <nav>
                    <ul class="pagination">
                        <li><a aria-label="Previous"><span aria-hidden="true">«</span></a></li>
                        <li class="active"><a>1</a></li>
                        <li><a>2</a></li>
                        <li><a>3</a></li>
                        <li><a>4</a></li>
                        <li><a>5</a></li>
                        <li><a aria-label="Next"><span aria-hidden="true">»</span></a></li>
                    </ul>
                </nav>
            </div>
        </div>
        </div>
    </div>
</div>
    <script src="/sap/resources/js/jquery.min.js"></script>
    <script src="/sap/resources/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>