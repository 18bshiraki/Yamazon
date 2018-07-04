<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
				<a class="logo" href="menu.html"><img src="ロゴ.jpg"></a>
				<nav class="navigation" role="navigation">
					<ul class="primary-nav">
						<li><a href="menu">Mypage</a></li>
						<li><a href="cart">Cart</a></li>
						<li><a href="login">Login</a></li>
						<li><a href="logout">Logout</a></li>
					</ul>
				</nav>
				<a href="#" class="nav-toggle">Menu<span></span></a>
			</div>
		</header>
	</section>


	<!-- header top section -->
	<!-- header content section -->

	<!-- footer section -->

	<!-- JS FILES -->

	<section id="hero" class="section ">
		<div class="hero text-center">
			<h2>商品検索結果</h2>
		</div>
	</section>
	<div class="text-center">
		<div class="container">
			<table class="table table-hover" style="color: black">
				<tr>
					<td>商品名</td>
					<td>金額</td>
					<td>カテゴリ</td>
					<td></td>
				</tr>
				<c:forEach var="goods" items="${search}">
					<tr>
						<td onclick="location.href='goodsDetail'; return false;"><font
							color="black"><h5>${fn:escapeXml(goods.goodsName)}</h5></font></td>
						<td onclick="location.href='goodsDetail'; return false;"><font
							color="black"><h5>${fn:escapeXml(goods.taxPrice)}</h5></font></td>
						<td onclick="location.href='goodsDetail'; return false;"><font
							color="black"><h5>${fn:escapeXml(goods.category)}</h5></font></td>
						<td><button type="button" class="btn btn-success"
								style="display: inline-block; padding: 0px 5px; margin: 0px 0px 0px 0px;"
								onclick="location.href='cart'; return false;">
								<h5>
									<font color="white">カートに入れる</font>
								</h5>
							</button></td>
					</tr>
				</c:forEach>
			</table>
		</div>
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