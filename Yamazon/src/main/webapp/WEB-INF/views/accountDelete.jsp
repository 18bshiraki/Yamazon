<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>

<body>

	<!-- header top section -->
	<section class="banner" role="banner">
 		<header id="header">
			<div class="header-content clearfix">
				<a class="logo" href="menu"><img src="ロゴ.jpg"></a>
				<nav class="navigation" role="navigation">
					<ul class="primary-nav">
					<c:if test="${null ne sessionScope.user.userName}">
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
	<form:form action="accountDeleteResult" method="post" modelAttribute="yamazon">
	<section id="hero" class="section "></section>
	<div class="text-center" style="margin: 50px;">
		<h2>本当に退会しますか？</h2>
		<div class="text-center">
    		<form:button class="btn btn-success btn-xs">退会 <span class="glyphicon glyphicon-chevron-right"></span></form:button>
		</div>
	</div>
	</form:form>
		<div class="text-center">
			<a href="account">
				<button type="button" class="return btn-outline-dark"><span class="glyphicon glyphicon-chevron-left"></span>戻る</button>
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

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.fancybox.pack.js"></script>
	<script src="js/retina.min.js"></script>
	<script src="js/modernizr.js"></script>
	<script src="js/main.js"></script>
</body>
</html>