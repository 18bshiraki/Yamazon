<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!-->
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
						<li><a href="logout">Logout</a></li>
					</ul>
				</nav>
				<a href="#" class="nav-toggle">Menu<span></span></a>
			</div>
		</header>
	</section>


	<!-- header top section -->
	<!-- header content section -->


	<section id="hero" class="section ">
		<div class="hero text-center">
			<h1>管理者情報更新</h1>
		</div>
	</section>


	<div class="text-center">
		<div class="container">

			<div class="row">
				<h3>現在のアカウント情報</h3>

				<div class="row">
					<h5>管理者番号(変更はできません)</h5>
					<div class="form-inline" style="padding: 8px;">
						<input type="text" class="form-control input-sm" id="name"
							placeholder="管理者ID" size="45"
							value="${sessionScope.manager.managerId}" readonly>
					</div>
				</div>

				<div class="row">
					<h5>名前</h5>
					<div class="form-inline" style="padding: 8px;">
						<input type="text" class="form-control input-sm" id="name"
							placeholder="名前" size="45"
							value="${sessionScope.manager.managerName}" readonly>
					</div>

					<div class="row">
						<h5>パスワード</h5>
						<div class="form-inline" style="padding: 8px;">
							<input type="text" class="form-control input-sm" id="Password"
								placeholder="Password" size="45"
								value="${sessionScope.manager.managerPassword}" readonly>
						</div>
					</div>
				</div>




				<br>
				<h3>更新内容を入力してください</h3>
				<c:if test="${not empty msg}">
					<h4>
						<span class="text-danger">${msg}</span>
					</h4>
				</c:if>

				<form:form action="managerUpdateConfirm" method="post"
					modelAttribute="yamazon">
					<div class="row">
						<h5>名前</h5>
						<div class="form-inline" style="padding: 8px;">
							<form:input class="form-control input-sm" id="name"
								placeholder="名前" size="45" path="managerName" />
						</div>
					</div>

					<div class="row">
						<h5>パスワード</h5>
						<div class="form-inline" style="padding: 8px;">
							<form:input class="form-control input-sm" id="email"
								placeholder="Password" size="45" path="managerPassword" />
						</div>
					</div>

					<div class="row">
						<h5>パスワード(再入力)</h5>
						<div class="form-inline" style="padding: 8px;">
							<form:input class="form-control input-sm" id="email"
								placeholder="Password" size="45" path="rePassword" />
						</div>
					</div>




					<div class="text-center">
						<button type="submit" class="btn btn-success btn-xs">
							変更確認<span class="glyphicon glyphicon-chevron-right"></span>
						</button>
					</div>
				</form:form>
			</div>

			<a href="managerMenu"><button type="button"
					class="return btn-outline-dark">
					<span class="glyphicon glyphicon-chevron-left"></span>管理者メニュー
				</button></a>
		</div>
	</div>




	<!-- footer section -->

	<!-- JS FILES -->
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