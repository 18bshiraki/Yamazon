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
<link href="https://cdn.rawgit.com/michalsnik/aos/2.1.1/dist/aos.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/flexslider.css">
<link rel="stylesheet" href="css/jquery.fancybox.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/responsive.css">
<link rel="stylesheet" href="css/animate.min.css">
<link rel="stylesheet" href="css/font-icon.css">
</head>
<body>
	<!-- header top section -->
	<section class="banner" role="banner">
		<header id="header">
			<div class="header-content clearfix">
				<a class="logo" href="menu.html"><img src="ロゴ.jpg"></a>
				<nav class="navigation" role="navigation">
					<ul class="primary-nav">
						<li>山田造さん</li>
						<li><a href="account.html">Mypage</a></li>
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

	<section id="hero" class="section ">
		<div class="hero text-center">
			<h2>カート</h2>
			<br>
			<h4>合計￥50,000以上で5％引きとなります</h4>
		</div>
	</section>
	<div class="text-center">
		<div class="container">
			<div class="caption">
				<div class="caption-content" style="color: black">
					<table class="table table-striped">
						<tr>
							<td><h5>商品名</h5></td>
							<td><h5>金額</h5></td>
							<td><h5>カテゴリ</h5></td>
							<td></td>
						</tr>
						<c:forEach var="goods" items="${goods}">
							<tr>
								<td onclick="location.href='goodsDetail.html'; return false;"><h5>${fn:escapeXml(goods.goodsName)}</h5></td>
								<td onclick="location.href='goodsDetail.html'; return false;"><h5>${fn:escapeXml(goods.taxPrice)}</h5></td>
								<td onclick="location.href='goodsDetail.html'; return false;"><font
									color="black"><h5>${fn:escapeXml(goods.category)}</h5></font></td>
								<td><button type="button" class="return btn-outline-dark"
										style="width: 120px; padding: 0px 5px; margin: 0px;"
										onclick="location.href='cart.html'; return false;">
										<h5>カートから出す</h5>
									</button></td>
							</tr>
							</c:forEach>
					</table>
				</div>
			</div>
			<div class="text-center">
				<button type="button" class="btn btn-success btn-xs"
					onclick="location.href='purchase.html'; return false;">
					購入へ<span class="glyphicon glyphicon-chevron-right"></span>
				</button>
			</div>
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