<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
		<div class="container">
			<div class="row">
				<div class=" hero">
					<div class="hero-content">
						<div class="input-group">
							<input type="text" class="form-control"
								placeholder="キーワードを入力してください"> <span
								class="input-group-btn">
								<button class="btn btn-default" type="submit"
									onClick="location.href='searchResult'"
									style="padding: 8px 15px 3px 15px; margin: 0px 2px 0px 9px; width: 50px;">
									<i class='glyphicon glyphicon-search'></i>
								</button>
							</span>
						</div>
					</div>
					<!-- hero -->
				</div>
			</div>
		</div>
	</section>

	<!-- header top section -->
	<!-- header content section -->

	<!-- footer section -->

	<!-- JS FILES -->
	<section id="portfolio">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<hr class="section">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-3 portfolio-item">
					<a href="goodsDetail.html" class="portfolio-link">
						<div class="caption">
							<div class="caption-content">
								<h3>電気ポット</h3>
								<h4>レッドデザイン</h4>
							</div>
						</div> <img src="電気ポット(修正後).jpg" class="img-responsive" alt=""
						width="200" height="200">
					</a>
				</div>
				<div class="col-sm-3 portfolio-item">
					<a href="goodsDetail.html" class="portfolio-link">
						<div class="caption">
							<div class="caption-content">
								<h3>電気ポット</h3>
								<h4>ホワイトデザイン</h4>
							</div>
						</div> <img src="電気白(修正後).jpg" class="img-responsive" alt="" width="200"
						height="200">
					</a>
				</div>
				<div class="col-sm-3 portfolio-item">
					<a href="goodsDetail.html" class="portfolio-link">
						<div class="caption">
							<div class="caption-content">
								<h3>コーヒーメーカ</h3>
								<h4>レッドデザイン</h4>
								<p>19800円</p>
							</div>
						</div> <img src="コーヒーメーカ(修正後).jpg" class="img-responsive" alt=""
						width="200" height="200">
					</a>
				</div>
				<div class="col-sm-3 portfolio-item">
					<a href="goodsDetail.html" class="portfolio-link">
						<div class="caption">
							<div class="caption-content">
								<h3>電気ポット</h3>
								<h4>ホワイトデザイン</h4>
							</div>
						</div> <img src="電気白(修正後).jpg" class="img-responsive" alt="">
					</a>
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
	<!-- portfolio grid section -->
	<!-- service section -->


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.fancybox.pack.js"></script>
	<script src="js/retina.min.js"></script>
	<script src="js/modernizr.js"></script>
	<script src="js/main.js"></script>
</body>
</html>