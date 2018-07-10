<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html class="no-js" lang="">
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
	<section class="banner" role="banner">
		<header id="header">
			<div class="header-content clearfix">
				<a class="logo" href="menu"><img src="ロゴ.jpg"></a>
				<nav class="navigation" role="navigation"></nav>
				<a href="#" class="nav-toggle">Menu<span></span></a>
			</div>
		</header>
	</section>

	<section id="hero" class="section ">
		<div class="hero text-center">
			<h1>ログイン画面</h1>
		</div>
	</section>
	<div class="text-center">
		<c:if test="${not empty msg}">
			<h4>
				<span class="text-danger">${msg}</span>
			</h4>
		</c:if>
		<form:form action="menu" method="post" modelAttribute="yamazon">
			<div class="container">

				<div class="row">
					<h5>電話番号</h5>
					<div class="col-sm-1">ユーザーID</div>
					<div class="col-sm-10 form-inline" style="padding: 3px;">
						<form:input class="form-control input-sm" id="name"
							placeholder="電話番号" size="45" path="phoneNumber" />
					</div>
				</div>
				<div class="row">
					<h5>パスワード</h5>
					<div class="col-sm-1">パスワード</div>
					<div class="col-sm-10 form-inline" style="padding: 3px;">
						<form:password class="form-control input-sm" placeholder="パスワード"
							size="45" path="password" />
					</div>
				</div>
				<form:button class="btn btn-success">
						ログイン<span class="glyphicon glyphicon-chevron-right"></span>
				</form:button>
			</div>
		</form:form>
		<c:if test="${null ne sessionScope.user.userName}">
			<div class="text-center">
				<a href="userInsert"><button type="button"
						class="btn btn-success">
						新規登録<span class="glyphicon glyphicon-chevron-right"></span>
					</button></a>
			</div>
		</c:if>
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