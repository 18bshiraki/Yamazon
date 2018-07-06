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
						<li><a href="account.html">Mypage</a></li>
						<li><a href="cart.html">Cart</a></li>
						<li><a href="login.html">Login</a></li>
						<li><a href="logout.html">Logout</a></li>
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
			<h2>商品詳細</h2>
		</div>
	</section>
	<section id="portfolio">
		<div class="container">
			<div class="row">
				<div class="col-sm-4 portfolio-item">
					<a href="cart.html" class="portfolio-link">
						<div class="caption">
							<div class="caption-content">
								<h2>
									<font color="white">カートへ入れる</font>
								</h2>
								<h3>Coffee maker/Red</h3>
							</div>
						</div> <img src="コーヒーメーカ.jpg" class="img-responsive" alt="">
					</a>
				</div>
				<div class="text-center">
					<div class="container">
						<div class="col-sm-8">
							<div class="caption">
								<div class="caption-content">
									<table class="table" style="color: black">
										<h3 class="text-left">コーヒーメーカー</h3>
										<tr>
											<th>分類</th>
											<th>値段</th>
											<th>在庫</th>
										</tr>
										<tr>
											<td><h5>コーヒーメーカー</h5></td>
											<td><h5>￥98,000</h5></td>
											<td><h5>20点</h5></td>
										</tr>
										<tr>
											<th>商品説明</th>
											<th></th>
											<th></th>
										</tr>
									</table>
									<h4 class="text-left">コーヒーメーカーです。コーヒーを淹れるための機械です。エスプレッソも入れることができます。</h4>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="text-center">
					<button type="button" class="btn btn-success btn-xs"
						onclick="location.href='Incart'; return false;">
						カートへ入れる<span class="glyphicon glyphicon-chevron-right"></span>
					</button>
				</div>
			</div>
		</div>
	</section>
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