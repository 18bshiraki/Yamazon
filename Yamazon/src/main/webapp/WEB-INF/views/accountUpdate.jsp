<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!doctype html>
<html class="no-js" lang="">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Yamazon</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/flexslider.css">
<link rel="stylesheet" href="css/jquery.fancybox.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/responsive.css">
<link rel="stylesheet" href="css/animate.min.css">
<link rel="stylesheet" href="css/font-icon.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>
<body>
<!-- header top section -->
<section class="banner" role="banner">
 		<header id="header">
			<div class="header-content clearfix">
				<a class="logo" href="menu"><img src="ロゴ.jpg"></a>
				<nav class="navigation" role="navigation">
					<ul class="primary-nav">
					<c:if test="${not empty sessionScope}">
						<li><c:out value="${sessionScope.user.userName}" />さん</li>
						<li><a href="account">Mypage</a></li>
					</c:if>
						<li><a href="cart">Cart</a></li>
						<li><a href="login">Login</a></li>
					<c:if test="${not empty sessionScope}">
						<li><a href="logout">Logout</a></li>
					</c:if>
					</ul>
				</nav>
				<a href="#" class="nav-toggle">Menu<span></span></a>
			</div>
		</header>
</section>
<section id="hero" class="section ">
</section>
<div class="text-center">
       <h2>ユーザー更新画面</h2>
 <h3><c:out value="${sessionScope.user.userName}" />さん</h3>
  <section id="hero" class="section ">
</section>
<form:form action="accountUpdate" method="post" modelAttribute="yamazon">
 <div class="row">
    <h5>新しい電話番号</h5>
   <h6><font color="red">※数字のみ入力してください（ハイフンなし）</font></h6>
    <div class="form-inline" style="padding: 8px;">
      <form:input type="text" class="form-control input-sm" nmae="tel" id="phoneName" placeholder="新しい電話番号" size="45" path="tel"/>
    </div>
  </div>
 <div class="row">
    <h5>新しい名前</h5>
    <div class="form-inline" style="padding: 8px;">
      <form:input type="text" class="form-control input-sm" id="userName" placeholder="新しい名前" size="45" path="name"/>
    </div>
  </div>
  <div class="row">
    <h5>新しい住所</h5>
    <div class="form-inline" style="padding: 8px;">
      <form:input type="text" class="form-control input-sm" id="address" placeholder="ご住所" size="45" path="address"/>
    </div>
  </div>
  <div class="row">
    <h5>新しいパスワード</h5>
    <div class="form-inline" style="padding: 8px;">
      <form:input type="password" class="form-control input-sm" placeholder="Password" size="45" path="newpass"/>
    </div>
  </div>
  <div class="row">
    <h5>今までのパスワード</h5>
    <div class="form-inline" style="padding: 8px;">
      <form:input type="text" class="form-control input-sm" placeholder="Password" size="45" value="${sessionScope.user.password}" path="pass"/>
    </div>
  </div>
     <div class="text-center">
        <form:button class="btn btn-success btn-xs">次へ<span class="glyphicon glyphicon-chevron-right"></span></form:button>
     </div>
</form:form>
</div>
<div class="text-center">
	<a href="account"><button type="button" class="return btn-outline-dark"><span class="glyphicon glyphicon-chevron-left"></span>戻る</button>
	</a>
</div>

<footer class="footer">
  <div class="container">
    <div class="col-md-6 left">
      <p>Yamazon運営チーム</p>
      <p>TEL:0120-117-117-828828</p>
    </div>
  </div>
</footer>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.fancybox.pack.js"></script>
<script src="js/retina.min.js"></script>
<script src="js/modernizr.js"></script>
<script src="js/main.js"></script>
</body>
</html>
